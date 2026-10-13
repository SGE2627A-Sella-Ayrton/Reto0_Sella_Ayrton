package com.iesdoctorbalmis.spring.repository;

import com.iesdoctorbalmis.spring.model.Producto;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductoRepositorio {
    private List<Producto> productos = new ArrayList<>();
    private Long proximoId = 1L;

    public Producto guardar(Producto producto) {
        producto.setId(proximoId++);
        productos.add(producto);
        return producto;
    }

    public List<Producto> buscarTodos() {
        return new ArrayList<>(productos);
    }

    public Producto buscarPorId(Long id) {
        for (Producto producto : productos) {
            if (producto.getId().equals(id)) {
                return producto;
            }
        }
        return null;
    }

    public Producto buscarPorReferencia(String referencia) {
        for (Producto producto : productos) {
            if (producto.getReferencia().equals(referencia)) {
                return producto;
            }
        }
        return null;
    }

    public Producto actualizar(Producto productoActualizado) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getId().equals(productoActualizado.getId())) {
                productos.set(i, productoActualizado);
                return productoActualizado;
            }
        }
        return null;
    }

    public boolean eliminar(Long id) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getId().equals(id)) {
                productos.remove(i);
                return true;
            }
        }
        return false;
    }

    public Integer contar() {
        return productos.size();
    }
}