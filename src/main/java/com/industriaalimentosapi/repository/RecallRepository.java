package com.industriaalimentosapi.repository;

import com.industriaalimentosapi.model.Recall;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecallRepository extends JpaRepository<Recall, Long> {
}
