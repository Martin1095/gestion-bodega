package com.example.gestionbodega.controller;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteControler {

    @Autowired
    private ClienteService clienteService;

    // Método para obtener todos los clientes
    @GetMapping
    public ResponseEntity<List<ClienteDTO>> obtenerClientes() {
        List<ClienteDTO> clientes = clienteService.obtenerClientes();
        if (clientes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    // Metodo para obtener un cliente por su ID
    @GetMapping("/{id_cliente}")
    public ResponseEntity<ClienteDTO> obtenerClientePorId(@PathVariable Integer id_cliente) {
        try {
            ClienteDTO cliente = clienteService.obtenerClientePorId(id_cliente);
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Método para buscar un cliente por su RUT
    @GetMapping("/buscar/{rut}")
    public ResponseEntity<List<ClienteDTO>> buscarPorRut(@PathVariable String rut) {
        List<ClienteDTO> clientes = clienteService.buscarPorRut(rut);
        if (clientes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    // Método para añadir un nuevo cliente
    @PostMapping
    public ResponseEntity<Cliente> agregarCliente(@RequestBody Cliente cliente) {
        try {
            Cliente nuevoCliente = clienteService.agregarCliente(cliente);
            return new ResponseEntity<>(nuevoCliente, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Método para actualizar un cliente existente
    @PatchMapping("/{id_cliente}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable Integer id_cliente, @RequestBody Cliente clienteActu) {
        try {
            Cliente cliente = clienteService.actualizarCliente(id_cliente, clienteActu);
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // metodo para eliminar un cliente por su ID
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarCliente(@PathVariable Integer id) {
        String mensaje = clienteService.eliminar(id);

        if (mensaje.contains("Exitosamente")) {
            return new ResponseEntity<>(mensaje, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(mensaje, HttpStatus.OK);
        }
        
    }
}
