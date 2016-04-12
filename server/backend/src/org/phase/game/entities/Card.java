package org.phase.game.entities;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Card {

	// POJO Class
	
	private String owner; // Players
	private String type;  // Colors
	private String mark; // Card_trumps / Card_suit
		
	
	public Card() {
	}
	
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getOwner() {
		return owner;
	}

	public String getType() {
		return type;
	}

	public String getMark() {
		return mark;
	}
	
}
