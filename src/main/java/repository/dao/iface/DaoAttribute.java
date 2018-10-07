package repository.dao.iface;

import repository.pojo.PojoAttribute;

public interface DaoAttribute {
    PojoAttribute get(Integer id);

    PojoAttribute[] getAll();

    PojoAttribute add(int makerId, Object... params);

    boolean add(int makerId, PojoAttribute attribute);

    boolean update(int makerId, PojoAttribute attribute);

    boolean update(int makerId, Object... params);

    boolean del(int id);
}
