package repositories;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import objetosNegocio.Categoria;
import objetosNegocio.Proveedor;

/**
 *
 * @author Daniel_Fernanda
 */
public class ProveedoresRepository extends BaseRepository<Proveedor>{

    @Override
    public boolean guardar(Proveedor proveedor) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(proveedor);
        entityManager.getTransaction().commit();
        return true;
    }

    @Override
    public boolean eliminar(int id) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Proveedor proveedor = entityManager.find(Proveedor.class, id);
        if (proveedor != null) {
            entityManager.remove(proveedor);
            entityManager.getTransaction().commit();
            return true;
        }
        entityManager.getTransaction().commit();
        return false;
    }

    @Override
    public boolean actualizar(Proveedor proveedorNuevo) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Proveedor proveedor = entityManager.find(Proveedor.class,proveedorNuevo.getIdproveedor());
        if (proveedor != null) {
            proveedor.setRfc(proveedorNuevo.getRfc());
            proveedor.setNombre(proveedorNuevo.getNombre());
            proveedor.setDireccion(proveedorNuevo.getDireccion());
            proveedor.setTelefono(proveedorNuevo.getTelefono());
            proveedor.setPaginaWeb(proveedorNuevo.getPaginaWeb());
            proveedor.setProductos(proveedorNuevo.getProductos());
            entityManager.merge(proveedor);
            entityManager.getTransaction().commit();
            return true;
        }
        entityManager.getTransaction().commit();
        return false;
    }

    @Override
    public Proveedor buscarporID(int id) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Proveedor proveedor = entityManager.find(Proveedor.class, id);
        entityManager.getTransaction().commit();
        return proveedor;
    }

    @Override
    public List<Proveedor> buscarTodas(String textoBusqueda) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaQuery criteria = entityManager.getCriteriaBuilder().createQuery();
        criteria.select(criteria.from(Proveedor.class));
        Query query = entityManager.createQuery(criteria);
        List<Proveedor> proveedores = query.getResultList();
        List<Proveedor> proveedoresTexto = new ArrayList<>();
        if (textoBusqueda == null || textoBusqueda.isEmpty()) {
            entityManager.getTransaction().commit();
            return proveedores;
        } else {
            for (Proveedor proveedor : proveedores) {
                if (proveedor.getNombre().equalsIgnoreCase(textoBusqueda)) {
                    proveedoresTexto.add(proveedor);
                }
            }
        }
        entityManager.getTransaction().commit();
        return proveedoresTexto;
    }
    
    public List<Proveedor> buscarLike(String busqueda) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        String sql;
        if (!busqueda.isEmpty()) {
            if (busqueda.matches("^[0-9]*$")) {
                sql = "SELECT p FROM Proveedor p WHERE p.nombre LIKE '" + busqueda + "%' OR p.idproveedor=" + busqueda + "";
            } else {
                sql = "SELECT p FROM Proveedor p WHERE p.nombre LIKE '" + busqueda + "%'";
            }
        } else {
            sql = "SELECT p FROM Proveedor p WHERE p.nombre LIKE '" + busqueda + "%'";
        }
        Query query1 = entityManager.createQuery(sql);
        List<Proveedor> list1 = (List<Proveedor>) query1.getResultList();
        return list1;
    }
    
}
