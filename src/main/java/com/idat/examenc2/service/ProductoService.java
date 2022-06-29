package com.idat.examenc2.service;

import java.util.List;

import com.idat.examenc2.dto.ProductoDTORequest;
import com.idat.examenc2.dto.ProductoDTOResponse;

public interface ProductoService {
	
	void guardarProducto(ProductoDTORequest producto);
	void actualizarProducto(ProductoDTORequest producto);
	void eliminarProducto(Integer id);
	List<ProductoDTOResponse> listarProductos();
	ProductoDTOResponse obtenerProductoId(Integer id);

}
