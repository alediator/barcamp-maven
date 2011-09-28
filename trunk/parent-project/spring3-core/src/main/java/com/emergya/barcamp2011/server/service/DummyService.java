/**
 * 
 */
package com.emergya.barcamp2011.server.service;

import java.util.List;

import com.emergya.barcamp2011.server.dto.DummyDTO;

/**
 * @author adiaz
 *
 */
public interface DummyService {
	
	/**
	 * Adds a dummy
	 * 
	 * @param dummy
	 */
	public void addDummy(DummyDTO dummy);
	
	/**
	 * Gets a dummy by id
	 * 
	 * @param id
	 * @return
	 */
	public DummyDTO getDummy(Long id);
	
	/**
	 * @return all dummies
	 */
	public List<DummyDTO> getAllDummies();
	
}
