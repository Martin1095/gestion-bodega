package com.example.gestionbodega.controller;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteControler {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> obtenerClientes() {
        List<ClienteDTO> clientes = clienteService.obtenerClientes();
        if (clientes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("/{id_cliente}")
    public ResponseEntity<ClienteDTO> obtenerClientePorId(@PathVariable Integer id_cliente) {
        try {
            ClienteDTO cliente = clienteService.obtenerClientePorId(id_cliente);
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<ClienteDTO>> buscarPorRut(@RequestParam String rut) {
        List<ClienteDTO> clientes = clienteService.buscarPorRut(rut);
        if (clientes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    // metodo para eliminar un cliente por su ID
    @GetMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarCliente(@PathVariable Integer id) {
        String mensaje = clienteService.eliminar(id);

        if (mensaje.contains("Exitosamente")) {
            return new ResponseEntity<>(mensaje, HttpStatus.OK);
        else {
            return new ResponseEntity<>(mensaje, HttpStatus.OK);
        }
        
    }
}
