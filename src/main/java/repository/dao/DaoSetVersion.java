package repository.dao;

import pojo.PojoSetVersion;

public interface DaoSetVersion {
    PojoSetVersion get(Integer id);

    PojoSetVersion[] getAll();

    PojoSetVersion add(int makerId, Object... params);

    boolean add(int makerId, PojoSetVersion setVersion);

    boolean update(int makerId, PojoSetVersion setVersion);

    PojoSetVersion update(int makerId, Object... params);

    boolean del(int id);
}
