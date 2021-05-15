/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import objetosNegocio.Proveedor;
import repositories.ProveedoresRepository;

/**
 *
 * @author Dany
 */
public class ControlProveedores {
    ProveedoresRepository proveedoresRepository;
    
    public ControlProveedores(){
        this.proveedoresRepository= new ProveedoresRepository();
    }
    
    public boolean guardar(Proveedor proveedor) {
        return proveedoresRepository.guardar(proveedor);
    }

    public boolean eliminar(int id) {
        return proveedoresRepository.eliminar(id);
    }

    public boolean actualizar(Proveedor proveedorNuevo) {
        return proveedoresRepository.actualizar(proveedorNuevo);
    }

    public Proveedor buscarporID(int id) {
        return proveedoresRepository.buscarporID(id);
    }

    public List<Proveedor> buscarTodas(String textoBusqueda) {
        return proveedoresRepository.buscarTodas(textoBusqueda);
    }
    
    public List<Proveedor> buscarLike (String textoBusqueda) {
        return proveedoresRepository.buscarLike(textoBusqueda);
    }
    
    
}
