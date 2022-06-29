package com.idat.examenc2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.examenc2.model.Productos;


@Repository
public interface ProductoRepository  extends JpaRepository<Productos, Integer>{
 
}
