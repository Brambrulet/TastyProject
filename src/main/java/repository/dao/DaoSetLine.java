package repository.dao;

import pojo.PojoSetLine;

public interface DaoSetLine {
    PojoSetLine get(Integer id);

    PojoSetLine[] getAll();

    PojoSetLine add(int makerId, Object... params);

    boolean add(int makerId, PojoSetLine setLine);

    boolean update(int makerId, PojoSetLine setLine);

    PojoSetLine update(int makerId, Object... params);

    boolean del(int id);
}
