package dao;

import entity.User;
import util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 数据库接口的实现类
 */
public class UserDaoImpl implements UserDao {
    public void addUser(User user) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try{
            conn = DBUtils.getConnection();
            String sql = "INSERT INTO user(user_name,user_pwd,user_phone,user_email,user_level) VALUES(?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,user.getUserName());
            pstmt.setString(2,user.getUserPwd());
            pstmt.setString(3,user.getUserPhone());
            pstmt.setString(4,user.getUserEmail());
            pstmt.setInt(5,user.getUserLevel());
            System.out.println(pstmt.executeUpdate());
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("添加失败！");
        }finally {
            DBUtils.closeAll(null,pstmt,conn);
        }
    }

    public User findUser(User user) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        User u = null;
        try {
            conn = DBUtils.getConnection();
            String sql = "SELECT * FROM user WHERE user_name=? AND user_pwd=?";
            pstmt.setString(1,user.getUserName());
            pstmt.setString(2,user.getUserPwd());
            rs = pstmt.executeQuery();
            if(rs.next()){//如果返回的结果集中有值
                u =new User();
                u.setUserName(rs.getString(1));
                u.setUserPwd(rs.getString(2));
                u.setUserPhone(rs.getString(3));
                u.setUserEmail(rs.getString(4));
                u.setUserLevel(rs.getInt(5));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtils.closeAll(rs,pstmt,conn);
        }

        return u;
    }
    /**
     * 如果当前用户名已存在，则返回true，否则返回false
     */
    public boolean findUserByUserName(String userName){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            conn = DBUtils.getConnection();
            String sql = "SELECT * FROM user WHERE user_name=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,userName);
            rs = pstmt.executeQuery();
            if (rs.next()){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtils.closeAll(rs,pstmt,conn);
        }
        return false;
    }
}
