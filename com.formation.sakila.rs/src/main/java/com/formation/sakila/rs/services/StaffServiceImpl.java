package com.formation.sakila.rs.services;


import com.formation.sakila.rs.entities.Staff;
import com.formation.sakila.rs.entities.StaffPicture;
import com.formation.sakila.rs.repositories.StaffPictureRepository;
import com.formation.sakila.rs.repositories.StaffRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {
    private static Logger log = LogManager.getLogger(StaffServiceImpl.class);

    // Injection par constructeur
    private final StaffRepository repository;

    // Injection par constructeur
    private final StaffPictureRepository pictureRepository;

    public StaffServiceImpl(StaffRepository repository, StaffPictureRepository pictureRepository) {
        this.repository = repository;
        this.pictureRepository = pictureRepository;
    }

    @Override
    public Staff findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Staff> findAll() {
        return repository.findAll();
    }

    @Override
    public StaffPicture findPictureFor(Long id) {
        return pictureRepository.findById(id).orElse(null);
    }

    @Override
    public StaffPicture savePictureFor(StaffPicture staffPicture) {
        return pictureRepository.save(staffPicture);
    }

    @Override
    public Staff save(Staff staff) {
        return repository.save(staff);
    }
}
