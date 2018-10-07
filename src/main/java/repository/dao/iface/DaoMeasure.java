package repository.dao.iface;

import repository.pojo.PojoMeasure;

public interface DaoMeasure {
    PojoMeasure get(Integer id);

    PojoMeasure[] getAll();

    PojoMeasure add(int makerId, Object... params);

    boolean add(int makerId, PojoMeasure measure);

    boolean update(int makerId, PojoMeasure measure);

    boolean update(int makerId, Object... params);

    boolean del(int id);
}