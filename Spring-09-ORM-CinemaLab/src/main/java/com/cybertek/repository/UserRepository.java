package com.cybertek.repository;

import com.cybertek.entity.MovieCinema;
import com.cybertek.entity.Ticket;
import com.cybertek.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//-------------------------DERIVED QUERIES-------------------------
    //Write a derived query to read a user with an email?
    Optional<User> findAllByEmail(String email);

    //Write a derived query to read a user with a username?
    Optional<User> findAllByUsername(String userName);

    //Write a derived query to list all users that contain a specific name?
    List<User> findAllByUsernameContaining(String userName);

    //Write a derived query to list all users that contain a specific name in the ignore case mode?
    List<User> findByUsernameIgnoreCase(String name);

    //Write a derived query to list all users with an age greater than a specified age?
    List<User> findAllByAccountAge(Integer age);

    //--------------JPQL---------------------------------------------------------
    //Write a JPQL query that returns a user read by email?
    Optional<User>getByEmail(String email);
    //Write a JPQL query that returns a user read by username?
    List<User> retrieveUserWithName(String name);
    //Write a JPQL query that returns all users?
    List<User> getAllWithJPQL();

    //--------------------------------------NATIVE----------------------------------
    //Write a native query that returns all users that contain a specific name?
    Optional<User> getWithSpecificName(String name);
    //Write a native query that returns all users?
    List<User>getAllUsers();
    //Write a native query that returns all users in the range of ages?
    List<User>getAllUsersInAgeRange(Integer low, Integer high);
    //Write a native query to read a user by email?
    Optional<User> retrieveUserWithEmail(String email);

}
