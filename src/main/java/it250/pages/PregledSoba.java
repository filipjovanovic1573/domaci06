/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it250.pages;

import it250.entity.Soba;
import java.util.ArrayList;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

/**
 *
 * @author Workbench
 */
public class PregledSoba {
   
    @Property
    private Soba soba;
    
    @Property
    private ArrayList<Soba> listaSoba;
    
    @Property
    private int idValue, spratValue;
    
    @Property
    private boolean tvValue, internetValue, djakuziValue;
    
    @Inject
    Session session;
    
    void onActivate(){
        if(listaSoba == null){
            listaSoba = new ArrayList<Soba>();
        }
        listaSoba = (ArrayList<Soba>)session.createCriteria(Soba.class).list();
    }
    
    Object onSuccess(){
        Soba s = new Soba();
        s.setId(idValue);
        s.setSprat(spratValue);
        s.setDjakuzi(djakuziValue);
        s.setInternet(internetValue);
        s.setTv(tvValue);
        session.persist(s);
        return this;
    }
}
