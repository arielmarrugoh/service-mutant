package com.magneto.servicemutant.services.internal;

import com.magneto.servicemutant.domain.model.Dna;
import com.magneto.servicemutant.domain.model.Stats;
import com.magneto.servicemutant.repositories.infrastructure.DnaRepository;
import com.magneto.servicemutant.repositories.infrastructure.StatsRepository;
import com.magneto.servicemutant.services.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultStatsService implements StatsService {

    @Autowired
    private StatsRepository statsRepository;
    @Autowired
    private DnaRepository dnaRepository;

    @Override
    public void calculate() {
        List<Dna> dnas=dnaRepository.findAll();
        Stats stats= countDna(dnas);

        this.delete();
        statsRepository.save(stats);
    }

    public void delete(){
        statsRepository.deleteAll();
    }

    @Override
    public List<Stats> getAllStats() {
        return statsRepository.findAll();
    }

    public Stats countDna(List<Dna> dnas){
        Stats stats = new Stats();

        for(Dna dna: dnas){
            if(dna.isMutant()){
                stats.setCount_mutant_dna(stats.getCount_mutant_dna()+1);
            }else{
                stats.setCount_human_dna(stats.getCount_human_dna()+1);
            }
        }
        stats.setRatio(ratio(stats));
        return stats;
    }



    private double ratio(Stats stats){
        if(stats.getCount_human_dna() == 0){
            return stats.getCount_human_dna() ;
        }else if(stats.getCount_mutant_dna() == 0){
            return stats.getCount_human_dna();
        }else{
            float ratio = (float)stats.getCount_human_dna() / stats.getCount_mutant_dna();
            return ratio;
        }
    }
}
