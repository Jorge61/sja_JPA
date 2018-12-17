/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "UBIGEO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ubigeo.findAll", query = "SELECT u FROM Ubigeo u")
    , @NamedQuery(name = "Ubigeo.findByCodubi", query = "SELECT u FROM Ubigeo u WHERE u.codubi = :codubi")
    , @NamedQuery(name = "Ubigeo.findByDptoubi", query = "SELECT u FROM Ubigeo u WHERE u.dptoubi = :dptoubi")
    , @NamedQuery(name = "Ubigeo.findByProvubi", query = "SELECT u FROM Ubigeo u WHERE u.provubi = :provubi")
    , @NamedQuery(name = "Ubigeo.findByDistubi", query = "SELECT u FROM Ubigeo u WHERE u.distubi = :distubi")})
public class Ubigeo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "CODUBI")
    private String codubi;
    @Size(max = 60)
    @Column(name = "DPTOUBI")
    private String dptoubi;
    @Size(max = 60)
    @Column(name = "PROVUBI")
    private String provubi;
    @Size(max = 60)
    @Column(name = "DISTUBI")
    private String distubi;
    @OneToMany(mappedBy = "codubi")
    private List<Demandante> demandanteList;
    @OneToMany(mappedBy = "codubi")
    private List<Demandado> demandadoList;
    @OneToMany(mappedBy = "codubi")
    private List<Usuario> usuarioList;

    public Ubigeo() {
    }

    public Ubigeo(String codubi) {
        this.codubi = codubi;
    }

    public String getCodubi() {
        return codubi;
    }

    public void setCodubi(String codubi) {
        this.codubi = codubi;
    }

    public String getDptoubi() {
        return dptoubi;
    }

    public void setDptoubi(String dptoubi) {
        this.dptoubi = dptoubi;
    }

    public String getProvubi() {
        return provubi;
    }

    public void setProvubi(String provubi) {
        this.provubi = provubi;
    }

    public String getDistubi() {
        return distubi;
    }

    public void setDistubi(String distubi) {
        this.distubi = distubi;
    }

    @XmlTransient
    public List<Demandante> getDemandanteList() {
        return demandanteList;
    }

    public void setDemandanteList(List<Demandante> demandanteList) {
        this.demandanteList = demandanteList;
    }

    @XmlTransient
    public List<Demandado> getDemandadoList() {
        return demandadoList;
    }

    public void setDemandadoList(List<Demandado> demandadoList) {
        this.demandadoList = demandadoList;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codubi != null ? codubi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ubigeo)) {
            return false;
        }
        Ubigeo other = (Ubigeo) object;
        if ((this.codubi == null && other.codubi != null) || (this.codubi != null && !this.codubi.equals(other.codubi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidad.Ubigeo[ codubi=" + codubi + " ]";
    }
    
}
