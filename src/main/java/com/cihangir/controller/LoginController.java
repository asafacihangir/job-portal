package com.cihangir.controller;

import com.cihangir.dao.UserRepository;
import com.cihangir.model.User;
import com.cihangir.security.UserService;
import java.util.HashMap;
import java.util.Map;
import javax.jws.soap.SOAPBinding.Use;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

  private final UserService userService;
  private final UserRepository userRepository;

  public LoginController(UserService userService, UserRepository userRepository) {
    this.userService = userService;
    this.userRepository = userRepository;
  }

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String getLoginPage() {
    return "common/login";
  }


  @RequestMapping(value = "/showCreateNewUser", method = RequestMethod.GET)
  public String showCreateNewUser(Model theModel) {
    User theBook=new User();

    theModel.addAttribute("newUser", theBook);

    Map<String, String> userTypes = new HashMap<>();
    userTypes.put("USER","İş Arayan");
    userTypes.put("COMPANY_USER","İşveren");

    theModel.addAttribute("userTypes", userTypes);

    return "common/create-new-user";
  }

  @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
  public String updateUser(@ModelAttribute("currentUser") User user) {

    User user1 = getCurrentUser();

    user.setUserType(user1.getUserType());
    userRepository.save(user);
    return "redirect:/login";
  }



  private User getCurrentUser(){
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    return userService.findUserByUserName(auth.getName());
  }

}
