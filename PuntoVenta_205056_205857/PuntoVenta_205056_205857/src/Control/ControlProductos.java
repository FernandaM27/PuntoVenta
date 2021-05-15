package Control;

import java.util.List;
import repositories.ProductosRepository;
import objetosNegocio.Producto;
/**
 *
 * @author Dany
 */
public class ControlProductos {
    ProductosRepository productosRepository;
    
    public ControlProductos(){
        this.productosRepository=new ProductosRepository();
    }
    
    public boolean guardar(Producto producto) {
        return productosRepository.guardar(producto);
    }
    
    public boolean eliminar(int id) {
        return productosRepository.eliminar(id);
    }
    
    public boolean actualizar(Producto productoNuevo) {
        return productosRepository.actualizar(productoNuevo);
    }
    
    public Producto buscarporID(int id) {
        return productosRepository.buscarporID(id);
    }

    public List<Producto> buscarTodas(String textoBusqueda) {
       return productosRepository.buscarTodas(textoBusqueda);
    }
    
    public List<Producto> buscarLike(String busqueda) {
        return productosRepository.buscarLike(busqueda);
    } 
}
