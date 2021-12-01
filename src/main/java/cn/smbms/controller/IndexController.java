package cn.smbms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author： 吕二宁
 * @date： 2021-11-30 08:28
 */
@Controller
public class IndexController extends AbstractController {

    @Override
    @RequestMapping("index.html")
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        System.out.println("程序被访问了");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Index");
        return modelAndView;
    }

    @RequestMapping("huanying")
    public ModelAndView husnying(@RequestParam(value = "name", required = false) String userName) {
        System.out.println(userName);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject( "name",userName);
        modelAndView.setViewName("Login");
        return modelAndView;
    }

    @RequestMapping("welcome")
    public String welcome(String name, Map<String, Object> map){
        map.put("name", name);
        return "Login";
    }

    @RequestMapping("Index")
    public ModelAndView Index(@RequestParam(value = "name",required = false) String userName){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name",userName);
        modelAndView.setViewName("Login");
        return modelAndView;
    }
}
