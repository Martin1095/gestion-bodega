package com.example.gestionbodega.assemblers;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.example.gestionbodega.DTO.ClienteDTO;
import com.example.gestionbodega.controller.ClienteControllerV2;





import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;



@Component
public class ClienteModelAssembler implements RepresentationModelAssembler<ClienteDTO, EntityModel<ClienteDTO>>  {

    @Override
    public EntityModel<ClienteDTO> toModel(ClienteDTO cliente) {
    return EntityModel.of(cliente,
            linkTo(methodOn(ClienteControllerV2.class).obtenerClientePorId(cliente.getId_cliente())).withSelfRel(),
            linkTo(methodOn(ClienteControllerV2.class).obtenerClientes()).withRel("clientes"));
    }


}
