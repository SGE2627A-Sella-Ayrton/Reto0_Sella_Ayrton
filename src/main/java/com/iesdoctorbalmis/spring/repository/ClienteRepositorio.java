package com.iesdoctorbalmis.spring.repository;

import com.iesdoctorbalmis.spring.model.Cliente;
import com.iesdoctorbalmis.spring.model.TipoCliente;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class ClienteRepositorio {
    private List<Cliente> clientes = new ArrayList<>();
    private Long proximoId = 1L;

    /**
     * Guarda un nuevo cliente en la lista. Asigna ID automáticamente.
     */
    public Cliente guardar(Cliente cliente) {
        cliente.setId(proximoId++);
        clientes.add(cliente);
        return cliente;
    }

    /**
     * Busca todos los clientes y los devuelve
     */
    public List<Cliente> buscarTodos() {
        return new ArrayList<>(clientes);
    }

    /**
     * Busca un cliente por ID.
     */
    public Cliente buscarPorId(Long id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId().equals(id)) {
                return cliente;
            }
        }
        return null;
    }

    /**
     * Actualiza un cliente existente.
     */
    public Cliente actualizar(Cliente clienteActualizado) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId().equals(clienteActualizado.getId())) {
                clientes.set(i, clienteActualizado);
                return clienteActualizado;
            }
        }
        return null;
    }

    /**
     * Elimina un cliente por ID.
     */
    public boolean eliminar(Long id) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId().equals(id)) {
                clientes.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Busca clientes por tipo (PROSPECTO, ACTIVO, INACTIVO).
     */
    public List<Cliente> buscarPorTipo(TipoCliente tipo) {
        List<Cliente> resultado = new ArrayList<>();
        for (Cliente cliente : clientes) {
            if (cliente.getTipoCliente() == tipo) {
                resultado.add(cliente);
            }
        }
        return resultado;
    }

    /**
     * Retorna el número total de clientes.
     */
    public Integer contar() {
        return clientes.size();
    }
}