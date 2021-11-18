package com.cogni.ally.model;

import java.io.Serializable;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "identifiablemarks")
public class IdentifiableMark implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name="side")
	private String side;
	
	@Column(name="location")
	private String location;
	
	@Column(name="mark")
	private String mark;
	
	@Column(name="color")
	private String color;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "unicorn_unicorn_id")
    private Unicorn unicorn;

	public IdentifiableMark() {}
	
	public IdentifiableMark(String side, String location, String mark, String color) {
		this.side = side;
		this.location = location;
		this.mark = mark;
		this.color = color;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setUnicorn(Unicorn unicorn) {
		this.unicorn = unicorn;
	}

	@Override
	public String toString() {
		return "IdentifiableMark [side=" + side + ", location=" + location + ", mark=" + mark + ", color=" + color
				+ "]";
	}
	
	
	
	
}
