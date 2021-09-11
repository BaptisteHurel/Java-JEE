package com.formation.sakila.rs.repositories;

import com.formation.sakila.rs.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface StaffRepository extends JpaRepository<Staff,Long> {

}
