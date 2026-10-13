package com.iesdoctorbalmis.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    private Long id;
    private String referencia;
    private String descripcion;
    private BigDecimal precioVenta;
    // NUNCA usar float o double para DINERO
    private BigDecimal precioCosto;
    private String imagen;
    private Integer stock;
}