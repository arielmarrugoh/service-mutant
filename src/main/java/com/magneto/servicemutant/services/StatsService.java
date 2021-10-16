package com.magneto.servicemutant.services;

import com.magneto.servicemutant.domain.model.Stats;

import java.util.List;

public interface StatsService {

    void calculate();
    void delete();
    List<Stats> getAllStats();
}
