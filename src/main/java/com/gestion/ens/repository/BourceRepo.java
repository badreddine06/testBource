package com.gestion.ens.repository;


import com.gestion.ens.entity.Bource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BourceRepo extends JpaRepository<Bource, Long> {
 Optional<Bource> findById (Long id);


}
