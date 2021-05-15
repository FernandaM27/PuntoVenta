
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
@Table(name = "proveedores")
public class Proveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "idproveedor")
    private Integer idproveedor;
    
    @Column(name = "rfc", nullable = false, length = 15)
    private String rfc;
    
    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;
    
    @Column(name = "direccion", nullable = false, length = 45)
    private String direccion;
    
    @Column(name = "telefono", nullable = true, length = 20)
    private String telefono;
    
    @Column(name = "paginaweb", nullable = true, length = 500)
    private String paginaWeb;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="proveedor")
    private List<Producto> productos;

    public Proveedor() {
        this.productos = new ArrayList<>();
    }

    public Proveedor(String rfc, String nombre, String direccion, String telefono, String paginaWeb) {
        this.rfc = rfc;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.paginaWeb = paginaWeb;
    }

    public Proveedor(Integer idproveedor, String rfc, String nombre, String direccion, String telefono, String paginaWeb) {
        this.idproveedor = idproveedor;
        this.rfc = rfc;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.paginaWeb = paginaWeb;
    }
    
    
    public Proveedor( String rfc, String nombre, String direccion, String telefono, String paginaWeb, List<Producto> productos) {
      this.rfc = rfc;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.paginaWeb = paginaWeb;
        this.productos = productos;
    }

    public int getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
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
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.idproveedor);
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
        final Proveedor other = (Proveedor) obj;
        if (!Objects.equals(this.idproveedor, other.idproveedor)) {
            return false;
        }
        return true;
    }
    
    public Object[] toArray() {
        return new Object[]{
            this.getIdproveedor(),
            this.getRfc(),
            this.getNombre(),
            this.getDireccion(),
            this.getTelefono(),
            this.getPaginaWeb()
        };
    }

    @Override
    public String toString() {
        return this.idproveedor+",  "+this.nombre;
    }
    
}
