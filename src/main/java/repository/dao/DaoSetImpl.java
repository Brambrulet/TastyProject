package repository.dao;

import repository.pojo.PojoSet;
import repository.dao.background.DaoBackground;
import repository.dao.iface.DaoSet;

public class DaoSetImpl extends DaoBackground<PojoSet> implements DaoSet {
    public DaoSetImpl() {
        super(PojoSet::new,
                PojoSet[]::new,
                PojoSet::init);
    }

    @Override
    public PojoSet get(Integer id) {
        return fetchOneRowAsPojoObject(SQL_SET_SELECT_BY_ID, id);
    }

    @Override
    public PojoSet[] getAll() {
        return fetchRowsAsPojoArray(SQL_SET_SELECT_ALL);
    }

    @Override
    public PojoSet add(int makerId, Object... params) {
        return makerId > 0 && params.length == 4 &&
                params[0] != null &&  //name
                params[1] != null &&  //node_id
                params[2] != null &&  //measure_id
                params[3] != null ?   //singleton
                fetchOneRowAsPojoObject(SQL_SET_INSERT, params[0], params[1], params[2], params[3], makerId) :
                null;
    }

    @Override
    public boolean add(int makerId, PojoSet set) {
        return makerId > 0 && set != null &&
                set.getName() != null &&
                set.getNodeId() != null &&
                set.getMeasureId() != null &&
                set.getSingleton() != null &&
                fetchOneRowAsPojoObject(set, SQL_SET_INSERT, set.getName(), set.getNodeId(), set.getMeasureId(), set.getSingleton(), makerId);
    }

    @Override
    public boolean update(int editorId, PojoSet set) {
        return editorId > 0 && set != null &&
                set.getId() != null &&
                set.getName() != null &&
                set.getNodeId() != null &&
                set.getSingleton() != null &&
                set.getMakerId() != null &&
                execute(SQL_SET_UPDATE, set.getName(), set.getNodeId(), set.getMeasureId(), set.getSingleton(), editorId, set.getId());
    }

    @Override
    public boolean update(int editorId, Object... params) {
        return editorId > 0 && params.length == 5 &&
                params[0] != null && //id
                params[1] != null && //name
                params[2] != null && //node_id
                params[3] != null && //measure_id
                params[4] != null && //singleton
                execute(SQL_SET_UPDATE, params[1], params[2], params[3], params[4], editorId, params[0]);
    }

    @Override
    public boolean del(int id) {
        return id > 0 && execute(SQL_SET_DELETE, id);
    }
}
