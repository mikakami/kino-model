package ws.softlabs.lib.kino.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ws.softlabs.lib.kino.model.client.Movie;

public class TestMovie {

	private static String movieName = "movie_name";
	private static String movieURL	= "movie_url";
	
	@Test
	public void testConstructor1() {
		Movie obj = new Movie(1L);
		assertEquals(new Long(1L), obj.getId());
	}
	@Test
	public void testConstructor2() {
		Movie obj = new Movie(1L, movieName, movieURL);
		assertEquals(new Long(1L), obj.getId());
		assertEquals(movieName,    obj.getName());
		assertEquals(movieURL,     obj.getUrl());
		
	}
	@Test
	public void testCopyConstructor() {
		Movie obj1 = new Movie(1L);
		obj1.init(movieName, movieURL);
		Movie obj2 = new Movie(obj1);
		assertEquals(obj1.equals(obj2), true);
	}
	@Test
	public void testGetSet() {
		Movie obj = new Movie(1L);
		obj.init(movieName, movieURL);
		assertEquals(new Long(1L), obj.getId());
		assertEquals(movieName,    obj.getName());
		assertEquals(movieURL,     obj.getUrl());
		obj.setName(movieURL);
		obj.setUrl(movieName);
		obj.setId(2L);
		assertEquals(new Long(2L), obj.getId());
		assertEquals(movieURL,     obj.getName());
		assertEquals(movieName,    obj.getUrl());
	}
	@Test
	public void testEquals() {
		Movie obj1, obj2, obj3;
		obj1 = new Movie(1L, "1", "1");
		obj2 = new Movie(2L, "2", "2");
		obj3 = new Movie(obj1);		
		assertEquals(obj1.equals(obj2), false);
		assertEquals(obj1.equals(obj3), true);
		obj2.setName("1");
		obj2.setUrl("1");
		assertEquals(obj1.equals(obj2), true);
	}
}
