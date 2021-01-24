/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *Esta es la clase donde se almacenan las consultas SQL
 * @author carlos herrerra
 */
public class Consultasp  extends Conexion {
    //consultas del inventario
    public boolean registrar (Producto pro){
    
    PreparedStatement ps = null;
    Connection con = getConexion();
    
    String sql = "insert into inven (nombre, precio, cantidad, fecha)  values (?,?,?,?)";
        try {
            
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getNombre());
            ps.setInt(2, pro.getPrecio());
            ps.setInt(3, pro.getCantidad());
            ps.setString(4, pro.getFecha());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("No se registro");
        return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("No se cerro conexion");
            }
        } 
    }
     
  public ArrayList <Producto> busca (){
        ArrayList busca = new ArrayList();
        Producto prod;
        String sql = "select * from inven";
        
           try {
            Connection con = getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                prod = new Producto();
                prod.setSku(rs.getInt(1));
                prod.setNombre(rs.getString(2));
                prod.setPrecio(rs.getInt(3));
                prod.setCantidad(rs.getInt(4));
                prod.setFecha(rs.getString(5));
                busca.add(prod);
            }
           } catch (SQLException e) { System.out.println("Error");
        }
        return busca;     
     
     }
  
     public boolean editar (Producto pro){
      PreparedStatement ps = null;
      Connection con = getConexion();
     String sql = "update inven set nombre = (?), precio = (?), cantidad = (?), fecha = (?) where sku = (?)";
         try {
              ps = con.prepareStatement(sql);
              ps.setString(1, pro.getNombre());
              ps.setInt(2, pro.getPrecio());
              ps.setInt(3, pro.getCantidad());
              ps.setString(4, pro.getFecha());
              ps.setInt(5, pro.getSku());
              ps.executeUpdate();
              return true;
         }  catch (SQLException e) {
            System.out.println("No se actualizo");
        return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("No se cerro conexion");
            }
        } 
     }
  //consultas para venta
  public boolean buscasku (Producto prod){
      PreparedStatement ps = null;
      Connection con = getConexion();
      
      String sql = "select * from inven where sku = (?)";
         try {
              ps = con.prepareStatement(sql);
              ps.setInt(1, prod.getSku());
              ResultSet rs = ps.executeQuery();
              
             if (rs.next()) {
                prod.setNombre(rs.getString("nombre"));
                prod.setPrecio(rs.getInt("precio"));
                return true;
            }        
  
         }  catch (SQLException e) {
            System.out.println("No se actualizo");
        return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("No se cerro conexion");
            }
        } 
        return false;
     }
    
    public boolean actuainve (Producto pro){
    
    PreparedStatement ps = null;
    Connection con = getConexion();
    
    String sql = "insert into ventas (sku, cantidad) values (?,?)";
        try {
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, pro.getSku());
            ps.setInt(2, pro.getCantidad());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("No se registro");
        return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("No se cerro conexion");
            }
        } 
    }
  //consultas para proveedor
    public boolean registrarpro (Producto pro){
    
    PreparedStatement ps = null;
    Connection con = getConexion();
    
    String sql = "insert into proveedores (nombre, productos, telefono, NIT)  values (?,?,?,?)";
        try {
            
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getNombrepro());
            ps.setString(2, pro.getProductos());
            ps.setString(3, pro.getTelefono());
            ps.setString(4, pro.getNIT());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("No se registro");
        return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("No se cerro conexion");
            }
        } 
    }
     
  public ArrayList <Producto> buscapro (){
        ArrayList busca = new ArrayList();
        Producto prod;
        String sql = "select * from proveedores";
        
           try {
            Connection con = getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                prod = new Producto();
                prod.setID(rs.getInt(1));
                prod.setNombrepro(rs.getString(2));
                prod.setProductos(rs.getString(3));
                prod.setTelefono(rs.getString(4));
                prod.setNIT(rs.getString(5));
                busca.add(prod);
            }
           } catch (SQLException e) { System.out.println("Error");
        }
        return busca;     
     
     }
  
     public boolean editarpro (Producto pro){
      PreparedStatement ps = null;
      Connection con = getConexion();
      String sql = "update proveedores set nombre = (?), productos = (?), telefono = (?), nit = (?) where ID = (?)";
         try {
              ps = con.prepareStatement(sql);
              ps.setString(1, pro.getNombrepro());
              ps.setString(2, pro.getProductos());
              ps.setString(3, pro.getTelefono());
              ps.setString(4, pro.getNIT());
              ps.setInt(5, pro.getID());
              ps.executeUpdate();
              return true;
         }  catch (SQLException e) {
            System.out.println("No se actualizo");
        return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("No se cerro conexion");
            }
        } 
     }
    //pedidos
     public boolean registrarped (Producto pro){
    
    PreparedStatement ps = null;
    Connection con = getConexion();
    
    String sql = "insert into pedidos (nombre, precio, cantidad, fecha, idpro)  values (?,?,?,?,?)";
      try {
            
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getNombreped());
            ps.setInt(2, pro.getPrecioped());
            ps.setInt(3, pro.getCantidadped());
            ps.setString(4, pro.getFechaen());
            ps.setInt(5, pro.getIDpro());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("No se registro");
        return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("No se cerro conexion");
            }
        } 
    }
     
  public ArrayList <Producto> buscaped (){
        ArrayList busca = new ArrayList();
        Producto prod;
        String sql = "select * from pedidos";
        
           try {
            Connection con = getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                prod = new Producto();
                prod.setIdpe(rs.getInt(1));
                prod.setNombreped(rs.getString(2));
                prod.setPrecioped(rs.getInt(3));
                prod.setCantidadped(rs.getInt(4));
                prod.setFechaen(rs.getString(5));
                prod.setIDpro(rs.getInt(6));
                busca.add(prod);
            }
           } catch (SQLException e) { System.out.println("Error");
        }
        return busca;     
     
     }
  
     public boolean editarped (Producto pro){
      PreparedStatement ps = null;
      Connection con = getConexion();
     String sql = "update pedidos set nombre = (?), precio = (?), cantidad = (?), fecha = (?), idpro = (?) where ID = (?)";
         try {
              ps = con.prepareStatement(sql);
              ps.setString(1, pro.getNombreped());
              ps.setInt(2, pro.getPrecioped());
              ps.setInt(3, pro.getCantidadped());
              ps.setString(4, pro.getFechaen());
              ps.setInt(5, pro.getIDpro());
              ps.setInt(6, pro.getIdpe());
              ps.executeUpdate();
              return true;
         }  catch (SQLException e) {
            System.out.println("No se actualizo");
        return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("No se cerro conexion");
            }
        } 
     }
   //login
      public boolean buscausu (Producto prod){
      PreparedStatement ps = null;
      Connection con = getConexion();
      
      String sql = "select * from usuarios where usuario = (?) and contrasena = (?)";
         try {
              ps = con.prepareStatement(sql);
              ps.setString(1, prod.getUsu());
              ps.setString(2, prod.getPass());
              ResultSet rs = ps.executeQuery();
              
             if (rs.next()) {
                //prod.setNombre(rs.getString("nombre"));
                //prod.setPrecio(rs.getInt("precio"));
                return true;
            }        
  
         }  catch (SQLException e) {
            System.out.println("No se actualizo");
        return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("No se cerro conexion");
            }
        } 
        return false;
     }
     
     //nuevo usu
      public boolean nuevousu (Producto pro){
    
    PreparedStatement ps = null;
    Connection con = getConexion();
    
    String sql = "insert into usuarios (usuario, contrasena)  values (?,?)";
      try {
            
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getUsu());
            ps.setString(2, pro.getPass());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("No se registro");
        return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("No se cerro conexion");
            }
        } 
    }     
     
}
