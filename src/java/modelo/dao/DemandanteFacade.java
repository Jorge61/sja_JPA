/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.entidad.Demandante;

/**
 *
 * @author Invitado
 */
@Stateless
public class DemandanteFacade extends AbstractFacade<Demandante> {

    @PersistenceContext(unitName = "SJAjpaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DemandanteFacade() {
        super(Demandante.class);
    }
    
}
