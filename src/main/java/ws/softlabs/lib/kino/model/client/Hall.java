package ws.softlabs.lib.kino.model.client;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Hall implements Serializable, Comparable<Hall> {

	private Long	id;
	private Theater	theatre;
	private String	name;
	private String	html;

	public Hall(){		
	}
	public Hall(Long id) {
		init(null, "", "");
		this.id = id;
	}
	public Hall(Long id, Theater theater, String name, String hmtl) {
		init(theater, name, hmtl);
		this.id = id;
	}
	public Hall(Hall hall) {
		init(hall.getTheatre(), hall.getName(), hall.getHtml());
		this.id = hall.getId();
	}	
	public void init(String name) {
		init(null, name, "");
	}	
	public void init(Theater theater, String name) {
		init(theater, name, "");
	}
	public void init(Theater theater, String name, String html) {
		this.theatre = theater;
		this.name    = name;
		this.html    = html;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Theater getTheatre() {
		return theatre;
	}
	public void setTheatre(Theater theatre) {
		this.theatre = theatre;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHtml() {
		return html;
	}
	public void setHtml(String html) {
		this.html = html;
	}
	public int compareTo(Hall r) {
		if (r == null) return 1;
		if (r == this) return 0;
		return (this.getName() + this.getTheatre()).compareTo(r.getName() + r.getTheatre());
	}
	public boolean equals(Object object) {
		if (this == object) return true;
		if (!(object instanceof Hall)) return false;
		Hall hall = (Hall)object;

		if ( this.name == null && hall.name == null )
			return this.theatre.equals(hall.theatre);
		if ( this.name == null && hall.name != null)
			return false;
		return	name.equals(hall.name) &&
				theatre.equals(hall.theatre);
	}
	public String toString() {
		String sId   = (this.getId()   != null) ? this.getId().toString() : "";
		String sName = (this.getName() != null) ? this.getName() : "''";
		return sId + ": " + sName + " ( " + this.getTheatre() + " )";
	}
}
