package repository.dao;

import repository.pojo.PojoTreeNode;
import repository.dao.background.DaoTreeNodeImpl;
import repository.dao.iface.DaoSetTree;

public class DaoSetTreeImpl extends DaoTreeNodeImpl implements DaoSetTree {

    @Override
    public PojoTreeNode get(Integer id) {
        return get(SQL_SET_TREE_SELECT_BY_ID, id);
    }

    @Override
    public PojoTreeNode[] getAll() {
        return getAll(SQL_SET_TREE_SELECT_ALL);
    }

    @Override
    public PojoTreeNode[] getRoot() {
        return getRoot(SQL_SET_TREE_SELECT_ROOT);
    }

    @Override
    public PojoTreeNode[] getChildren(Integer parentId) {
        return getChildren(SQL_SET_TREE_SELECT_CHILDREN, parentId);
    }

    @Override
    public PojoTreeNode add(int makerId, Object... params) {
        return add(SQL_SET_TREE_INSERT, makerId, params);
    }

    @Override
    public boolean add(int makerId, PojoTreeNode attribute) {
        return add(SQL_SET_TREE_INSERT, makerId, attribute);
    }

    @Override
    public boolean update(int editorId, PojoTreeNode treeNode) {
        return update(SQL_SET_TREE_UPDATE, editorId, treeNode);
    }

    @Override
    public boolean update(int editorId, Object... params) {
        return update(SQL_SET_TREE_UPDATE, editorId, params);
    }

    @Override
    public boolean del(int id) {
        return del(SQL_SET_TREE_DELETE, id);
    }
}
