package co.com.falabella.utils;

import co.com.falabella.models.Product;

import java.sql.ResultSet;
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

    public String buscar(int id) throws SQLException {
        String sql = "SELECT product FROM search WHERE id= "+"'"+id+"'";

        String product = "";

        try {

            ResultSet ps = con.query(sql);

            if(ps.next()){
                product = ps.getString("product");
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

}
