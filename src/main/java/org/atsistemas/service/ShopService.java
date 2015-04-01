package org.atsistemas.service;

import java.util.List;

import org.atsistemas.model.Shop;

public interface ShopService {

	public Shop create(Shop Shop);

	public Shop delete(Shop Shop);

	public List<Shop> findAll();

	public Shop update(Shop Shop);

	public Shop findById(long id);

}
