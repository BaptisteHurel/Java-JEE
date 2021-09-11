package com.formation.sakila.rs.adapters;

import com.formation.sakila.rs.dtos.StaffDto;
import com.formation.sakila.rs.entities.StaffPicture;

import java.util.List;

public interface StaffAdapter {
    public StaffDto find(Long id);
    public List<StaffDto> findAll();
    public StaffDto save(StaffDto staffDto);
    public byte[] getOnePicture(Long id);
    public StaffPicture findPicture(Long id);
    public void savePicture(StaffPicture staffPicture);
}
