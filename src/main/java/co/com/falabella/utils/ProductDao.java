package co.com.falabella.utils;

import co.com.falabella.models.Product;

import java.sql.SQLException;

public class ProductDao {

    private Conexion con = null;

    public ProductDao() {
        con = Conexion.getConexion();
    }

    public boolean insertar(Product product) throws SQLException {
        String sql = "INSERT INTO product (name, quantity) VALUES ('"+product.getNombre()+"','"+product.getCantidad()+"')";
        try {
            con.insert(sql);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

}
