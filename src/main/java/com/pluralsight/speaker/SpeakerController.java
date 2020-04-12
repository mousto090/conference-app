package com.pluralsight.speaker;

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
@RequestMapping("/api/v1/speakers")
public class SpeakerController {

	@Autowired
	SpeakerRepository speakerRepository;
	
	@GetMapping
	private List<Speaker> list() {
		return speakerRepository.findAll();
	}
	
	@PostMapping
	private Speaker create(@RequestBody final Speaker speaker) {
		return speakerRepository.saveAndFlush(speaker);
	}
	
	@GetMapping(path = "/{id}")
	private Speaker get(@PathVariable Long id) {
		return speakerRepository.getOne(id);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker) {
		Speaker foundSpeaker = speakerRepository.getOne(id);
		if(null == foundSpeaker) {
			return null;
		}
		//PUT require all object attributes to be passed, so
		//Update the existing speaker in case all attributes is not supplied
		BeanUtils.copyProperties(speaker, foundSpeaker, "speaker_id");
		return speakerRepository.saveAndFlush(foundSpeaker);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		Speaker speaker = speakerRepository.getOne(id);
		if(null != speaker) {
			speakerRepository.delete(speaker);
		}
	}
	
}
