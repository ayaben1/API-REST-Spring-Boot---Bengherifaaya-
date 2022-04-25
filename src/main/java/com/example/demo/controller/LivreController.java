package com.example.demo.controller;
import com.example.demo.exception.BookNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.OrderBy;
import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Livre;
import com.example.demo.repos.*;

import com.example.demo.entities.*;

@RestController
public class LivreController {
	@Autowired
	private LivreRepo br;
	//Afficher les livres 
	@GetMapping("/emsi_api/livres")
	  public List<Livre> getAllBook(){
		
	    return br.findAll();
	  } 
	//Ajout d'un livre
	@PostMapping("/emsi_api/livres/add")
	  public String addBook( @RequestBody Livre livre){
		 br.save(livre);
		 return "Livre ajoutee avec succes!";
	  } 
	// id
    @GetMapping("/emsi_api/livres/{id}")
    public Optional<Livre> getNoteById(@PathVariable(value = "id") Long id)  {
        return br.findById(id);
                
    }
    //update
    @PutMapping("/emsi_api/livres/update/{id}")
    public String updateNote(@PathVariable(value = "id") Long livreId,
                           @Validated @RequestBody Livre livreDetails)  {

       Livre book = br.findById(livreId).get();

		book.setId(livreDetails.getId());
        book.setTitre(livreDetails.getTitre());
        book.setDatesortie(livreDetails.getDatesortie());
        book.setAuteur(livreDetails.getAuteur());
        book.setNbrpages(livreDetails.getNbrpages());
        book.setDateconsultation(livreDetails.getDateconsultation());
        book.setDisponibilite(livreDetails.isDisponibilite());
        Livre updatedBook = br.save(book);

        return "update successuful";
    }
    //suppression
    @DeleteMapping("/emsi_api/livres/delete/{id}")
    public String deleteBook(@PathVariable(value = "id") Long id)  {
        Livre livre = br.findById(id).get();

         br.delete(livre);

        return "Livre  "+id+" supprimee avec succes";
    }
	

}
