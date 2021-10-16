package com.magneto.servicemutant.repositories.infrastructure;

import com.magneto.servicemutant.domain.model.Stats;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatsRepository extends MongoRepository<Stats, String> {

}
