package com.formation.sakila.rs.services;

import com.formation.sakila.rs.entities.Staff;
import com.formation.sakila.rs.entities.StaffPicture;

import java.util.List;

public interface StaffService {
    public Staff findById(Long id);
    public List<Staff> findAll();
    public Staff save(Staff staff); // Create if not Exists

    public StaffPicture findPictureFor(Long id);
    public StaffPicture savePictureFor(StaffPicture staffPicture);
}
