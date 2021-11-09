package com.usrcontrol.usrinfo.controller.admin;

import com.usrcontrol.usrinfo.entity.User;
import com.usrcontrol.usrinfo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.usrcontrol.usrinfo.entity.Result;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    /**
     * Login
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public Result login(@RequestParam("username") String username, @RequestParam("password") String password) {
        System.out.println("username:" + username + ", password:" + password);
        User user = userService.findByName(username);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                attributes.getRequest().getSession().setAttribute("user", user);
                return new Result(true, user.getUsername());
            }
        }
        return new Result(false, "Login failure");
    }

    /**
     * logout
     *
     * @return
     */
    @RequestMapping("/logout")
    public String logout() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        attributes.getRequest().getSession().removeAttribute("user");
        return "home/login";
    }


    /**
     * register
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/register")
    @ResponseBody
    public Result register(@RequestParam("username") String username, @RequestParam("password") String password) {
        try {
            userService.create(new User(username, password));
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            attributes.getRequest().getSession().setAttribute("user", new User(username, password));
            return new Result(true, username);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(false, "Error");
    }

    /**
     * login
     *
     * @return
     */
    @GetMapping("/login")
    public String login() {
        return "home/login";
    }

    /**
     * register
     *
     * @return
     */
    @GetMapping("/register")
    public String register(){
        return "home/register";
    }
}
