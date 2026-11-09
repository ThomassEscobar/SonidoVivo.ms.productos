package cl.sonidovivo.ms.productos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data 
@Entity 
@Table(name = "productos")
public class Producto {

    private Long id;

    private String codigo;

    private String titulo;

    private String descripcion;

    private Double precio;

    private String categoria;
    
    private String imagen;

}
