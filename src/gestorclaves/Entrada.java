/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestorclaves;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "entrada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entrada.findAll", query = "SELECT e FROM Entrada e"),
    @NamedQuery(name = "Entrada.findByIdClave", query = "SELECT e FROM Entrada e WHERE e.idClave = :idClave"),
    @NamedQuery(name = "Entrada.findByNombre", query = "SELECT e FROM Entrada e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Entrada.findByUsuario", query = "SELECT e FROM Entrada e WHERE e.usuario = :usuario"),
    @NamedQuery(name = "Entrada.findByClave", query = "SELECT e FROM Entrada e WHERE e.clave = :clave"),
    @NamedQuery(name = "Entrada.findByPaginaWeb", query = "SELECT e FROM Entrada e WHERE e.paginaWeb = :paginaWeb"),
    @NamedQuery(name = "Entrada.findByFavorito", query = "SELECT e FROM Entrada e WHERE e.favorito = :favorito"),
    @NamedQuery(name = "Entrada.findByFecha", query = "SELECT e FROM Entrada e WHERE e.fecha = :fecha"),
    @NamedQuery(name = "Entrada.findByCuota", query = "SELECT e FROM Entrada e WHERE e.cuota = :cuota")})
public class Entrada implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_clave")
    private Integer idClave;
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @Column(name = "clave")
    private String clave;
    @Column(name = "pagina_web")
    private String paginaWeb;
    @Column(name = "favorito")
    private Boolean favorito;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cuota")
    private BigDecimal cuota;
    @JoinColumn(name = "id_cat", referencedColumnName = "id_cat")
    @ManyToOne
    private Categoria idCat;

    public Entrada() {
    }

    public Entrada(Integer idClave) {
        this.idClave = idClave;
    }

    public Entrada(Integer idClave, String usuario, String clave) {
        this.idClave = idClave;
        this.usuario = usuario;
        this.clave = clave;
    }

    public Integer getIdClave() {
        return idClave;
    }

    public void setIdClave(Integer idClave) {
        this.idClave = idClave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public Boolean getFavorito() {
        return favorito;
    }

    public void setFavorito(Boolean favorito) {
        this.favorito = favorito;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getCuota() {
        return cuota;
    }

    public void setCuota(BigDecimal cuota) {
        this.cuota = cuota;
    }

    public Categoria getIdCat() {
        return idCat;
    }

    public void setIdCat(Categoria idCat) {
        this.idCat = idCat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClave != null ? idClave.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entrada)) {
            return false;
        }
        Entrada other = (Entrada) object;
        if ((this.idClave == null && other.idClave != null) || (this.idClave != null && !this.idClave.equals(other.idClave))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gestorclaves.Entrada[ idClave=" + idClave + " ]";
    }
    
}
