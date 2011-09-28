/**
 * 
 */
package com.emergya.barcamp2011.server.service.impl;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emergya.barcamp2011.server.dao.DummyDAO;
import com.emergya.barcamp2011.server.dto.DummyDTO;
import com.emergya.barcamp2011.server.entity.DummyEntity;
import com.emergya.barcamp2011.server.service.DummyService;

/**
 * @author adiaz
 *
 */
@Repository
@Transactional
public class DummyServiceImpl implements DummyService {
	
	@Resource
	private DummyDAO dummyDao;

	/* (non-Javadoc)
	 * @see com.emergya.barcamp2011.server.service.DummyService#addDummy(com.emergya.barcamp2011.server.dto.DummyDTO)
	 */
	@Override
	public void addDummy(DummyDTO dummy) {
		DummyEntity entity = new DummyEntity();
		entity.setName(dummy.getName());
		dummyDao.makePersistent(entity);
	}

	/* (non-Javadoc)
	 * @see com.emergya.barcamp2011.server.service.DummyService#getDummy(java.lang.Long)
	 */
	@Override
	public DummyDTO getDummy(Long id) {
		DummyEntity entity = dummyDao.findById(id, false);
		DummyDTO dummy =  
			new DummyDTO();
		dummy =  entityToDTO(entity);
		dummy.setName(entity.getName());
		dummy.setId(entity.getId());
		return null;
	}

	/* (non-Javadoc)
	 * @see com.emergya.barcamp2011.server.service.DummyService#getAllDummies()
	 */
	@Override
	public List<DummyDTO> getAllDummies() {
		List<DummyDTO> resultado = new LinkedList<DummyDTO>();
		try{
			List<DummyEntity> resultadoDao = dummyDao.findAll();
			if(resultadoDao != null){
				for(DummyEntity entity: resultadoDao){
					resultado.add(entityToDTO(entity));
				}
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return resultado;
	}

	private DummyDTO entityToDTO(DummyEntity entity) {
		DummyDTO dummy = null; 
		if(entity != null){
			dummy = new DummyDTO();
			dummy.setName(entity.getName());
			dummy.setId(entity.getId());	
		}
		return dummy;
	}

	protected DummyEntity dtoToEntity(DummyDTO dummy) {
		DummyEntity entity = null; 
		if(dummy != null){
			if(dummy.getId() != null){
				entity = dummyDao.findById(dummy.getId(), false);
			}else{
				entity = new DummyEntity();
			}
			entity.setName(dummy.getName());
		}
		return entity;
	}

}
