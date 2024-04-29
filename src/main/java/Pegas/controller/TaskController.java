package Pegas.controller;

import Pegas.dto.UserAgeFilterDto;
import Pegas.dto.UserReadDTO;
import Pegas.entity.User;
import Pegas.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
    private final UserService userService;

    @GetMapping("/filter/{age}")
    public List<UserReadDTO> filterByAge(@PathVariable Integer age, UserAgeFilterDto filter){
        return userService.findAll(age,filter);
    }

    @GetMapping("/sort")
    public Page<UserReadDTO> sortByAge(){
        var pageable = PageRequest.of(0, 3, Sort.by("age").descending());
        return userService.findAllSortByAge(pageable);
    }

    @GetMapping("/calc")
    public Double averageOfAge(){
        return userService.avgOfUsersAge();
    }
}
