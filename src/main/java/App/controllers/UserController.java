package App.controllers;

import App.entities.User;
import App.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

/**
 * Created by MoustafaELkady on 1/8/18.
 */

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value="/users")
    Page<User> list(Pageable pageable){
        Page<User> persons = userService.listAllByPage(pageable);
        return persons;
    }

    @PostMapping(value="/create")
    void create(@Valid @RequestBody User user){
        userService.save(user);
//        URI location = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(savedUser.getId()).toUri();

//        return ResponseEntity.created(location).build();
    }

}
