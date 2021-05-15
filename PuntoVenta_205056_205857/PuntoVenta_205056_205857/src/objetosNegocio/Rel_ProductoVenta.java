package objetosNegocio;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rel_productoventa")
public class Rel_ProductoVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrel_puntoventa", nullable = false)
    private Integer idrel_productoventa;
    
    @Column(name = "precio", nullable = false)
    private float precio;
    
    @Column(name = "cantidad", length = 11, nullable = false)
    private int cantidad;
    
    @Column(name = "montototal", nullable = false)
    private float montoTotal;
    
    @ManyToOne
    @JoinColumn(name = "idventa", nullable = false)
    private Venta venta;
    
    @ManyToOne
    @JoinColumn(name = "idproducto", nullable = false)
    private Producto producto;

    public Rel_ProductoVenta() {
    }
    
    public Rel_ProductoVenta(float precio, int cantidad, float montoTotal) {        
        this.precio = precio;
        this.cantidad = cantidad;
        this.montoTotal = montoTotal;
    }

    public Rel_ProductoVenta(float precio, int cantidad, float montoTotal, Venta venta, Producto producto) {
        this.precio = precio;
        this.cantidad = cantidad;
        this.montoTotal = montoTotal;
        this.venta = venta;
        this.producto = producto;
    }

    public int getIdrel_productoventa() {
        return idrel_productoventa;
    }

    public void setIdrel_productoventa(int idrel_productoventa) {
        this.idrel_productoventa = idrel_productoventa;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrel_productoventa!=null ? idrel_productoventa.hashCode():0);
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
        final Rel_ProductoVenta other = (Rel_ProductoVenta) obj;
        if (this.idrel_productoventa != other.idrel_productoventa) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Rel_ProductoVenta{" + "idrel_productoventa=" + idrel_productoventa + ", precio=" + precio + ", cantidad=" + cantidad + ", montoTotal=" + montoTotal + ", venta=" + venta + ", producto=" + producto + '}';
    }

  

}
