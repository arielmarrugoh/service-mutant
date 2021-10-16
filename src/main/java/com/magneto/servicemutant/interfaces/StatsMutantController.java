package com.magneto.servicemutant.interfaces;

import com.magneto.servicemutant.services.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
    @RequestMapping("stats/")
public class StatsMutantController {

    @Autowired
    private StatsService statsService;

    @GetMapping
    public ResponseEntity stats() {

        return new ResponseEntity<>(statsService.getAllStats(), HttpStatus.OK);
    }
}
