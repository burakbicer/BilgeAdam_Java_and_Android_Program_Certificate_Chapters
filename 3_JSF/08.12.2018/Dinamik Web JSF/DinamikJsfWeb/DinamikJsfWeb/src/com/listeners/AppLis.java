package com.listeners;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.mbeans.UygulamaKapsami;

/**
 * Application Lifecycle Listener implementation class AppLis
 *
 */

@WebListener
public class AppLis implements HttpSessionListener {
 
	private UygulamaKapsami uygulamaKapsami;
	
	
    /**
     * Default constructor. 
     */
    public AppLis() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    uygulamaKapsami = (UygulamaKapsami) FacesContext.getCurrentInstance()
    		.getExternalContext().getApplicationMap().get("uygulamaKapsami");	
    
    uygulamaKapsami.setOturumAdedi(uygulamaKapsami.getOturumAdedi()+1);
    	
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }
	
}
