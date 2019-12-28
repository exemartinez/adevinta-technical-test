package com.schibsted.spain.friends.repositories;

import com.schibsted.spain.friends.domain.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

/**
 * This matches with the Neo4j services for querying.
 * Many of these methods work out of the box.
 * @author Ezequiel Martinez
 */
@RepositoryRestResource(collectionResourceRel = "movies", path = "movies")
public interface PersonRepository extends Neo4jRepository<User, Long> {

    User findByName(@Param("name") String name);

    Collection<User> findByNameLike(@Param("name") String name);

    Collection<User> findAll();

    @Query("MATCH (m:User)-[r:FRIEND_OF]->(a:User) RETURN m,r,a LIMIT {limit}")
    Collection<User> getAllFriendsOf(@Param("limit") int limit);

}