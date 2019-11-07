import dao.UserDao;
import dao.UserDaoImpl;
import entity.User;

public class Test01 {
    public static void main(String[] args) throws Exception {
        User user = new User("zhangsan","123","12123412","230197309@qq.com",1);
        System.out.println(user);
        UserDao userDao = new UserDaoImpl();
        userDao.addUser(user);
    }
}
