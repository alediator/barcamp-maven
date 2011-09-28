/**
 * 
 */
package com.emergya.barcamp2011.server.dto;

import java.io.Serializable;

/**
 * @author adiaz
 *
 */
public class DummyDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3817771582899055727L;
	
	private Long id;
	private String name;
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
}
