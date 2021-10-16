package com.magneto.servicemutant.interfaces;

import com.magneto.servicemutant.services.IsMutantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
    @RequestMapping("mutant/")
public class IsMutantController {

    @Autowired
    private IsMutantService isMutantService;

    @PostMapping
    public ResponseEntity isMutant(@RequestBody final String [] dnas) {
        String[] dnaUppercase = new String[dnas.length];
        for(int i= 0; i<dnas.length; i++){
            dnaUppercase[i]= dnas[i].trim().toUpperCase();

        }
        boolean result= this.isMutantService.isMutant(dnaUppercase);
        if(result){
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
}
