package com.project.authProject.controller;

import com.project.authProject.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthController {

    @Autowired
    private AuthService authService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void handleRegister(@RequestParam(name = "username") String username,
                               @RequestParam(name = "password") String password,
                               Model model) {
        boolean success = this.authService.register(username, password);
        if (success) {
            model.addAttribute("successMessage", "Registration successful!");
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView handleLogin(@RequestParam(name = "username") String username,
                                    @RequestParam(name = "password") String password,
                                    Model model) {

        boolean success = this.authService.login(username, password);
        if (success) {
            ModelAndView homepage = new ModelAndView("homepage");
            homepage.addObject("username", username);
            return homepage;

        }
        ModelAndView loginPage = new ModelAndView("login");
        loginPage.addObject("errorMessage", "Invalid username or password");

        return loginPage;
    }
}
