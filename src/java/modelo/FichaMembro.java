package modelo;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "ficha_membro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FichaMembro.findAll", query = "SELECT f FROM FichaMembro f")
    , @NamedQuery(name = "FichaMembro.findByIdFichaMembro", query = "SELECT f FROM FichaMembro f WHERE f.idFichaMembro = :idFichaMembro")
    , @NamedQuery(name = "FichaMembro.findByActividadeNaIgreja", query = "SELECT f FROM FichaMembro f WHERE f.actividadeNaIgreja = :actividadeNaIgreja")
    , @NamedQuery(name = "FichaMembro.findByOQueGostariaDeFazer", query = "SELECT f FROM FichaMembro f WHERE f.oQueGostariaDeFazer = :oQueGostariaDeFazer")
    , @NamedQuery(name = "FichaMembro.findByDizimistaRegular", query = "SELECT f FROM FichaMembro f WHERE f.dizimistaRegular = :dizimistaRegular")
    , @NamedQuery(name = "FichaMembro.findByTipoMembroConjuge", query = "SELECT f FROM FichaMembro f WHERE f.tipoMembroConjuge = :tipoMembroConjuge")
    , @NamedQuery(name = "FichaMembro.findByCultosQueFrequenta", query = "SELECT f FROM FichaMembro f WHERE f.cultosQueFrequenta = :cultosQueFrequenta")
    , @NamedQuery(name = "FichaMembro.findByCultoLar", query = "SELECT f FROM FichaMembro f WHERE f.cultoLar = :cultoLar")
    , @NamedQuery(name = "FichaMembro.findByDiasDeCulto", query = "SELECT f FROM FichaMembro f WHERE f.diasDeCulto = :diasDeCulto")
    , @NamedQuery(name = "FichaMembro.findByParticipantesCulto", query = "SELECT f FROM FichaMembro f WHERE f.participantesCulto = :participantesCulto")
    , @NamedQuery(name = "FichaMembro.findByProgramasQueAssisteNaIgreja", query = "SELECT f FROM FichaMembro f WHERE f.programasQueAssisteNaIgreja = :programasQueAssisteNaIgreja")
    , @NamedQuery(name = "FichaMembro.findByEncontrosQueParticipaComRegularidade", query = "SELECT f FROM FichaMembro f WHERE f.encontrosQueParticipaComRegularidade = :encontrosQueParticipaComRegularidade")
    , @NamedQuery(name = "FichaMembro.findByPontual", query = "SELECT f FROM FichaMembro f WHERE f.pontual = :pontual")
    , @NamedQuery(name = "FichaMembro.findByProgramasQueNuncaParticipou", query = "SELECT f FROM FichaMembro f WHERE f.programasQueNuncaParticipou = :programasQueNuncaParticipou")
    , @NamedQuery(name = "FichaMembro.findByMotivos", query = "SELECT f FROM FichaMembro f WHERE f.motivos = :motivos")
    , @NamedQuery(name = "FichaMembro.findByMeiosParaCrescerEspiritualmente", query = "SELECT f FROM FichaMembro f WHERE f.meiosParaCrescerEspiritualmente = :meiosParaCrescerEspiritualmente")})
public class FichaMembro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ficha_membro")
    private Integer idFichaMembro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "actividade_na_igreja")
    private String actividadeNaIgreja;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "o_que_gostaria_de_fazer")
    private String oQueGostariaDeFazer;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "dizimista_regular")
    private String dizimistaRegular;
    @Size(max = 45)
    @Column(name = "tipo_membro_conjuge")
    private String tipoMembroConjuge;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "cultos_que_frequenta")
    private String cultosQueFrequenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "culto_lar")
    private String cultoLar;
    @Size(max = 45)
    @Column(name = "dias_de_culto")
    private String diasDeCulto;
    @Size(max = 455)
    @Column(name = "participantes_culto")
    private String participantesCulto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 455)
    @Column(name = "programas_que_assiste_na_igreja")
    private String programasQueAssisteNaIgreja;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 455)
    @Column(name = "encontros_que_participa_com_regularidade")
    private String encontrosQueParticipaComRegularidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "pontual")
    private String pontual;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 455)
    @Column(name = "programas_que_nunca_participou")
    private String programasQueNuncaParticipou;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 445)
    @Column(name = "motivos")
    private String motivos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "meios_para_crescer_espiritualmente")
    private String meiosParaCrescerEspiritualmente;
    @JoinColumn(name = "membro", referencedColumnName = "id_membro")
    @ManyToOne(optional = false)
    private Membro membro;

    public FichaMembro() {
    }

    public FichaMembro(Integer idFichaMembro) {
        this.idFichaMembro = idFichaMembro;
    }

    public FichaMembro(Integer idFichaMembro, String actividadeNaIgreja, String oQueGostariaDeFazer, String dizimistaRegular, String cultosQueFrequenta, String cultoLar, String programasQueAssisteNaIgreja, String encontrosQueParticipaComRegularidade, String pontual, String programasQueNuncaParticipou, String motivos, String meiosParaCrescerEspiritualmente) {
        this.idFichaMembro = idFichaMembro;
        this.actividadeNaIgreja = actividadeNaIgreja;
        this.oQueGostariaDeFazer = oQueGostariaDeFazer;
        this.dizimistaRegular = dizimistaRegular;
        this.cultosQueFrequenta = cultosQueFrequenta;
        this.cultoLar = cultoLar;
        this.programasQueAssisteNaIgreja = programasQueAssisteNaIgreja;
        this.encontrosQueParticipaComRegularidade = encontrosQueParticipaComRegularidade;
        this.pontual = pontual;
        this.programasQueNuncaParticipou = programasQueNuncaParticipou;
        this.motivos = motivos;
        this.meiosParaCrescerEspiritualmente = meiosParaCrescerEspiritualmente;
    }

    public Integer getIdFichaMembro() {
        return idFichaMembro;
    }

    public void setIdFichaMembro(Integer idFichaMembro) {
        this.idFichaMembro = idFichaMembro;
    }

    public String getActividadeNaIgreja() {
        return actividadeNaIgreja;
    }

    public void setActividadeNaIgreja(String actividadeNaIgreja) {
        this.actividadeNaIgreja = actividadeNaIgreja;
    }

    public String getOQueGostariaDeFazer() {
        return oQueGostariaDeFazer;
    }

    public void setOQueGostariaDeFazer(String oQueGostariaDeFazer) {
        this.oQueGostariaDeFazer = oQueGostariaDeFazer;
    }

    public String getDizimistaRegular() {
        return dizimistaRegular;
    }

    public void setDizimistaRegular(String dizimistaRegular) {
        this.dizimistaRegular = dizimistaRegular;
    }

    public String getTipoMembroConjuge() {
        return tipoMembroConjuge;
    }

    public void setTipoMembroConjuge(String tipoMembroConjuge) {
        this.tipoMembroConjuge = tipoMembroConjuge;
    }

    public String getCultosQueFrequenta() {
        return cultosQueFrequenta;
    }

    public void setCultosQueFrequenta(String cultosQueFrequenta) {
        this.cultosQueFrequenta = cultosQueFrequenta;
    }

    public String getCultoLar() {
        return cultoLar;
    }

    public void setCultoLar(String cultoLar) {
        this.cultoLar = cultoLar;
    }

    public String getDiasDeCulto() {
        return diasDeCulto;
    }

    public void setDiasDeCulto(String diasDeCulto) {
        this.diasDeCulto = diasDeCulto;
    }

    public String getParticipantesCulto() {
        return participantesCulto;
    }

    public void setParticipantesCulto(String participantesCulto) {
        this.participantesCulto = participantesCulto;
    }

    public String getProgramasQueAssisteNaIgreja() {
        return programasQueAssisteNaIgreja;
    }

    public void setProgramasQueAssisteNaIgreja(String programasQueAssisteNaIgreja) {
        this.programasQueAssisteNaIgreja = programasQueAssisteNaIgreja;
    }

    public String getEncontrosQueParticipaComRegularidade() {
        return encontrosQueParticipaComRegularidade;
    }

    public void setEncontrosQueParticipaComRegularidade(String encontrosQueParticipaComRegularidade) {
        this.encontrosQueParticipaComRegularidade = encontrosQueParticipaComRegularidade;
    }

    public String getPontual() {
        return pontual;
    }

    public void setPontual(String pontual) {
        this.pontual = pontual;
    }

    public String getProgramasQueNuncaParticipou() {
        return programasQueNuncaParticipou;
    }

    public void setProgramasQueNuncaParticipou(String programasQueNuncaParticipou) {
        this.programasQueNuncaParticipou = programasQueNuncaParticipou;
    }

    public String getMotivos() {
        return motivos;
    }

    public void setMotivos(String motivos) {
        this.motivos = motivos;
    }

    public String getMeiosParaCrescerEspiritualmente() {
        return meiosParaCrescerEspiritualmente;
    }

    public void setMeiosParaCrescerEspiritualmente(String meiosParaCrescerEspiritualmente) {
        this.meiosParaCrescerEspiritualmente = meiosParaCrescerEspiritualmente;
    }

    public Membro getMembro() {
        return membro;
    }

    public void setMembro(Membro membro) {
        this.membro = membro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFichaMembro != null ? idFichaMembro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FichaMembro)) {
            return false;
        }
        FichaMembro other = (FichaMembro) object;
        if ((this.idFichaMembro == null && other.idFichaMembro != null) || (this.idFichaMembro != null && !this.idFichaMembro.equals(other.idFichaMembro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.FichaMembro[ idFichaMembro=" + idFichaMembro + " ]";
    }
    
}
