package managedBean;

import facade.UsuarioFacade;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import modelo.Usuario;
import filters.Util;
import java.io.IOException;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;


@Named(value = "loginMB")
@SessionScoped
public class LoginMB implements Serializable{
    private String nomeUsuario;
    private String password;
    
    @EJB
    UsuarioFacade usuarioFacade;
    
    private Usuario usuarioAutenticado;
    
    public Usuario getUsuarioAutenticado() {
        return usuarioAutenticado;
    }

    public void setUsuarioAutenticado(Usuario usuarioAutenticado) {
        this.usuarioAutenticado = usuarioAutenticado;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    

    
    public LoginMB() {
    }
    
    public String autenticar(){
        
        FacesContext context = FacesContext.getCurrentInstance();
        usuarioAutenticado = usuarioFacade.encontrarUsuarioLogin(nomeUsuario);
        if(usuarioAutenticado!=null){
            context.getExternalContext().getSessionMap().put("usuario" , nomeUsuario);
            if(usuarioAutenticado.getPassword().equals(password)){
                HttpSession hs = Util.getSession();
                hs.setAttribute("usuario", nomeUsuario);
                if(usuarioAutenticado.getTipoUsuario().equals("Operador")){
                    return "/index?faces-redirect=true";
                }
                
                else if(usuarioAutenticado.getTipoUsuario().equals("Administrador")){
                    return "/index?faces-redirect=true";
                }
            }
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Senha Inexistente! Tente Novamente.", "A Senha não Existe"));
            return null;
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Usuário Inexistente! Tente Novamente.", "O Usuário não Existe"));
        return null;
    } 
    
    public void logout(){
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().invalidateSession();
        
        try {
            context.getExternalContext().redirect("home.jsf");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
