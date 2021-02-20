package com.cihangir.controller;

import com.cihangir.dao.UserRepository;
import com.cihangir.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

  private final UserRepository userRepository;

  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @RequestMapping(value = "/saveNewUser", method = RequestMethod.POST)
  public String saveUser(@ModelAttribute("newUser") User user) {

    user.setActivated(true);
    userRepository.save(user);

    return "redirect:/login";
  }

}
