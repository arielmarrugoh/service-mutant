package com.magneto.servicemutant.repositories.infrastructure;

import com.magneto.servicemutant.domain.model.Dna;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DnaRepository extends MongoRepository<Dna, String> {
}
