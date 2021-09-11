package com.formation.sakila.rs.controllers;

import com.formation.sakila.rs.adapters.StaffAdapter;
import com.formation.sakila.rs.dtos.StaffDto;
import com.formation.sakila.rs.entities.StaffPicture;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

@RestController
    @RequestMapping("/staff")
public class StaffController {
    private static final Logger log = LogManager.getLogger(StaffController.class);

    private final StaffAdapter adapter;

    public StaffController(StaffAdapter adapter) {
        this.adapter = adapter;
    }

    @GetMapping("/{id}")
    public StaffDto getOne(@PathVariable(value = "id") Long id){
        log.debug("getOne Id("+id+")");
        return adapter.find(id);
    }

    @GetMapping({"","/all"})
    public List<StaffDto> getAll(){
        log.debug("getAll called ...");
        return adapter.findAll();
    }

    /**
     * Special treat because pictures is created from
     * - Spring MVC Controller OR
     * - Spring RestController and it is not the same process
     * - So some gymnastic here ;-)
     * @param id : Long id of Staff
     * @return : Binary byte array
     */
    @GetMapping(value="/pic/{id}", produces = {MediaType.IMAGE_JPEG_VALUE,MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_GIF_VALUE})
    public  byte[] getPicture(@PathVariable(value = "id") Long id) {
        log.debug("getPicture called ...");
        byte[] bArray =adapter.findPicture(id).getPicture();

        if ( bArray != null) {
            String test = new String(Arrays.copyOfRange(bArray, 0, 10));
            log.debug("test string :" + test);

            if (test.startsWith("data:image")) {
                log.debug("bArray 1 : " + bArray.length);
                bArray = Base64.getDecoder().decode(Arrays.copyOfRange(bArray, 23, bArray.length));
                log.debug("bArray 2 : " + bArray.length);
            }else{
                log.debug("bArray byte[] : " + bArray.length);
            }
        }
        return bArray;
    }

    /**
     * This Web Service perform picture update for
     * an Staff record
     * @param id : StaffId (Long)
     * @param file : Binary file of picture
     * @return : True | false
     * @throws IOException : If file is not passed
     */
    @PostMapping(value="/addPic/{id}")
    @ResponseBody
    public Boolean addPicture(@PathVariable(value = "id") Long id,
                              @RequestParam(value = "picture") MultipartFile file) throws IOException {
        log.debug("addPicture called Id("+id+")");
        boolean status;
        if ( file != null ) {
            log.debug("picture size :" + file.getBytes().length);
            StaffPicture staffPicture = new StaffPicture();
            staffPicture.setId(id);
            staffPicture.setPicture(file.getBytes());
            adapter.savePicture(staffPicture);
            status = true;
        }else {
            log.debug("No Picture send ...");
            status = false;
        }
        return status;
    }
}
