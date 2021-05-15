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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproducto")
    private Integer idproducto;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "precioactual", nullable = false)
    private float precioactual;

    @Column(name = "stock", nullable = false)
    private int stock;

    @ManyToOne
    @JoinColumn(name = "idproveedor", nullable = false)
    private Proveedor proveedor;

    @ManyToOne
    @JoinColumn(name = "idcategoria", nullable = false)
    private Categoria categoria;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private List<Rel_ProductoVenta> relProVen;

    public Producto() {
        this.relProVen = new ArrayList<>();
    }

    public Producto(String nombre, float precioActual, int stock, Proveedor proveedor, Categoria categoria) {
        this.nombre = nombre;
        this.precioactual = precioActual;
        this.stock = stock;
        this.proveedor = proveedor;
        this.categoria = categoria;
    }

    public Producto(Integer idproducto, String nombre, float precioactual, int stock, Proveedor proveedor, Categoria categoria) {
        this.idproducto = idproducto;
        this.nombre = nombre;
        this.precioactual = precioactual;
        this.stock = stock;
        this.proveedor = proveedor;
        this.categoria = categoria;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getprecioactual() {
        return precioactual;
    }

    public void setprecioatual(float precioactual) {
        this.precioactual = precioactual;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Rel_ProductoVenta> getRelProVen() {
        return relProVen;
    }

    public void setRelProVen(List<Rel_ProductoVenta> relProVen) {
        this.relProVen = relProVen;
    }

    public void addRel_productoventa(Rel_ProductoVenta... rel_pv) {
        this.relProVen.addAll(Arrays.asList(rel_pv));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.idproducto);
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
        final Producto other = (Producto) obj;
        if (!Objects.equals(this.idproducto, other.idproducto)) {
            return false;
        }
        return true;
    }
    
    
    public Object[] toArray() {
        return new Object[]{
            this.getIdproducto(),
            this.getNombre(),
            this.getprecioactual(),
            this.getStock(),
            this.getProveedor().getIdproveedor(),
            this.getCategoria().getIdcategoria()
        };
    }
    
    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idproducto + ", nombre=" + nombre + ", precioActual=" + precioactual + ", stock=" + stock + ", proveedor=" + proveedor.getIdproveedor() + ", categoria=" + categoria.getIdcategoria() + '}';
    }

}
