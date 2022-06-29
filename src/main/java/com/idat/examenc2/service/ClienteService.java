package com.idat.examenc2.service;

import java.util.List;

import com.idat.examenc2.dto.ClienteDTORequest;
import com.idat.examenc2.dto.ClienteDTOResponse;

public interface ClienteService {
	
	void guardarCliente(ClienteDTORequest cliente);
	void actualizarCliente(ClienteDTORequest cliente);
	void eliminarCliente(Integer id);
	List<ClienteDTOResponse> listarClientes();
	ClienteDTOResponse obtenerClienteId(Integer id);

}
