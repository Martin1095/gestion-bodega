package com.example.gestionbodega.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionbodega.DTO.RecepcionDTO;
import com.example.gestionbodega.model.Recepcion;
import com.example.gestionbodega.repository.RecepcionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RecepcionService {

    @Autowired
    private RecepcionRepository recepcionRepository;

    public List<RecepcionDTO> obtenerTodos() {
        return recepcionRepository.findAll()
            .stream()
            .map(this::convertirADTO)
            .toList();
    }

    private RecepcionDTO convertirADTO(Recepcion recepcion) {
        RecepcionDTO dto = new RecepcionDTO();
        dto.setId(recepcion.getId());
        dto.setFecha(recepcion.getFecha());
        dto.setProveedorId(recepcion.getProveedor().getId());
        dto.setCantidad(recepcion.getCantidad());
        return dto;
    }

    public Recepcion guardarRecepcion(Recepcion recepcion) {
        return recepcionRepository.save(recepcion);
    }


}
