/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.entidad.Pagos;

/**
 *
 * @author Invitado
 */
@Stateless
public class PagosFacade extends AbstractFacade<Pagos> {

    @PersistenceContext(unitName = "SJAjpaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PagosFacade() {
        super(Pagos.class);
    }

}
