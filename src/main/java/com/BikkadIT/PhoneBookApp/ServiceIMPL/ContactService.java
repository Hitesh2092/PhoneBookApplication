package com.BikkadIT.PhoneBookApp.ServiceIMPL;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikkadIT.PhoneBookApp.Entity.Contacts;
import com.BikkadIT.PhoneBookApp.Repository.ContactRepo;
import com.BikkadIT.PhoneBookApp.ServiceI.ContactServiceI;
import com.BikkadIT.PhoneBookApp.exception.ResourceNotFoundException;
@Service
public class ContactService implements ContactServiceI{

	@Autowired
	private ContactRepo contactRepo;
	@Override
	public boolean save(Contacts contact) {
		Contacts contacts = contactRepo.save(contact);
		if(contacts!=null) {
			return true;
		}else {
		
		return false;}
	}
	@Override
	public List<Contacts> getAll() {
		List<Contacts> list = contactRepo.findAll();
		return list;
	}
	@Override
	public Contacts getContactById(Integer contactId) {
		Contacts contacts = contactRepo.findById(contactId)
		.orElseThrow(()->new ResourceNotFoundException("Contacts", "contactId",contactId ));
		return contacts;
	}
	@Override
	public boolean updateContact(Contacts contact) {
		Contacts contacts = contactRepo.save(contact);
		if(contacts!=null) {
			return true;
		}else {
		
		return false;}
	}
	@Override
	public boolean DeleteContact(Integer contactId) {
		boolean existsById = contactRepo.existsById(contactId);
		if(existsById) {
			contactRepo.deleteById(contactId);
			return true;
		}else {
		return false;
		}
	}
	@Override
	public boolean DeleteContactSoft(Integer contactId) {
		Contacts contact = contactRepo.findById(contactId)
				.orElseThrow(()->new ResourceNotFoundException("Contects", "contactId", contactId));
		if(contact!=null) {
		contact .setActiveSwitch('N');
		contactRepo.save(contact);
		return true;
		}else {
		return false;
		}
	}
		
	}


