package com.pluralsight.session;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pluralsight.speaker.Speaker;

import lombok.Data;

@Data
@Entity(name = "sessions")
@JsonIgnoreProperties({ "hibernateLazyInitializer" })
public class Session {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long session_id;
	private String session_name;
	private String session_description;
	private Long session_length;

	@ManyToMany
	@JoinTable(name = "session_speakers", joinColumns = @JoinColumn(name = "session_id"), inverseJoinColumns = @JoinColumn(name = "speaker_id"))
	private List<Speaker> speakers;

}
