/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import objetosNegocio.Rel_ProductoVenta;
import repositories.Rel_ProductoVentaRepository;
/**
 *
 * @author Dany
 */
public class ControlRel_productosVentas {
    Rel_ProductoVentaRepository rel_ProductoVentaRepository;
    
    public ControlRel_productosVentas(){
        this.rel_ProductoVentaRepository= new Rel_ProductoVentaRepository();
    }
    
    public boolean guardar(Rel_ProductoVenta rel_provent) {
        return rel_ProductoVentaRepository.guardar(rel_provent);
    }
    
}
