/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import objetosNegocio.Cliente;
import objetosNegocio.Venta;


/**
 *
 * @author Dany
 */
public class VentasRepository extends BaseRepository<Venta>{

    @Override
    public boolean guardar(Venta venta) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(venta);
        entityManager.getTransaction().commit();
        return true;
    }

    @Override
    public boolean eliminar(int id) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Venta venta = entityManager.find(Venta.class, id);
        if (venta != null) {
            entityManager.remove(venta);
            entityManager.getTransaction().commit();
            return true;
        }
        entityManager.getTransaction().commit();
        return false;
    }

    @Override
    public boolean actualizar(Venta ventaNueva) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Venta venta = entityManager.find(Venta.class, ventaNueva.getIdventa());
        if (venta != null) {
            venta.setFecha(ventaNueva.getFecha());
            venta.setDescuento(ventaNueva.getDescuento());
            venta.setMontoFinal(ventaNueva.getMontoFinal());
            venta.setCliente(ventaNueva.getCliente());
            venta.setRelProVen(ventaNueva.getRelProVen());
            entityManager.merge(venta);
            entityManager.getTransaction().commit();
            return true;
        }
        entityManager.getTransaction().commit();
        return false;
    }

    @Override
    public Venta buscarporID(int id) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Venta venta = entityManager.find(Venta.class, id);
        entityManager.getTransaction().commit();
        return venta;
    }

    @Override
    public List<Venta> buscarTodas(String textoBusqueda) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaQuery criteria = entityManager.getCriteriaBuilder().createQuery();
        criteria.select(criteria.from(Venta.class));
        Query query = entityManager.createQuery(criteria);
        List<Venta> ventas = query.getResultList();
        entityManager.getTransaction().commit();
        return ventas;
    }
    
    public List<Venta> busquedaRango(Cliente cliente, Date inicio, Date fin) {
        EntityManager entityManager = this.createEntityManager();
        CriteriaQuery criteria = entityManager.getCriteriaBuilder().createQuery();
        criteria.select(criteria.from(Venta.class));
        Query query = entityManager.createQuery(criteria);
        List<Venta> ventas = query.getResultList();
        List<Venta> ventasRango = new ArrayList<>();
        if (cliente.getNombre().equalsIgnoreCase("Todos")) {
            for (Venta venta : ventas) {
                if (venta.getFecha().after(inicio) && venta.getFecha().before(fin)) {
                    ventasRango.add(venta);
                }
            }
        } else {
            for (Venta venta : ventas) {
                if (venta.getCliente().equals(cliente)) {
                    if (venta.getFecha().after(inicio) && venta.getFecha().before(fin)) {
                        ventasRango.add(venta);
                    }
                }
            }
        }
        return ventasRango;
    }    
    
    public int ultimaVenta(){
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        String sql;
        sql = "SELECT max(p.idventa) FROM Venta p";
        Query query1 = entityManager.createQuery(sql);
        return (Integer)query1.getSingleResult();
    }
}
