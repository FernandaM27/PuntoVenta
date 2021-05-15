/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import objetosNegocio.Categoria;

/**
 *
 * @author Dany
 */
public class CategoriasRepository extends BaseRepository<Categoria> {

    @Override
    public boolean guardar(Categoria categoria) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(categoria);
        entityManager.getTransaction().commit();
        return true;
    }

    @Override
    public boolean eliminar(int id) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Categoria categoria = entityManager.find(Categoria.class, id);
        if (categoria != null) {
            entityManager.remove(categoria);
            entityManager.getTransaction().commit();
            return true;
        }
        entityManager.getTransaction().commit();
        return false;
    }

    @Override
    public boolean actualizar(Categoria categoriaNueva) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Categoria categoria = entityManager.find(Categoria.class,categoriaNueva.getIdcategoria());
        if (categoria != null) {
            categoria.setNombre(categoriaNueva.getNombre());
            categoria.setDescripcion(categoriaNueva.getDescripcion());
            categoria.setProductos(categoriaNueva.getProductos());
            entityManager.merge(categoria);
            entityManager.getTransaction().commit();
            return true;
        }
        entityManager.getTransaction().commit();
        return false;
    }

    @Override
    public Categoria buscarporID(int id) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Categoria categoria = entityManager.find(Categoria.class, id);
        entityManager.getTransaction().commit();
        return categoria;
    }

    @Override
    public List<Categoria> buscarTodas(String textoBusqueda) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaQuery criteria = entityManager.getCriteriaBuilder().createQuery();
        criteria.select(criteria.from(Categoria.class));
        Query query = entityManager.createQuery(criteria);
        List<Categoria> categorias = query.getResultList();
        List<Categoria> categoriasTexto = new ArrayList<>();
        entityManager.getTransaction().commit();
        return categorias;

    }

    public List<Categoria> buscarLike(String busqueda) {
        ArrayList<Categoria> listaCategorias = new ArrayList<>();
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        String sql;
        if (!busqueda.isEmpty()) {
            if (busqueda.matches("^[0-9]*$")) {
                sql = "SELECT p FROM Categoria p WHERE p.nombre LIKE '" + busqueda + "%' OR p.idcategoria=" + busqueda + "";
            } else {
                sql = "SELECT p FROM Categoria p WHERE p.nombre LIKE '" + busqueda + "%'";
            }
        } else {
            sql = "SELECT p FROM Categoria p WHERE p.nombre LIKE '" + busqueda + "%'";
        }
        Query query1 = entityManager.createQuery(sql);
        List<Categoria> list1 = (List<Categoria>) query1.getResultList();
        return list1;
    }

}
