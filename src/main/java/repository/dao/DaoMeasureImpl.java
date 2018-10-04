package repository.dao;

import pojo.PojoMeasure;
import repository.dao.background.DaoBgSupport;

import java.util.Arrays;

public class DaoMeasureImpl implements DaoMeasure {

    @Override
    public PojoMeasure get(Integer id) {
        return (PojoMeasure) DaoBgSupport.fetchOneRowAsPonjo(PojoMeasure.class, DaoBgSupport.SQL_MEASURE_SELECT_BY_ID, id);
    }

    @Override
    public PojoMeasure[] getAll() {
        return Arrays.stream(DaoBgSupport.getRowsAsPonjoArray(PojoMeasure.class, DaoBgSupport.SQL_MEASURE_SELECT_ALL)).map(object -> (PojoMeasure) object).toArray(PojoMeasure[]::new);
    }

    //Не обновляется время изменения в Pojo
    //но в данный момент это реализовывать не актуально
    //Параметры должны идти без id
    //ибо он сам генерится в базе
    @Override
    public PojoMeasure add(int makerId, Object... params) {
        if (makerId > 0 && params.length == 4 &&
                params[0] != null && ((String) params[0]).length() > 0 &&
                params[1] != null &&
                params[2] != null &&
                params[3] != null) {
            Object[] fields = DaoBgSupport.executeQueryGetOneRow(DaoBgSupport.SQL_MEASURE_INSERT, params[0], params[1], params[2], params[3], makerId);
            return fields == null ? null : new PojoMeasure(fields);
        }
        return null;
    }

    @Override
    public boolean add(int makerId, PojoMeasure measure) {
        if (makerId > 0 && measure != null &&
                measure.getName() != null && measure.getName().length() > 0 &&
                measure.getKind() != null &&
                measure.getPrimary() != null &&
                measure.getBaseK() != null) {
            Object[] fields = DaoBgSupport.executeQueryGetOneRow(DaoBgSupport.SQL_MEASURE_INSERT, measure.getName(), measure.getKind(), measure.getPrimary(), measure.getBaseK(), makerId);
            measure.init(fields);
            return fields != null;
        }
        return false;
    }

    @Override
    public boolean update(int makerId, PojoMeasure measure) {
        if (makerId > 0 && measure != null &&
                measure.getId() != null &&
                measure.getName() != null && measure.getName().length() > 0 &&
                measure.getKind() != null &&
                measure.getPrimary() != null &&
                measure.getBaseK() != null) {
            return DaoBgSupport.execute(DaoBgSupport.SQL_MEASURE_UPDATE, measure.getName(), measure.getKind(), measure.getPrimary(), measure.getBaseK(), makerId, measure.getId());
        }
        return false;
    }

    @Override
    public PojoMeasure update(int makerId, Object... params) {
        if (makerId > 0 && params.length == 5 &&
                params[0] != null &&
                params[1] != null &&
                params[2] != null &&
                params[3] != null &&
                params[4] != null) {
            return DaoBgSupport.execute(DaoBgSupport.SQL_MEASURE_UPDATE, params[1], params[2], params[3], params[4], makerId, params[0]) ?
                    get((Integer) params[0]) : null;
        }
        return null;
    }

    @Override
    public boolean del(int id) {
        return id > 0 && DaoBgSupport.execute(DaoBgSupport.SQL_MEASURE_DELETE, id);
    }
}
