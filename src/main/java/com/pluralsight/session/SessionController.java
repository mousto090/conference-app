package com.pluralsight.session;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionController {
	@Autowired
	SessionRepository sessionRepository;
	
	@GetMapping
	public List<Session> list() {
		return sessionRepository.findAll();
	}
	
	@PostMapping
	public Session create(@RequestBody final Session session) {
		return sessionRepository.saveAndFlush(session);

	}
	
	@GetMapping(path = "/{id}")
	public Session get(@PathVariable Long id) {
		return sessionRepository.getOne(id);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public Session update(@PathVariable Long id, @RequestBody Session session) {
		Session foundSess = sessionRepository.getOne(id);
		if(null == foundSess) {
			return null;
		}
		//PUT require all object attributes to be passed, so
		//Update the existing session in case all attributes is not supplied
		BeanUtils.copyProperties(session, foundSess, "session_id");
		return sessionRepository.saveAndFlush(foundSess);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		Session session = sessionRepository.getOne(id);
		if(null != session) {
			sessionRepository.delete(session);
		}
	}

}
