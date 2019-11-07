package service;

import dao.UserDao;
import dao.UserDaoImpl;
import entity.User;
import org.omg.CORBA.UserException;
import web.Exception.UserExistException;

/**
 * 用户接口的实现类
 */
public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();

    public void register(User user) throws Exception {
        userDao.addUser(user);
    }

    public User login(User user) {
        User u = null;
        try{
            u = userDao.findUser(user);
        }catch (Exception e){
            e.printStackTrace();
        }
        return u;
    }

    public boolean findUserByName(String userName) throws Exception {
        boolean b = userDao.findUserByUserName(userName);
        if (b){
            throw new UserExistException("此用户已存在");
        }
        return b;
    }
}
