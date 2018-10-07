package repository.dao.iface;

import repository.pojo.PojoSet;

public interface DaoSet {
    PojoSet get(Integer id);

    PojoSet[] getAll();

    PojoSet add(int makerId, Object... params);

    boolean add(int makerId, PojoSet set);

    boolean update(int makerId, PojoSet set);

    boolean update(int makerId, Object... params);

    boolean del(int id);
}
