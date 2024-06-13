package edu.pocs.sgonzalezb.poc_neo4j_service.infrastructure.internal.api.controller;


import edu.pocs.sgonzalezb.poc_neo4j_service.domain.user.service.UserService;
import edu.pocs.sgonzalezb.poc_neo4j_service.infrastructure.internal.api.UserDtoMapper;
import edu.pocs.sgonzalezb.poc_neo4j_service.infrastructure.internal.api.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping("/{name}")
    public UserDto findUserByUserName(
            @PathVariable("name") final String name) {
        return UserDtoMapper.fromModel(this.userService.findUserByName(name));
    }
}
