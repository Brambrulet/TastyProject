package repository.dao.test;

import org.apache.log4j.Logger;
import pojo.PojoUser;
import repository.dao.DaoUserImpl;

import java.util.Arrays;

public class TestDao {
    private static final Logger LOGGER = Logger.getLogger(TestDao.class);

    public static void main(String[] args) {

        PojoUser pojoUser = new DaoUserImpl().add(1, "userLogin", "userPassw", "userNick");
        LOGGER.debug(pojoUser == null ? "null" : pojoUser.toString());

        Arrays.stream(new DaoUserImpl().getAll()).forEach(pojo -> LOGGER.debug(pojo == null ? "null" : pojo.toString()));

        pojoUser = new DaoUserImpl().getByLogin("asdg");
        LOGGER.debug(pojoUser == null ? "null" : pojoUser.toString());

        pojoUser = new DaoUserImpl().get(1);
        LOGGER.debug(pojoUser == null ? "null" : pojoUser.toString());

        pojoUser = new DaoUserImpl().get(2);
        LOGGER.debug(pojoUser == null ? "null" : pojoUser.toString());
    }
}
