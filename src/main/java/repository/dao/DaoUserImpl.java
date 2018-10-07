package repository.dao;

import repository.pojo.PojoUser;
import repository.dao.background.DaoBackground;
import repository.dao.iface.DaoUser;

public class DaoUserImpl extends DaoBackground<PojoUser> implements DaoUser {

    public DaoUserImpl() {
        super(PojoUser::new,
                PojoUser[]::new,
                PojoUser::init);
    }

    @Override
    public PojoUser getByLogin(String login) {
        return fetchOneRowAsPojoObject(SQL_USER_SELECT_BY_LOGIN, login);
    }

    @Override
    public PojoUser get(Integer id) {
        return fetchOneRowAsPojoObject(SQL_USER_SELECT_BY_ID, id);
    }

    @Override
    public PojoUser[] getAll() {
        return fetchRowsAsPojoArray(SQL_USER_SELECT_ALL);
    }

    @Override
    public PojoUser add(int makerId, Object... params) {
        return makerId > 0 && params.length == 3 &&
                params[0] != null &&  //login
                params[1] != null &&  //md5Passw
                params[2] != null ?   //nick
                fetchOneRowAsPojoObject(SQL_USER_INSERT, params[0], params[1], params[2], makerId) :
                null;
    }

    @Override
    public boolean add(int makerId, PojoUser user) {
        return makerId > 0 && user != null &&
                user.getLogin() != null &&
                user.getMd5Passw() != null &&
                user.getNick() != null &&
                fetchOneRowAsPojoObject(user, SQL_USER_INSERT, user.getLogin(), user.getMd5Passw(), user.getNick(), makerId);
    }

    @Override
    public boolean del(int id) {
        //удалять можно почти всех :)
        return id > 2 && execute(SQL_USER_DELETE, id);
    }

    //Не обновляется время изменения в Pojo
    //но в данный момент это реализовывать не актуально
    @Override
    public boolean update(int editorId, PojoUser user) {
        return editorId > 0 && user != null &&
                user.getId() != null &&
                user.getLogin() != null &&
                user.getMd5Passw() != null &&
                user.getNick() != null &&
                execute(SQL_USER_UPDATE, user.getLogin(), user.getMd5Passw(), user.getNick(), editorId, user.getId());
    }

    //Этот метод по полям крайне похож на add,
    //но здесь массив данных должен начинаться
    //с поля id. Это важно!
    @Override
    public boolean update(int editorId, Object... params) {
        return editorId > 0 && params.length == 4 &&
                params[0] != null && //id
                params[1] != null && //login
                params[2] != null && //md5Passw
                params[3] != null && //nick
                execute(SQL_USER_UPDATE, params[1], params[2], params[3], editorId, params[0]);
    }
}
