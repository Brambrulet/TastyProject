package repository.dao;

import pojo.PojoTreeNode;
import repository.dao.background.DaoBackground;
import repository.dao.background.DaoTreeNodeImpl;

public class DaoSetTreeImpl extends DaoBackground implements DaoSetTree {
    private static final DaoTreeNodeImpl daoTreeNodeImpl = new DaoTreeNodeImpl();

    @Override
    public PojoTreeNode get(Integer id) {
        return daoTreeNodeImpl.get(SQL_SET_TREE_SELECT_BY_ID, id);
    }

    @Override
    public PojoTreeNode[] getAll() {
        return daoTreeNodeImpl.getAll(SQL_SET_TREE_SELECT_ALL);
    }

    @Override
    public PojoTreeNode[] getRoot() {
        return daoTreeNodeImpl.getRoot(SQL_SET_TREE_SELECT_ROOT);
    }

    @Override
    public PojoTreeNode[] getChildren(Integer parentId) {
        return daoTreeNodeImpl.getChildren(SQL_SET_TREE_SELECT_CHILDREN, parentId);
    }

    @Override
    public PojoTreeNode add(int makerId, Object... params) {
        return daoTreeNodeImpl.add(SQL_SET_TREE_INSERT, makerId, params);
    }

    @Override
    public boolean add(int makerId, PojoTreeNode attribute) {
        return daoTreeNodeImpl.add(SQL_SET_TREE_INSERT, makerId, attribute);
    }

    @Override
    public boolean update(int editorId, PojoTreeNode treeNode) {
        return daoTreeNodeImpl.update(SQL_SET_TREE_UPDATE, editorId, treeNode);
    }

    @Override
    public boolean update(int editorId, Object... params) {
        return daoTreeNodeImpl.update(SQL_SET_TREE_UPDATE, editorId, params);
    }

    @Override
    public boolean del(int id) {
        return daoTreeNodeImpl.del(SQL_SET_TREE_DELETE, id);
    }
}
