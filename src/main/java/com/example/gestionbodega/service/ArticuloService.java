package com.example.gestionbodega.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.gestionbodega.DTO.ArticuloDTO;
import com.example.gestionbodega.model.Articulo;
import com.example.gestionbodega.repository.ArticuloRepository;
import jakarta.transaction.Transactional;
@Service
@Transactional
public class ArticuloService {
    @Autowired
    private ArticuloRepository articuloRepository;
    // Convertir entidad a DTO
    private ArticuloDTO convertirADTO(Articulo articulo) {
        ArticuloDTO dto = new ArticuloDTO();
            dto.setId_articulo(articulo.getId_articulo());
            dto.setNombre(articulo.getNombre());
            dto.setMarca(articulo.getMarca());
            dto.setStock(articulo.getStock());
            dto.setPrecio(articulo.getPrecio());
            return dto;
    }
    // Obtener todos los artículos
    public List<ArticuloDTO> obtenerTodos() {
        return articuloRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .toList();
    }
    // Buscar artículo por id
    public ArticuloDTO buscarPorId(Integer id) {
        Articulo articulo = articuloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Artículo no encontrado"));
        return convertirADTO(articulo);
    }
    // Guardar artículo
    public Articulo guardarArticulo(Articulo articulo) {
        return articuloRepository.save(articulo);
    }
    // Eliminar artículo
    public String eliminarArticulo(Integer id) {
        try {
            Articulo articulo = articuloRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Artículo no encontrado"));
            articuloRepository.delete(articulo);
            return "Artículo eliminado correctamente";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }
    // Actualización parcial PATCH
    public Articulo actualizarArticulo(Integer id, Articulo articulo) {
        Articulo art = articuloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Artículo no encontrado"));
        if (articulo.getNombre() != null) {
            art.setNombre(articulo.getNombre());
        }
        if (articulo.getMarca() != null) {
            art.setMarca(articulo.getMarca());
        }
        if (articulo.getStock() != null) {
            art.setStock(articulo.getStock());
        }
        if (articulo.getPrecio() != null) {
            art.setPrecio(articulo.getPrecio());
        }
        return articuloRepository.save(art);
    }

}

