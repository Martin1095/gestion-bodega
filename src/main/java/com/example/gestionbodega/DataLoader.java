package com.example.gestionbodega;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.example.gestionbodega.model.*;
import com.example.gestionbodega.repository.*;
import net.datafaker.Faker;


@Profile("test")
@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ArticuloRepository articuloRepository;
    
    @Autowired
    private BodegaRepository bodegaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private DespachoRepository despachoRepository;

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    @Autowired
    private InventarioRepository inventarioRepository;

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Autowired
    private RecepcionRepository recepcionRepository;

    @Autowired
    private TrabajadorRepository trabajadorRepository;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();
        Random random = new Random();

        // Generar datos de Articulos
        for (int i = 0; i < 50; i++) {
            Articulo articulo = new Articulo();
            articulo.setId_articulo(i + 1);
            articulo.setNombre(faker.commerce().productName());
            articulo.setMarca(faker.company().name());
            articulo.setStock(random.nextInt(100));
            articulo.setPrecio(Double.parseDouble(faker.commerce().price()));
            articuloRepository.save(articulo);
        }

        // Generar datos de Bodega
        for (int i = 0; i < 5; i++) {
            Bodega bodega = new Bodega();
            bodega.setId_bodega(i + 1);
            bodega.setNombre("Bodega " + (i + 1));
            bodega.setDireccion(faker.address().fullAddress());
            bodegaRepository.save(bodega);
        }

        // Generar datos de Clientes
        for (int i = 0; i < 30; i ++){
            Cliente cliente = new Cliente();
            cliente.setId_cliente(i + 1);
            cliente.setNombre(faker.name().firstName());
            cliente.setApellido(faker.name().lastName());
            cliente.setRut(faker.idNumber().valid());
            cliente.setCorreo(faker.internet().emailAddress());
            cliente.setTelefono(faker.number().digits(9));
            clienteRepository.save(cliente);
        }

        // Generar datos de Despachos
        for (int i = 0; i < 20; i++) {
            Despacho despacho = new Despacho();
            despacho.setId_despacho(i + 1);
            despacho.setFecha(null);
            despacho.setEstado(faker.options().option("Pendiente", "Enviado", "Entregado"));
            despachoRepository.save(despacho);
        }
        

    }





    
}
