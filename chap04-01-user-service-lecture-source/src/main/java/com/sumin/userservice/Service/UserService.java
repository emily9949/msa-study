package com.sumin.userservice.Service;

import com.sumin.userservice.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void registUser(UserDTO userDTO);

}
