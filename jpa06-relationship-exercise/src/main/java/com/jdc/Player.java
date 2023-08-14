package com.jdc;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "player")
public class Player implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false,length = 30)
	private String name;

	@Column(nullable = false)
	private double weight;

	@Column(nullable = false)
	private double height;

	@Column(nullable = false)
	private int age;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	public enum Role{
		Attacker,MiddleFielder,Defender,GoalKeeper
	}
	
	@OneToOne
	private Nation nation;
	
	@ManyToOne
	private Team team;
}
