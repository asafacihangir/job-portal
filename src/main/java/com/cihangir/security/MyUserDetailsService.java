package com.cihangir.security;

import com.cihangir.enums.UserType;
import com.cihangir.model.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyUserDetailsService implements UserDetailsService {

  @Autowired
  private UserService userService;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    User user = userService.findUserByUserName(userName);
    List<GrantedAuthority> authorities = getUserAuthority(user.getUserType());
    return buildUserForAuthentication(user, authorities);
  }

  private List<GrantedAuthority> getUserAuthority(UserType userType) {
    List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
    grantedAuthorities.add(new SimpleGrantedAuthority(userType.toString()));
    return grantedAuthorities;
  }

  private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
    return new org.springframework.security.core.userdetails.User(user.getUsername(),
        user.getPassword(), user.getActivated(), true, true, true, authorities);
  }
}