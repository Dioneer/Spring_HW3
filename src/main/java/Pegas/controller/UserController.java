package Pegas.controller;

import Pegas.dto.UserCreateEditDTO;
import Pegas.dto.UserReadDTO;
import Pegas.service.NotificationService;
import Pegas.service.RegistrationService;
import Pegas.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final RegistrationService registrationService;
    private final NotificationService notificationService;

    @GetMapping
    public List<UserReadDTO> findAll(){
       return userService.findAll();
    }

    @PostMapping(value="/body")
    @ResponseStatus(HttpStatus.CREATED)
    public UserReadDTO create(@RequestBody UserCreateEditDTO user){
        notificationService.notifyUser(user);
        return registrationService.create(user);
    }

    @GetMapping("/{id}")
    public UserReadDTO findById(@PathVariable Long id){
        return userService.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public UserReadDTO update(@PathVariable Long id, @RequestBody UserCreateEditDTO user){
        return userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id){
        return userService.delete(id);
    }

    @GetMapping(value="/param")
    @ResponseStatus(HttpStatus.CREATED)
    public UserReadDTO create(@RequestParam String userName, @RequestParam Integer age, @RequestParam String email){
        UserCreateEditDTO user = new UserCreateEditDTO(userName, age, email);
        notificationService.notifyUser(user);
        return registrationService.create(user);
    }

}
