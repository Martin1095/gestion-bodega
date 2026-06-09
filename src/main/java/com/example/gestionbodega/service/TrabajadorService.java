package com.example.gestionbodega.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.gestionbodega.DTO.TrabajadorDTO;
import com.example.gestionbodega.model.Trabajador;
import com.example.gestionbodega.repository.TrabajadorRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TrabajadorService {

    @Autowired
    private TrabajadorRepository trabajadorRepository;
    //metodo para obtener todos los trabajadores, devuelve una lista de TrabajadorDTO
    public List<TrabajadorDTO> obtenerTodos() {
        return trabajadorRepository.findAll()
            .stream()
            .map(this::convertirADTO)
            .toList();
    }

    //metodo para convertir un Trabajador a TrabajadorDTO
    private TrabajadorDTO convertirADTO(Trabajador trabajador) {
        TrabajadorDTO dto = new TrabajadorDTO();
        dto.setId(trabajador.getId_trabajador());
        dto.setNombre(trabajador.getNombre());
        dto.setCargo(trabajador.getCargo());
        dto.setEdad(trabajador.getEdad());
        return dto;
    }
    
    //metodo para guardar un trabajador, recibe un objeto Trabajador y lo guarda en la base de datos
    public Trabajador guardarTrabajador(Trabajador trabajador) {
        return trabajadorRepository.save(trabajador);
    }
}
