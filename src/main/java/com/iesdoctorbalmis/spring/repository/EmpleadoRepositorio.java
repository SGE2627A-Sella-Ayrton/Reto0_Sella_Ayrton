package com.iesdoctorbalmis.spring.repository;

import com.iesdoctorbalmis.spring.model.Empleado;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmpleadoRepositorio {
    private List<Empleado> empleados = new ArrayList<>();
    private Long proximoId = 1L;

    public Empleado guardar(Empleado empleado) {
        empleado.setId(proximoId++);
        empleados.add(empleado);
        return empleado;
    }

    public List<Empleado> buscarTodos() {
        return new ArrayList<>(empleados);
    }

    public Empleado buscarPorId(Long id) {
        for (Empleado empleado : empleados) {
            if (empleado.getId().equals(id)) {
                return empleado;
            }
        }
        return null;
    }

    public List<Empleado> buscarPorDepartamento(String departamento) {
        List<Empleado> resultado = new ArrayList<>();
        for (Empleado empleado : empleados) {
            if (empleado.getDepartamento().equals(departamento)) {
                resultado.add(empleado);
            }
        }
        return resultado;
    }

    public Empleado actualizar(Empleado empleadoActualizado) {
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getId().equals(empleadoActualizado.getId())) {
                empleados.set(i, empleadoActualizado);
                return empleadoActualizado;
            }
        }
        return null;
    }

    public boolean eliminar(Long id) {
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getId().equals(id)) {
                empleados.remove(i);
                return true;
            }
        }
        return false;
    }

    public Integer contar() {
        return empleados.size();
    }
}