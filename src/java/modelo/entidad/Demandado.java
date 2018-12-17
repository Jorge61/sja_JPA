/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Invitado
 */
@Entity
@Table(name = "DEMANDADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Demandado.findAll", query = "SELECT d FROM Demandado d")
    , @NamedQuery(name = "Demandado.findByCoddado", query = "SELECT d FROM Demandado d WHERE d.coddado = :coddado")
    , @NamedQuery(name = "Demandado.findByDnidado", query = "SELECT d FROM Demandado d WHERE d.dnidado = :dnidado")
    , @NamedQuery(name = "Demandado.findByNombdado", query = "SELECT d FROM Demandado d WHERE d.nombdado = :nombdado")
    , @NamedQuery(name = "Demandado.findByApepdado", query = "SELECT d FROM Demandado d WHERE d.apepdado = :apepdado")
    , @NamedQuery(name = "Demandado.findByApemdado", query = "SELECT d FROM Demandado d WHERE d.apemdado = :apemdado")
    , @NamedQuery(name = "Demandado.findByCeldado", query = "SELECT d FROM Demandado d WHERE d.celdado = :celdado")
    , @NamedQuery(name = "Demandado.findByDirdado", query = "SELECT d FROM Demandado d WHERE d.dirdado = :dirdado")
    , @NamedQuery(name = "Demandado.findBySueldado", query = "SELECT d FROM Demandado d WHERE d.sueldado = :sueldado")
    , @NamedQuery(name = "Demandado.findByEstdado", query = "SELECT d FROM Demandado d WHERE d.estdado = :estdado")})
public class Demandado implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODDADO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DEMANDADO_SEQ")
    @SequenceGenerator(sequenceName = "demandado_seq", allocationSize = 1, name = "DEMANDADO_SEQ")
    private BigDecimal coddado;
    @Size(max = 8)
    @Column(name = "DNIDADO")
    private String dnidado;
    @Size(max = 50)
    @Column(name = "NOMBDADO")
    private String nombdado;
    @Size(max = 50)
    @Column(name = "APEPDADO")
    private String apepdado;
    @Size(max = 50)
    @Column(name = "APEMDADO")
    private String apemdado;
    @Size(max = 9)
    @Column(name = "CELDADO")
    private String celdado;
    @Size(max = 100)
    @Column(name = "DIRDADO")
    private String dirdado;
    @Column(name = "SUELDADO")
    private BigDecimal sueldado;
    @Column(name = "ESTDADO")
    private Character estdado;
    @JoinColumn(name = "CODUBI", referencedColumnName = "CODUBI")
    @ManyToOne
    private Ubigeo codubi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coddado")
    private List<Expediente> expedienteList;

    public Demandado() {
    }

    public Demandado(BigDecimal coddado) {
        this.coddado = coddado;
    }

    public BigDecimal getCoddado() {
        return coddado;
    }

    public void setCoddado(BigDecimal coddado) {
        this.coddado = coddado;
    }

    public String getDnidado() {
        return dnidado;
    }

    public void setDnidado(String dnidado) {
        this.dnidado = dnidado;
    }

    public String getNombdado() {
        return nombdado;
    }

    public void setNombdado(String nombdado) {
        this.nombdado = nombdado;
    }

    public String getApepdado() {
        return apepdado;
    }

    public void setApepdado(String apepdado) {
        this.apepdado = apepdado;
    }

    public String getApemdado() {
        return apemdado;
    }

    public void setApemdado(String apemdado) {
        this.apemdado = apemdado;
    }

    public String getCeldado() {
        return celdado;
    }

    public void setCeldado(String celdado) {
        this.celdado = celdado;
    }

    public String getDirdado() {
        return dirdado;
    }

    public void setDirdado(String dirdado) {
        this.dirdado = dirdado;
    }

    public BigDecimal getSueldado() {
        return sueldado;
    }

    public void setSueldado(BigDecimal sueldado) {
        this.sueldado = sueldado;
    }

    public Character getEstdado() {
        return estdado;
    }

    public void setEstdado(Character estdado) {
        this.estdado = estdado;
    }

    public Ubigeo getCodubi() {
        return codubi;
    }

    public void setCodubi(Ubigeo codubi) {
        this.codubi = codubi;
    }

    @XmlTransient
    public List<Expediente> getExpedienteList() {
        return expedienteList;
    }

    public void setExpedienteList(List<Expediente> expedienteList) {
        this.expedienteList = expedienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coddado != null ? coddado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Demandado)) {
            return false;
        }
        Demandado other = (Demandado) object;
        if ((this.coddado == null && other.coddado != null) || (this.coddado != null && !this.coddado.equals(other.coddado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidad.Demandado[ coddado=" + coddado + " ]";
    }
    
}
