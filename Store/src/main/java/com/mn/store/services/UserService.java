package com.mn.store.services;

import com.mn.store.entities.Address;
import com.mn.store.entities.User;
import com.mn.store.repositories.AddressRepository;
import com.mn.store.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service

public class UserService {

    private final UserRepository userRepository;
    private final EntityManager entityManager;
    private final AddressRepository addressRepository;

    @Transactional
    public void showEntityState(){

        var user = User.builder()
            .name("mladh")
            .email("mladh@gmail.com")
            .password("password")
            .build();

        if (entityManager.contains(user))
            System.out.println("Persistent");
        else
            System.out.println("Transient / Detached");

        userRepository.save(user);

        if (entityManager.contains(user))
            System.out.println("Persistent");
        else
            System.out.println("Transient / Detached");


    }
    public void persistReleated(){
        var user = User.builder()
                .name("Alex")
                .email("alex@gmail.com")
                .password("password")
                .build();

        var address = Address.builder()
                .zip("zip")
                .state("state")
                .street("street")
                .city("city")
                .build();

        user.addAddress(address);
        userRepository.save(user);

    }@Transactional
    public void deleteRelated(){
        var user = userRepository.findById(1L).orElseThrow();
        var address = user.getAddresses().getFirst();
        user.removeAddress(address);
        userRepository.save(user);



    }
}
