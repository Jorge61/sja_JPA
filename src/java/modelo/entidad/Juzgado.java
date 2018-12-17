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
@Table(name = "JUZGADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Juzgado.findAll", query = "SELECT j FROM Juzgado j")
    , @NamedQuery(name = "Juzgado.findByCodjuz", query = "SELECT j FROM Juzgado j WHERE j.codjuz = :codjuz")
    , @NamedQuery(name = "Juzgado.findByNombjuz", query = "SELECT j FROM Juzgado j WHERE j.nombjuz = :nombjuz")
    , @NamedQuery(name = "Juzgado.findByAdmjuz", query = "SELECT j FROM Juzgado j WHERE j.admjuz = :admjuz")
    , @NamedQuery(name = "Juzgado.findBySecjuz", query = "SELECT j FROM Juzgado j WHERE j.secjuz = :secjuz")
    , @NamedQuery(name = "Juzgado.findByEstjuz", query = "SELECT j FROM Juzgado j WHERE j.estjuz = :estjuz")})
public class Juzgado implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODJUZ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "JUZGADO_SEQ")
    @SequenceGenerator(sequenceName = "juzgado_seq", allocationSize = 1, name = "JUZGADO_SEQ")
    private BigDecimal codjuz;
    @Size(max = 50)
    @Column(name = "NOMBJUZ")
    private String nombjuz;
    @Size(max = 100)
    @Column(name = "ADMJUZ")
    private String admjuz;
    @Size(max = 100)
    @Column(name = "SECJUZ")
    private String secjuz;
    @Column(name = "ESTJUZ")
    private Character estjuz;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codjuz")
    private List<Expediente> expedienteList;

    public Juzgado() {
    }

    public Juzgado(BigDecimal codjuz) {
        this.codjuz = codjuz;
    }

    public BigDecimal getCodjuz() {
        return codjuz;
    }

    public void setCodjuz(BigDecimal codjuz) {
        this.codjuz = codjuz;
    }

    public String getNombjuz() {
        return nombjuz;
    }

    public void setNombjuz(String nombjuz) {
        this.nombjuz = nombjuz;
    }

    public String getAdmjuz() {
        return admjuz;
    }

    public void setAdmjuz(String admjuz) {
        this.admjuz = admjuz;
    }

    public String getSecjuz() {
        return secjuz;
    }

    public void setSecjuz(String secjuz) {
        this.secjuz = secjuz;
    }

    public Character getEstjuz() {
        return estjuz;
    }

    public void setEstjuz(Character estjuz) {
        this.estjuz = estjuz;
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
        hash += (codjuz != null ? codjuz.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Juzgado)) {
            return false;
        }
        Juzgado other = (Juzgado) object;
        if ((this.codjuz == null && other.codjuz != null) || (this.codjuz != null && !this.codjuz.equals(other.codjuz))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidad.Juzgado[ codjuz=" + codjuz + " ]";
    }
    
}
