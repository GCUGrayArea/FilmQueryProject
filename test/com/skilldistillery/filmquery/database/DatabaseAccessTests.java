package com.skilldistillery.filmquery.database;

import static org.junit.jupiter.api.Assertions.*;

//import java.util.List ;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.filmquery.entities.Actor ;
import com.skilldistillery.filmquery.entities.Film;

class DatabaseAccessTests {
  private DatabaseAccessor db;

  @BeforeEach
  void setUp() throws Exception {
    db = new DatabaseAccessorObject();
  }

  @AfterEach
  void tearDown() throws Exception {
    db = null;
  }

  @Test
  void test_getFilmById_with_invalid_id_returns_null() {
    Film f = db.findFilmById(-42);
    assertNull(f);
  }
  
  @Test
  void test_getFilmByKeyword_with_bad_keyword_returns_null() {
  	Film f = db.findFilmByKeyword( "ZZZZZ" );
  	assertNull(f);
  }
  
  @Test
  void test_getFilmById_with_good_id_returns_not_null() {
  	Film f = db.findFilmById( 1 );
  	assertNotNull(f);
  }
  
  @Test
  void test_getFilmById_with_good_keyword_returns_not_null() {
  	Film f = db.findFilmByKeyword( "DRAGON" );
  	assertNotNull(f);
  }
  
  @Test
  void test_getFilmByKeyword_with_working_keyword_fills_all_fields() {
  	
  	Film f = db.findFilmByKeyword( "cas" );
  	assertNotEquals( f.getId() , 0 );
  	assertNotNull( f.getTitle() );
  	assertNotNull( f.getDescription() );
  	assertNotEquals( f.getReleaseYear() , 0 );
  	assertNotEquals( f.getLanguageId() , 0 );
  	assertNotNull( f.getLanguage() );
  	assertNotEquals( f.getRentalDuration() , 0 );
  	assertNotEquals( f.getLength() , 0 );
  	assertNotEquals( f.getReplacementCost() , 0 );
  	assertNotNull( f.getRating() );
  	assertNotNull( f.getSpecialFeatures() );
  	assertNotNull( f.getActors() );
  	assertNotNull( f.getCategory() );
  	assertNotNull( f.getInventory() );
  	
  }
  
  @Test
  void test_getFilmById_with_working_id_fills_all_fields() {
  	
  	Film f = db.findFilmById( 3 );
  	assertNotEquals( f.getId() , 0 );
  	assertNotNull( f.getTitle() );
  	assertNotNull( f.getDescription() );
  	assertNotEquals( f.getReleaseYear() , 0 );
  	assertNotEquals( f.getLanguageId() , 0 );
  	assertNotNull( f.getLanguage() );
  	assertNotEquals( f.getRentalDuration() , 0 );
  	assertNotEquals( f.getLength() , 0 );
  	assertNotEquals( f.getReplacementCost() , 0 );
  	assertNotNull( f.getRating() );
  	assertNotNull( f.getSpecialFeatures() );
  	assertNotNull( f.getActors() );
  	assertNotNull( f.getCategory() );
  	assertNotNull( f.getInventory() );
  	
  }

}
