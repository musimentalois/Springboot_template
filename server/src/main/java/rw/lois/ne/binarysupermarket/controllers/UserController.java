package rw.lois.ne.binarysupermarket.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import rw.lois.ne.binarysupermarket.dtos.SignUpDTO;
import rw.lois.ne.binarysupermarket.enums.ERole;
import rw.lois.ne.binarysupermarket.models.User;
import rw.lois.ne.binarysupermarket.payload.ApiResponse;
import rw.lois.ne.binarysupermarket.services.IUserService;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/users")
@CrossOrigin
public class UserController {

    private final IUserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    public UserController(IUserService userService,BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @GetMapping(path = "/current-user")
    public ResponseEntity<ApiResponse> currentlyLoggedInUser() {
        return ResponseEntity.ok(new ApiResponse(true, userService.getLoggedInUser()));
    }

    @PostMapping(path = "/register/as-admin")
    public ResponseEntity<ApiResponse> registerAsAdmin(@Valid @RequestBody SignUpDTO dto) {

        User user = new User();

        String encodedPassword = bCryptPasswordEncoder.encode(dto.getPassword());

        user.setFirstName(dto.getFirstname());
        user.setPhone(dto.getPhone());
        user.setEmail(dto.getEmail());
        user.setRole(ERole.ADMIN);
        user.setPassword(encodedPassword);

        User entity = this.userService.create(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(true, entity));
    }

    @PostMapping(path = "/register/as-customer")
    public ResponseEntity<ApiResponse> registerAsCustomer(@Valid @RequestBody SignUpDTO dto) {

        User user = new User();

        String encodedPassword = bCryptPasswordEncoder.encode(dto.getPassword());

        user.setFirstName(dto.getFirstname());
        user.setPhone(dto.getPhone());
        user.setEmail(dto.getEmail());
        user.setRole(ERole.CUSTOMER);
        user.setPassword(encodedPassword);

        User entity = this.userService.create(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(true, entity));
    }

}