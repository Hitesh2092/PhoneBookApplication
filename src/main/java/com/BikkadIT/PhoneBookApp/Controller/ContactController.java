package com.BikkadIT.PhoneBookApp.Controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.PhoneBookApp.Entity.Contacts;
import com.BikkadIT.PhoneBookApp.ServiceI.ContactServiceI;

import io.swagger.annotations.Contact;


@RestController
public class ContactController {
	@Autowired
	private ContactServiceI contactServiceI;
	@PostMapping(value="/create",consumes = "application/json",produces = "application/json")
	public ResponseEntity<String> createContact(@RequestBody Contacts contact){
		boolean savedcontact = contactServiceI.save(contact);
	    
		if(savedcontact) {
			String msg="Contact saved succefully";
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Contact not saved",HttpStatus.BAD_REQUEST);
		
	}
	@GetMapping(value="/DisplayAll",produces = "application/json")
	public ResponseEntity<List<Contacts>> DisplayAll(){
		List<Contacts> allContacts = contactServiceI.getAll();
		Stream<Contacts> stream = allContacts.stream();
		Stream<Contacts> filter = stream.filter((contact)->contact.getActiveSwitch()=='Y');
		List<Contacts> list = filter.collect(Collectors.toList());
		return new ResponseEntity<List<Contacts>>(list,HttpStatus.OK);
		
	}
	@GetMapping(value="/getById/{contactId}",produces = "application/json")
	public ResponseEntity<Contacts>getContactById(@PathVariable Integer contactId){
		Contacts byId = contactServiceI.getContactById(contactId);
		return new ResponseEntity<Contacts>(byId,HttpStatus.OK);
		
	}
	@PostMapping(value="/update",consumes = "application/json",produces = "application/json")
	public ResponseEntity<String> updateContact(@RequestBody Contacts contact){
		boolean savedcontact = contactServiceI.save(contact);
	    
		if(savedcontact) {
			String msg="Contact updated succefully";
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Contact not updated",HttpStatus.BAD_REQUEST);
		
	}
	@DeleteMapping("delete/{contactId}")
	public ResponseEntity<String> deleteContact(@PathVariable Integer contactId){
		boolean deleteContact = contactServiceI.DeleteContact(contactId);
		if(deleteContact) {
		String msg="Contact deleted succefully";
		return new ResponseEntity<String>(msg,HttpStatus.OK);
		}else {
			String msg="contact not deleted succefully";
			return new ResponseEntity<String>(msg,HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@DeleteMapping("/softDelete/{contactId}")
	public ResponseEntity<String> deleteContactSoft(@PathVariable Integer contactId){
		boolean contactSoft = contactServiceI.DeleteContactSoft(contactId);
		if(contactSoft) {
			String msg="Contact Deleted Successfully";
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}else {
			String msg="Contact not deleted successfully ";
			return new ResponseEntity<String>(msg,HttpStatus.BAD_REQUEST);
			
		}
		
		
	}

}
