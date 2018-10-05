package repository.dao;

import pojo.PojoUser;

public interface DaoUser {
    PojoUser getByLogin(String login);

    PojoUser get(Integer id);

    PojoUser[] getAll();

    PojoUser add(int makerId, Object... params);

    boolean add(int makerId, PojoUser user);

    boolean update(int makerId, PojoUser user);

    boolean update(int makerId, Object... params);

    boolean del(int id);
}
