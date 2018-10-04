package repository.dao;

import pojo.PojoAttribute;

public interface DaoAttribute {
    PojoAttribute get(Integer id);

    PojoAttribute[] getAll();

    PojoAttribute add(int makerId, Object... params);

    boolean add(int makerId, PojoAttribute attribute);

    boolean update(int makerId, PojoAttribute attribute);

    PojoAttribute update(int makerId, Object... params);

    boolean del(int id);
}
