package com.jdc;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "team")
public class Team implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private Double networth;

	private String sponsers;

	@OneToMany(mappedBy = "team")
	private List<Player> players;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "team_match", joinColumns = @JoinColumn(name = "team_id"), inverseJoinColumns = @JoinColumn(name = "match_id"))
	private List<Match> match;
}
