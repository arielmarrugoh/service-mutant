package com.magneto.servicemutant.events.publish;

import com.magneto.servicemutant.domain.dto.DnaDTO;

import java.io.IOException;

public interface SaveSms {
    void send(DnaDTO dnaDTO) throws IOException;

}
