package com.magneto.servicemutant.services.internal;

import com.magneto.servicemutant.domain.dto.DnaDTO;
import com.magneto.servicemutant.domain.dto.ResultValidate;
import com.magneto.servicemutant.domain.model.Dna;
import com.magneto.servicemutant.events.publish.SaveSms;
import com.magneto.servicemutant.repositories.infrastructure.DnaRepository;
import com.magneto.servicemutant.services.IsMutantService;
import com.magneto.servicemutant.util.NitrogenousBaseConstant;
import com.magneto.servicemutant.validator.ValidationProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DefaultIsMutantService implements IsMutantService {

    @Autowired
    private ValidationProvider validationProvider;
    @Autowired
    private DnaRepository dnaRepository;
    @Autowired
        private SaveSms saveSmse;

    @Override
    public boolean isMutant(String[] dna) {
        boolean isMutant = false;
        ResultValidate resultValidate =validationProvider.validate(dna);
        if(!resultValidate.isValid()) {
            return false;
        }

        DnaDTO dnaDTO = new DnaDTO();
        dnaDTO.setValue(dna);

        try {
            if (resultValidate.getSequenceCount() >= NitrogenousBaseConstant.MUTANT_SEQUENCE_COUNT) {
                dnaDTO.setMutant(true);
                saveSmse.send(dnaDTO);

                isMutant = true;
            } else {
                dnaDTO.setMutant(false);
                    saveSmse.send(dnaDTO);
                isMutant = false;
            }
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return isMutant;
    }

    public void save(DnaDTO dna) {
        Dna dnaEntity= new Dna();
        dnaEntity.setValue(dna.getValue());
        dnaEntity.setMutant(dna.isMutant());
        this.dnaRepository.save(dnaEntity);
    }

}
