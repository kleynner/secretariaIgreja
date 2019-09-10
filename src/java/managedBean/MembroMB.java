package managedBean;

import facade.EstadoCivilFacade;
import facade.GeneroFacade;
import facade.MembroFacade;
import facade.MunicipioFacade;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import modelo.EstadoCivil;
import modelo.Genero;
import modelo.Membro;
import modelo.Municipio;
import org.jboss.logging.Logger;
import util.JSFUtil;


@Named(value = "membroMB")
@SessionScoped
public class MembroMB implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private Membro membro;
    private List<Membro> membros;
    private List<Municipio> municipios;
    private List<Genero> generos;
    private List<EstadoCivil> estados;
    
    @Inject
    MembroFacade membroFacade;
    
    @Inject
    MunicipioFacade municipioFacade;
    
    @Inject
    EstadoCivilFacade estadoCivilFacade;
    
    @Inject
    GeneroFacade generoFacade; 
        
    public MembroMB() {
    }
    
    @PostConstruct
    public void inicializar(){
        membro = new Membro();
        membros = new ArrayList<>();
        municipios = new ArrayList<>();
    }

    public List<Genero> getGeneros() {
        generos = generoFacade.findAll();
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }

    public List<EstadoCivil> getEstados() {
        estados = estadoCivilFacade.findAll();
        return estados;
    }

    public void setEstados(List<EstadoCivil> estados) {
        this.estados = estados;
    }

    public EstadoCivilFacade getEstadoCivilFacade() {
        return estadoCivilFacade;
    }

    public void setEstadoCivilFacade(EstadoCivilFacade estadoCivilFacade) {
        this.estadoCivilFacade = estadoCivilFacade;
    }

    public GeneroFacade getGeneroFacade() {
        return generoFacade;
    }

    public void setGeneroFacade(GeneroFacade generoFacade) {
        this.generoFacade = generoFacade;
    }

    
    
    public Membro getMembro() {
        return membro;
    }

    public void setMembro(Membro membro) {
        this.membro = membro;
    }

    public List<Membro> getMembros() {
        membros = membroFacade.findAll();
        return membros;
    }

    public void setMembros(List<Membro> membros) {
        this.membros = membros;
    }

    public List<Municipio> getMunicipios() {
        municipios = municipioFacade.findAll();
        return municipios;
    }

    public void setMunicipios(List<Municipio> municipios) {
        this.municipios = municipios;
    }

    public MembroFacade getMembroFacade() {
        return membroFacade;
    }

    public void setMembroFacade(MembroFacade membroFacade) {
        this.membroFacade = membroFacade;
    }

    public MunicipioFacade getMunicipioFacade() {
        return municipioFacade;
    }

    public void setMunicipioFacade(MunicipioFacade municipioFacade) {
        this.municipioFacade = municipioFacade;
    }
    
    public void guardar(ActionEvent evt){
        membroFacade.create(membro);
        membro = new Membro();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Membro Registado Com Sucesso", "Guardar" ));
        JSFUtil.refresh();
    }
    
    public void edit(ActionEvent event){
        membroFacade.edit(membro);
        membros = null;
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("publico/lista-membro.jsf");
        } catch (IOException e) {
            java.util.logging.Logger.getLogger(MembroMB.class.getName()).log(Level.SEVERE,null,e);
        }
    
    }
}
