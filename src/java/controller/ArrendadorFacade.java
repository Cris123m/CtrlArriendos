/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.leydi.jsf.Arrendador;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author crist
 */
@Stateless
public class ArrendadorFacade extends AbstractFacade<Arrendador> {

    @PersistenceContext(unitName = "CtrlArriendosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArrendadorFacade() {
        super(Arrendador.class);
    }
    
}
