package repository.dao;

import pojo.PojoGoods;
import repository.dao.background.DaoBackground;

public class DaoGoodsImpl extends DaoBackground implements DaoGoods {
    @Override
    public PojoGoods get(Integer id) {
        return fetchOneRowAsPojo(PojoGoods::new, SQL_GOODS_SELECT_BY_ID, id);
    }

    @Override
    public PojoGoods[] getAll() {
        return fetchRowsAsPojoArray(PojoGoods::new, PojoGoods[]::new, SQL_GOODS_SELECT_ALL);
    }

    @Override
    public PojoGoods add(int makerId, Object... params) {
        return makerId > 0 && params.length == 3 &&
                params[0] != null &&  //name
                params[1] != null &&  //node_id
                params[2] != null ?   //measure_id
                fetchOneRowAsPojo(PojoGoods::new, SQL_GOODS_INSERT, params[0], params[1], params[2], makerId) :
                null;
    }

    @Override
    public boolean add(int makerId, PojoGoods goods) {
        return makerId > 0 && goods != null &&
                goods.getName() != null &&
                goods.getNodeId() != null &&
                goods.getMeasureId() != null &&
                fetchOneRowAsPojoObject(goods::init, SQL_GOODS_INSERT, goods.getName(), goods.getNodeId(), goods.getMeasureId(), makerId);
    }

    @Override
    public boolean update(int editorId, PojoGoods goods) {
        return editorId > 0 && goods != null &&
                goods.getId() != null &&
                goods.getName() != null &&
                goods.getNodeId() != null &&
                goods.getMakerId() != null &&
                execute(SQL_GOODS_UPDATE, goods.getName(), goods.getNodeId(), goods.getMeasureId(), editorId, goods.getId());
    }

    @Override
    public boolean update(int editorId, Object... params) {
        return editorId > 0 && params.length == 4 &&
                params[0] != null && //id
                params[1] != null && //name
                params[2] != null && //node_id
                params[3] != null && //measure_id
                execute(SQL_GOODS_UPDATE, params[1], params[2], params[3], editorId, params[0]);
    }

    @Override
    public boolean del(int id) {
        return id > 0 && execute(SQL_GOODS_DELETE, id);
    }
}
