package com.BikkadIT.PhoneBookApp.ServiceI;

import java.util.List;

import com.BikkadIT.PhoneBookApp.Entity.Contacts;
import com.BikkadIT.PhoneBookApp.Repository.ContactRepo;



public interface ContactServiceI {
	
	
	
	//create contact
	public boolean save(Contacts contact);
	
	//Display All Contacts
	
	public List<Contacts>getAll();
	
	//get contact by id
	
	public Contacts getContactById(Integer contactId);
	
	//Edit and Update Contact Details
	
	public boolean updateContact(Contacts contact);
	
	
	//Delete Contacts
	
	public boolean DeleteContact(Integer contactId);
	
	//Soft Delete 
	
	public boolean DeleteContactSoft(Integer contactId);

}
