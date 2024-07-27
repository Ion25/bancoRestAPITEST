package com.banco.bancorestapi.application.ports.inbound;

import com.banco.bancorestapi.domain.entities.Cliente;

import java.util.List;
import java.util.Optional;

public interface CuentaService {

    Optional<Cliente> obtenerClientePorId(Long id);
    List<Cliente> listarClientes();
    Cliente guardarCliente(Cliente cliente);
    Cliente actualizarCliente(Cliente cliente);
    void eliminarCliente(Long id);
}
