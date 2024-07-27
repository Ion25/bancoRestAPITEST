package com.banco.bancorestapi.infrastructure.adapters.inbound.rest;

import com.banco.bancorestapi.application.ports.inbound.CuentaService;
import com.banco.bancorestapi.domain.entities.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final CuentaService cuentaService;

    public ClienteController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obtenerCliente(@PathVariable Long id) {
        return cuentaService.obtenerClientePorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        List<Cliente> clientes = cuentaService.listarClientes();
        return ResponseEntity.ok(clientes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        cliente.setId(id);
        Cliente clienteActualizado = cuentaService.actualizarCliente(cliente);
        return ResponseEntity.ok(clienteActualizado);
    }

    @PostMapping
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {
        Cliente nuevoCliente = cuentaService.guardarCliente(cliente);
        return ResponseEntity.ok(nuevoCliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long id) {
        cuentaService.eliminarCliente(id);
        return ResponseEntity.noContent().build();
    }
}
