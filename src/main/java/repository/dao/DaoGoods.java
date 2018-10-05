package repository.dao;

import pojo.PojoGoods;

public interface DaoGoods {
    PojoGoods get(Integer id);

    PojoGoods[] getAll();

    PojoGoods add(int makerId, Object... params);

    boolean add(int makerId, PojoGoods goods);

    boolean update(int makerId, PojoGoods goods);

    boolean update(int makerId, Object... params);

    boolean del(int id);
}
