package com.skilldistillery.filmquery.entities;

import java.util.List ;

public class Film {
	
	private int id;
	private String title;
	private String description;
	private int releaseYear;
	private int languageId;
	private String language;
	private int rentalDuration;
	private double rentalRate;
	private int length;
	private double replacementCost;
	private String rating;
	private String specialFeatures;
	private List<Actor> actors;
	private String category;
	
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
	
	public int getLanguageId() {
	
		return languageId ;
	
	}
	
	public void setLanguageId( int languageId ) {
	
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
	
	public void setLanguage( String language ) {
		
		this.language = language;
		
	}
	
	public String getLanguage() {
		
		return this.language;
		
	}

	
	public String getCategory() {
	
		return category ;
	
	}

	
	public void setCategory( String category ) {
	
		this.category = category ;
	
	}

	@Override
	public String toString() {
		
		StringBuilder actorList = null;
		
		if ( this.actors.size() > 0 ) {
			actorList = new StringBuilder();
			actorList.append( "Cast:\n" );
			for ( Actor a : this.actors ) {
				actorList.append(
						String.format(
								"%s %s%n" ,
								a.getFirstName() ,
								a.getLastName() ) );
		}
	}
		return String.format( 
				"%s (%d)%nLanguage: %s%nCategory: %s%nDescription: %s%nRated %s%n%n%s",
				this.title ,
				this.releaseYear ,
				this.language ,
				this.category ,
				this.description ,
				this.rating ,
				actorList );
				
	}

	public String allInfo() {
		
		StringBuilder cast = new StringBuilder();
		cast.append( "Cast: ");
		for ( Actor a : this.actors ) {
			cast.append(
					String.format(
							"%s %s, " ,
							a.getFirstName() ,
							a.getLastName() ) );
		}

		return String.format(
				"Film [id=%d%ntitle=%s%ndescription=%s%nreleaseYear=%d%nlanguageId=%d%nlanguage=%s%nrentalDuration=%d%nrentalRate=%.2f%nlength=%d%nreplacementCost=%.2f%nrating=%s%nspecialFeatures=%s%nactors=%s%ncategory=%s]" ,
				id , title , description , releaseYear , languageId , language , rentalDuration , rentalRate , length ,
				replacementCost , rating , specialFeatures , cast.toString() , category ) ;

	}


	
	
}
