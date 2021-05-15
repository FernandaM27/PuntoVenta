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
import objetosNegocio.Rel_ProductoVenta;
/**
 *
 * @author Dany
 */
public class Rel_ProductoVentaRepository extends BaseRepository<Rel_ProductoVenta>{
    
    @Override
    public boolean guardar(Rel_ProductoVenta rel_provent) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(rel_provent);
        entityManager.getTransaction().commit();
        return true;
    }

    @Override
    public boolean eliminar(int id) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Rel_ProductoVenta rel_provent = entityManager.find(Rel_ProductoVenta.class, id);
        if (rel_provent != null) {
            entityManager.remove(rel_provent);
            entityManager.getTransaction().commit();
            return true;
        }
        entityManager.getTransaction().commit();
        return false;
    }

    @Override
    public boolean actualizar(Rel_ProductoVenta rel_proventNueva) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Rel_ProductoVenta rel_provent = entityManager.find(Rel_ProductoVenta.class, rel_proventNueva.getIdrel_productoventa());
        if (rel_provent != null) {
            rel_provent.setPrecio(rel_proventNueva.getPrecio());
            rel_provent.setCantidad(rel_proventNueva.getCantidad());
            rel_provent.setMontoTotal(rel_proventNueva.getMontoTotal());
            rel_provent.setVenta(rel_proventNueva.getVenta());
            rel_provent.setProducto(rel_proventNueva.getProducto());
            entityManager.merge(rel_provent);
            entityManager.getTransaction().commit();
            return true;
        }
        entityManager.getTransaction().commit();
        return false;
    }

    @Override
    public Rel_ProductoVenta buscarporID(int id) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Rel_ProductoVenta rel_provent = entityManager.find(Rel_ProductoVenta.class, id);
        entityManager.getTransaction().commit();
        return rel_provent;
    }

    @Override
    public List<Rel_ProductoVenta> buscarTodas(String textoBusqueda) {
        EntityManager entityManager = this.createEntityManager();
        CriteriaQuery criteria = entityManager.getCriteriaBuilder().createQuery();
        criteria.select(criteria.from(Rel_ProductoVenta.class));
        Query query = entityManager.createQuery(criteria);
        List<Rel_ProductoVenta> rel_proventas = query.getResultList();
        List<Rel_ProductoVenta> rel_proventasTexto = new ArrayList<>();
        entityManager.getTransaction().commit();
        return rel_proventas;
    }
}
