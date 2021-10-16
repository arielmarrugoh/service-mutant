package com.magneto.servicemutant.events.consume;

import java.io.IOException;

public interface SaveSms {
    void consume(String json)throws IOException;

}
