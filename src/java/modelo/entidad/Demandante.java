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
@Table(name = "DEMANDANTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Demandante.findAll", query = "SELECT d FROM Demandante d")
    , @NamedQuery(name = "Demandante.findByCoddnte", query = "SELECT d FROM Demandante d WHERE d.coddnte = :coddnte")
    , @NamedQuery(name = "Demandante.findByDnidnte", query = "SELECT d FROM Demandante d WHERE d.dnidnte = :dnidnte")
    , @NamedQuery(name = "Demandante.findByNombdnte", query = "SELECT d FROM Demandante d WHERE d.nombdnte = :nombdnte")
    , @NamedQuery(name = "Demandante.findByApepdnte", query = "SELECT d FROM Demandante d WHERE d.apepdnte = :apepdnte")
    , @NamedQuery(name = "Demandante.findByApemdnte", query = "SELECT d FROM Demandante d WHERE d.apemdnte = :apemdnte")
    , @NamedQuery(name = "Demandante.findByCeldnte", query = "SELECT d FROM Demandante d WHERE d.celdnte = :celdnte")
    , @NamedQuery(name = "Demandante.findByDirdnte", query = "SELECT d FROM Demandante d WHERE d.dirdnte = :dirdnte")
    , @NamedQuery(name = "Demandante.findByEstdnte", query = "SELECT d FROM Demandante d WHERE d.estdnte = :estdnte")})
public class Demandante implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODDNTE")
    private BigDecimal coddnte;
    @Size(max = 8)
    @Column(name = "DNIDNTE")
    private String dnidnte;
    @Size(max = 50)
    @Column(name = "NOMBDNTE")
    private String nombdnte;
    @Size(max = 50)
    @Column(name = "APEPDNTE")
    private String apepdnte;
    @Size(max = 50)
    @Column(name = "APEMDNTE")
    private String apemdnte;
    @Size(max = 9)
    @Column(name = "CELDNTE")
    private int celdnte;
    @Size(max = 100)
    @Column(name = "DIRDNTE")
    private String dirdnte;
    @Column(name = "ESTDNTE")
    private Character estdnte;
    @JoinColumn(name = "CODUBI", referencedColumnName = "CODUBI")
    @ManyToOne
    private Ubigeo codubi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coddnte")
    private List<Expediente> expedienteList;

    public Demandante() {
    }

    public Demandante(BigDecimal coddnte) {
        this.coddnte = coddnte;
    }

    public BigDecimal getCoddnte() {
        return coddnte;
    }

    public void setCoddnte(BigDecimal coddnte) {
        this.coddnte = coddnte;
    }

    public String getDnidnte() {
        return dnidnte;
    }

    public void setDnidnte(String dnidnte) {
        this.dnidnte = dnidnte;
    }

    public String getNombdnte() {
        return nombdnte;
    }

    public void setNombdnte(String nombdnte) {
        this.nombdnte = nombdnte;
    }

    public String getApepdnte() {
        return apepdnte;
    }

    public void setApepdnte(String apepdnte) {
        this.apepdnte = apepdnte;
    }

    public String getApemdnte() {
        return apemdnte;
    }

    public void setApemdnte(String apemdnte) {
        this.apemdnte = apemdnte;
    }

    public int getCeldnte() {
        return celdnte;
    }

    public void setCeldnte(int celdnte) {
        this.celdnte = celdnte;
    }

    public String getDirdnte() {
        return dirdnte;
    }

    public void setDirdnte(String dirdnte) {
        this.dirdnte = dirdnte;
    }

    public Character getEstdnte() {
        return estdnte;
    }

    public void setEstdnte(Character estdnte) {
        this.estdnte = estdnte;
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
        hash += (coddnte != null ? coddnte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Demandante)) {
            return false;
        }
        Demandante other = (Demandante) object;
        if ((this.coddnte == null && other.coddnte != null) || (this.coddnte != null && !this.coddnte.equals(other.coddnte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidad.Demandante[ coddnte=" + coddnte + " ]";
    }
    
}
