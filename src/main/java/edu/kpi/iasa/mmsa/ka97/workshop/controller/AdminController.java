package edu.kpi.iasa.mmsa.ka97.workshop.controller;

import edu.kpi.iasa.mmsa.ka97.workshop.model.ClinicData;
import edu.kpi.iasa.mmsa.ka97.workshop.model.User;
import edu.kpi.iasa.mmsa.ka97.workshop.repository.UserRepository;
import edu.kpi.iasa.mmsa.ka97.workshop.service.ClinicDataService;
import edu.kpi.iasa.mmsa.ka97.workshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/secured")
public class AdminController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    //@PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping(value = "/admin/add_user")
    public String addUserByAdmin(@RequestBody User user) {
        String password = user.getPassword();
        String encryptedPassword = passwordEncoder.encode(password);
        user.setPassword(encryptedPassword);
        userRepository.save(user);
        return "User was successfully added!";
    }
}
