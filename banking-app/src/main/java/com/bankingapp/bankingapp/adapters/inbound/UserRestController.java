package com.bankingapp.bankingapp.adapters.inbound;

import com.bankingapp.bankingapp.adapters.dto.user.UserConverter;
import com.bankingapp.bankingapp.adapters.dto.user.UserDTO;
import com.bankingapp.bankingapp.application.controller.UserController;
import com.bankingapp.bankingapp.domain.entity.User;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    private final UserController userController;

    public UserRestController(UserController userController) {
        this.userController = userController;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        UserConverter converter = new UserConverter();
        User userEntity = converter.fromDto(userDTO);
        UserDTO userdto = userController.createUser(userEntity);
        return ResponseEntity.status(200)
                .body(userdto);
    }
    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> userdto = userController.getAllUser();
        return ResponseEntity.status(200)
                .body(userdto);
    }
}
