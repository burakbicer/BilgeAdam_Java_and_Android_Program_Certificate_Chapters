package com.ui.personel.converters;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.models.Tumuni;
import com.ui.personel.EgitimBilgileriController;

@FacesConverter(value="uniConverter")
public class UniversiteConverter implements Converter {

	public UniversiteConverter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String uniId) {
		
		ValueExpression vex =
				context.getApplication().getExpressionFactory()
				.createValueExpression(context.getELContext(),
						"#{egitimBilgileriController}" , 
						EgitimBilgileriController.class);
		EgitimBilgileriController econt = 
				(EgitimBilgileriController) vex.getValue(context.getELContext());
		return econt.uniGetir(Long.valueOf(uniId));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object universite) {
		
		return ((Tumuni)universite).getId().toString();
	}

}
