package org.atsistemas.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.atsistemas.model.Shop;
import org.atsistemas.repository.ShopRepository;
import org.atsistemas.service.ShopService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("shopService")
public class ShopServiceImpl implements ShopService {

	@Resource
	private ShopRepository shopRepository;
	
	@Transactional
	public Shop create(Shop Shop) {
		Shop createdShop = Shop;
		return shopRepository.save(createdShop);
	}

	@Transactional
	public Shop delete(Shop Shop) {
		Shop deletedShop = shopRepository.findOne(Shop.getId());
		
		if(deletedShop == null){
			try {
				throw new SQLException("Shop does not exist.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		shopRepository.delete(Shop);
		
		return deletedShop;
	}

	@Transactional
	public List<Shop> findAll() {
		return (List<Shop>) shopRepository.findAll();
	}

	@Transactional
	public Shop update(Shop shop) {
		Shop updatedShop = shopRepository.findOne(shop.getId());
		
		if(updatedShop == null){
			try {
				throw new SQLException("Shop does not exist.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		updatedShop.setCompany(shop.getCompany());
		updatedShop.setAddress(shop.getAddress());
		updatedShop.setSpace(shop.getSpace());
		
		return updatedShop;
	}

	public Shop findById(long id) {
		return shopRepository.findOne(id);
	}
	
	/**
	 * Método para añadir varios registros en BD al crearse el bean.
	 */
	@PostConstruct
	public void init(){
		List<Shop> shops = new ArrayList<Shop>();
		shops.add(new Shop("Apple","C/Passeig de Gràcia",100D,"Barcelona",55,"08210",13.23453D,34.2354325D));
		shops.add(new Shop("Game","C/García Lorca",70D,"Sabadell",51,"08206",13.23453D,34.2354325D));
		shops.add(new Shop("Blade Center","C/Illa Digna",60D,"Sabadell",10,"08206",13.23453D,34.2354325D));
		for(Shop shop : shops){
			shopRepository.save(shop);
		}
	}

}
