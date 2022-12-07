package com.example.PhoneBookApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.PhoneBookApp.Entity.Contacts;

public interface ContactRepo extends JpaRepository<Contacts, Integer> {

}
