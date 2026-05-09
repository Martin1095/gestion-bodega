package com.example.gestionbodega.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionbodega.DTO.ClienteDTO;
import com.example.gestionbodega.model.Cliente;
import com.example.gestionbodega.repository.ClienteRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // Método para obtener todos los clientes
    public List<ClienteDTO> obtenerClientes(){
        return clienteRepository.findAll().stream()
                .map(this::convertirAClienteDTO)
                .toList();
    }

    // Metodo para obtener un cliente por su ID
    public Cliente obtenerClientePorId(Integer id_cliente){
        Cliente cliente = clienteRepository.findById(id_cliente)
                    .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + id_cliente));
        return convertirAClienteDTO(cliente);
    }

    // Metodo para eliminar un cliente por su ID
    public String eliminar(Integer id) {
        try {
            Cliente cliente = clienteRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("¡Imposible eliminar! El cliente con ID " + id + " no existe."));
            clienteRepository.delete(cliente);
            return "El cliente '" + cliente.getNombre() + "' ha sido eliminado exitosamente.";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    // Método para añadir un nuevo cliente
    public Cliente agregarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Método para actualizar un cliente existente
    public Cliente actualizarCliente(Integer id_cliente, Cliente clienteActu) {
        Cliente cliente = clienteRepository.findById(id_cliente).orElseThrow(() -> new RuntimeException("¡Imposible editar! El cliente con ID " + id_cliente + " no existe."));
        
        if(cliente.getNombre() != null) {
            cliente.setNombre(clienteActu.getNombre());
        }
        if(cliente.getCorreo() != null) {
            cliente.setCorreo(clienteActu.getCorreo());
        }
        if(cliente.getTelefono() != 0) {
            cliente.setTelefono(clienteActu.getTelefono());
        }
        return clienteRepository.save(cliente);
    }

    // Método para buscar clientes por RUT
    public List<ClienteDTO> buscarPorRut(String rut) {
        return clienteRepository.findByRut(rut).stream()
                .map(this::convertirAClienteDTO)
                .toList();
    }
    
    // Método para transformar un Cliente a ClienteDTO
    public ClienteDTO convertirAClienteDTO(Cliente cliente) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId_cliente(cliente.getId_cliente());
        clienteDTO.setNombre(cliente.getNombre());
        clienteDTO.setCorreo(cliente.getCorreo());
        clienteDTO.setTelefono(cliente.getTelefono());
        return clienteDTO;
    }

}