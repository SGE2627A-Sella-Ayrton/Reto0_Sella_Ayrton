package com.iesdoctorbalmis.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
// get, set, toString
@NoArgsConstructor
// constructor vacío
@AllArgsConstructor
// constructor con todo
public class Cliente {
    private Long id;
    private String codigoCliente;
    private String nombre;
    private String email;
    private String telefono;
    private TipoCliente tipoCliente;
    private LocalDate fechaAlta;
}