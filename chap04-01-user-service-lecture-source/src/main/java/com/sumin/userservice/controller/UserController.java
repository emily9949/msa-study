package com.sumin.userservice.controller;

import com.sumin.userservice.Service.UserService;
import com.sumin.userservice.dto.UserDTO;
import com.sumin.userservice.vo.RequestRegistUserVO;
import com.sumin.userservice.vo.ResponseRegistUserVO;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController {

    private Environment env;
    private UserService userService;
    private ModelMapper modelMapper;

    @Autowired
    public UserController(Environment env, UserService userService, ModelMapper modelMapper) {
        this.env = env;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/health")
    public String status() {
        return "I'm Working in User Service " + env.getProperty("local.server.port");
    }

    @PostMapping("users")
    public ResponseEntity<ResponseRegistUserVO> registUser(@RequestBody RequestRegistUserVO newUser) {
        UserDTO userDTO = modelMapper.map(newUser, UserDTO.class);

        /* 설명. call by reference 개념 */
        userService.registUser(userDTO);   // service 가기 전과 후가 같은 객체이니 반환받을 필요가 없다.
        ResponseRegistUserVO successRegistUser = modelMapper.map(userDTO, ResponseRegistUserVO.class);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(successRegistUser);
    }

}
