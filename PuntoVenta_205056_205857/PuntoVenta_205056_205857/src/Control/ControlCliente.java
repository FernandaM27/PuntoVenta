/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.util.List;
import objetosNegocio.Cliente;
import repositories.ClientesRepository;

/**
 *
 * @author miran
 */
public class ControlCliente {
     ClientesRepository clientesRepository;
    
    public ControlCliente(){
        this.clientesRepository=new ClientesRepository();
    }
    
    public boolean guardar(Cliente cliente) {
        return this.clientesRepository.guardar(cliente);
    }

    public boolean eliminar(int id) {
        return this.clientesRepository.eliminar(id);
    }

    public boolean actualizar(Cliente clientenuevo) {
        return clientesRepository.actualizar(clientenuevo);
    }

    public Cliente buscarporID(int id) {
        return clientesRepository.buscarporID(id);
    }

    public List<Cliente> buscarTodas(String textoBusqueda) {
        return clientesRepository.buscarTodas(textoBusqueda);
    }
    
    public List<Cliente> buscarLike(String busqueda) {
        return clientesRepository.buscarLike(busqueda);
    }
}
