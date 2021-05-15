
package objetosNegocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "categorias")
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "idcategoria", nullable = false)
    private Integer idcategoria;
    
    @Column(name= "nombre", nullable = false, length = 45)
    private String nombre;
    
    @Column(name = "descripcion", nullable = false ,length = 100)
    private String descripcion;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="categoria")
    private List<Producto> productos;

    public Categoria() {
        this.productos = new ArrayList<>();
    }

    public Categoria(int idcategoria, String nombre, String descripcion) {
        this.idcategoria = idcategoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Categoria(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Categoria( String nombre, String descripcion, List<Producto> productos) {
        this();
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.productos = productos;
    }

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
    
    public void addProducto(Producto... producto){
        this.productos.addAll(Arrays.asList(producto));        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.idcategoria);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Categoria other = (Categoria) obj;
        if (!Objects.equals(this.idcategoria, other.idcategoria)) {
            return false;
        }
        return true;
    }

    public Object[] toArray() {
        return new Object[]{
            this.getIdcategoria(),
            this.getNombre(),
            this.getDescripcion()
        };
    }
    
    @Override
    public String toString() {
        return idcategoria + ", " + nombre;
    }


    
}
