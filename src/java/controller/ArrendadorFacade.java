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

    public Arrendador authenticate(String cedula, String clave) {
        Arrendador arrendador = (Arrendador) em.createNamedQuery("Arrendador.authenticate")
                .setParameter("cedula", cedula)
                .setParameter("clave", clave)
                .getResultList().get(0);
        return arrendador;
    }   
}
