package org.atsistemas.viewhandler;

import javax.faces.application.ViewHandler;
import javax.faces.application.ViewHandlerWrapper;
import javax.faces.context.FacesContext;

public class CustomViewHandler extends ViewHandlerWrapper {

	private ViewHandler wrapped;

	public CustomViewHandler(ViewHandler wrapped) {
		this.wrapped = wrapped;
	}

	@Override
	public ViewHandler getWrapped() {
		return this.wrapped;
	}

	@Override
	public String calculateRenderKitId(FacesContext context) {
		return "PRIMEFACES_MOBILE";
		
	}
}
	
