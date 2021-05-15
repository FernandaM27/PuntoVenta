/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Dany
 * @param <T>
 */
public abstract class BaseRepository<T>{
    
    //Definir el contrato
    //T es que el tipo de dato aun no esta definido
    public abstract boolean guardar(T entidad);
    public abstract boolean eliminar(int id);
    public abstract boolean actualizar(T entidad);
    //T porque es el tipo con el que estamos trabajando
    public abstract T buscarporID(int id);
    public abstract List<T> buscarTodas(String textoBusqueda);

    public EntityManager createEntityManager(){
        EntityManagerFactory managerFactory= Persistence.createEntityManagerFactory("PuntoVenta_205056_205857PU");
        EntityManager entityManager= managerFactory.createEntityManager();
        return entityManager;
    }
}
