package com.magneto.servicemutant.services;

import com.magneto.servicemutant.domain.model.Dna;
import com.magneto.servicemutant.domain.model.Stats;
import com.magneto.servicemutant.repositories.infrastructure.DnaRepository;
import com.magneto.servicemutant.repositories.infrastructure.StatsRepository;
import com.magneto.servicemutant.services.internal.DefaultStatsService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = {DefaultStatsService.class})
public class DefaultStatsServiceTest {

    @InjectMocks
    private DefaultStatsService defaultIsMutantService;

    @Mock
    private StatsRepository statsRepository;
    @Mock
    private DnaRepository dnaRepository;

    private final String[] dnaMutant = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
    private final String[] notMutantDna = {"ATGCGA","CAGTGC","TTATTT","AGACGG","GCGTCA","TCACTG"};
    private final String[] invalidDna = {"TTGCGA", "TGXCGA"};
    private Dna dna;



    @Test
    public void getAll(){

        Assert.assertNotNull(defaultIsMutantService.getAllStats());
    }

    @Test
    public void countDnaMutantWithHumanZero(){
        List<Dna> dnaList = new ArrayList<>();
        Dna dnaMutant = new Dna();
        dnaMutant.setMutant(true);

        dnaList.add(dnaMutant);
        Stats stats = this.defaultIsMutantService.countDna(dnaList);
        Assert.assertEquals(1,stats.getCount_mutant_dna());
        Assert.assertEquals(0,stats.getCount_human_dna());
        Assert.assertEquals(1,stats.getRatio(), 1);
    }

    @Test
    public void countDnaHumanWithMutantZero(){
        List<Dna> dnaList = new ArrayList<>();
        Dna dnaMutant = new Dna();
        dnaMutant.setMutant(false);

        dnaList.add(dnaMutant);
        Stats stats = this.defaultIsMutantService.countDna(dnaList);
        Assert.assertEquals(0,stats.getCount_mutant_dna());
        Assert.assertEquals(1,stats.getCount_human_dna());
        Assert.assertEquals(1,stats.getRatio(), 1);
    }

    @Test
    public void countDnaHumanAndMutant(){
        List<Dna> dnaList = new ArrayList<>();
        Dna dnaHuman = new Dna();
        dnaHuman.setMutant(false);


        Dna dnaMutant = new Dna();
        dnaMutant.setMutant(true);

        dnaList.add(dnaHuman);
        dnaList.add(dnaMutant);
        dnaList.add(dnaMutant);
        Stats stats = this.defaultIsMutantService.countDna(dnaList);
        Assert.assertEquals(2,stats.getCount_mutant_dna());
        Assert.assertEquals(1,stats.getCount_human_dna());
        Assert.assertEquals(2,stats.getRatio(), 2);
    }

    @Test
    public void calculate() {
        this.defaultIsMutantService.calculate();
        verify(statsRepository,times(1)).deleteAll();
    }
}
