package repository.dao;

import repository.dao.background.DaoBackground;
import repository.dao.iface.DaoMeasure;
import repository.pojo.PojoMeasure;

public class DaoMeasureImpl extends DaoBackground<PojoMeasure> implements DaoMeasure {
    public DaoMeasureImpl() {
        super(PojoMeasure::new,
                PojoMeasure[]::new,
                PojoMeasure::init);
    }

    @Override
    public PojoMeasure get(Integer id) {
        return fetchOneRowAsPojoObject(SQL_MEASURE_SELECT_BY_ID, id);
    }

    @Override
    public PojoMeasure[] getAll() {
        return fetchRowsAsPojoArray(SQL_MEASURE_SELECT_ALL);
    }

    @Override
    public PojoMeasure add(int makerId, Object... params) {
        return makerId > 0 && params.length == 4 &&
                params[0] != null && ((String) params[0]).length() > 0 &&
                params[1] != null &&
                params[2] != null &&
                params[3] != null ?
                fetchOneRowAsPojoObject(SQL_MEASURE_INSERT, params[0], params[1], params[2], params[3], makerId) :
                null;
    }

    //Не обновляется время изменения в Pojo
    //но в данный момент это реализовывать не актуально
    //Параметры должны идти без id
    //ибо он сам генерится в базе
    @Override
    public boolean add(int makerId, PojoMeasure measure) {
        if (makerId > 0 && measure != null &&
                measure.getName() != null && measure.getName().length() > 0 &&
                measure.getKind() != null &&
                measure.getPrimary() != null &&
                measure.getBaseK() != null) {
            Object[] fields = fetchOneRowAsObjArray(SQL_MEASURE_INSERT, measure.getName(), measure.getKind(), measure.getPrimary(), measure.getBaseK(), makerId);
            if (fields.length > 0) {
                measure.init(fields);
                return true;
            } else return false;
        }
        return false;
    }

    @Override
    public boolean update(int makerId, PojoMeasure measure) {
        return makerId > 0 && measure != null &&
                measure.getId() != null &&
                measure.getName() != null && measure.getName().length() > 0 &&
                measure.getKind() != null &&
                measure.getPrimary() != null &&
                measure.getBaseK() != null &&
                execute(SQL_MEASURE_UPDATE, measure.getName(), measure.getKind(), measure.getPrimary(), measure.getBaseK(), makerId, measure.getId());
    }

    @Override
    public boolean update(int makerId, Object... params) {
        return makerId > 0 && params.length == 5 &&
                params[0] != null &&
                params[1] != null &&
                params[2] != null &&
                params[3] != null &&
                params[4] != null &&
                execute(SQL_MEASURE_UPDATE, params[1], params[2], params[3], params[4], makerId, params[0]);
    }

    @Override
    public boolean del(int id) {
        return id > 0 && execute(SQL_MEASURE_DELETE, id);
    }
}
