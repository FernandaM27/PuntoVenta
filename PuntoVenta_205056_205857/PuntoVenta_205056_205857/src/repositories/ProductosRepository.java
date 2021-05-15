/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import objetosNegocio.Producto;

/**
 *
 * @author Dany
 */
public class ProductosRepository extends BaseRepository<Producto>{

    @Override
    public boolean guardar(Producto producto) {
        if(producto.getStock()>=0){
            EntityManager entityManager = this.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(producto);
            entityManager.getTransaction().commit();
             return true;
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Producto producto = entityManager.find(Producto.class, id);
        if (producto != null) {
            entityManager.remove(producto);
            entityManager.getTransaction().commit();
            return true;
        }
        entityManager.getTransaction().commit();
        return false;
    }

    @Override
    public boolean actualizar(Producto productoNuevo) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Producto producto = entityManager.find(Producto.class, productoNuevo.getIdproducto());
        if (producto != null) {
            producto.setNombre(productoNuevo.getNombre());
            producto.setprecioatual(productoNuevo.getprecioactual());
            producto.setStock(productoNuevo.getStock());
            producto.setProveedor(productoNuevo.getProveedor());
            producto.setCategoria(productoNuevo.getCategoria());
            entityManager.merge(producto);
            entityManager.getTransaction().commit();
            return true;
        }
        entityManager.getTransaction().commit();
        return false;
    }

    @Override
    public Producto buscarporID(int id) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Producto cliente = entityManager.find(Producto.class, id);
        entityManager.getTransaction().commit();
        return cliente;
    }

    @Override
    public List<Producto> buscarTodas(String textoBusqueda) {
     EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaQuery criteria = entityManager.getCriteriaBuilder().createQuery();
        criteria.select(criteria.from(Producto.class));
        Query query = entityManager.createQuery(criteria);
        List<Producto> productos = query.getResultList();
        entityManager.getTransaction().commit();
        return productos;
    }
    
    public List<Producto> buscarLike(String busqueda) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        String sql;
        if (!busqueda.isEmpty()) {
            if (busqueda.matches("^[0-9]*$")) {
                sql = "SELECT p FROM Producto p WHERE p.idproducto=" + busqueda + "";
            } else {
                sql = "SELECT p FROM Producto p WHERE p.nombre LIKE '" + busqueda + "%'";
            }
        } else {
            sql = "SELECT p FROM Producto p WHERE p.nombre LIKE '" + busqueda + "%'";
        }
        Query query1 = entityManager.createQuery(sql);
        List<Producto> list1 = (List<Producto>) query1.getResultList();
        return list1;
    }
}
