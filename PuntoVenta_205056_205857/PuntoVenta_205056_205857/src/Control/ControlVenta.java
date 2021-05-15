/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.util.Date;
import java.util.List;
import objetosNegocio.Cliente;
import objetosNegocio.Venta;
import repositories.VentasRepository;

/**
 *
 * @author miran
 */
public class ControlVenta {

    VentasRepository ventasRepository;

    public ControlVenta() {
        this.ventasRepository = new VentasRepository();
    }

    public boolean guardar(Venta venta) {
        return ventasRepository.guardar(venta);
    }

    public boolean eliminar(int id) {
        return ventasRepository.eliminar(id);
    }

    public boolean actualizar(Venta ventaNueva) {
        return ventasRepository.actualizar(ventaNueva);
    }

    public Venta buscarporID(int id) {
        return ventasRepository.buscarporID(id);
    }

    public List<Venta> buscarTodas(String textoBusqueda) {
        return ventasRepository.buscarTodas(textoBusqueda);
    }

   
    public List<Venta> busquedaRango(Cliente cliente, Date inicio, Date fin) {
        return ventasRepository.busquedaRango(cliente, inicio, fin);
    }

    public int ultimaidVenta() {
        return ventasRepository.ultimaVenta();
    }
}
