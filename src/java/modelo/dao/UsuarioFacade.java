/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.entidad.Usuario;

/**
 *
 * @author Invitado
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "SJAjpaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public Usuario validarUsuario(String usu, String pass) {
        Usuario user = null;
        String jpql = "SELECT u FROM Usuario u WHERE u.usuusu = :usuusu and u.pswusu = :pswusu";
        Query p = em.createQuery(jpql);
        p.setParameter("usuusu", usu);
        p.setParameter("pswusu", pass);
        List<Usuario> lstUsuario = p.getResultList();
        if (lstUsuario.size() > 0) {
            user = lstUsuario.get(0);
        }
        return user;
    }
    
}
