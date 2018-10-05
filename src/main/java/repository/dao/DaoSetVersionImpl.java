package repository.dao;

import pojo.PojoSetVersion;
import repository.dao.background.DaoBackground;

public class DaoSetVersionImpl extends DaoBackground implements DaoSetVersion {
    @Override
    public PojoSetVersion get(Integer id) {
        return fetchOneRowAsPojo(PojoSetVersion::new, SQL_SET_VERSION_SELECT_BY_ID, id);
    }

    @Override
    public PojoSetVersion[] getListBySetId(int setId) {
        return fetchRowsAsPojoArray(PojoSetVersion::new,
                PojoSetVersion[]::new,
                SQL_SET_VERSION_SELECT_BY_SET_ID, setId);
    }

    @Override
    public PojoSetVersion add(int makerId, Object... params) {
        return makerId > 0 && params.length == 3 &&
                params[0] != null &&  //set_id
                params[1] != null &&  //start_date
                params[2] != null ?   //set_value
                fetchOneRowAsPojo(PojoSetVersion::new,
                        SQL_SET_VERSION_INSERT,
                        params[0],
                        params[1],
                        params[2],
                        makerId) :
                null;
    }

    @Override
    public boolean add(int makerId, PojoSetVersion setVersion) {
        return makerId > 0 && setVersion != null &&
                setVersion.getSetId() != null &&
                setVersion.getStartDate() != null &&
                setVersion.getSetValue() != null &&
                fetchOneRowAsPojoObject(setVersion::init,
                        SQL_SET_VERSION_INSERT,
                        setVersion.getSetId(),
                        setVersion.getStartDate(),
                        setVersion.getSetValue(),
                        makerId);
    }

    @Override
    public boolean update(int editorId, PojoSetVersion setVersion) {
        return editorId > 0 && setVersion != null &&
                setVersion.getId() != null &&
                setVersion.getSetId() != null &&
                setVersion.getStartDate() != null &&
                setVersion.getSetValue() != null &&
                execute(SQL_SET_VERSION_UPDATE,
                        setVersion.getSetId(),
                        setVersion.getStartDate(),
                        setVersion.getSetValue(),
                        editorId,
                        setVersion.getId());
    }

    @Override
    public boolean update(int editorId, Object... params) {
        return editorId > 0 && params.length == 4 &&
                params[0] != null && //id
                params[1] != null && //set_id
                params[2] != null && //start_date
                params[3] != null && //set_value
                execute(SQL_SET_VERSION_UPDATE,
                        params[1],
                        params[2],
                        params[3],
                        editorId,
                        params[0]);
    }

    @Override
    public boolean del(int id) {
        return id > 0 && execute(SQL_SET_VERSION_DELETE, id);
    }
}
