package com.upiiz.orm.controllers;

import com.upiiz.orm.models.ClienteEntity;
import com.upiiz.orm.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    // Dependencia
    @Autowired
    ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteEntity>> getClientes() {
        return ResponseEntity.ok(clienteService.obtenerTodos());
    }

    @PostMapping
    public ResponseEntity<ClienteEntity> guardar(@RequestBody ClienteEntity cliente) {
        return ResponseEntity.ok(clienteService.guardarCliente(cliente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteEntity> getCliente(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.obtenerClientePorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteEntity> updateCliente(@PathVariable Long id, @RequestBody ClienteEntity cliente) {
        cliente.setId(id); // Aseguramos que el ID sea el correcto
        return ResponseEntity.ok(clienteService.updateCliente(cliente));
    }

}
