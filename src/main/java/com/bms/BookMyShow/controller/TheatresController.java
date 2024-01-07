package com.bms.BookMyShow.controller;

import com.bms.BookMyShow.dtos.TheatresDTO;
import com.bms.BookMyShow.entities.Shows;
import com.bms.BookMyShow.entities.Theatres;
import com.bms.BookMyShow.service.TheatresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TheatresController {

    @Autowired
    private TheatresService theatresService;

    @PostMapping("/theatres")
    public void addTheatres(@RequestBody TheatresDTO req)
    {
        theatresService.saveTheatres(req);
    }

    @GetMapping(value = "/theatres", produces="application/json")
    public List<Theatres> getTheatres()
    {
        return theatresService.getTheatres();
    }
}
