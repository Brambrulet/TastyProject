package repository.dao;

import repository.pojo.PojoGoodsMeasure;
import repository.dao.background.DaoBackground;
import repository.dao.iface.DaoGoodsMeasure;

public class DaoGoodsMeasureImpl extends DaoBackground<PojoGoodsMeasure> implements DaoGoodsMeasure {
    public DaoGoodsMeasureImpl() {
        super(PojoGoodsMeasure::new,
                PojoGoodsMeasure[]::new,
                PojoGoodsMeasure::init);
    }

    @Override
    public PojoGoodsMeasure get(int goodsId, int measureId) {
        return fetchOneRowAsPojoObject(SQL_GOODS_MEASURE_SELECT_BY_IDS, goodsId, measureId);
    }

    @Override
    public PojoGoodsMeasure[] getAllForGoods(int goodsId) {
        return fetchRowsAsPojoArray(SQL_GOODS_MEASURE_SELECT_ALL_FOR_GOODS);
    }

    @Override
    public PojoGoodsMeasure add(int makerId, Object... params) {
        return makerId > 0 && params.length == 4 &&
                params[0] != null &&  //goods_id
                params[1] != null &&  //measure_id
                params[2] != null &&  //is_primary
                params[3] != null ?   //k
                fetchOneRowAsPojoObject(SQL_GOODS_MEASURE_INSERT, params[0], params[1], params[2], params[3], makerId) :
                null;
    }

    @Override
    public boolean add(int makerId, PojoGoodsMeasure goodsMeasure) {
        return makerId > 0 && goodsMeasure != null &&
                goodsMeasure.getGoodsId() != null &&
                goodsMeasure.getMeasureId() != null &&
                goodsMeasure.getPrimary() != null &&
                goodsMeasure.getK() != null &&
                fetchOneRowAsPojoObject(goodsMeasure::init, SQL_GOODS_MEASURE_INSERT, goodsMeasure.getGoodsId(), goodsMeasure.getMeasureId(), goodsMeasure.getPrimary(), goodsMeasure.getK(), makerId);
    }

    @Override
    public boolean update(int editorId, PojoGoodsMeasure goodsMeasure) {
        return editorId > 0 && goodsMeasure != null &&
                goodsMeasure.getGoodsId() != null &&
                goodsMeasure.getMeasureId() != null &&
                goodsMeasure.getPrimary() != null &&
                goodsMeasure.getK() != null &&
                execute(SQL_GOODS_MEASURE_UPDATE, goodsMeasure.getPrimary(), goodsMeasure.getK(), editorId, goodsMeasure.getGoodsId(), goodsMeasure.getMeasureId());
    }

    @Override
    public boolean update(int editorId, Object... params) {
        return editorId > 0 && params.length == 4 &&
                params[0] != null &&  //goods_id
                params[1] != null &&  //measure_id
                params[2] != null &&  //is_primary
                params[3] != null &&  //k
                execute(SQL_GOODS_MEASURE_UPDATE, params[2], params[3], editorId, params[0], params[1]);
    }

    @Override
    public boolean del(int goodsId, int measureId) {
        return goodsId > 0 && measureId > 0 && execute(SQL_GOODS_MEASURE_DELETE, goodsId, measureId);
    }
}
