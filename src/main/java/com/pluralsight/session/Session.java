package com.pluralsight.session;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pluralsight.speaker.Speaker;

import lombok.Data;

@Data
@Entity
@Table(name = "sessions")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "session_id")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Session{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long session_id;
	private String session_name;
	private String session_description;
	private Long session_length;
	
	@ManyToMany
	@JoinTable(name = "session_speakers", joinColumns = @JoinColumn(name = "session_id"),
	inverseJoinColumns = @JoinColumn(name="speaker_id"))
	private Set<Speaker> speakers;

	public Long getSession_id() {
		return session_id;
	}

	public void setSession_id(Long session_id) {
		this.session_id = session_id;
	}

	public String getSession_name() {
		return session_name;
	}

	public void setSession_name(String session_name) {
		this.session_name = session_name;
	}

	public String getSession_description() {
		return session_description;
	}

	public void setSession_description(String session_description) {
		this.session_description = session_description;
	}

	public Long getSession_length() {
		return session_length;
	}

	public void setSession_length(Long session_length) {
		this.session_length = session_length;
	}

	public Set<Speaker> getSpeakers() {
		return speakers;
	}

	public void setSpeakers(Set<Speaker> speakers) {
		this.speakers = speakers;
	}
	
	
}
