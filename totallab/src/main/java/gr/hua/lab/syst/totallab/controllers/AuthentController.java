package gr.hua.lab.syst.totallab.controllers;


import gr.hua.lab.syst.totallab.repositories.RoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.management.relation.Role;
import java.util.List;

@Controller
public class AuthentController {

    RoleRepository roleRepository;

    public AuthentController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    public void setup() {
        Role role_user = new Role("ROLE_USER", List.of());
        Role role_admin = new Role("ROLE_ADMIN", List.of());

        roleRepository.updateOrInsert(role_user);
        roleRepository.updateOrInsert(role_admin);
    }

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }
}
}
