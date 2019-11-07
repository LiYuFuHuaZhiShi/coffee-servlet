package web.controller;

import entity.User;
import org.apache.commons.beanutils.BeanUtils;
import service.UserService;
import service.UserServiceImpl;
import web.Exception.UserExistException;
import web.formbean.RegisterFormBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet",urlPatterns = "/servlet/registerServlet")
public class RegisterServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{

        request.setCharacterEncoding("UTF-8");
        response.setContentType("test/html;charset=UTF-8");

        //获取表单
        RegisterFormBean registerFormBean = new RegisterFormBean();
        try{
            BeanUtils.populate(registerFormBean,request.getParameterMap());
        }catch (Exception e){
            e.printStackTrace();
        }
        if (!registerFormBean.validate()){//如果map集合不为空，说明格式有误
            request.setAttribute("registerFormBean",registerFormBean);
            System.out.println("map集合不为空");
            request.getRequestDispatcher("/request.jsp").forward(request,response);
            System.out.println("已经完成请求转发了");
            return;//这个空的return语句可以让格式错误的表单不提交到服务器中，即下面的代码不执行了
        }
        //获取表单数据
        User u = new User();
        try{
//            ConvertUtils.register(new DateLocaleConverter(), Date.class);//这里给提交的Date类型数据提供注册
            BeanUtils.populate(u,request.getParameterMap());//使用apache提供的Bean工具类获取表单数据,支持四类八种数据的转换，但是Date不包含在内，所以使用Date会报错

            //处理业务逻辑

            userService.findUserByName(u.getUserName());
            userService.register(u);

        }catch (UserExistException e){
            request.setAttribute("error", "用户名已存在");
            request.getRequestDispatcher("/regist.jsp").forward(request, response);
        }catch (Exception e){
            e.printStackTrace();
        }
        //分发转向
        response.getWriter().write("注册成功，1秒后进入主页。");
        response.setHeader("refresh", "1;url="+request.getContextPath()+"/index.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
