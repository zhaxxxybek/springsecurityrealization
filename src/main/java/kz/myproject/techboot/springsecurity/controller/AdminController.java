package kz.myproject.techboot.springsecurity.controller;


import kz.myproject.techboot.springsecurity.Service.UserService;
import kz.myproject.techboot.springsecurity.model.User;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@AllArgsConstructor
@Controller
public class AdminController {
    private UserService userService;


    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "admin-panel")
    public String getAdminPanel(Model model){
        List<User> userList = userService.getAllUsers();
        model.addAttribute("users", userList);
        return "admin";
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "/details/{userId}")
    public String userDetails(@PathVariable(name = "userId")Long id,Model model){
        User user=userService.getUser(id);
        model.addAttribute("users",user);
        return "details";
    }

}