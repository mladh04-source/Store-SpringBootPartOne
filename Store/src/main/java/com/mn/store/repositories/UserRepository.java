package com.mn.store.repositories;

import com.mn.store.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    // Derived Methods
    // String
    List<User> findByName(String name);
    List<User> findByAddressLike(String address);
    List<User> findByAddressNotLike(String address);
    List<User> findByAddressContaining(String name);
    List<User> findByAddressStartingWith(String name);
    List<User> findByAddressEndingWith(String name);
    List<User> findByAddressContainingIgnoreCase(String name);

    //Numbers
    //List<User> findByPoints(int point);
    //List<User> findByPointsGreaterThan(int point);
    //List<User> findByPointsGreaterThanAndEqual(int point);
    //List<User> findByPointsBetween(int min, int max);

    // Null values
    List<User> findByDescriptionNull();
    List<User> findByDescriptionNotNull();
    List<User> findByDescriptionNullAndNameNull();

    // Sort
    List<User> findByNameOrderBYAddress(String name);
    List<User> findByNameOrderBYAddressAsc(String name);
    List<User> findFirst5NameOrderByAddress(String name);


    // Custom Queries
    // List<User> findByPointBetweenOrderByName(BigDecimal min, BigDecimal max);
    // the same methode using @query with Sql
    // @Query("Select * from users u where u.points between :min :max order by u.name , nativeQuery = true")
    // List<Users> findUser(@Param("min") BigDecimal min, @Param("max") BigDecimal max);
    // using JPQL
    // @Query("Select u from User u where u.points between :min :max order by u.name")
    // List<Users> findUser(@Param("min") BigDecimal min, @Param("max") BigDecimal max);






}
