/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Invitado
 */
@Entity
@Table(name = "EXPEDIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Expediente.findAll", query = "SELECT e FROM Expediente e")
    , @NamedQuery(name = "Expediente.findByCodexp", query = "SELECT e FROM Expediente e WHERE e.codexp = :codexp")
    , @NamedQuery(name = "Expediente.findByFecnotif", query = "SELECT e FROM Expediente e WHERE e.fecnotif = :fecnotif")
    , @NamedQuery(name = "Expediente.findByFecregistro", query = "SELECT e FROM Expediente e WHERE e.fecregistro = :fecregistro")
    , @NamedQuery(name = "Expediente.findByInteres", query = "SELECT e FROM Expediente e WHERE e.interes = :interes")
    , @NamedQuery(name = "Expediente.findByEstexp", query = "SELECT e FROM Expediente e WHERE e.estexp = :estexp")
    , @NamedQuery(name = "Expediente.findByNroexp", query = "SELECT e FROM Expediente e WHERE e.nroexp = :nroexp")})
public class Expediente implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODEXP")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EXPEDIENTE_SEQ")
    @SequenceGenerator(sequenceName = "expediente_seq", allocationSize = 1, name = "EXPEDIENTE_SEQ")
    private BigDecimal codexp;
    @Column(name = "FECNOTIF")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecnotif;
    @Column(name = "FECREGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecregistro;
    @Column(name = "INTERES")
    private BigInteger interes;
    @Column(name = "ESTEXP")
    private Character estexp;
    @Size(max = 20)
    @Column(name = "NROEXP")
    private String nroexp;
    @JoinColumn(name = "CODDADO", referencedColumnName = "CODDADO")
    @ManyToOne(optional = false)
    private Demandado coddado;
    @JoinColumn(name = "CODDNTE", referencedColumnName = "CODDNTE")
    @ManyToOne(optional = false)
    private Demandante coddnte;
    @JoinColumn(name = "CODJUZ", referencedColumnName = "CODJUZ")
    @ManyToOne(optional = false)
    private Juzgado codjuz;
    @JoinColumn(name = "CODUSU", referencedColumnName = "CODUSU")
    @ManyToOne(optional = false)
    private Usuario codusu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codexp")
    private List<Liquidacion> liquidacionList;

    public Expediente() {
    }

    public Expediente(BigDecimal codexp) {
        this.codexp = codexp;
    }

    public BigDecimal getCodexp() {
        return codexp;
    }

    public void setCodexp(BigDecimal codexp) {
        this.codexp = codexp;
    }

    public Date getFecnotif() {
        return fecnotif;
    }

    public void setFecnotif(Date fecnotif) {
        this.fecnotif = fecnotif;
    }

    public Date getFecregistro() {
        return fecregistro;
    }

    public void setFecregistro(Date fecregistro) {
        this.fecregistro = fecregistro;
    }

    public BigInteger getInteres() {
        return interes;
    }

    public void setInteres(BigInteger interes) {
        this.interes = interes;
    }

    public Character getEstexp() {
        return estexp;
    }

    public void setEstexp(Character estexp) {
        this.estexp = estexp;
    }

    public String getNroexp() {
        return nroexp;
    }

    public void setNroexp(String nroexp) {
        this.nroexp = nroexp;
    }

    public Demandado getCoddado() {
        return coddado;
    }

    public void setCoddado(Demandado coddado) {
        this.coddado = coddado;
    }

    public Demandante getCoddnte() {
        return coddnte;
    }

    public void setCoddnte(Demandante coddnte) {
        this.coddnte = coddnte;
    }

    public Juzgado getCodjuz() {
        return codjuz;
    }

    public void setCodjuz(Juzgado codjuz) {
        this.codjuz = codjuz;
    }

    public Usuario getCodusu() {
        return codusu;
    }

    public void setCodusu(Usuario codusu) {
        this.codusu = codusu;
    }

    @XmlTransient
    public List<Liquidacion> getLiquidacionList() {
        return liquidacionList;
    }

    public void setLiquidacionList(List<Liquidacion> liquidacionList) {
        this.liquidacionList = liquidacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codexp != null ? codexp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Expediente)) {
            return false;
        }
        Expediente other = (Expediente) object;
        if ((this.codexp == null && other.codexp != null) || (this.codexp != null && !this.codexp.equals(other.codexp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidad.Expediente[ codexp=" + codexp + " ]";
    }
    
}
