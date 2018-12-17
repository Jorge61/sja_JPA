/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidad;

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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Invitado
 */
@Entity
@Table(name = "PAGOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pagos.findAll", query = "SELECT p FROM Pagos p")
    , @NamedQuery(name = "Pagos.findByCodpag", query = "SELECT p FROM Pagos p WHERE p.codpag = :codpag")
    , @NamedQuery(name = "Pagos.findByFecpago", query = "SELECT p FROM Pagos p WHERE p.fecpago = :fecpago")
    , @NamedQuery(name = "Pagos.findByMontpago", query = "SELECT p FROM Pagos p WHERE p.montpago = :montpago")
    , @NamedQuery(name = "Pagos.findByFecreg", query = "SELECT p FROM Pagos p WHERE p.fecreg = :fecreg")})
public class Pagos implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODPAG")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PAGOS_SEQ")
    @SequenceGenerator(sequenceName = "pagos_seq", allocationSize = 1, name = "PAGOS_SEQ")
    private BigDecimal codpag;
    @Column(name = "FECPAGO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecpago;
    @Column(name = "MONTPAGO")
    private BigDecimal montpago;
    @Column(name = "FECREG")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecreg;
    @JoinColumn(name = "CODLIQ", referencedColumnName = "CODLIQ")
    @ManyToOne(optional = false)
    private Liquidacion codliq;

    public Pagos() {
    }

    public Pagos(BigDecimal codpag) {
        this.codpag = codpag;
    }

    public BigDecimal getCodpag() {
        return codpag;
    }

    public void setCodpag(BigDecimal codpag) {
        this.codpag = codpag;
    }

    public Date getFecpago() {
        return fecpago;
    }

    public void setFecpago(Date fecpago) {
        this.fecpago = fecpago;
    }

    public BigDecimal getMontpago() {
        return montpago;
    }

    public void setMontpago(BigDecimal montpago) {
        this.montpago = montpago;
    }

    public Date getFecreg() {
        return fecreg;
    }

    public void setFecreg(Date fecreg) {
        this.fecreg = fecreg;
    }

    public Liquidacion getCodliq() {
        return codliq;
    }

    public void setCodliq(Liquidacion codliq) {
        this.codliq = codliq;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codpag != null ? codpag.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pagos)) {
            return false;
        }
        Pagos other = (Pagos) object;
        if ((this.codpag == null && other.codpag != null) || (this.codpag != null && !this.codpag.equals(other.codpag))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidad.Pagos[ codpag=" + codpag + " ]";
    }
    
}
