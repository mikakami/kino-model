package ws.softlabs.lib.kino.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ws.softlabs.lib.kino.model.client.Theater;

public class TestTheater {
	
	private static String theaterName = "theater_name";
	private static String theaterURL  = "theater_url";

	@Test
	public void testConstructor1() {
		Theater obj = new Theater(1L);
		assertEquals(new Long(1L), obj.getId());
	}
	@Test
	public void testConstructor2() {
		Theater obj = new Theater(1L, theaterName, theaterURL);
		assertEquals(new Long(1L), obj.getId());
		assertEquals(theaterName,    obj.getName());
		assertEquals(theaterURL,     obj.getUrl());
		
	}
	@Test
	public void testCopyConstructor() {
		Theater obj1 = new Theater(1L);
		obj1.init(theaterName, theaterURL);
		Theater obj2 = new Theater(obj1);
		assertEquals(obj1.equals(obj2), true);
	}
	@Test
	public void testGetSet() {
		Theater obj = new Theater(1L);
		obj.init(theaterName, theaterURL);
		assertEquals(new Long(1L), obj.getId());
		assertEquals(theaterName,    obj.getName());
		assertEquals(theaterURL,     obj.getUrl());
		obj.setName(theaterURL);
		obj.setUrl(theaterName);
		obj.setId(2L);
		assertEquals(new Long(2L), obj.getId());
		assertEquals(theaterURL,     obj.getName());
		assertEquals(theaterName,    obj.getUrl());
	}
	@Test
	public void testEquals() {
		Theater obj1, obj2, obj3;
		obj1 = new Theater(1L, "1", "1");
		obj2 = new Theater(2L, "2", "2");
		obj3 = new Theater(obj1);		
		assertEquals(obj1.equals(obj2), false);
		assertEquals(obj1.equals(obj3), true);
		obj2.setName("1");
		obj2.setUrl("1");
		assertEquals(obj1.equals(obj2), true);
	}

}
