package service;

import entity.User;
import web.Exception.UserException;
import web.Exception.UserExistException;

/**
 * 根据用户需求写的接口
 */
public interface UserService {
    /**
     * 添加用户信息
     * @param user 用户对象
     * @throws Exception
     */
    void register(User user) throws Exception;

    /**
     * 根据用户名和密码查找用户信息
     * @param user 用户对象
     * @return 用户对象
     * @throws UserException
     */
    User login(User user) throws UserException;

    /**
     *根据用户名查找用户
     * @param userName 用户名
     * @return 是否有此用户：true为有，false为没有
     * @throws UserExistException
     */
    boolean findUserByName(String userName) throws Exception;
}
