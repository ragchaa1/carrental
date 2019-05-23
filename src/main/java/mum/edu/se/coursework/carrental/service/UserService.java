package mum.edu.se.coursework.carrental.service;

import mum.edu.se.coursework.carrental.entity.User;
import mum.edu.se.coursework.carrental.entity.UserRole;
import mum.edu.se.coursework.carrental.repository.UserRepository;
import mum.edu.se.coursework.carrental.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;




    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public UserRole findbyUserId(Long userId){
        return userRoleRepository.findByUserId(userId);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findByUserId(id);
    }

    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        //  Role userRole = roleRepository.findByRole("ADMIN");
        //  user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        User save = userRepository.save(user);
        UserRole userRole = new UserRole();
        userRole.setRoleId(2L);
        userRole.setUserId(save.getUserId());
        userRoleRepository.save(userRole);
    }
}
