import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;
 
public class FileHandler extends IHandler{
	
	
//	Movie m1 = new  Movie("Lion","steven","1999", 120, false);
//	Movie m2 = new  Movie("EXE", "Ahmad", "2000", 100, true);
//	Movie m3 = new Movie("cat", "ali", "2001", 150, false);
//	Movie m4 = new Movie("dog", "khalid", "2002", 160, true);
//	
	File file;
	
	ArrayList<Movie> movies = new ArrayList<Movie>();
	
	ArrayList<Movie> seenMovies ;

	ArrayList<Movie> unSeenMovies ;
	
	ArrayList<Movie> moviesBasedOnName ;
	
	ArrayList<Movie> moviesBasedOnYear ;
	
	ArrayList<Movie> moviesBasedOnDirector ;
	
	ArrayList<Movie> moviesBasedOnDuration ;
	
	ArrayList<Movie> moviesBasedOnWatch ;
	
	public FileHandler() {
		// TODO Auto-generated constructor stub
		
//		movies.add(m1);
//		movies.add(m2);
//		movies.add(m3);
//		movies.add(m4);
//		
//		selectSeenMovies() ;
//		selectUnseenMovies();

	}

	@Override
	public ArrayList<Movie> selectAllMovies() {
		// TODO Auto-generated method stub
		return movies;
	}

	@Override
	public ArrayList<Movie> selectSeenMovies() {
		// TODO Auto-generated method stub
		seenMovies = new  ArrayList<Movie>();
		for (int i=0; i < movies.size(); i++) {
			if (movies.get(i).isSeen()) {
				seenMovies.add(movies.get(i));
			}
		}
	
		return seenMovies;
	}

	@Override
	public ArrayList<Movie> selectUnseenMovies() {
		// TODO Auto-generated method stub
		unSeenMovies = new  ArrayList<Movie>();
		for (int i=0; i < movies.size(); i++) {
			if (!movies.get(i).isSeen()) {
				unSeenMovies.add(movies.get(i));
			}
		}
		
		return unSeenMovies;
	}

	@Override
	public void addMovie(Movie m) {
		// TODO Auto-generated method stub
		this.movies.add(m);
		
		selectSeenMovies();
		selectUnseenMovies();
	}

	@Override
	public void editMovie(Movie newMovie, Movie selectedMovie) {
		// TODO Auto-generated method stub
		int i = movies.indexOf(selectedMovie);
		movies.remove(selectedMovie);
		movies.add(i, newMovie);
		
		selectSeenMovies();
		selectUnseenMovies();
		
	}

	@Override
	public void delMovie(Movie m) {
		// TODO Auto-generated method stub
		movies.remove(m);
		selectSeenMovies();
		selectUnseenMovies();
	}

	@Override
	public void markSeen(Movie m) {
		// TODO Auto-generated method stub
		int i = movies.indexOf(m);
		movies.get(i).setSeen(true);
	
	}

	@Override
	public void markUnseen(Movie m) {
		// TODO Auto-generated method stub
		int i = movies.indexOf(m);
		movies.get(i).setSeen(false);
	}

	@Override
	public void closeFile() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Movie> filterMoviesBasedOnName(String name) {
		// TODO Auto-generated method stub
		moviesBasedOnName = new ArrayList<Movie>();
		for (int i=0; i<movies.size(); i++) {
			
			if (movies.get(i).getName().equalsIgnoreCase(name)) {
				moviesBasedOnName.add(movies.get(i));
			}
		}
		
		return moviesBasedOnName;
	}

	@Override
	public ArrayList<Movie> filterMoviesBasedOnYear(String year) {
		// TODO Auto-generated method stub
		moviesBasedOnYear = new ArrayList<Movie>();
		for (int i=0; i<movies.size(); i++) {
			
			if (movies.get(i).getYear().equals(year)) {
				moviesBasedOnYear.add(movies.get(i));
			}
		}
		return moviesBasedOnYear;
	}

	@Override
	public ArrayList<Movie> filterMoviesBasedOnDirector(String Director) {
		// TODO Auto-generated method stub
		moviesBasedOnDirector = new ArrayList<Movie>();
		for (int i=0; i<movies.size(); i++) {
			
			if (movies.get(i).getDirector().equalsIgnoreCase(Director)) {
				moviesBasedOnDirector.add(movies.get(i));
			}
		}
		return moviesBasedOnDirector;
	}

	@Override
	public ArrayList<Movie> filterMoviesBasedOnWatch(Boolean isSeen) {
		// TODO Auto-generated method stub
		moviesBasedOnWatch = new ArrayList<Movie>();
		for (int i=0; i<movies.size(); i++) {
			
			if (movies.get(i).isSeen().equals(isSeen)) {
				moviesBasedOnWatch.add(movies.get(i));
			}
		}
		return moviesBasedOnWatch;
	}
	

	@Override
	public ArrayList<Movie> filterMoviesBasedOnDuration(Integer duration) {
		// TODO Auto-generated method stub
		moviesBasedOnDuration = new  ArrayList<Movie>();
	    for (int i=0; i<movies.size(); i++) {
			
			if (movies.get(i).getDuration().equals(duration)) {
				moviesBasedOnDuration.add(movies.get(i));
			}
		}
		return moviesBasedOnDuration;
	}
	
	public int getSizeOfSeen() {
		
		return seenMovies.size();
	}

	@Override
	public void openFile() {
		// TODO Auto-generated method stub
		  file = new File("C:\\Users\\Ashraf Habromman\\Desktop\\file test.txt");
		  try {
			  
			    Scanner readFile =new Scanner(file);
				
				while (readFile.hasNextLine()) {
					
					String movie = readFile.nextLine();
					String movieComponent[] = movie.split("\t");
					
					if (movieComponent[4].equals("true"))
						movies.add(new Movie(movieComponent[0], movieComponent[1], movieComponent[2], Integer.parseInt(movieComponent[3]), true));
					
					else 	movies.add(new Movie(movieComponent[0], movieComponent[1], movieComponent[2], Integer.parseInt(movieComponent[3]), false));
						
				}
				
//				selectSeenMovies();
//				selectUnseenMovies();
					
		  }
		  
		  catch(FileNotFoundException ex) {
			  JOptionPane.showMessageDialog(null, "File not found. ", "FileNotFoundException", JOptionPane.ERROR_MESSAGE);
		  }
	
		
	}



}
