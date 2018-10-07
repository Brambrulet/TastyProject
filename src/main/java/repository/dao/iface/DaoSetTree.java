package repository.dao.iface;

import repository.pojo.PojoTreeNode;

public interface DaoSetTree {
    PojoTreeNode get(Integer id);

    PojoTreeNode[] getAll();

    PojoTreeNode[] getRoot();

    PojoTreeNode[] getChildren(Integer id);

    PojoTreeNode add(int makerId, Object... params);

    boolean add(int makerId, PojoTreeNode attribute);

    boolean update(int makerId, PojoTreeNode attribute);

    boolean update(int makerId, Object... params);

    boolean del(int id);
}
