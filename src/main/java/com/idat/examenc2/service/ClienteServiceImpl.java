package com.idat.examenc2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.examenc2.dto.ClienteDTORequest;
import com.idat.examenc2.dto.ClienteDTOResponse;
import com.idat.examenc2.model.Cliente;
import com.idat.examenc2.repository.ClienteRepository;


@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository repository;

	@Override
	public void guardarCliente(ClienteDTORequest cliente) {
		
		Cliente c = new Cliente();
		c.setNombre(cliente.getNombreCliente());
		c.setDireccion(cliente.getDireccionCliente());
		c.setDni(cliente.getDniCliente());
		repository.save(c);
	}

	@Override
	public void actualizarCliente(ClienteDTORequest cliente) {
		
		Cliente c = new Cliente();
		c.setNombre(cliente.getNombreCliente());
		c.setDireccion(cliente.getDireccionCliente());
		c.setDni(cliente.getDniCliente());
		repository.saveAndFlush(c);
		
	}

	@Override
	public void eliminarCliente(Integer id) {
		
		repository.deleteById(id);
		
	}

	@Override
	public List<ClienteDTOResponse> listarClientes() {
		

		List<ClienteDTOResponse> listar = new ArrayList<>();
		
		ClienteDTOResponse dto = null;
		
		List<Cliente> c = repository.findAll();
		
		for (Cliente cliente : c) {
			
			dto = new ClienteDTOResponse();
			
			dto.setNombreCliente(cliente.getNombre());
			dto.setDireccionCliente(cliente.getDireccion());
			dto.setDniCliente(cliente.getDni());
			dto.setId(cliente.getIdCliente());
			
			listar.add(dto);
		}
		
		return listar;
	}
	

	@Override
	public ClienteDTOResponse obtenerClienteId(Integer id) {
		
		Cliente cliente = repository.findById(id).orElse(null);
		ClienteDTOResponse dto = new ClienteDTOResponse();
		
		dto.setNombreCliente(cliente.getNombre());
		dto.setDireccionCliente(cliente.getDireccion());
		dto.setDniCliente(cliente.getDni());
		dto.setId(cliente.getIdCliente());
		
		return dto;
		
	}

}
