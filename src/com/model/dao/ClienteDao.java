package com.model.dao;

import com.dto.Cliente;
import java.util.List;

/**
 *
 * @author DAFECESA
 */
public interface ClienteDao {
    public List<Cliente> list();
    public String insert(Cliente cliente);
    public Integer idCliente();
    public Cliente get(Integer id);
    public String delete(Integer id);
    public String update(Cliente cliente);
    
    
}
