package com.upiiz.orm.services;

import com.upiiz.orm.models.ClienteEntity;
import com.upiiz.orm.repositories.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    // Inyectar una dependencia - Conectar
    @Autowired
    ClienteRepository clienteRepository;

    // Listar todos
    public List<ClienteEntity> obtenerTodos() {
        return clienteRepository.findAll();
    }

    // Guardar un cliente
    public ClienteEntity guardarCliente(ClienteEntity cliente) {
        return clienteRepository.save(cliente);
    }

    // Obtener cliente por Id
    public ClienteEntity obtenerClientePorId(Long id) {
        return clienteRepository.findClienteById(id);
    }

    @Transactional
    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    // Actualizar cliente
    public ClienteEntity updateCliente(ClienteEntity cliente) {
        return clienteRepository.save(cliente);
    }

}
