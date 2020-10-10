package com.skilldistillery.filmquery.app;

import java.util.InputMismatchException ;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {
  
  DatabaseAccessor db = new DatabaseAccessorObject();

  public static void main(String[] args) {
    FilmQueryApp app = new FilmQueryApp();
//    app.test();
    app.launch();
  }

  private void test() {
    Film film = db.findFilmById(1);
    System.out.println(film);
  }

  private void launch() {
    Scanner input = new Scanner(System.in);
    
    startUserInterface(input);
    
    input.close();
  }

  private void startUserInterface(Scanner input) {
    boolean keepGoing;
  	do {
  		
  		keepGoing = mainMenu( input );
  		
  	} while ( keepGoing );
  	
  }
  
  private boolean mainMenu( Scanner kb ) {
  	int menuSelection;
  	
  	printMainMenu();
  	try {
  		menuSelection = kb.nextInt();
  		kb.nextLine();
  		if ( menuSelection < 0  || menuSelection > 3 ) {
  			throw new InputMismatchException();
  		}
  		switch( menuSelection ) {
  			case 0:
  				System.out.println( "Come back soon!" ) ;
  				return false;
  			case 1:
  				lookUpFilmById( kb );
  				break;
  			case 2:
  				lookUpFilmByKeyword( kb );
  				break;
  		}
  		
  	} catch ( InputMismatchException e ) {
  		kb.nextLine();
  		System.out.println( "Invalid input. Please enter one of the menu options listed. " ) ;
  		return mainMenu( kb );
  	} 
  	catch ( NumberFormatException e ) {
  		kb.nextLine();
  		System.out.println( "Invalid input. Please enter one of the menu options listed. " ) ;
  		return mainMenu( kb );
  	}
  	
  	return true;
  	
  }
  
  private void printMainMenu() {
  	
  	String endLine = "___________________________________________";
  	
  	System.out.println( endLine ) ;
  	System.out.println( "| 1. Look up a film by its ID |" ) ;
  	System.out.println( "| 2. Look up a film by a search keyword |" );
  	System.out.println( "|                                      |" ) ;
  	System.out.println( "| 0. Quit |" ) ;
  	System.out.println( endLine ) ;
  	System.out.println(  ) ;
  	System.out.print( "What would you like to do? " ) ;
  	
  }
  
  private void subMenu1( Film film, Scanner kb ) {
  	
  	if ( film == null ) { return; } //not offered if no film was found
  	
		String endLine = "____________________________";
		System.out.println( endLine ) ;
		System.out.println( "| 1. View all film details |" ) ;
		System.out.println( "| 2. Return to main menu   |" ) ;
		System.out.println( endLine ) ;
		System.out.println() ;
		System.out.print( "What would you like to do now? " ) ;
		int subMenuSelection;
		try {
			subMenuSelection = kb.nextInt();
			kb.nextLine();
			if ( subMenuSelection < 1 || subMenuSelection > 2 ) {
				throw new NumberFormatException();
			}
			System.out.println( film.allInfo() ) ;
			
		}
		catch ( NumberFormatException e ) {
			kb.nextLine();
				System.out.println( "Invalid input. Please select option 1 or 2." ) ;
				subMenu1( film , kb );
		}
		catch ( InputMismatchException e ) {
			kb.nextLine();
				System.out.println( "Invalid input. Please select option 1 or 2." ) ;
				subMenu1( film , kb );
		}
		
	}

  
  private void lookUpFilmById( Scanner kb ) {
  	
  	System.out.print( "What film ID would you like to look up? " ) ;
  	int lookupId = kb.nextInt();
  	kb.nextLine();
  	Film film = this.db.findFilmById( lookupId );
  	System.out.println(
  			film != null ? film :
  			String.format( "Sorry, no film found with ID %d" , lookupId ) ) ;
  	subMenu1( film , kb );
  	
  }
  
  private void lookUpFilmByKeyword( Scanner kb ) {
  	
  	System.out.print( "Please enter a keyword to search by: " ) ;
  	String lookupKeyword = kb.nextLine();
  	Film film = this.db.findFilmByKeyword( String.format( "%%%s%%" , lookupKeyword.toUpperCase() ) );
  	System.out.println(
  			film != null ? film :
  			String.format( "Sorry, no films found matching keyword '%s'" , lookupKeyword )) ;
  	subMenu1( film , kb );
  	
  }

}
