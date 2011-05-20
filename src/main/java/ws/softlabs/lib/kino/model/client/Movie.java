package ws.softlabs.lib.kino.model.client;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Movie implements Serializable, Comparable<Movie> {

	private Long	id;
	private String	name;
	private String	url;
	
	public Movie(){

	}
	public Movie(Long id){
		this.id   = id;
		this.name = "";
		this.url  = "";
	}
	public Movie(Long id, String name, String url) {
		this.id   = id;
		this.name = name;
		this.url  = url;
	}
	public Movie(Movie movie) {
		this.id   = movie.getId();
		this.name = movie.getName();
		this.url  = movie.getUrl();
	}
	public void init(String name, String url) {
		this.name = name;
		this.url  = url;
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
		if (!(object instanceof Movie)) return false;
		Movie movie = (Movie)object;
		return 	name.equals(movie.name) &&
				url.equals(movie.url);
	}
	public String toString() {
		return this.getName();
	}
	public int compareTo(Movie o) {
		if (o == null) return 1;
		if (o == this) return 0;
		return (this.getName() + this.getUrl()).compareTo(o.getName() + o.getUrl());
	}
}
