package com.BikkadIT.PhoneBookApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BikkadIT.PhoneBookApp.Entity.Contacts;

public interface ContactRepo extends JpaRepository<Contacts, Integer> {

}
