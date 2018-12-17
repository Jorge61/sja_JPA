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
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByCodusu", query = "SELECT u FROM Usuario u WHERE u.codusu = :codusu")
    , @NamedQuery(name = "Usuario.findByNombusu", query = "SELECT u FROM Usuario u WHERE u.nombusu = :nombusu")
    , @NamedQuery(name = "Usuario.findByApeusu", query = "SELECT u FROM Usuario u WHERE u.apeusu = :apeusu")
    , @NamedQuery(name = "Usuario.findByDirusu", query = "SELECT u FROM Usuario u WHERE u.dirusu = :dirusu")
    , @NamedQuery(name = "Usuario.findByCelusu", query = "SELECT u FROM Usuario u WHERE u.celusu = :celusu")
    , @NamedQuery(name = "Usuario.findByUsuusu", query = "SELECT u FROM Usuario u WHERE u.usuusu = :usuusu")
    , @NamedQuery(name = "Usuario.findByPswusu", query = "SELECT u FROM Usuario u WHERE u.pswusu = :pswusu")
    , @NamedQuery(name = "Usuario.findByEstusu", query = "SELECT u FROM Usuario u WHERE u.estusu = :estusu")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODUSU")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIO_SEQ")
    @SequenceGenerator(sequenceName = "usuario_seq", allocationSize = 1, name = "USUARIO_SEQ")
    private BigDecimal codusu;
    @Size(max = 50)
    @Column(name = "NOMBUSU")
    private String nombusu;
    @Size(max = 50)
    @Column(name = "APEUSU")
    private String apeusu;
    @Size(max = 100)
    @Column(name = "DIRUSU")
    private String dirusu;
    @Size(max = 9)
    @Column(name = "CELUSU")
    private String celusu;
    @Size(max = 20)
    @Column(name = "USUUSU")
    private String usuusu;
    @Size(max = 50)
    @Column(name = "PSWUSU")
    private String pswusu;
    @Column(name = "ESTUSU")
    private Character estusu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codusu")
    private List<Expediente> expedienteList;
    @JoinColumn(name = "CODUBI", referencedColumnName = "CODUBI")
    @ManyToOne
    private Ubigeo codubi;

    public Usuario() {
    }

    public Usuario(BigDecimal codusu) {
        this.codusu = codusu;
    }

    public BigDecimal getCodusu() {
        return codusu;
    }

    public void setCodusu(BigDecimal codusu) {
        this.codusu = codusu;
    }

    public String getNombusu() {
        return nombusu;
    }

    public void setNombusu(String nombusu) {
        this.nombusu = nombusu;
    }

    public String getApeusu() {
        return apeusu;
    }

    public void setApeusu(String apeusu) {
        this.apeusu = apeusu;
    }

    public String getDirusu() {
        return dirusu;
    }

    public void setDirusu(String dirusu) {
        this.dirusu = dirusu;
    }

    public String getCelusu() {
        return celusu;
    }

    public void setCelusu(String celusu) {
        this.celusu = celusu;
    }

    public String getUsuusu() {
        return usuusu;
    }

    public void setUsuusu(String usuusu) {
        this.usuusu = usuusu;
    }

    public String getPswusu() {
        return pswusu;
    }

    public void setPswusu(String pswusu) {
        this.pswusu = pswusu;
    }

    public Character getEstusu() {
        return estusu;
    }

    public void setEstusu(Character estusu) {
        this.estusu = estusu;
    }

    @XmlTransient
    public List<Expediente> getExpedienteList() {
        return expedienteList;
    }

    public void setExpedienteList(List<Expediente> expedienteList) {
        this.expedienteList = expedienteList;
    }

    public Ubigeo getCodubi() {
        return codubi;
    }

    public void setCodubi(Ubigeo codubi) {
        this.codubi = codubi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codusu != null ? codusu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.codusu == null && other.codusu != null) || (this.codusu != null && !this.codusu.equals(other.codusu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidad.Usuario[ codusu=" + codusu + " ]";
    }
    
}
