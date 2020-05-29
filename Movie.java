

public class Movie {

	private String name = new String();
	private String director = new String();
	private String year = new String();
	private Integer duration ;
	private Boolean isSeen = false ; 
	
	public Movie(String name, String director, String year, int duration, boolean isSeen) {
		
		this.name = name;
		this.director = director;
		this.year=year;
		this.duration=duration;
		this.isSeen=isSeen;
		
	
	}
	/*//////geters and seters.*/
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name= name;
		
	}
	
	public String getDirector() {
		return this.director;
	}
	
	public void setDirector(String director) {
		this.director= director;
	}
	
	public String getYear() {
		return this.year;
	}
	
	
	public void setYear(String year) {
		this.year=year;
	}
	
	public Integer getDuration() {
		return this.duration;
	}
	
	public void setDuration(int duration) {
		this.duration=duration;
	}
	
	public Boolean isSeen() {
	   return this.isSeen;
	}
	
	public void setSeen(boolean isSeen) {
		this.isSeen = isSeen;
	}
	
	@Override
	public String toString() {
		return name+"\t"+director+"\t"+year+"\t"+duration+"\t"+isSeen+"\n";
		
	}
	
}
