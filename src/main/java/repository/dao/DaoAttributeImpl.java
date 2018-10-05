package repository.dao;

import pojo.PojoAttribute;
import repository.dao.background.DaoBackground;

public class DaoAttributeImpl extends DaoBackground implements DaoAttribute {
    @Override
    public PojoAttribute get(Integer id) {
        return fetchOneRowAsPojo(PojoAttribute::new, SQL_ATTRIBUTE_SELECT_BY_ID, id);
    }

    @Override
    public PojoAttribute[] getAll() {
        return fetchRowsAsPojoArray(PojoAttribute::new, PojoAttribute[]::new, SQL_ATTRIBUTE_SELECT_ALL);
    }

    @Override
    public PojoAttribute add(int makerId, Object... params) {
        return makerId > 0 && params.length == 2 &&
                params[0] != null &&
                params[1] != null ?
                fetchOneRowAsPojo(PojoAttribute::new, SQL_ATTRIBUTE_INSERT, params[0], params[1], makerId) :
                null;
    }

    @Override
    public boolean add(int makerId, PojoAttribute attribute) {
        if (makerId > 0 && attribute != null &&
                attribute.getName() != null &&
                attribute.getValue() != null) {
            Object[] fields = fetchOneRowAsObjArray(SQL_ATTRIBUTE_INSERT, attribute.getName(), attribute.getValue(), makerId);
            if (fields.length > 0) {
                attribute.init(fields);
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public boolean update(int editorId, PojoAttribute attribute) {
        return editorId > 0 && attribute != null &&
                attribute.getId() != null &&
                attribute.getName() != null &&
                attribute.getValue() != null &&
                execute(SQL_ATTRIBUTE_UPDATE, attribute.getName(), attribute.getValue(), editorId, attribute.getId());
    }

    @Override
    public boolean update(int editorId, Object... params) {
        return editorId > 0 && params.length == 3 &&
                params[0] != null &&
                params[1] != null &&
                params[2] != null &&
                execute(SQL_ATTRIBUTE_UPDATE, params[1], params[2], editorId, params[0]);
    }

    @Override
    public boolean del(int id) {
        return id > 0 && execute(SQL_ATTRIBUTE_DELETE, id);
    }
}
