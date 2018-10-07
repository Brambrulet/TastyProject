package repository.dao.iface;

import repository.pojo.PojoSetLine;

public interface DaoSetLine {
    PojoSetLine get(int id);

    PojoSetLine[] getByVersion(int versionId);

    PojoSetLine add(int makerId, Object... params);

    boolean add(int makerId, PojoSetLine setLine);

    boolean update(int makerId, PojoSetLine setLine);

    boolean update(int makerId, Object... params);

    boolean del(int id);
}
