package com.formation.thyme.controllers;

import com.formation.thyme.adapters.CityAdapter;
import com.formation.thyme.adapters.CountryAdapter;
import com.formation.thyme.dtos.CityDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
    @RequestMapping("/cities")
        @SessionAttributes({"userValid","version","message"})
public class CityController {
    private final static Logger log = LoggerFactory.getLogger(CityController.class);

    private CityAdapter adapter;
    private CountryAdapter countryAdapter;

    public CityController(CityAdapter adapter, CountryAdapter countryAdapter) {
        this.adapter = adapter;
        this.countryAdapter = countryAdapter;
    }

    @GetMapping({"","all"})
    public String getAll(Model model, HttpSession session){
        log.trace("getAll called..");
        model.addAttribute("cities",adapter.getAll());
        return "cities";
    }

    @GetMapping({"/capitals"})
    public String getAllCapitals(@RequestParam(required = false) Boolean capitals,
                                 Model model, HttpSession session){
        log.trace("getAllCapitals called option :{}",capitals);

        if (capitals == null )
            capitals = Boolean.TRUE;
        else
            capitals = ! capitals ;

        if ( capitals ) {
            log.trace("All Capitals called");
            model.addAttribute("capitals", Boolean.TRUE);
            model.addAttribute("cities", adapter.getAllCapitals());
        } else {
            log.trace("All Cities called..");
            model.addAttribute("capitals", Boolean.FALSE);
            model.addAttribute("cities", adapter.getAll());
        }
        //model.addAttribute("userValid",userValid);
        return "cities";
    }

    @GetMapping({"/modify"})
    private String modifyCity(@RequestParam("id") Long id,
                              @RequestParam("option") String modify,
                              Model model){
        log.trace("modifyCity id : {}, option={}",id,modify);
        model.addAttribute("option",modify);
/*        model.addAttribute("userValid",userValid);*/
        model.addAttribute("countries",countryAdapter.getAll());
        CityDto cityDto;
        if ( id < 0 )
            cityDto = new CityDto();
        else
            cityDto = adapter.getOne(id);

        model.addAttribute("cityDto",cityDto);

        return "modifyCity";
    }

    @PostMapping("/validate")
    public String modifyCity(@Valid CityDto cityDto, BindingResult result, Model model){
        log.trace("Validation modify City : {} ",cityDto);

        if (result.hasErrors()){
            log.trace("Validation ERRORS :{}, {}",result.getErrorCount(),result.getFieldErrors());
            return "modifyCity";
        }
        adapter.update(cityDto);
        return "redirect:/cities";
    }



    @PostMapping("/delete/{id}")
    public String deleteCountry(@PathVariable("id") Long id){
        log.trace("Delete City Id : {} ",id);
        adapter.delete(id);
        return "redirect:/cities";
    }
}
