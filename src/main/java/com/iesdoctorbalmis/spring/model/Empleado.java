package com.iesdoctorbalmis.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empleado {
    private Long id;
    private String numeroEmpleado;
    private String nombre;
    private String apellidos;
    private String cargo;
    private String departamento;
    private String email;
    private LocalDate fechaIncorporacion;
}