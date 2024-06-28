package com.example.demo.Repository;

import com.example.demo.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    // if I just made it an enum from the start I wouldn't have to do all this BS
}
