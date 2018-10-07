package repository.dao.iface;

import repository.pojo.PojoTreeNode;

public interface DaoGoodsTree {
    PojoTreeNode get(Integer id);

    PojoTreeNode[] getAll();

    PojoTreeNode[] getRoot();

    PojoTreeNode[] getChildren(Integer id);

    PojoTreeNode add(int makerId, Object... params);

    boolean add(int makerId, PojoTreeNode attribute);

    boolean update(int editorId, PojoTreeNode attribute);

    boolean update(int editorId, Object... params);

    boolean del(int id);
}
