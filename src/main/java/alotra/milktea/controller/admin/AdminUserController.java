package alotra.milktea.controller.admin;

import alotra.milktea.service.Interfaces.IUserService;
import alotra.milktea.service.Implements.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/user")
public class AdminUserController {
    @Autowired
    IUserService userService = new UserServiceImpl();
    @GetMapping("/view")
    protected String displayUserList(){
        return null;
    };
}
