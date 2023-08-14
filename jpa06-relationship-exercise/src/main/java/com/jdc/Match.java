package com.jdc;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "match")
public class Match implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private LocalDateTime matchDate;
	@Column(nullable = false, unique = true, length = 50)
	private String stadiumName;
	@Column(nullable = false, length = 45)
	private String referee;
	
	@ManyToMany(mappedBy = "match")
	private List<Team> team;
	
	@ManyToOne
	private Season season;
}
