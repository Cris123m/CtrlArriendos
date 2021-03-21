/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.leydi.jsf.Arrendatarios;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author crist
 */
@Stateless
public class ArrendatariosFacade extends AbstractFacade<Arrendatarios> {

    @PersistenceContext(unitName = "CtrlArriendosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArrendatariosFacade() {
        super(Arrendatarios.class);
    }
    
}
