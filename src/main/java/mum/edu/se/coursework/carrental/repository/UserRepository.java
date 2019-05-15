package mum.edu.se.coursework.carrental.repository;

import mum.edu.se.coursework.carrental.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
    //userId
    User findByUserId(Long id);
}
