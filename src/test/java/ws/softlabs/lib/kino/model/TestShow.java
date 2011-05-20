package ws.softlabs.lib.kino.model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import ws.softlabs.lib.kino.model.client.Hall;
import ws.softlabs.lib.kino.model.client.Movie;
import ws.softlabs.lib.kino.model.client.Show;
import ws.softlabs.lib.kino.model.client.Theater;
import ws.softlabs.lib.util.client.DateUtils;

public class TestShow {

	private static Movie    movie   = 
		new Movie(1L, "movie1", "url1");
	private static Long	    id      = 
		1L;
	private	static Date	date    	= 
		new Date(System.currentTimeMillis());
	private static Theater  theater =
		new Theater(1L, "theater_name", "theater_url");
	private	static Hall		hall    = 
		new Hall(1L, theater, "hall1", "html1");
	private static Integer arr[]    = 
		{1, 2, 3, 4};
	private static List<Integer> price = 
		Arrays.asList(arr);
	

	@Test
	public void testConstructor1() {
		Show obj = new Show(id);
		assertEquals(id, obj.getId());
	}
	@Test
	public void testConstructor2() {
		Show obj = new Show(id, hall, movie, date, price);
		assertEquals(id, obj.getId());
		assertEquals(hall.equals(obj.getHall()), true);
		assertEquals(date.equals(obj.getDate()), true);
		assertEquals(movie.equals(obj.getMovie()), true);
	}
	@Test
	public void testCopyConstructor() {
		Show obj1 = new Show(id);
		obj1.init(hall, movie, date);
		Show obj2 = new Show(obj1);
		assertEquals(obj1.equals(obj2), true);
	}
	@Test
	public void testGetSet() {
		Show obj = new Show(id);
		obj.init(hall, movie, date);
		assertEquals(id,   obj.getId());
		assertEquals(true, hall.equals(obj.getHall()));
		assertEquals(true, movie.equals(obj.getMovie()));
		assertEquals(true, date.equals(obj.getDate()));
		
		Movie newMovie   = new Movie(2L, "movie2", "url2");
		Hall  newHall    = new Hall(2L, new Theater(2L), "hall2", "html2");
		Date newDate     = new Date(); 
		obj.setMovie(newMovie);
		obj.setHall(newHall);
		obj.setId(id+1);
		obj.setDate(newDate);
		
		assertEquals(new Long(id+1), obj.getId());
		assertEquals(true, newHall.equals(obj.getHall()));
		assertEquals(true, newMovie.equals(obj.getMovie()));
		assertEquals(true, DateUtils.equalTimes(newDate, obj.getDate()));
	}
	@Test
	public void testEquals() {
		Show obj1, obj2, obj3;
		obj1 = new Show(1L, hall, movie, date, price);
		obj2 = new Show(1L, 
						new Hall(	2L,
									new Theater(2L),
									"h2",
									"html2"),
						new Movie(	2L,
									"m2",
									"url2"), 
						new Date(100), 
						new ArrayList<Integer>());
		obj3 = new Show(obj1);		
		assertEquals(obj1.equals(obj2), false);
		assertEquals(obj1.equals(obj3), true);
		Hall  newHall  = new Hall((Hall)obj1.getHall());
		Movie newMovie = new Movie((Movie)obj1.getMovie()); 
		obj2.setHall(newHall);
		obj2.setMovie(newMovie);
		Date newDate = (Date) obj1.getDate().clone();
		obj2.setDate(newDate);
		assertEquals(obj1.equals(obj2), true);
	}
}
