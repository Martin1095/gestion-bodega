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
    public List<Cliente> obtenerClientes(){
        return clienteRepository.findAll();
    }

    // Metodo para obtener un cliente por su ID
    public Cliente obtenerClientePorId(Integer id_cliente){
        return clienteRepository.findById(id_cliente)
                    .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + id_cliente));
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
    public Cliente actualizarCliente(Integer id_cliente, Cliente clienteActualizado) {
        Cliente cliente = clienteRepository.findById(id_cliente).orElseThrow(() -> new RuntimeException("¡Imposible editar! El cliente con ID " + id_cliente + " no existe."));
        
        if(cliente.getNombre() != null) {
            cliente.setNombre(clienteActualizado.getNombre());
        }
        if(cliente.getCorreo() != null) {
            cliente.setCorreo(clienteActualizado.getCorreo());
        }
        if(cliente.getTelefono() != 0) {
            cliente.setTelefono(clienteActualizado.getTelefono());
        }
        return clienteRepository.save(cliente);
    }

    // Método para buscar clientes por RUT
    public List<Cliente> buscarPorRut(String rut) {
        return clienteRepository.findByRut(rut);
    }




    
}