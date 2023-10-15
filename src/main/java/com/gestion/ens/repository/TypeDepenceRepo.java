package com.gestion.ens.repository;

import com.gestion.ens.entity.Bource;
import com.gestion.ens.entity.TypeDepence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeDepenceRepo extends JpaRepository<TypeDepence,Long> {
}
