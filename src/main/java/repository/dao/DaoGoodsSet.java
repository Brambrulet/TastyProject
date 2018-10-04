package repository.dao;

import pojo.PojoGoodsSet;

public interface DaoGoodsSet {
    PojoGoodsSet get(int goodsId, int setId);

    PojoGoodsSet[] getAll();

    PojoGoodsSet add(int makerId, Object... params);

    boolean add(int makerId, PojoGoodsSet goodsSet);

    boolean update(int makerId, PojoGoodsSet goodsSet);

    PojoGoodsSet update(int makerId, Object... params);

    boolean del(int goodsId, int setId);
}
