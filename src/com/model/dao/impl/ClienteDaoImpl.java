package com.model.dao.impl;

import com.conexion.sql.ConectaDB;
import com.dto.Cliente;
import com.model.dao.ClienteDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DAFECESA
 */
public class ClienteDaoImpl implements ClienteDao {
    public ConectaDB db;
    public ClienteDaoImpl(){
        db = new ConectaDB();
    }

    @Override
    public List<Cliente> list() {
        
        List<Cliente>   list  = null;
        String sql = "select * from cliente";
        try {
            
            Connection cn   =   db.getConnection();
            PreparedStatement   st  =   cn.prepareStatement(sql);
            
            ResultSet   rs  =   st.executeQuery(sql);
            list    =   new ArrayList<Cliente>();
            while(rs.next()){
                Cliente o   =   new Cliente();
                o.setIdCliente(rs.getInt(1));
                o.setNombre(rs.getString(2));
                o.setApellidos(rs.getString(3));
                o.setDni(rs.getString(4));
                o.setDireccion(rs.getString(5));
                list.add(o);
            }
            
        }catch (SQLException e){
            System.out.println("Error: " + e.getMessage() );
        }
        
        return list;
    
    }   

    @Override
    public String insert(Cliente cliente) {
        String  result  =   null;
        String  sql ="insert into cliente(idcliente,nombre,"
                +"apellidos,dni,direccion)"
                +"Values(?,?,?,?,?)";
        try {
            Connection  cn  =   db.getConnection();
            PreparedStatement    ps  =   cn.prepareStatement(sql);
            ps.setInt(1,cliente.getIdCliente());
            ps.setString(2,cliente.getNombre());
            ps.setString(3, cliente.getApellidos());
            ps.setString(4, cliente.getDni());
            ps.setString(5, cliente.getDireccion());
            ps.executeUpdate();
            
            ps.close();
            cn.close();
            
            
        }catch (SQLException e){
            result  =   e.getMessage();
        }
        
        return result;
    }

    @Override
    public Integer idCliente() {
        Integer id=0;
        String  sql =   "SELECT max(idCliente) + 1 as codigo from cliente;";
        
        try{
            Connection  cn  =   db.getConnection();
            PreparedStatement   ps  =   cn.prepareStatement(sql);
            ResultSet   rs= ps.executeQuery();
            if (rs.next())
            {
                id=rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("error: "+ex.getMessage());
        }
        
        return id;
    }

    @Override
    public Cliente get(Integer id) {
        Cliente cliente =null;
        String sql = "select * from cliente where idcliente=?";
        try {
            Connection cn = db.getConnection();
            PreparedStatement ps =    cn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet   rs= ps.executeQuery();
            cliente = new Cliente();
            
            if (rs.next()) {
                cliente.setIdCliente(rs.getInt(1));
                cliente.setNombre(rs.getString(2));
                cliente.setApellidos(rs.getString(3));
                cliente.setDni(rs.getString(4));
                cliente.setDireccion(rs.getString(5));
            }
            cn.close();
            ps.close();
        }catch(SQLException e){
            System.out.println("error: "+ e.getMessage());
        }
        
        return cliente;
    }

    @Override
    public String delete(Integer id) {
        String result=null;
        String sql= "delete from cliente where idcliente=?";
        try{
            Connection cn=db.getConnection();
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            
            cn.close();
            ps.close();
        } catch (SQLException ex) {
            result=ex.getMessage();
        }
        return result;
    
    }

    @Override
    public String update(Cliente cliente) {
        String result = null;
        String sql= "update cliente set nombre=? , " + "apellidos=?, dni=? ,direccion=? " +
                    "where idcliente=?";
       
        try {
            Connection cn=db.getConnection();
            PreparedStatement ps=cn.prepareStatement(sql);
            
            ps.setString(1,cliente.getNombre());
            ps.setString(2, cliente.getApellidos());
            ps.setString(3, cliente.getDni());
            ps.setString(4, cliente.getDireccion());
            ps.setInt(5, cliente.getIdCliente());
            ps.executeUpdate();
            cn.close();
            ps.close();
            
        } catch (SQLException ex) {
        }
        return result;
    }
    
}
