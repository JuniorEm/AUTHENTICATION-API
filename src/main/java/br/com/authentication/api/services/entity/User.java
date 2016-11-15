package br.com.authentication.api.services.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	private Long id;
	private String name;
	private String login;
	private String password;
}
