package com.example.demo.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "course") // La table s'appellera "course"

public class course {

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incrémentation
	    private Long id;

	    @Column(name = "title", nullable = false) // Le champ "title" ne peut pas être nul
	    private String title;

	    @Column(name = "description", length = 500) // Limite la description à 500 caractères
	    private String description;

	    @Column(name = "price", nullable = false) // Le champ "price" ne peut pas être nul
	    private double price;

	    @Column(name = "image", nullable = true) // Champ optionnel
	    private String imageUrl;

	    // Constructeur sans paramètres (obligatoire pour JPA)
	    public course() {
	    }

	    // Constructeur avec tous les paramètres
	    public course(long id, String title, String description, double price, String imageUrl) {
	       super();
	       this.id=id;
	        this.title = title;
	        this.description = description;
	        this.price = price;
	        this.imageUrl = imageUrl;
	    }

	    // Getters et Setters
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public void setTitle(String title) {
	        this.title = title;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public double getPrice() {
	        return price;
	    }

	    public void setPrice(double price) {
	        this.price = price;
	    }

	    public String getImageUrl() {
	        return imageUrl;
	    }

	    public void setImageUrl(String imageUrl) {
	        this.imageUrl = imageUrl;
	    }
	}
	

