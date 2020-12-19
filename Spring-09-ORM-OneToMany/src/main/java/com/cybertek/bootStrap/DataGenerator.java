package com.cybertek.bootStrap;

import com.cybertek.entity.Address;
import com.cybertek.entity.Person;
import com.cybertek.repository.AddressRepository;
import com.cybertek.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataGenerator implements CommandLineRunner {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    AddressRepository addressRepository;

    @Override
    public void run(String... args) throws Exception {

        Person person1 = new Person("Mike", "Smith");
        Person person2 = new Person("Ozzy", "Kmith");
        Person person3 = new Person("Tedd", "Bbith");

        Address address1 = new Address("King St", "22042");
        Address address2 = new Address("Elm St", "33042");
        Address address3 = new Address("Java St", "44042");

        //    person1.setAddresses(Arrays.asList(address1,address2)); //case-1
        personRepository.saveAll(Arrays.asList(person1, person2, person3));

        address1.setPerson(person1);
        address2.setPerson(person1);
        address3.setPerson(person1);
        addressRepository.saveAll(Arrays.asList(address1,address2,address3));


    }
}
