/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hp
 */
@Entity
@Table(name = "membro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Membro.findAll", query = "SELECT m FROM Membro m")
    , @NamedQuery(name = "Membro.findByIdMembro", query = "SELECT m FROM Membro m WHERE m.idMembro = :idMembro")
    , @NamedQuery(name = "Membro.findByNomeMembro", query = "SELECT m FROM Membro m WHERE m.nomeMembro = :nomeMembro")
    , @NamedQuery(name = "Membro.findBySobrenomeMembro", query = "SELECT m FROM Membro m WHERE m.sobrenomeMembro = :sobrenomeMembro")
    , @NamedQuery(name = "Membro.findByConjuge", query = "SELECT m FROM Membro m WHERE m.conjuge = :conjuge")
    , @NamedQuery(name = "Membro.findByNomePai", query = "SELECT m FROM Membro m WHERE m.nomePai = :nomePai")
    , @NamedQuery(name = "Membro.findByNomeMae", query = "SELECT m FROM Membro m WHERE m.nomeMae = :nomeMae")
    , @NamedQuery(name = "Membro.findByDataNascimento", query = "SELECT m FROM Membro m WHERE m.dataNascimento = :dataNascimento")
    , @NamedQuery(name = "Membro.findByDataBaptismo", query = "SELECT m FROM Membro m WHERE m.dataBaptismo = :dataBaptismo")
    , @NamedQuery(name = "Membro.findByLocalBaptismo", query = "SELECT m FROM Membro m WHERE m.localBaptismo = :localBaptismo")
    , @NamedQuery(name = "Membro.findByDocumentoTransfer\u00eancia", query = "SELECT m FROM Membro m WHERE m.documentoTransfer\u00eancia = :documentoTransfer\u00eancia")
    , @NamedQuery(name = "Membro.findByTipoMembro", query = "SELECT m FROM Membro m WHERE m.tipoMembro = :tipoMembro")
    , @NamedQuery(name = "Membro.findByRua", query = "SELECT m FROM Membro m WHERE m.rua = :rua")
    , @NamedQuery(name = "Membro.findByTelefone", query = "SELECT m FROM Membro m WHERE m.telefone = :telefone")
    , @NamedQuery(name = "Membro.findByBiMembro", query = "SELECT m FROM Membro m WHERE m.biMembro = :biMembro")})
public class Membro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_membro")
    private Integer idMembro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nome_membro")
    private String nomeMembro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "sobrenome_membro")
    private String sobrenomeMembro;
    @Size(max = 45)
    @Column(name = "conjuge")
    private String conjuge;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nome_pai")
    private String nomePai;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nome_mae")
    private String nomeMae;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_baptismo")
    @Temporal(TemporalType.DATE)
    private Date dataBaptismo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "local_baptismo")
    private String localBaptismo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "documento_transfer\u00eancia")
    private String documentoTransferência;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo_membro")
    private String tipoMembro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 445)
    @Column(name = "rua")
    private String rua;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 445)
    @Column(name = "telefone")
    private String telefone;
    @Size(max = 45)
    @Column(name = "bi_membro")
    private String biMembro;
    @JoinColumn(name = "municipio", referencedColumnName = "id_municipio")
    @ManyToOne(optional = false)
    private Municipio municipio;
    @JoinColumn(name = "estado_civil", referencedColumnName = "id_estado_civil")
    @ManyToOne(optional = false)
    private EstadoCivil estadoCivil;
    @JoinColumn(name = "genero", referencedColumnName = "id_genero")
    @ManyToOne(optional = false)
    private Genero genero;

    public Membro() {
    }

    public Membro(Integer idMembro) {
        this.idMembro = idMembro;
    }

    public Membro(Integer idMembro, String nomeMembro, String sobrenomeMembro, String nomePai, String nomeMae, Date dataNascimento, Date dataBaptismo, String localBaptismo, String documentoTransferência, String tipoMembro, String rua, String telefone) {
        this.idMembro = idMembro;
        this.nomeMembro = nomeMembro;
        this.sobrenomeMembro = sobrenomeMembro;
        this.nomePai = nomePai;
        this.nomeMae = nomeMae;
        this.dataNascimento = dataNascimento;
        this.dataBaptismo = dataBaptismo;
        this.localBaptismo = localBaptismo;
        this.documentoTransferência = documentoTransferência;
        this.tipoMembro = tipoMembro;
        this.rua = rua;
        this.telefone = telefone;
    }

    public Integer getIdMembro() {
        return idMembro;
    }

    public void setIdMembro(Integer idMembro) {
        this.idMembro = idMembro;
    }

    public String getNomeMembro() {
        return nomeMembro;
    }

    public void setNomeMembro(String nomeMembro) {
        this.nomeMembro = nomeMembro;
    }

    public String getSobrenomeMembro() {
        return sobrenomeMembro;
    }

    public void setSobrenomeMembro(String sobrenomeMembro) {
        this.sobrenomeMembro = sobrenomeMembro;
    }

    public String getConjuge() {
        return conjuge;
    }

    public void setConjuge(String conjuge) {
        this.conjuge = conjuge;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataBaptismo() {
        return dataBaptismo;
    }

    public void setDataBaptismo(Date dataBaptismo) {
        this.dataBaptismo = dataBaptismo;
    }

    public String getLocalBaptismo() {
        return localBaptismo;
    }

    public void setLocalBaptismo(String localBaptismo) {
        this.localBaptismo = localBaptismo;
    }

    public String getDocumentoTransferência() {
        return documentoTransferência;
    }

    public void setDocumentoTransferência(String documentoTransferência) {
        this.documentoTransferência = documentoTransferência;
    }

    public String getTipoMembro() {
        return tipoMembro;
    }

    public void setTipoMembro(String tipoMembro) {
        this.tipoMembro = tipoMembro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getBiMembro() {
        return biMembro;
    }

    public void setBiMembro(String biMembro) {
        this.biMembro = biMembro;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMembro != null ? idMembro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Membro)) {
            return false;
        }
        Membro other = (Membro) object;
        if ((this.idMembro == null && other.idMembro != null) || (this.idMembro != null && !this.idMembro.equals(other.idMembro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Membro[ idMembro=" + idMembro + " ]";
    }
    
}
