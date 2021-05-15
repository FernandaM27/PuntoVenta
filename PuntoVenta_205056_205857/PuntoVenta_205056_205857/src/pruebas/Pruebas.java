package pruebas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import objetosNegocio.*;
import repositories.*;

public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Control control= new Control();        
//        /*
//        * CRUD Categorias
//        */
        CategoriasRepository categoriasRepository = new CategoriasRepository();
        //Categoria categoria = new Categoria( "Frutas y verduras", "Frutas y verduras frescas");
        Categoria categoria1= new Categoria(1,"Frutas y verduras", "Frutas y verduras frescas");
        Categoria categoria2= new Categoria(2,"Carnes", "clasificadas desde sonora para el mundo");
//        categoriasRepository.guardar(categoria2);
//        categoriasRepository.guardar(categoria3);
//        categoriasRepository.guardar(categoria2);
//        Categoria categoriaActualizada= new Categoria(1, "Frutas y verduras", "Frutas y verduras frescas y secas");
//        categoriasRepository.actualizar(categoriaActualizada);
//        System.out.println(categoriasRepository.buscarporID(1));
//        categoriasRepository.eliminar(1);
//        Categoria p = categoriasRepository.buscarporID(2);
//        List<Producto> productoProveedor = p.getProductos();
//        for (Producto producto : productoProveedor) {
//            System.out.println(producto);
//        }
//
//        List<Categoria>todasCategorias=categoriasRepository.buscarTodas("");
//        for (Categoria todasCategoria : todasCategorias) {
//            System.out.println(todasCategoria);
//        }
        
//        /*
//        * CRUD Proveedores
//        */
       ProveedoresRepository proveedoresRepository=control.getProveedoresRepository();
       Proveedor proveedor1 = new Proveedor(1,"DSADASd", "Fernanda", "Corerepe", "123456", "miranda.com");
       Proveedor proveedor2 = new Proveedor(2,"ABCDE", "Daniel", "Ej insurgentes de pueblo yaqui", "78910", "daniel.net");
        Proveedor proveedor3 = new Proveedor(3,"ABCDEss", "Adolfo", "Ej insurgentes", "78910", "daniel.net");
//        proveedoresRepository.guardar(proveedor1);
//        proveedoresRepository.guardar(proveedor2);
//        proveedoresRepository.guardar(proveedor3);
//        proveedoresRepository.actualizar(proveedor2);
//        proveedoresRepository.eliminar(3);
//       System.out.println(proveedoresRepository.buscarporID(1));
//       Proveedor p=proveedoresRepository.buscarporID(2);
//       List<Producto>productoProveedor=p.getProductos();
//      for (Producto producto : productoProveedor) {
//            System.out.println(producto);
//      }
//        List<Proveedor>proveedores= proveedoresRepository.buscarTodas("");
//        for (Proveedor proveedor : proveedores) {
//            System.out.println(proveedor);
//        }


//        /*
//        * CRUD Clientes
//        */
//        ClientesRepository clientesRepository=control.getClientesRepository();
        Cliente cliente1= new Cliente(1,"ASDFg", "Jesus", "Cd. obregón", "", "");
        Cliente cliente2= new Cliente(2,"hjlp", "Rubén", "Cd. obregón", "123456", "");
        Cliente cliente3= new Cliente(3,"qwerty", "Javier", "Campo sepalabola", "7890", "");
//        clientesRepository.guardar(cliente1);
//        clientesRepository.guardar(cliente2);
//        clientesRepository.guardar(cliente3);
//        clientesRepository.actualizar(cliente1);
//        clientesRepository.eliminar(1);
//          System.out.println(clientesRepository.buscarporID(3));
//          List<Cliente>clientes=clientesRepository.buscarTodas("");
//          for (Cliente cliente : clientes) {
//              System.out.println(cliente);
//          }
//
//
//        /**
//        * CRUD Productos
//        */
        ProductosRepository productosRepository=control.getProductosRepository();
        Producto producto1= new Producto(1,"Salsa la costena", 15.5f, 5, proveedor1, categoria1);
        Producto producto2= new Producto(2,"tomate", 22.5f, 5, proveedor2, categoria2);
        Producto producto3= new Producto(3,"cebolla", 13.5f, 5, proveedor1, categoria1);
//        productosRepository.guardar(producto1);
//        productosRepository.guardar(producto2);
//        productosRepository.guardar(producto3);
        //productosRepository.actualizar(producto3);
//        productosRepository.eliminar(2);
//        System.out.println(productosRepository.buscarporID(1));
//        List<Producto>productos=productosRepository.buscarTodas("");
//        for (Producto producto : productos) {
//            System.out.println(producto);
//        }

        VentasRepository ventasRepository= control.getVentasRepository();
//        Venta venta1= new Venta(new Date(), 15, 1215, cliente2);
//        Venta venta2= new Venta(new Date(), 30, 120, cliente3);
//        ventasRepository.guardar(venta1);
//        ventasRepository.guardar(venta2);

          
//          List<Proveedor>proveedores=proveedoresRepository.busquedaLike("3");
//          for (Proveedor proveedor : proveedores) {
//              System.out.println(proveedor);
//        }
    }

}
