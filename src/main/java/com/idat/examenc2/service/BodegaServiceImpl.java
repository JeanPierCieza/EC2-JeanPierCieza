package com.idat.examenc2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.examenc2.dto.BodegaDTORequest;
import com.idat.examenc2.dto.BodegaDTOResponse;
import com.idat.examenc2.model.Bodega;
import com.idat.examenc2.repository.BodegaRepository;


@Service
public class BodegaServiceImpl implements BodegaService {
	
	@Autowired
	private BodegaRepository repository;

	@Override
	public void guardarBodega(BodegaDTORequest bodega) {
		
		Bodega b = new Bodega();
		b.setNombre(bodega.getNombreBodega());
		b.setDireccion(bodega.getDireccionBodega());
		repository.save(b);
	
	}

	@Override
	public void actualizarBodega(BodegaDTORequest bodega) {
		
		Bodega b = new Bodega();
		b.setNombre(bodega.getNombreBodega());
		b.setDireccion(bodega.getDireccionBodega());
		repository.saveAndFlush(b);
			
	}

	@Override
	public void eliminarBodega(Integer id) {
		
		repository.deleteById(id);
	}

	@Override
	public List<BodegaDTOResponse> listarBodega() {
		

		List<BodegaDTOResponse> listar = new ArrayList<>();
		
		BodegaDTOResponse dto = null;
		
		List<Bodega> b = repository.findAll();
		
		for (Bodega bodega : b) {
			
			dto = new BodegaDTOResponse();
			
			dto.setNombreBodega(bodega.getNombre());
			dto.setDireccionBodega(bodega.getDireccion());
			dto.setId(bodega.getIdBodega());
			
			listar.add(dto);
		}
		
		return listar;
	}

	@Override
	public BodegaDTOResponse obtenerBodegaId(Integer id) {
		
		Bodega bodega = repository.findById(id).orElse(null);
		BodegaDTOResponse dto = new BodegaDTOResponse();
		
		dto.setNombreBodega(bodega.getNombre());
		dto.setDireccionBodega(bodega.getDireccion());
		dto.setId(bodega.getIdBodega());
		
		return dto;
	}

}
