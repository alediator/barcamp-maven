package com.emergya.barcamp2011.web;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.emergya.barcamp2011.server.dto.DummyDTO;
import com.emergya.barcamp2011.server.service.DummyService;

/**
 * Simple index page controller serving hello.jsp file
 */
@Controller
public class DummyController {

	private static Log LOG = LogFactory.getLog(DummyController.class);

	@Resource
	private DummyService dummyService;

	/**
	 * Adds a dummy
	 * 
	 * @param name
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/addDummy", method = RequestMethod.POST)
	public String addDummy(@RequestParam("name") String name, Model model) {
		LOG.trace("Entro en addDummy");

		DummyDTO dummy = new DummyDTO();
		dummy.setName(name);

		dummyService.addDummy(dummy);

		List<DummyDTO> dummies = dummyService.getAllDummies();
		
		for(DummyDTO dummyRes: dummies){
			LOG.trace(dummyRes.getName());
		}
		
		model.addAttribute("dummies", dummies);

		return "allDummies";
	}

	/**
	 * Show a Dummy
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/getDummy", method = RequestMethod.POST)
	public String getDummy(@RequestParam("id") Long id, Model model) {
		LOG.trace("Entro en getDummy");

		model.addAttribute("dummy", dummyService.getDummy(id));

		return "showDummy";
	}

	/**
	 * Simply serves allDummies.jsp
	 * 
	 * @return view with name 'allDummies'
	 */
	@RequestMapping(value = "/listDummies")
	public String listDummies(Model model) {
		LOG.trace("Entro en listDummies");

		model.addAttribute("dummies", dummyService.getAllDummies());

		return "allDummies";
	}
	
	/**
     * Simply serves allDumies.jsp
     * @return view with name 'allDumies'
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String handleRequest() {
        return "allDummies";
    }
	
    /**
     * Simply serves addDummy.jsp
     * @return view with name 'addDummy'
     */
	@RequestMapping(value = "/newDummy")
	public String newDummy() {
		LOG.trace("Entro en newDummy");

		return "addDummy";
	}

}
