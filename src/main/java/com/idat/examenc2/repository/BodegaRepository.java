package com.idat.examenc2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.examenc2.model.Bodega;

@Repository
public interface BodegaRepository extends JpaRepository<Bodega, Integer>{

}
