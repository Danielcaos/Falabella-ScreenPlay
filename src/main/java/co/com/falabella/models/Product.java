package co.com.falabella.models;

import lombok.Data;

@Data
public class Product {

    private String nombre;

    private int cantidad;

    public Product(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

}
