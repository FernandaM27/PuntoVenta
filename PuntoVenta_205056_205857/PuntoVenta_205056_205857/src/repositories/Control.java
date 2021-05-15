/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

/**
 *
 * @author Dany
 */
public class Control {
    private CategoriasRepository categoriasRepository;
    private ClientesRepository clientesRepository;
    private ProductosRepository productosRepository;
    private ProveedoresRepository proveedoresRepository;
//    private Rel_ProductoVentaRepository rel_ProductoVentaRepository;
    private VentasRepository ventasRepository;
    
    public CategoriasRepository getCategoriasRepository(){
        if(this.categoriasRepository != null){
            return this.categoriasRepository;
        }else{
            this.categoriasRepository = new CategoriasRepository();
            return this.categoriasRepository;
        }
    }
    
    public ClientesRepository getClientesRepository(){
        if(this.clientesRepository != null){
            return this.clientesRepository;
        }else{
            this.clientesRepository= new ClientesRepository();
            return this.clientesRepository;
        }
    }
    
    public ProductosRepository getProductosRepository(){
        if(this.productosRepository != null){
            return this.productosRepository;
        }else{
            this.productosRepository= new ProductosRepository();
            return this.productosRepository;
        }
    }
    
    public ProveedoresRepository getProveedoresRepository(){
        if(this.proveedoresRepository != null){
            return this.proveedoresRepository;
        }else{
            this.proveedoresRepository= new ProveedoresRepository();
            return this.proveedoresRepository;
        }
    }
    
//    public Rel_ProductoVentaRepository getRel_ProductoVentaRepository(){
//        if(this.rel_ProductoVentaRepository != null){
//            return this.rel_ProductoVentaRepository;
//        }else{
//            this.rel_ProductoVentaRepository= new Rel_ProductoVentaRepository();
//            return this.rel_ProductoVentaRepository;
//        }
//    }
//   
    public VentasRepository getVentasRepository(){
        if(this.ventasRepository != null){
            return this.ventasRepository;
        }else{
            this.ventasRepository= new VentasRepository();
            return ventasRepository;
        }
    }
    
    
    
    
    
    
}
