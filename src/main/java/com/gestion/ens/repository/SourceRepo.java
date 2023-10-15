package com.gestion.ens.repository;

import com.gestion.ens.entity.Bource;
import com.gestion.ens.entity.Source;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SourceRepo extends JpaRepository<Source,Long> {
}
