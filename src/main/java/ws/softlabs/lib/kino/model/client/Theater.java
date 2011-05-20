package ws.softlabs.lib.kino.model.client;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Theater implements Serializable, Comparable<Theater> {

	private Long		id;
	private String		name;
	private String 	 	url;
	
	public Theater() {
		
	}
	public Theater(Long id){	
		this.id = id;
	}
	public Theater(Long id, String name, String url) {
		this.id   = id;
		this.name = name;
		this.url  = url;
	}
	public Theater(Theater theater) {
		this.id    = new Long(theater.getId());
		this.name  = new String(theater.getName());
		this.url   = new String(theater.getUrl());
	}	
	public void init(String name, String url){
		this.name = name;
		this.url = url;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean equals(Object object) {		
		if (this == object) return true;
		if (!(object instanceof Theater)) return false;
		Theater theater = (Theater)object;
		return 	name.equals(theater.name) &&
				url.equals(theater.url);
	}
	public String toString() {
		if (this.getId() != null)
			return this.getId() + ": " + this.getName() + " ( " + this.getUrl() + " )";
		else
			return this.getName() + " ( " + this.getUrl() + " )";
	}
	public int compareTo(Theater o) {
		if (o == null) return 1;
		if (o == this) return 0;
		return (this.getName() + this.getUrl()).compareTo(o.getName() + o.getUrl());
	}
}
