package com.skilldistillery.filmquery.database ;

import java.sql.Connection ;
import java.sql.DriverManager ;
import java.sql.PreparedStatement ;
import java.sql.ResultSet ;
import java.sql.SQLException ;
import java.util.ArrayList ;
import java.util.List ;

import com.skilldistillery.filmquery.entities.Actor ;
import com.skilldistillery.filmquery.entities.Film ;

public class DatabaseAccessorObject implements DatabaseAccessor {
	
	static {
		try {
			Class.forName( "com.mysql.jdbc.Driver" ) ;
		} catch ( ClassNotFoundException e ) {
			System.out.println( "ERROR! CLASS DEFINITION NOT FOUND!" ) ;
		}
	}

	@Override
	public Film findFilmById( int filmId ) {

		Film film = null ;
		String sqltxt = "SELECT * FROM film WHERE id = ?" ;

		try {
			Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/sdvid?useSSL=false" , "student" ,
					"student" ) ;
			PreparedStatement stmt = conn.prepareStatement( sqltxt ) ;
			stmt.setInt( 1 , filmId ) ;
			ResultSet rs = stmt.executeQuery() ;

			if ( rs.next() ) {

				film = new Film() ;
				film.setId( rs.getInt( "id" ) ) ;
				film.setTitle( rs.getString( "title" ) ) ;
				film.setDescription( rs.getString( "description" ) ) ;
				film.setReleaseYear( rs.getInt( "release_year" ) ) ;
				film.setLanguageId( rs.getString( "language_id" ) ) ;
				film.setRentalDuration( rs.getInt( "rental_duration" ) ) ;
				film.setRentalRate( rs.getDouble( "rental_rate" ) ) ;
				film.setLength( rs.getInt( "length" ) ) ;
				film.setReplacementCost( rs.getDouble( "replacement_cost" ) ) ;
				film.setRating( rs.getString( "rating" ) ) ;
				film.setSpecialFeatures( rs.getString( "special_features" ) ) ;
				film.setActors( findActorsByFilmId( filmId ) ) ;

				rs.close() ;
				stmt.close() ;
				conn.close() ;

			}

		} catch ( SQLException e ) {
			e.printStackTrace() ;
		}

		return film ;

	}

	public List < Actor > findActorsByFilmId( int filmId ) {

		List < Actor > actors = new ArrayList < Actor >() ;
		String sqltxt = "SELECT a.id , a.first_name , a.last_name " +
			"FROM actor a JOIN ( SELECT * FROM film_actor WHERE film_id = ? ) fa " +
			"ON a.id = fa.actor_id;" ;


		try {
			Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/sdvid?useSSL=false" , "student" ,
					"student" ) ;
			PreparedStatement stmt = conn.prepareStatement( sqltxt ) ;
			stmt.setInt( 1 , filmId ) ;
			ResultSet rs = stmt.executeQuery() ;

			while ( rs.next() ) {
				Actor actor = new Actor();
				actor.setId( rs.getInt( "id" ) ) ;
				actor.setFirstName( rs.getString( "first_name" ) ) ;
				actor.setLastName( rs.getString( "last_name" ) ) ;
				actors.add( actor ) ;
				
			}
				rs.close() ;
				stmt.close() ;
				conn.close() ;

		} catch ( SQLException e ) {
			e.printStackTrace() ;
		}

		return actors ;

	}
	
	public Actor findActorById( int actorId ) {
		Actor actor = null ;
		String sqltxt = "SELECT * FROM actor WHERE id = ?" ;

		try {
			Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/sdvid?useSSL=false" , "student" , "student" ) ;
			PreparedStatement stmt = conn.prepareStatement( sqltxt ) ;
			stmt.setInt( 1 , actorId ) ;
			ResultSet rs = stmt.executeQuery() ;

			if ( rs.next() ) {
				
				actor = new Actor();
				actor.setId( rs.getInt( "id" ) ) ;
				actor.setFirstName( rs.getString( "first_name" ) ) ;
				actor.setLastName( rs.getString( "last_name" ) ) ;

			}
			
			rs.close() ;
			stmt.close() ;
			conn.close() ;
			
		} catch (SQLException e ) {
			e.printStackTrace();
		}
		
		return actor;
	}

}