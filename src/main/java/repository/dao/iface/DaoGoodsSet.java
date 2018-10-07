package repository.dao.iface;

import repository.pojo.PojoGoodsSet;

public interface DaoGoodsSet {
    PojoGoodsSet get(int goodsId, int setId);

    PojoGoodsSet[] getAllForGoods(int goodsId);

    PojoGoodsSet add(int makerId, Object... params);

    boolean add(int makerId, PojoGoodsSet goodsSet);

    boolean update(int editorId, PojoGoodsSet goodsSet);

    boolean update(int editorId, Object... params);

    boolean del(int goodsId, int setId);
}
