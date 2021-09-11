package com.formation.sakila.rs.adapters;

import com.formation.sakila.rs.dtos.StaffDto;
import com.formation.sakila.rs.entities.Staff;
import com.formation.sakila.rs.entities.StaffPicture;
import com.formation.sakila.rs.mappers.StaffMapper;
import com.formation.sakila.rs.services.StaffService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StaffAdapterImpl implements StaffAdapter {

    private StaffService service;

    public StaffAdapterImpl(StaffService service) {
        this.service = service;
    }

    @Override
    public StaffDto find(Long id) {
        return StaffMapper.toDto(service.findById(id));
    }

    @Override
    public List<StaffDto> findAll() {
        return service.findAll().stream().map(s->StaffMapper.toDto(s)).collect(Collectors.toList());
    }

    @Override
    public StaffDto save(StaffDto staffDto) {
        Staff staff = service.save(StaffMapper.toDao(staffDto));
        return StaffMapper.toDto(staff);
    }

    @Override
    public byte[] getOnePicture(Long id) {
        return service.findById(id).getPicture();
    }

    @Override
    public StaffPicture findPicture(Long id) {
        return service.findPictureFor(id);
    }

    @Override
    public void savePicture(StaffPicture staffPicture) {
        service.savePictureFor(staffPicture);
    }
}
