package edu.kpi.iasa.mmsa.ka97.workshop.service;

import edu.kpi.iasa.mmsa.ka97.workshop.model.User;
import edu.kpi.iasa.mmsa.ka97.workshop.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository UserRepository;
    public UserService(UserRepository UserRepository) {
        this.UserRepository = UserRepository;
    }
    public List<User> getUser() {
        return UserRepository.findAll();
    }
}
