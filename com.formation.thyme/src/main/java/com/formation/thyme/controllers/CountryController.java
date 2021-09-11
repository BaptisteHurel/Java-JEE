package com.formation.thyme.controllers;

import com.formation.thyme.adapters.CountryAdapter;
import com.formation.thyme.dtos.CountryDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalTime;

@Controller
    @RequestMapping(value = "/countries")
        @SessionAttributes({"userValid","version","message"})
public class CountryController {
    private final static Logger log = LoggerFactory.getLogger(CountryController.class);

    private CountryAdapter adapter;

    public CountryController(CountryAdapter adapter, String version) {
        this.adapter = adapter;
    }

    @GetMapping({"","/all"})
    private String getAll(Model model){
        log.trace("getAll called...");
        model.addAttribute("countries",adapter.getAll());
        return "countries";
    }

    @GetMapping({"/modify"})
    private String modifyCountry(@RequestParam("id") Long id,
                                 @RequestParam("option") String modify,
                                 Model model){
        log.trace("modifyCountry id : {}, option={}",id,modify);
        model.addAttribute("option",modify);
        CountryDto countryDto;
        if ( id < 0 )
            countryDto = new CountryDto();
        else
            countryDto = adapter.getOne(id);

        model.addAttribute("countryDto",countryDto);

        return "modifyCountry";
    }

    @PostMapping("/validate")
    public String modifyCountry(@Valid CountryDto countryDto, BindingResult result, Model model){
        log.trace("Validation modifyCountry : {} ",countryDto);

        if (result.hasErrors()){
            log.trace("Validation ERRORS :{}, {}",result.getErrorCount(),result.getFieldErrors());
//          model.addAttribute("country",country);
            return "modifyCountry";
        }
        adapter.update(countryDto);
        return "redirect:/countries";
    }

    @PostMapping("/delete/{id}")
    public String deleteCountry(@PathVariable("id") Long id){
        log.trace("Delete Country Id : {} ",id);
        adapter.delete(id);
        return "redirect:/countries";
    }
}
