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
@Table(name = "clientes")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcliente")
    private Integer idcliente;

    @Column(name = "rfc", length = 15, nullable = false)
    private String rfc;

    @Column(name = "nombre", length = 45, nullable = false)
    private String nombre;

    @Column(name = "direecion", length = 100, nullable = false)
    private String direccion;

    @Column(name = "telefono1", length = 15, nullable = true)
    private String telefono1;

    @Column(name = "telefono2", length = 15, nullable = true)
    private String telefono2;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Venta> ventas;

    public Cliente() {
        this.ventas = new ArrayList<>();
    }

    public Cliente(String rfc, String nombre, String direccion, String telefono1, String telefono2) {
        this();
        this.rfc = rfc;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
    }

    public Cliente(Integer idcliente, String rfc, String nombre, String direccion, String telefono1, String telefono2) {
        this();
        this.idcliente = idcliente;
        this.rfc = rfc;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
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

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    public void addVenta(Venta... venta) {
        this.ventas.addAll(Arrays.asList(venta));
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.idcliente);
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
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.idcliente, other.idcliente)) {
            return false;
        }
        return true;
    }

    public Object[] toArray() {
        return new Object[]{
            this.getIdcliente(),
            this.getRfc(),
            this.getNombre(),
            this.getDireccion(),
            this.getTelefono1(),
            this.getTelefono2()
        };
    }

    @Override
    public String toString() {
        return this.idcliente + ", " + this.nombre;
    }

}
