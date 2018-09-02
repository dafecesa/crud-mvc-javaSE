
package com.negocio;

import com.dto.Cliente;
import com.model.dao.ClienteDao;
import com.model.dao.impl.ClienteDaoImpl;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DAFECESA
 */
public class ClienteNE {
    ClienteDao clienteDao;
    private ArrayList<Object> a = new ArrayList<Object>();
    
    public ClienteNE(){
        clienteDao= new ClienteDaoImpl();
    }
    
    public ClienteNE(ArrayList<Object> a){
        this.a = a;
    }
    
    public List<Cliente> list(){
        return clienteDao.list();
    }
    
    public String insertarClientes(Cliente cliente){
        return clienteDao.insert(cliente);    
    }
    
    public Integer idCliente(){
        return clienteDao.idCliente();
    }
    
    public Cliente get(Integer id){
        return clienteDao.get(id);
    }
    
    public String delete(Integer id){
        return clienteDao.delete(id);
    }
    
    public String update(Cliente cliente){
        return clienteDao.update(cliente);
    }
    
     public Cliente obtenerRegistro(int i){
        return (Cliente)a.get(i);
    }
    
    public int cantidadRegistro(){
        return this.a.size();
    }
    
    public int buscaId(int id){
        for(int i = 0; i < cantidadRegistro(); i++){
            if(id == obtenerRegistro(i).getIdCliente())return i;
        }
        return -1;
    }
    
    public void agregarRegistro(Cliente cliente){
        this.a.add(cliente);
    }
    
}
