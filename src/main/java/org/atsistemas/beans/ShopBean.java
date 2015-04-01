package org.atsistemas.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.atsistemas.model.Shop;
import org.atsistemas.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;


@ManagedBean
@SessionScoped
public class ShopBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	List<Shop> fetchedShops;
	
	Shop selectedShop = new Shop();
	
	@Autowired
	private ShopService shopService;

	public List<Shop> getFetchedShops() {
		if(fetchedShops == null){
			fetchedShops = shopService.findAll();
		}
		return fetchedShops;
	}

	public void setFetchedShops(List<Shop> fetchedShops) {
		this.fetchedShops = fetchedShops;
	}

	public void setShopService(ShopService shopService) {
		this.shopService = shopService;
	}
	
	public Shop getSelectedShop() {
		return selectedShop;
	}

	public void setSelectedShop(Shop selectedShop) {
		this.selectedShop = selectedShop;
	}

	

}
