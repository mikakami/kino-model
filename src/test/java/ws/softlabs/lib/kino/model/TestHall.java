package ws.softlabs.lib.kino.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ws.softlabs.lib.kino.model.client.Hall;
import ws.softlabs.lib.kino.model.client.Theater;

public class TestHall {

	private static String hallName  = "hall_name";
	private static String hallHTML  = "hall_html";

	Theater theater1;
	Theater theater2;
	
	@Before
	public void prepare() {
		theater1 = new Theater(1L, "theater1", "url1");
		theater2 = new Theater(2L, "theater2", "url2");
	}	
	@Test
	public void testConstructor1() {
		Hall obj = new Hall(1L);
		assertEquals(new Long(1L), obj.getId());
	}
	@Test
	public void testConstructor2() {
		Hall obj = new Hall(1L, theater1, hallName, hallHTML);
		assertEquals(new Long(1L), obj.getId()  );
		assertEquals(hallName,     obj.getName());
		assertEquals(hallHTML,     obj.getHtml());
		assertEquals(theater1.equals(obj.getTheatre()), true);
		
	}
	@Test
	public void testCopyConstructor() {
		Hall obj1 = new Hall(1L);
		obj1.init(theater1, hallName, hallHTML);
		Hall obj2 = new Hall(obj1);
		assertEquals(obj1.equals(obj2), true);
	}
	@Test
	public void testGetSet() {
		Hall obj = new Hall(1L);
		obj.init(theater1, hallName, hallHTML);
		assertEquals(new Long(1L), obj.getId());
		assertEquals(hallName,     obj.getName());
		assertEquals(hallHTML,     obj.getHtml());
		assertEquals(theater1.equals(obj.getTheatre()), true);
		obj.setName(hallHTML);
		obj.setHtml(hallName);
		obj.setId(2L);
		obj.setTheatre(theater2);
		assertEquals(new Long(2L), obj.getId());
		assertEquals(hallHTML,     obj.getName());
		assertEquals(hallName,     obj.getHtml());
		assertEquals(theater2.equals(obj.getTheatre()), true);
	}	
	@Test
	public void testEquals() {
		Hall obj1, obj2, obj3;
		obj1 = new Hall(1L, theater1, "1", "1");
		obj2 = new Hall(2L, theater2, "2", "2");
		obj3 = new Hall(obj1);		
		assertEquals(obj1.equals(obj2), false);
		assertEquals(obj1.equals(obj3), true);
		Theater t = new Theater(theater1);
		obj2.setTheatre(t);
		obj2.setName("1");
		obj2.setHtml("1");
		assertEquals(obj1.equals(obj2), true);
	}	
}
