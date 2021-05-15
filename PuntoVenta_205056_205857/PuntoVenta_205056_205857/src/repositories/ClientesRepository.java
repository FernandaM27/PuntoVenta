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
import objetosNegocio.Cliente;
import objetosNegocio.Proveedor;

/**
 *
 * @author Dany
 */
public class ClientesRepository extends BaseRepository<Cliente>{

    @Override
    public boolean guardar(Cliente cliente) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();
        return true;
    }

    @Override
    public boolean eliminar(int id) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Cliente cliente = entityManager.find(Cliente.class, id);
        if (cliente != null) {
            entityManager.remove(cliente);
            entityManager.getTransaction().commit();
            return true;
        }
        entityManager.getTransaction().commit();
        return false;
    }

    @Override
    public boolean actualizar(Cliente clienteNuevo) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Cliente cliente = entityManager.find(Cliente.class, clienteNuevo.getIdcliente());
        if (cliente != null) {
            cliente.setRfc(clienteNuevo.getRfc());
            cliente.setNombre(clienteNuevo.getNombre());
            cliente.setTelefono1(clienteNuevo.getTelefono1());
            cliente.setTelefono2(clienteNuevo.getTelefono2());
            cliente.setVentas(clienteNuevo.getVentas());
            entityManager.merge(cliente);
            entityManager.getTransaction().commit();
            return true;
        }
        entityManager.getTransaction().commit();
        return false;
    }

    @Override
    public Cliente buscarporID(int id) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Cliente cliente = entityManager.find(Cliente.class, id);
        entityManager.getTransaction().commit();
        return cliente;
    }

    @Override
    public List<Cliente> buscarTodas(String textoBusqueda) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaQuery criteria = entityManager.getCriteriaBuilder().createQuery();
        criteria.select(criteria.from(Cliente.class));
        Query query = entityManager.createQuery(criteria);
        List<Cliente> clientes = query.getResultList();
        List<Cliente> clientesTexto = new ArrayList<>();
        if (textoBusqueda == "" || textoBusqueda.isEmpty()) {
            entityManager.getTransaction().commit();
            return clientes;
        } else {
            for (Cliente cliente : clientes) {
                if (cliente.getNombre().equalsIgnoreCase(textoBusqueda)) {
                    clientesTexto.add(cliente);
                }
            }
        }
        entityManager.getTransaction().commit();
        return clientesTexto;
    }
    
    public List<Cliente> buscarLike(String busqueda) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        String sql;
        if (!busqueda.isEmpty()) {
            if (busqueda.matches("^[0-9]*$")) {
                sql = "SELECT p FROM Cliente p WHERE p.idcliente=" + busqueda + "";
            } else {
                sql = "SELECT p FROM Cliente p WHERE p.nombre LIKE '" + busqueda + "%'";
            }
        } else {
            sql = "SELECT p FROM Cliente p WHERE p.nombre LIKE '" + busqueda + "%'";
        }
        Query query1 = entityManager.createQuery(sql);
        List<Cliente> list1 = (List<Cliente>) query1.getResultList();
        return list1;
    }
}
