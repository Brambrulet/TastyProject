package repository.dao.background;

import repository.dao.iface.DaoTreeNode;
import repository.pojo.PojoTreeNode;

public class DaoTreeNodeImpl extends DaoBackground<PojoTreeNode> implements DaoTreeNode {
    protected DaoTreeNodeImpl() {
        super(PojoTreeNode::new,
                PojoTreeNode[]::new,
                PojoTreeNode::init);
    }

    @Override
    public PojoTreeNode get(String sql, Integer id) {
        return fetchOneRowAsPojoObject(sql, id);
    }

    @Override
    public PojoTreeNode[] getAll(String sql) {
        return fetchRowsAsPojoArray(sql);
    }

    @Override
    public PojoTreeNode[] getRoot(String sql) {
        return fetchRowsAsPojoArray(sql);
    }

    @Override
    public PojoTreeNode[] getChildren(String sql, Integer id) {
        return fetchRowsAsPojoArray(sql, id);
    }

    @Override
    public PojoTreeNode add(String sql, int makerId, Object... params) {
        return makerId > 0 && params.length == 3 &&
                params[0] != null &&  //parent_id
                params[1] != null &&  //name
                params[2] != null ?   //note_type
                fetchOneRowAsPojoObject(sql, params[0], params[1], params[2], makerId) :
                null;
    }

    @Override
    public boolean add(String sql, int makerId, PojoTreeNode treeNode) {
        return makerId > 0 && treeNode != null &&
                treeNode.getParentId() != null &&
                treeNode.getName() != null &&
                treeNode.getNodeType() != null &&
                fetchOneRowAsPojoObject(treeNode, sql, treeNode.getParentId(), treeNode.getName(), treeNode.getNodeType(), makerId);
    }

    @Override
    public boolean update(String sql, int makerId, PojoTreeNode treeNode) {
        return makerId > 0 && treeNode != null &&
                treeNode.getId() != null &&
                treeNode.getParentId() != null &&
                treeNode.getName() != null &&
                treeNode.getNodeType() != null &&
                execute(SQL_USER_UPDATE, treeNode.getParentId(), treeNode.getName(), treeNode.getNodeType(), makerId, treeNode.getId());
    }

    @Override
    public boolean update(String sql, int makerId, Object... params) {
        return makerId > 0 && params.length == 4 &&
                params[0] != null && //id
                params[1] != null && //parent_id
                params[2] != null && //name
                params[3] != null && //note_type
                execute(SQL_USER_UPDATE, params[1], params[2], params[3], makerId, params[0]);
    }

    @Override
    public boolean del(String sql, int id) {
        return id > 0 && execute(sql, id);
    }
}
