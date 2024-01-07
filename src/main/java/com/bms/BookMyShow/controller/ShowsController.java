package com.bms.BookMyShow.controller;

import com.bms.BookMyShow.dtos.ShowsDTO;
import com.bms.BookMyShow.entities.Shows;
import com.bms.BookMyShow.service.ShowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShowsController {

    @Autowired
    ShowsService showsService;


    @PostMapping(value="/shows",  produces="application/json", consumes = "application/json")
    public  void save(@RequestBody ShowsDTO req)
    {
        showsService.save(req);
    }

    @GetMapping(value = "/shows", produces="application/json")
    public List<Shows> getShows()
    {
        return showsService.getShows();
    }
}
