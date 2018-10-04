package repository.dao;

import pojo.PojoAttribute;
import repository.dao.background.DaoBgSupport;

import java.util.Arrays;

public class DaoAttributeImpl implements DaoAttribute {
    @Override
    public PojoAttribute get(Integer id) {
        return (PojoAttribute) DaoBgSupport.fetchOneRowAsPonjo(PojoAttribute.class, DaoBgSupport.SQL_ATTRIBUTE_SELECT_BY_ID, id);
    }

    @Override
    public PojoAttribute[] getAll() {
        return Arrays.stream(DaoBgSupport.getRowsAsPonjoArray(PojoAttribute.class, DaoBgSupport.SQL_ATTRIBUTE_SELECT_ALL)).map(object -> (PojoAttribute) object).toArray(PojoAttribute[]::new);
    }

    @Override
    public PojoAttribute add(int makerId, Object... params) {
        if (makerId > 0 && params.length == 2 &&
                params[0] != null &&
                params[1] != null) {
            return (PojoAttribute) DaoBgSupport.fetchOneRowAsPonjo(PojoAttribute.class, DaoBgSupport.SQL_ATTRIBUTE_INSERT, params[0], params[1], makerId);
        }
        return null;
    }

    @Override
    public boolean add(int makerId, PojoAttribute attribute) {
        if (makerId > 0 && attribute != null &&
                attribute.getName() != null &&
                attribute.getValue() != null) {
            Object[] fields = DaoBgSupport.executeQueryGetOneRow(DaoBgSupport.SQL_ATTRIBUTE_INSERT, attribute.getName(), attribute.getValue(), makerId);
            attribute.init(fields);
            return fields != null;
        }
        return false;
    }

    @Override
    public boolean update(int makerId, PojoAttribute attribute) {
        if (makerId > 0 && attribute != null &&
                attribute.getId() != null &&
                attribute.getName() != null &&
                attribute.getValue() != null) {
            return DaoBgSupport.execute(DaoBgSupport.SQL_ATTRIBUTE_UPDATE, attribute.getName(), attribute.getValue(), makerId, attribute.getId());
        }
        return false;
    }

    @Override
    public PojoAttribute update(int makerId, Object... params) {
        if (makerId > 0 && params.length == 3 &&
                params[0] != null &&
                params[1] != null &&
                params[2] != null) {
            return DaoBgSupport.execute(DaoBgSupport.SQL_ATTRIBUTE_UPDATE, params[1], params[2], makerId, params[0]) ?
                    get((Integer) params[0]) : null;
        }
        return null;
    }

    @Override
    public boolean del(int id) {
        return id > 0 && DaoBgSupport.execute(DaoBgSupport.SQL_ATTRIBUTE_DELETE, id);
    }
}
