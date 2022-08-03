package com.selcukuzunsoy;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.stereotype.Component;

@Component
public class BaseController {

	public void mesajVer(String mesaj, TIP tip) {

		FacesMessage facesMessage = null;

		switch (tip) {
		case BILGI:
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "<b>Bilgilendirme</b>", "<i>" + mesaj + "</i>");
			break;
		case HATA:
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "<b>Hata</b>", "<i>" + mesaj + "</i>");
			break;
		case UYARI:
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_WARN, "<b>Uyarı</b>", "<i>" + mesaj + "</i>");
			break;

		default:
			break;
		}

		FacesContext.getCurrentInstance().addMessage(null, facesMessage);

	}

}
