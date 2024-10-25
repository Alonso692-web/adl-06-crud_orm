package com.upiiz.orm.repositories;

import com.upiiz.orm.models.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// JpaRepository
// CrudRepository
@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

    // Generar consultas más personalizadas
    // @Query

    // Métodos para buscar cliente por ID usando Query personalizada
    @Query("SELECT c FROM ClienteEntity c WHERE c.id = :id")
    ClienteEntity findClienteById(@Param("id") Long id);

    // Métodos para actualizar cliente
    @Query("UPDATE ClienteEntity c SET c.nombre = :nombre, c.email = :email WHERE c.id = :id")
    void updateCliente(@Param("id") Long id, @Param("nombre") String nombre, @Param("email") String email);

    // Métodos para eliminar cliente por ID
}
