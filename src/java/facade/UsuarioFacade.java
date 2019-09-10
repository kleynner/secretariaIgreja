/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.Usuario;

/**
 *
 * @author Hp
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "secretariaIelPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public Usuario encontrarUsuarioLogin(String nomeUsuario){
        Query query = em.createNamedQuery("Usuario.findByEmailUsuario", Usuario.class)
                .setParameter("emailUsuario", nomeUsuario);
        
        List <Usuario> listado = query.getResultList();
        
        if(!listado.isEmpty()){
            return listado.get(0);
        }
        
        return null;
    }
    
}
