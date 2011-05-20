package ws.softlabs.lib.kino.model.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
public class Show implements Serializable, Comparable<Show> {

	private Long			id;
	private	Date			date;
	private String			timeString;
	private	Hall			hall;
	private	Movie			movie;
	private List<Integer> 	price;
	
	public Show(){		
	}
	public Show(Long id){
		this.id = id;
	}
	public Show(Long id, Hall hall, Movie movie, Date date, List<Integer> price) {
		init(hall, movie, date, price);
		this.id = id;
	}
	public Show(Show show) {
		if (show != null) {			
			init(show.getHall(), show.getMovie(), show.getDate(), show.getPrice());
			this.id = show.getId();
		}
	}
	public void init(Hall hall, Movie movie, Date dateTime, List<Integer> price) {
		this.hall  = hall;
		this.movie = movie;
		this.date  = dateTime;
		if (price != null)
			this.price = new ArrayList<Integer>(price);
		else 
			this.price = new ArrayList<Integer>();
		if (this.date != null)
			setTimeString();
	}
	public void init (Hall hall, Movie movie, Date date) {
		init(hall, movie, date, new ArrayList<Integer>());
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Hall getHall() {
		return hall;
	}
	public void setHall(Hall hall) {
		this.hall = hall;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
		setTimeString();
	}
	public List<Integer> getPrice() {
		return price;
	}
	public void setPrice(List<Integer> price) {
		this.price = price;
	}
	public String toString(){
		String s = "";
		s += this.date.toString() + " "; 
		s += hall.getTheatre().getName() + " ";
		s += (hall.getName() == null) ? "'' " : hall.getName()  + " ";
		s += movie.getName() + " ";
		for (Integer i : price) 
			if (i != null)	s += i + " ";
			else			s += "";
		return s;		
	}
	public boolean equals(Object object) {
		if (this == object) return true;
		if (!(object instanceof Show)) return false;
		Show show = (Show)object;
		return 	date.equals(show.date) &&
				hall.equals(show.hall) && 
				movie.equals(show.movie)
				;
	}
	@SuppressWarnings("deprecation")
	public int compareTo(Show o) {
		/**** FIXME: check this method !!! ****/
		if (o == null) return 1;
		if (o == this) return 0;
	
		Integer h1 = this.getDate().getHours(), 
				h2 = o.getDate().getHours();
		if (this.getDate().getHours() >=0 && this.getDate().getHours() < 5)
			h1 += 24;
		if (o.getDate().getHours() >=0 && o.getDate().getHours() < 5)
			h2 += 24;

		int result = h1.compareTo(h2);
		if (0 != result) return result;
		result = this.getDate().compareTo(o.getDate()); 
		if (0 != result) return result;
		result = this.getHall().compareTo(o.getHall());
		if (0 != result) return result;
		return this.getMovie().compareTo(o.getMovie());
	}
	public String getTimeString() {
		return this.timeString;
	}	
	@SuppressWarnings("deprecation")
	private void setTimeString() {
		String  s = ((Integer)date.getHours()).toString();
		String hs = (s.length() > 1) ? s : "0" + s;
		        s = ((Integer)date.getMinutes()).toString();
		String ms = (s.length() > 1) ? s : "0" + s;
		this.timeString = hs + ":" + ms;		
	}
}
