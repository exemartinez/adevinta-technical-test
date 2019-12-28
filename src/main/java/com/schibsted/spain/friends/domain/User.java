package com.schibsted.spain.friends.domain;


import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

/**
 * This is an entity kind of class used for represneting a user in the system.
 *
 * @author Ezequiel Martinez
 */
@NodeEntity
public class User {

    @Id
    @GeneratedValue
	private Long id;
    
	private String userName;
	private String password;

	@Relationship(type = "FRIEND_OF")
	private List<User> friends = new ArrayList<>();


	public User() {
	}

	public User(String userName, String pass) {
		this.userName = userName;
		this.password = pass;
	}

	public Long getId() {
		return id;
	}

	public List<User> getFriends() {
		return friends;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserName() {
		return userName;
	}
}