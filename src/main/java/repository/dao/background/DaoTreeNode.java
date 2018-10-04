package repository.dao.background;

import pojo.PojoTreeNode;

public interface DaoTreeNode {
    PojoTreeNode get(String sql, Integer id);

    PojoTreeNode[] getAll(String sql);

    PojoTreeNode[] getChildren(String sql, Integer id);

    PojoTreeNode add(String sql, int makerId, Object... params);

    boolean add(String sql, int makerId, PojoTreeNode treeNode);

    boolean update(String sql, int makerId, PojoTreeNode treeNode);

    PojoTreeNode update(String sql, int makerId, Object... params);

    boolean del(String sql, int id);
}
