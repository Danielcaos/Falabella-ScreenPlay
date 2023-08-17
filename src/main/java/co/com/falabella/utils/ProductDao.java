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
        String sql = "INSERT INTO product (name, quantity, count) VALUES ('"+product.getNombre()+"','"+product.getCantidad()+"','"+product.getCount()+"')";
        try {
            con.insert(sql);
            return true;
        } catch (SQLException e) {
            return false;
        }

    }

    public boolean product(String nombre) throws SQLException {
        String sql = "SELECT COUNT(*) FROM product WHERE name= "+"'"+nombre+"'";
        boolean result = true;
        try {
            ResultSet ps = con.query(sql);
            ps.next();
            int count = ps.getInt(1);
            if (count==0){
                result = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void update (String name, int quantity) throws SQLException {
        String sql = "UPDATE product SET count = count + 1, quantity ='"+quantity+"' WHERE name= "+"'"+name+"'";

        try {
            con.insert(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //Search product sql

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
