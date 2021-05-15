/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.util.List;
import objetosNegocio.Categoria;
import repositories.CategoriasRepository;

/**
 *
 * @author Dany
 */
public class ControlCategorias {
    private CategoriasRepository categoriasRepository;
    
    public ControlCategorias(){
        this.categoriasRepository=new CategoriasRepository();
    }
    
    public boolean guardar(Categoria categoria) {
        return this.categoriasRepository.guardar(categoria);
    }

    public boolean eliminar(int id) {
        return this.categoriasRepository.eliminar(id);
    }

    public boolean actualizar(Categoria categoriaNueva) {
        return categoriasRepository.actualizar(categoriaNueva);
    }

    public Categoria buscarporID(int id) {
        return categoriasRepository.buscarporID(id);
    }

    public List<Categoria> buscarTodas(String textoBusqueda) {
        return categoriasRepository.buscarTodas(textoBusqueda);
    }
    
    public List<Categoria> buscarLike(String busqueda) {
        return categoriasRepository.buscarLike(busqueda);
    }
}
