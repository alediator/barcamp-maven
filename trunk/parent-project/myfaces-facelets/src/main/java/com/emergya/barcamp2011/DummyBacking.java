/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.emergya.barcamp2011;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.emergya.barcamp2011.server.dto.DummyDTO;
import com.emergya.barcamp2011.server.service.DummyService;

/**
 * A typical simple backing bean, that is backed to <code>alldummies.jsp</code>
 *
 * @author <a href="mailto:adiaz@emergya.com">adiaz</a>
 */
public class DummyBacking{
	
	private static Log LOG = LogFactory.getLog(DummyBacking.class);

	//properties
    private String name;
	private Long id;
    private List<DummyDTO> dummies;
    
    public DummyBacking(){
		LOG.info("Creando DummyBacking");
    }
    
    /**
     * Lad a dummy to this
     * 
     * @return 'showDummy'
     */
    public String showDummy(){
		LOG.trace("Entro en showDummy");

		if(id!= null){
			DummyDTO dummy = dummyService.getDummy(id);
			name = dummy.getName();
		}
		
		return "showDummy";
    }

    /**
     * Load allDummys to 'dummies'
     * 
     * @return 'allDummies'
     */
    public String allDummies(){
		LOG.trace("Entro en allDummies");

		dummies = dummyService.getAllDummies();
		
		for(DummyDTO dummyRes: dummies){
			LOG.trace(dummyRes.getName());
		}
		
		return "allDummies";
    }

    /**
     * Add a dummy
     * 
     * @return 'allDummies'
     */
    public String addDummy(){
		LOG.trace("Entro en addDummy");

		DummyDTO dummy = new DummyDTO();
		dummy.setName(name);

		dummyService.addDummy(dummy);

		dummies = dummyService.getAllDummies();
		
		for(DummyDTO dummyRes: dummies){
			LOG.trace(dummyRes.getName());
		}
		
		return "allDummies";
    }
    
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

	public List<DummyDTO> getDummies() {
		if(dummies == null && dummyService != null){
			dummies = dummyService.getAllDummies();
		}else{
			LOG.trace("dummyService --> "+ dummyService);
		}
		return dummies;
	}

	public void setDummies(List<DummyDTO> dummies) {
		this.dummies = dummies;
	}

	private DummyService dummyService;

    public DummyService getDummyService() {
		return dummyService;
	}

	public void setDummyService(DummyService dummyService) {
		this.dummyService = dummyService;
	}
}