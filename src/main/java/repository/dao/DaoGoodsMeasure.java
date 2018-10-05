package repository.dao;

import pojo.PojoGoodsMeasure;

public interface DaoGoodsMeasure {
    PojoGoodsMeasure get(int goodsId, int measureId);

    PojoGoodsMeasure[] getAllForGoods(int goodsId);

    PojoGoodsMeasure add(int makerId, Object... params);

    boolean add(int makerId, PojoGoodsMeasure goodsMeasure);

    boolean update(int makerId, PojoGoodsMeasure goodsMeasure);

    boolean update(int makerId, Object... params);

    boolean del(int goodsId, int measureId);
}
