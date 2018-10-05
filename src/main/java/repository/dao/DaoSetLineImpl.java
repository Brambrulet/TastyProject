package repository.dao;

import pojo.PojoSetLine;
import repository.dao.background.DaoBackground;

public class DaoSetLineImpl extends DaoBackground implements DaoSetLine {
    @Override
    public PojoSetLine get(int id) {
        return fetchOneRowAsPojo(PojoSetLine::new, SQL_SET_LINE_SELECT_BY_ID, id);
    }

    @Override
    public PojoSetLine[] getByVersion(int versionId) {
        return fetchRowsAsPojoArray(PojoSetLine::new, PojoSetLine[]::new, SQL_SET_LINE_SELECT_BY_VERSION, versionId);
    }

    @Override
    public PojoSetLine add(int makerId, Object... params) {
        return makerId > 0 && params.length == 7 &&
                params[0] != null &&  //version_id
                params[1] != null &&  //goods_id
                params[2] != null &&  //set_id
                params[3] != null &&  //params
                params[4] != null &&  //value1
                params[5] != null &&  //value2
                params[6] != null ?   //value3
                fetchOneRowAsPojo(PojoSetLine::new,
                        SQL_SET_LINE_INSERT,
                        params[0],
                        params[1],
                        params[2],
                        params[3],
                        params[4],
                        params[5],
                        params[6],
                        makerId) :
                null;
    }

    @Override
    public boolean add(int makerId, PojoSetLine setLine) {
        return makerId > 0 && setLine != null &&
                setLine.getVersionId() != null &&
                setLine.getGoodsId() != null &&
                setLine.getSetId() != null &&
                setLine.getParams() != null &&
                setLine.getValue1() != null &&
                setLine.getValue2() != null &&
                setLine.getValue3() != null &&
                fetchOneRowAsPojoObject(setLine::init,
                        SQL_SET_LINE_INSERT,
                        setLine.getVersionId(),
                        setLine.getGoodsId(),
                        setLine.getSetId(),
                        setLine.getParams(),
                        setLine.getValue1(),
                        setLine.getValue2(),
                        setLine.getValue3(),
                        makerId);
    }

    @Override
    public boolean update(int editorId, PojoSetLine setLine) {
        return editorId > 0 && setLine != null &&
                setLine.getId() != null &&
                setLine.getVersionId() != null &&
                setLine.getGoodsId() != null &&
                setLine.getSetId() != null &&
                setLine.getParams() != null &&
                setLine.getValue1() != null &&
                setLine.getValue2() != null &&
                setLine.getValue3() != null &&
                execute(SQL_SET_LINE_UPDATE,
                        setLine.getVersionId(),
                        setLine.getGoodsId(),
                        setLine.getSetId(),
                        setLine.getParams(),
                        setLine.getValue1(),
                        setLine.getValue2(),
                        setLine.getValue3(),
                        editorId,
                        setLine.getId());
    }

    @Override
    public boolean update(int editorId, Object... params) {
        return editorId > 0 && params.length == 8 &&
                params[0] != null && //id
                params[1] != null &&  //version_id
                params[2] != null &&  //goods_id
                params[3] != null &&  //set_id
                params[4] != null &&  //params
                params[5] != null &&  //value1
                params[6] != null &&  //value2
                params[7] != null &&   //value3
                execute(SQL_SET_LINE_UPDATE,
                        params[1],
                        params[2],
                        params[3],
                        params[4],
                        params[5],
                        params[6],
                        params[7],
                        editorId,
                        params[0]);
    }

    @Override
    public boolean del(int id) {
        return id > 0 && execute(SQL_SET_LINE_DELETE, id);
    }
}
