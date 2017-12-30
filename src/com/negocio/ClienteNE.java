
package com.negocio;

import com.dto.Cliente;
import com.model.dao.ClienteDao;
import com.model.dao.impl.ClienteDaoImpl;
import java.util.List;

/**
 *
 * @author DAFECESA
 */
public class ClienteNE {
    ClienteDao clienteDao;
    
    public ClienteNE(){
        clienteDao= new ClienteDaoImpl();
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
}
