package com.magneto.servicemutant.events.consume.internal;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.magneto.servicemutant.domain.dto.DnaDTO;
import com.magneto.servicemutant.events.consume.SaveSms;
import com.magneto.servicemutant.services.IsMutantService;
import com.magneto.servicemutant.services.StatsService;
import com.magneto.servicemutant.util.NitrogenousBaseConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class DefaultSaveSmsConsume implements SaveSms {

    @Autowired
    private IsMutantService isMutantService;
    @Autowired
    private StatsService statsService;
    @Autowired
    private ObjectMapper mapper;

    @Override
    @JmsListener(destination = NitrogenousBaseConstant.INBOUND_SAVE)
    public void consume(String json) throws IOException {
        DnaDTO dnaDTO = mapper.readValue(json, DnaDTO.class);

        this.isMutantService.save(dnaDTO);
        this.statsService.calculate();
    }
}
