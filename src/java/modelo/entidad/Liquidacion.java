/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Invitado
 */
@Entity
@Table(name = "LIQUIDACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Liquidacion.findAll", query = "SELECT l FROM Liquidacion l")
    , @NamedQuery(name = "Liquidacion.findByCodliq", query = "SELECT l FROM Liquidacion l WHERE l.codliq = :codliq")
    , @NamedQuery(name = "Liquidacion.findByFecinicio", query = "SELECT l FROM Liquidacion l WHERE l.fecinicio = :fecinicio")
    , @NamedQuery(name = "Liquidacion.findByFecfin", query = "SELECT l FROM Liquidacion l WHERE l.fecfin = :fecfin")
    , @NamedQuery(name = "Liquidacion.findByMontoliq", query = "SELECT l FROM Liquidacion l WHERE l.montoliq = :montoliq")
    , @NamedQuery(name = "Liquidacion.findByFecreg", query = "SELECT l FROM Liquidacion l WHERE l.fecreg = :fecreg")})
public class Liquidacion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODLIQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LIQUIDACION_SEQ")
    @SequenceGenerator(sequenceName = "liquidacion_seq", allocationSize = 1, name = "LIQUIDACION_SEQ")
    private BigDecimal codliq;
    @Column(name = "FECINICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecinicio;
    @Column(name = "FECFIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecfin;
    @Column(name = "MONTOLIQ")
    private BigDecimal montoliq;
    @Column(name = "FECREG")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecreg;
    @JoinColumn(name = "CODEXP", referencedColumnName = "CODEXP")
    @ManyToOne(optional = false)
    private Expediente codexp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codliq")
    private List<Pagos> pagosList;

    public Liquidacion() {
    }

    public Liquidacion(BigDecimal codliq) {
        this.codliq = codliq;
    }

    public BigDecimal getCodliq() {
        return codliq;
    }

    public void setCodliq(BigDecimal codliq) {
        this.codliq = codliq;
    }

    public Date getFecinicio() {
        return fecinicio;
    }

    public void setFecinicio(Date fecinicio) {
        this.fecinicio = fecinicio;
    }

    public Date getFecfin() {
        return fecfin;
    }

    public void setFecfin(Date fecfin) {
        this.fecfin = fecfin;
    }

    public BigDecimal getMontoliq() {
        return montoliq;
    }

    public void setMontoliq(BigDecimal montoliq) {
        this.montoliq = montoliq;
    }

    public Date getFecreg() {
        return fecreg;
    }

    public void setFecreg(Date fecreg) {
        this.fecreg = fecreg;
    }

    public Expediente getCodexp() {
        return codexp;
    }

    public void setCodexp(Expediente codexp) {
        this.codexp = codexp;
    }

    @XmlTransient
    public List<Pagos> getPagosList() {
        return pagosList;
    }

    public void setPagosList(List<Pagos> pagosList) {
        this.pagosList = pagosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codliq != null ? codliq.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Liquidacion)) {
            return false;
        }
        Liquidacion other = (Liquidacion) object;
        if ((this.codliq == null && other.codliq != null) || (this.codliq != null && !this.codliq.equals(other.codliq))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidad.Liquidacion[ codliq=" + codliq + " ]";
    }
    
}
