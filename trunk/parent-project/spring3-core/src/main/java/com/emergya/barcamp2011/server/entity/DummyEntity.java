package com.emergya.barcamp2011.server.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class DummyEntity {
    
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	
	private String name;

	@Column
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

    public void setId(Long id) {
        this.id = id;
    }
}
