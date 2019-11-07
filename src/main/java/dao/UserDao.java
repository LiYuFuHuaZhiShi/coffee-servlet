package dao;

import entity.User;

/**
 * 用户数据库连接的接口
 */
public interface UserDao {
    /**
     * 添加用户信息
     * @param user 用户对象
     * @throws Exception
     */
    void addUser(User user) throws Exception;

    /**
     * 在数据库中核对用户信息
     * @param user 用户对象
     * @return 用户对象
     * @throws Exception
     */
    User findUser(User user) throws Exception;

    /**
     * 使用用户名查找相应的用户
     * @param userName 用户名
     * @return 用户对象
     * @throws Exception
     */
    boolean findUserByUserName(String userName) throws Exception;
}
