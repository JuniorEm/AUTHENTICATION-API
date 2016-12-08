package br.com.gmf.api.services.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents the entity User class
 * @author Junior
 *
 */
@Entity
@NoArgsConstructor
@SuppressWarnings("serial")
public @Data class User implements Serializable {
	
	@Id
	@GeneratedValue
	@JsonIgnore
	private Long id;
	private String name;
	private String login;
	private String password;
}
