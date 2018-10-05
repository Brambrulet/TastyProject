package repository.dao;

import pojo.PojoGoodsSet;
import repository.dao.background.DaoBackground;

public class DaoGoodsSetImpl extends DaoBackground implements DaoGoodsSet {
    @Override
    public PojoGoodsSet get(int goodsId, int setId) {
        return fetchOneRowAsPojo(PojoGoodsSet::new, SQL_GOODS_SET_SELECT_BY_IDS, goodsId, setId);
    }

    @Override
    public PojoGoodsSet[] getAllForGoods(int goodsId) {
        return fetchRowsAsPojoArray(PojoGoodsSet::new, PojoGoodsSet[]::new, SQL_GOODS_SET_SELECT_ALL_FOR_GOODS);
    }

    @Override
    public PojoGoodsSet add(int makerId, Object... params) {
        return makerId > 0 && params.length == 4 &&
                params[0] != null &&  //goods_id
                params[1] != null &&  //set_id
                params[2] != null &&  //measure_id
                params[3] != null ?   //k
                fetchOneRowAsPojo(PojoGoodsSet::new, SQL_GOODS_SET_INSERT, params[0], params[1], params[2], params[3], makerId) :
                null;
    }

    @Override
    public boolean add(int makerId, PojoGoodsSet goodsSet) {
        return makerId > 0 && goodsSet != null &&
                goodsSet.getGoodsId() != null &&
                goodsSet.getSetId() != null &&
                goodsSet.getMeasureId() != null &&
                goodsSet.getK() != null &&
                fetchOneRowAsPojoObject(goodsSet::init, SQL_GOODS_SET_INSERT, goodsSet.getGoodsId(), goodsSet.getSetId(), goodsSet.getMeasureId(), goodsSet.getK(), makerId);
    }

    @Override
    public boolean update(int editorId, PojoGoodsSet goodsSet) {
        return editorId > 0 && goodsSet != null &&
                goodsSet.getGoodsId() != null &&
                goodsSet.getSetId() != null &&
                goodsSet.getMeasureId() != null &&
                goodsSet.getK() != null &&
                execute(SQL_GOODS_SET_UPDATE, goodsSet.getMeasureId(), goodsSet.getK(), editorId, goodsSet.getGoodsId(), goodsSet.getSetId());
    }

    @Override
    public boolean update(int editorId, Object... params) {
        return editorId > 0 && params.length == 4 &&
                params[0] != null &&  //goods_id
                params[1] != null &&  //set_id
                params[2] != null &&  //measure_id
                params[3] != null &&  //k
                execute(SQL_GOODS_SET_UPDATE, params[2], params[3], editorId, params[0], params[1]);
    }

    @Override
    public boolean del(int goodsId, int setId) {
        return goodsId > 0 && setId > 0 && execute(SQL_GOODS_SET_DELETE, goodsId, setId);
    }
}
