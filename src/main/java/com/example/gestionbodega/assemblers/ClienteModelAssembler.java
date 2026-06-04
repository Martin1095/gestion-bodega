package com.example.gestionbodega.assemblers;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


import com.example.gestionbodega.controller.ClienteControllerV2;

import com.example.gestionbodega.model.Cliente;



import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;



@Component
public class ClienteModelAssembler implements RepresentationModelAssembler<Cliente, EntityModel<Cliente>>  {

    @Override
    public EntityModel<Cliente> toModel(Cliente cliente) {
    return EntityModel.of(cliente,
            linkTo(methodOn(ClienteControllerV2.class).obtenerClientePorId(cliente.getId_cliente())).withSelfRel(),
            linkTo(methodOn(ClienteControllerV2.class).obtenerClientes()).withRel("clientes"));
    }


}
