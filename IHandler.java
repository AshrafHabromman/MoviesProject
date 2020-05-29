import java.util.ArrayList;

public abstract class IHandler {
	
	public abstract ArrayList<Movie> selectAllMovies();
	public abstract ArrayList<Movie> selectSeenMovies();
    public abstract ArrayList<Movie> selectUnseenMovies();
    public abstract void openFile();
	public abstract void addMovie(Movie m);
    public abstract void editMovie(Movie newMovie, Movie selectedMovie);
	public abstract void delMovie(Movie m);
	public abstract void markSeen(Movie m);
	public abstract void markUnseen(Movie m);
	public abstract void closeFile();
	
	public abstract ArrayList<Movie> filterMoviesBasedOnName(String name);
	public abstract ArrayList<Movie> filterMoviesBasedOnYear(String year);
	public abstract ArrayList<Movie> filterMoviesBasedOnDirector(String Director);
	public abstract ArrayList<Movie> filterMoviesBasedOnWatch(Boolean isSeen);
	public abstract ArrayList<Movie> filterMoviesBasedOnDuration(Integer duration);
	

}


