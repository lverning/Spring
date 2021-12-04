package cn.smbms.controller;


import cn.smbms.beans.User;
import cn.smbms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.net.ssl.HandshakeCompletedEvent;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/user")
public class UserController{

    @Autowired
    @Qualifier("userService")
    private UserService userService ;

    @RequestMapping("index.html")
    public String login() {
        return "login" ;
    }

    @RequestMapping("/dologin.html")
    public String dologin(@RequestParam("userCode") String userCode,
                          @RequestParam("userPassword") String userPassword,
                          HttpSession session){
        User user = userService.login(userCode, userPassword);
        if (user != null){
            session.setAttribute("userCode",userCode);
            return "redirect:/user/main";
        }else {
            return "login";
        }
    }

    @RequestMapping("/main")
    public String main(){
        return "frame";
    }
}
