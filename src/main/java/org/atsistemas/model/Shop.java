package org.atsistemas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shop")
public class Shop {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "company")
	private String company;
	@Column(name = "address")
	private String address;
	@Column(name = "space")
	private Double space;
	@Column(name = "city")
	private String city;
	@Column(name = "address_number")
	private int addressNumber;
	@Column(name = "postal_code")
	private String postalCode;
	@Column(name = "latitude")
	private Double latitude;
	@Column(name = "longitude")
	private Double longitude;
	
	
	public Shop() {

	}

	public Shop(String company, String address, Double space, String city, int addressNumber, String postalCode, Double latitude, Double longitude) {
		this.company = company;
		this.address = address;
		this.space = space;
		this.city = city;
		this.addressNumber = addressNumber;
		this.postalCode = postalCode;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getSpace() {
		return space;
	}

	public void setSpace(Double space) {
		this.space = space;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getAddressNumber() {
		return addressNumber;
	}

	public void setAddressNumber(int addressNumber) {
		this.addressNumber = addressNumber;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	
	
	
	
}
