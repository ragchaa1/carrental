package mum.edu.se.coursework.carrental.repository;

import mum.edu.se.coursework.carrental.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
    @Override
    Optional<UserRole> findById(Long aLong);

    UserRole findByUserId(Long userId);
}
