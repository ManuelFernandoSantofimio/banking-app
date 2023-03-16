package com.bankingapp.bankingapp.adapters.inbound;

import com.bankingapp.bankingapp.adapters.dto.user.UserConverter;
import com.bankingapp.bankingapp.adapters.dto.user.UserDTO;
import com.bankingapp.bankingapp.application.controller.UserController;
import com.bankingapp.bankingapp.domain.entity.User;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    private final UserController userController;

    public UserRestController(UserController userController, UserController userControoler) {
        this.userController = userController;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<User> createUser(@RequestBody UserDTO user){
        UserConverter converter = new UserConverter();
        User userEntity = converter.fromDto(user);
        userController.createUser(userEntity);
        return ResponseEntity.status(200)
                .body(userEntity);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> viewAllUser(@PathVariable  UserDTO userDTO){
        UserConverter converter = new UserConverter();
        User userEntity = converter.fromDto(userDTO);
        userController.createUser(userEntity);
        return null;
    }
}
