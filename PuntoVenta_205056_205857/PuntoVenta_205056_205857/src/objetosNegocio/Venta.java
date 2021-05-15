package objetosNegocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ventas")
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idventa")
    private Integer idventa;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "descuento")
    private float descuento;

    @Column(name = "montofinal")
    private float montoFinal;

    @ManyToOne
    @JoinColumn(name = "idcliente", nullable = false)
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venta")
    private List<Rel_ProductoVenta> relProVen;

    public Venta() {
        this.relProVen = new ArrayList<>();
    }

    public Venta(Date fecha, float descuento, float montoFinal, Cliente cliente) {
        this();
        this.fecha = fecha;
        this.descuento = descuento;
        this.montoFinal = montoFinal;
        this.cliente = cliente;
    }

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public float getMontoFinal() {
        return montoFinal;
    }

    public void setMontoFinal(float montoFinal) {
        this.montoFinal = montoFinal;
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
        hash = 59 * hash + Objects.hashCode(this.idventa);
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
        final Venta other = (Venta) obj;
        if (!Objects.equals(this.idventa, other.idventa)) {
            return false;
        }
        return true;
    }

    public Object[] toArray() {
        return new Object[]{
            this.getIdventa(),
            this.getCliente().getNombre(),
            this.getFecha(),
            this.getDescuento(),            
            this.getMontoFinal(),
            
        };
    }

    @Override
    public String toString() {
        return "Venta{" + "idventa=" + idventa + ", fecha=" + fecha + ", descuento=" + descuento + ", montofinal=" + montoFinal + ", cliente=" + cliente + '}';
    }

}
