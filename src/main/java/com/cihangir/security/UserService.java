package com.cihangir.security;

import com.cihangir.dao.UserRepository;
import com.cihangir.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User findUserByEmail(String email) {
    return userRepository.findByMail(email);
  }

  public User findUserByUserName(String userName) {
    return userRepository.findByUsername(userName);
  }

  public User getCurrentUser(){
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    return findUserByUserName(auth.getName());
  }

  @Transactional
  public User saveUser(User user) {
    user.setActivated(true);
    return userRepository.save(user);
  }

}
