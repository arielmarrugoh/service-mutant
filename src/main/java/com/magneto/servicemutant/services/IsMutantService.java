package com.magneto.servicemutant.services;

import com.magneto.servicemutant.domain.dto.DnaDTO;

public interface IsMutantService {

    boolean isMutant(String[] dna);
    void save(DnaDTO dna);
}
