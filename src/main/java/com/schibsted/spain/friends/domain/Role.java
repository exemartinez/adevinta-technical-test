package com.schibsted.spain.friends.domain;

import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Defines a looped relationship to the same kind of node.
 * //TODO watch out the case in which a user tries to befriend himself.
 * @author Ezequiel Martinez
 */
@RelationshipEntity(type = "FRIEND_OF")
public class Role {

    @Id
    @GeneratedValue
	private Long id;
	private List<String> roles = new ArrayList<>();

	@StartNode
	private User user;

	@EndNode
	private User userFriend;

	public Role() {
	}

	public Role(User userFriend, User actor) {
		this.userFriend = userFriend;
		this.user = actor;
	}

	public Long getId() {
	    return id;
	}

	public List<String> getRoles() {
	    return roles;
	}

	public User getUser() {
	    return user;
	}

	public User getUserFriend() {
	    return userFriend;
	}

    public void addRoleName(String name) {
        if (this.roles == null) {
            this.roles = new ArrayList<>();
        }
        this.roles.add(name);
    }
}