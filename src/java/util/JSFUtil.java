package util;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "jsfUtil")
@RequestScoped
public class JSFUtil implements Serializable{

    public JSFUtil() {
    }
    
    public static void mensagemSucesso(String mensagem) {
        
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, mensagem);
        FacesContext.getCurrentInstance().addMessage("Mensagem de Sucesso", facesMessage);        
    }
    
    public static void refresh(){
        
        FacesContext context = FacesContext.getCurrentInstance();
        Application application = context.getApplication();
        ViewHandler viewHandler = application.getViewHandler();
        UIViewRoot viewRoot = viewHandler.createView(context, context.getViewRoot().getViewId());
        context.setViewRoot(viewRoot);
        context.renderResponse();
    }
   
    
}
