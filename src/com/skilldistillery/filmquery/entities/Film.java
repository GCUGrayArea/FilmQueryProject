package com.skilldistillery.filmquery.entities;

import java.util.List ;

public class Film {
	
	private int id;
	private String title;
	private String description;
	private int releaseYear;
	private String languageId;
	private int rentalDuration;
	private double rentalRate;
	private int length;
	private double replacementCost;
	private String rating;
	private String specialFeatures;
	private List<Actor> actors;
	
	public int getId() {
	
		return id ;
	
	}
	
	public void setId( int id ) {
	
		this.id = id ;
	
	}
	
	public String getTitle() {
	
		return title ;
	
	}
	
	public void setTitle( String title ) {
	
		this.title = title ;
	
	}
	
	public String getDescription() {
	
		return description ;
	
	}
	
	public void setDescription( String description ) {
	
		this.description = description ;
	
	}
	
	public int getReleaseYear() {
	
		return releaseYear ;
	
	}
	
	public void setReleaseYear( int releaseYear ) {
	
		this.releaseYear = releaseYear ;
	
	}
	
	public String getLanguageId() {
	
		return languageId ;
	
	}
	
	public void setLanguageId( String languageId ) {
	
		this.languageId = languageId ;
	
	}
	
	public int getRentalDuration() {
	
		return rentalDuration ;
	
	}
	
	public void setRentalDuration( int rentalDuration ) {
	
		this.rentalDuration = rentalDuration ;
	
	}
	
	public double getRentalRate() {
	
		return rentalRate ;
	
	}
	
	public void setRentalRate( double rentalRate ) {
	
		this.rentalRate = rentalRate ;
	
	}
	
	public int getLength() {
	
		return length ;
	
	}
	
	public void setLength( int length ) {
	
		this.length = length ;
	
	}
	
	public double getReplacementCost() {
	
		return replacementCost ;
	
	}
	
	public void setReplacementCost( double replacementCost ) {
	
		this.replacementCost = replacementCost ;
	
	}
	
	public String getRating() {
	
		return rating ;
	
	}
	
	public void setRating( String rating ) {
	
		this.rating = rating ;
	
	}
	
	public String getSpecialFeatures() {
	
		return specialFeatures ;
	
	}
	
	public void setSpecialFeatures( String specialFeatures ) {
	
		this.specialFeatures = specialFeatures ;
	
	}
	
	public List < Actor > getActors() {
	
		return actors ;
	
	}
	
	public void setActors( List < Actor > actors ) {
	
		this.actors = actors ;
	
	}

	@Override
	public String toString() {
		
		StringBuilder actorList = null;
		
		if ( this.actors.size() > 0 ) {
			actorList = new StringBuilder();
			actorList.append( "\nActors:\n" );
			for ( Actor a : this.actors ) {
				actorList.append(
						String.format(
								"%s %s" ,
								a.getFirstName() ,
								a.getLastName() ) );
				actorList.append( 
						this.actors.indexOf( a ) < this.actors.size() - 1 ? "\n" : " " );
		}
	}
		return this == null ? null : String.format(
				"Film [id=%s, title=%s, description=%s, releaseYear=%s, languageId=%s, rentalDuration=%s, rentalRate=%s, length=%s, replacementCost=%s, rating=%s, specialFeatures=%s, actors=%s]" ,
				id , title , description , releaseYear , languageId , rentalDuration , rentalRate , length , replacementCost ,
				rating , specialFeatures , actorList );

	}
	
}
