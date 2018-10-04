package repository.dao;

import pojo.PojoUser;
import repository.dao.background.DaoBgSupport;

import java.util.Arrays;

public class DaoUserImpl implements DaoUser {
    @Override
    public PojoUser getByLogin(String login) {
        return (PojoUser) DaoBgSupport.fetchOneRowAsPonjo(PojoUser.class, DaoBgSupport.SQL_USER_SELECT_BY_LOGIN, login);
    }

    @Override
    public PojoUser get(Integer id) {
        return (PojoUser) DaoBgSupport.fetchOneRowAsPonjo(PojoUser.class, DaoBgSupport.SQL_USER_SELECT_BY_ID, id);
    }

    @Override
    public PojoUser[] getAll() {
        return Arrays.stream(DaoBgSupport.getRowsAsPonjoArray(PojoUser.class, DaoBgSupport.SQL_USER_SELECT_ALL)).map(object -> (PojoUser) object).toArray(PojoUser[]::new);
    }

    //Не обновляется время изменения в Pojo
    //но в данный момент это реализовывать не актуально
    //Параметры должны идти без id
    //ибо он сам генерится в базе
    @Override
    public PojoUser add(int makerId, Object... params) {
        if (makerId > 0 && params.length == 3 &&
                params[0] != null &&
                params[1] != null &&
                params[2] != null) {
            return (PojoUser) DaoBgSupport.fetchOneRowAsPonjo(PojoUser.class, DaoBgSupport.SQL_USER_INSERT, params[0], params[1], params[2], makerId);
        }
        return null;
    }

    @Override
    public boolean add(int makerId, PojoUser user) {
        if (makerId > 0 && user != null &&
                user.getLogin() != null &&
                user.getMd5Passw() != null &&
                user.getNick() != null) {
            Object[] fields = DaoBgSupport.executeQueryGetOneRow(DaoBgSupport.SQL_USER_INSERT, user.getLogin(), user.getMd5Passw(), user.getNick(), makerId);
            user.init(fields);
            return fields != null;
        }
        return false;
    }

    @Override
    public boolean del(int id) {
        //удалять можно почти всех :)
        return id > 2 && DaoBgSupport.execute(DaoBgSupport.SQL_USER_DELETE, id);
    }

    //Не обновляется время изменения в Pojo
    //но в данный момент это реализовывать не актуально
    @Override
    public boolean update(int makerId, PojoUser user) {
        if (makerId > 0 && user != null &&
                user.getId() != null &&
                user.getLogin() != null &&
                user.getMd5Passw() != null &&
                user.getNick() != null) {
            return DaoBgSupport.execute(DaoBgSupport.SQL_USER_UPDATE, user.getLogin(), user.getMd5Passw(), user.getNick(), makerId, user.getId());
        }
        return false;
    }

    //Этот метод крайне похож на add,
    //но здесь массив данных должен начинаться
    //с поля id. Это важно!
    @Override
    public PojoUser update(int makerId, Object... params) {
        if (makerId > 0 && params.length == 4 &&
                params[0] != null &&
                params[1] != null &&
                params[2] != null &&
                params[3] != null) {
            return DaoBgSupport.execute(DaoBgSupport.SQL_USER_UPDATE, params[1], params[2], params[3], makerId, params[0]) ?
                    get((Integer) params[0]) : null;
        }
        return null;
    }
}
