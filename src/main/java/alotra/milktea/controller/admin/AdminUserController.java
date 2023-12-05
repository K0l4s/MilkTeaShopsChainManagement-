package alotra.milktea.controller.admin;

import alotra.milktea.entity.UserEntity;
import alotra.milktea.model.AdminUserModel;
import alotra.milktea.service.Interfaces.IUserService;
import alotra.milktea.service.Implements.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("admin/user")
public class AdminUserController {
    @Autowired
    IUserService userService = new UserServiceImpl();
    @GetMapping("/view")
    protected String displayUserList(Model model){
        List<UserEntity> listUser = userService.findAll();
        List<AdminUserModel> listUserRole = new ArrayList<AdminUserModel>();
        for(UserEntity item : listUser){
            AdminUserModel userModel = new AdminUserModel();
            userModel.setUser(item);
            userModel.setRolename("Admin");
            listUserRole.add(userModel);
        }
        model.addAttribute("list",listUserRole);
        return "/views/admin/display-users";
    };
}
