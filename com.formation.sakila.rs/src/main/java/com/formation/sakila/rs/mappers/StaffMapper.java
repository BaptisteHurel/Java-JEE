package com.formation.sakila.rs.mappers;


import com.formation.sakila.rs.dtos.StaffDto;
import com.formation.sakila.rs.entities.Address;
import com.formation.sakila.rs.entities.Staff;

public interface StaffMapper {
    public static Staff toDao(StaffDto dto){
        Staff staff = new Staff();
        staff.setActive(dto.getActive());
        Address a = new Address();
        a.setId(dto.getAddressId());
        staff.setAddress(a);
        staff.setEmail(dto.getEmail());
        staff.setFirstName(dto.getFirstName());
        staff.setLastName(dto.getLastName());
        staff.setId(dto.getId());
        staff.setLastUpdate(dto.getLastUpdate());
        staff.setPassword(dto.getPassword());
        staff.setUsername(dto.getUsername());
        // Leave picture to null
        return staff;
    }
    public static StaffDto toDto(Staff staff){
        StaffDto dto = new StaffDto();
        dto.setActive(staff.getActive());
        dto.setAddressId(staff.getAddress().getId());
        dto.setEmail(staff.getEmail());
        dto.setFirstName(staff.getFirstName());
        dto.setLastName(staff.getLastName());
        dto.setId(staff.getId());
        dto.setLastUpdate(staff.getLastUpdate());
        dto.setPassword(staff.getPassword());
        dto.setStoreId(staff.getStoreId());
        dto.setUsername(staff.getUsername());
        return dto;
    }
}
