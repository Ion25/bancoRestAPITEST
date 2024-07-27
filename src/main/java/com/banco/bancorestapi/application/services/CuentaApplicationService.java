package com.banco.bancorestapi.application.services;

import com.banco.bancorestapi.application.ports.inbound.CuentaService;
import com.banco.bancorestapi.application.ports.outbound.ClienteRepositorio;
import com.banco.bancorestapi.domain.entities.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuentaApplicationService implements CuentaService {

    private final ClienteRepositorio clienteRepositorio;

    public CuentaApplicationService(ClienteRepositorio clienteRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
    }

    @Override
    public Optional<Cliente> obtenerClientePorId(Long id) {
        return clienteRepositorio.obtenerClientePorId(id);
    }

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepositorio.listarClientes();
    }

    @Override
    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepositorio.guardarCliente(cliente);
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) {
        return clienteRepositorio.actualizarCliente(cliente);
    }

    @Override
    public void eliminarCliente(Long id) {
        clienteRepositorio.eliminarCliente(id);
    }
}
