package com.hibernate.HibernateWithMaven;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.*;

@Entity(name="Student_Address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Address_ID")
	private int addressId;
	
	private String Street;
	
	private String City;
	
	@Transient
	private String postal;
	
	@Temporal(TemporalType.DATE)
	private Date addedDate;
	
	@Lob
	private byte[] image;

	public Address(int addressId, String street, String city, String postal, Date addedDate, byte[] image) {
		super();
		this.addressId = addressId;
		Street = street;
		City = city;
		this.postal = postal;
		this.addedDate = addedDate;
		this.image = image;
	}
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getStreet() {
		return Street;
	}
	public void setStreet(String street) {
		Street = street;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getPostal() {
		return postal;
	}
	public void setPostal(String postal) {
		this.postal = postal;
	}
	public Date getAddedDate() {
		return addedDate;
	}
	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", Street=" + Street + ", City=" + City + ", postal=" + postal
				+ ", addedDate=" + addedDate + ", image=" + Arrays.toString(image) + "]";
	}
	
	

}
