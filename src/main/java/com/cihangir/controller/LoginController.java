package com.cihangir.controller;

import com.cihangir.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String getLoginPage() {
    return "common/login";
  }


  @RequestMapping(value = "/showCreateNewUser", method = RequestMethod.GET)
  public String showCreateNewUser(Model theModel) {
    User theBook=new User();
    theModel.addAttribute("newUser", theBook);
    return "common/create-new-user";
  }

}
