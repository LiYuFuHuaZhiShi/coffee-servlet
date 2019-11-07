package web.formbean;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户注册表单Bean
 */
public class RegisterFormBean {
    private Integer userId;
    private String userName;
    private String userPwd;
    private String passwordConfirm;
    private String userPhone;
    private String userEmail;
    private Integer userLevel;

    /**
     * 用于返回表单检测结果
     */
    Map<String,String> msg = new HashMap<String, String>();

    /**
     * 用来规范表单输入
     * @return 符合规范返回true，不符合规范返回false
     */
    public boolean validate(){
        if ("".equals(userName)){
            msg.put("userName","用户名不能为空！");
        }
        if ("".equals(userPwd)){
            msg.put("userPwd","用户密码不能为空！");
        }
        if (!passwordConfirm.equals(userPwd)){
            msg.put("passwordConfirm","两次输入密码不一致！");
        }
        if ("".equals(userPhone)){
            msg.put("userPhone","用户电话不能为空！");
        }
        if ("".equals(userEmail)){
            msg.put("userEmail","用户邮箱不能为空！");
        }else if (!userEmail.matches("\\b^['_a-z0-9-\\+]+(\\.['_a-z0-9-\\+]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*\\.([a-z]{2}|aero|arpa|asia|biz|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|name|nato|net|org|pro|tel|travel|xxx)$\\b")){
            msg.put("userEmail","用户邮箱格式不正确！");
        }
        if ("".equals(userLevel)){
            msg.put("userLevel","用户级别不能为空！");
        }else if (userLevel!=1||userLevel!=2){
            msg.put("userLevel","用户级别格式不正确！");
        }
        return msg.isEmpty();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    public Map<String, String> getMsg() {
        return msg;
    }

    public void setMsg(Map<String, String> msg) {
        this.msg = msg;
    }
}
