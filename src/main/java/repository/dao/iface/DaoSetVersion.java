package repository.dao.iface;

import repository.pojo.PojoSetVersion;

public interface DaoSetVersion {
    PojoSetVersion get(Integer id);

    PojoSetVersion[] getListBySetId(int setId);

    PojoSetVersion add(int makerId, Object... params);

    boolean add(int makerId, PojoSetVersion setVersion);

    boolean update(int makerId, PojoSetVersion setVersion);

    boolean update(int makerId, Object... params);

    boolean del(int id);
}
