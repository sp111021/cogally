package com.cogni.ally.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "unicorns")
public class Unicorn implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long unicornId;

	@Column(name="name")
	private String name;

	@Column(name="haircolor")
	private String hairColor;
	
	@Column(name="hornlength")
	private int hornLength;
	
	@Column(name="horncolor")
	private String hornColor;

	@Column(name="eyecolor")
	private String eyeColor;
	
	@Column(name="height")
	private int height;
	
	@Column(name="heightunit")
	private String heightUnit;
	
	@Column(name="weight")
	private int weight;
	
	@Column(name="weightunit")
	private String weightUnit;
	
	@OneToMany(mappedBy = "unicorn", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<IdentifiableMark> identifiableMarks;
	
	public Unicorn() {};
	public Unicorn(String name, String hairColor, String hornColor, int hornLength, String eyeColor, int height
			, String heightUnit, int weight, String weightUnit, Set<IdentifiableMark> identifiableMarks) {
		this.name = name; this.hairColor=hairColor; this.hornColor=hornColor; this.hornLength=hornLength;
		this.eyeColor=eyeColor; this.height=height; this.heightUnit=heightUnit; 
		this.weight=weight; this.weightUnit=weightUnit; this.identifiableMarks=identifiableMarks;
	}
	
	public Set<IdentifiableMark> getIdentifiableMarks() {
		return identifiableMarks;
	}
	public void setIdentifiableMarks(Set<IdentifiableMark> identifiableMarks) {
		this.identifiableMarks = identifiableMarks;
	}
	public long getUnicornId() {
		return unicornId;
	}
	public void setUnicornId(long id) {
		this.unicornId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHairColor() {
		return hairColor;
	}

	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}

	public int getHornLength() {
		return hornLength;
	}

	public void setHornLength(int hornLength) {
		this.hornLength = hornLength;
	}

	public String getHornColor() {
		return hornColor;
	}

	public void setHornColor(String hornColor) {
		this.hornColor = hornColor;
	}

	public String getEyeColor() {
		return eyeColor;
	}

	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getHeightUnit() {
		return heightUnit;
	}

	public void setHeightUnit(String heightUnit) {
		this.heightUnit = heightUnit;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getWeightUnit() {
		return weightUnit;
	}

	public void setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
	}


	
}
