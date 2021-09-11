package com.formation.sakila.rs.repositories;


import com.formation.sakila.rs.entities.StaffPicture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffPictureRepository extends JpaRepository<StaffPicture,Long> {
}
