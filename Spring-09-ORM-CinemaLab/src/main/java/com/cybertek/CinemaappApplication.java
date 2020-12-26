package com.cybertek;

import com.cybertek.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@SpringBootApplication
public class CinemaappApplication {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    CinemaRepository cinemaRepository;
    @Autowired
    MovieCinemaRepository movieCinemaRepository;
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    UserRepository userRepository;
    public static void main(String[] args) {
        SpringApplication.run(CinemaappApplication.class, args);
    }

    @PostConstruct
    public void testQueries(){
        System.out.println(accountRepository.findAllAdminAccounts());
        System.out.println(cinemaRepository.distinctBySponsoredName());
        System.out.println(movieCinemaRepository.findAllByCinemaLocationName("AMC Village 7"));
        System.out.println(movieCinemaRepository.countAllByMovieId(9l));
        System.out.println(movieCinemaRepository.countCinemaMovies(4l));
        System.out.println(ticketRepository.retrieveAllBySearchCriteria("it"));
        System.out.println(ticketRepository.countAllByUserId(5l));
        System.out.println(ticketRepository.countAllByMovieCinemaMovieName("The Gentleman"));

        System.out.println("important output : " + ticketRepository.findTicket(4l));
        System.out.println("ticket with properties : " + ticketRepository.getAllTicketDependsDatesRange(LocalDateTime.now().minusYears(1l),LocalDateTime.now()));

        System.out.println("__________________________USER REPO_______________________________");

        System.out.println(userRepository.findAllByEmail("bernard@email.com"));
        System.out.println(userRepository.findAllByUsername("faith"));
        System.out.println(userRepository.findAllByUsernameContaining("faith"));
        System.out.println(userRepository.findByUsernameIgnoreCase("joHNnie"));
        System.out.println(userRepository.findAllByAccountAge(47));
        System.out.println("orm.xml exercise : " + userRepository.getByEmail("bernard@email.com"));
        System.out.println("orm.xml exercise : " + userRepository.getWithSpecificName("johnnie"));
        System.out.println("annotation exercise : " + userRepository.getAllUsers());
        System.out.println("annotation exercise : " + userRepository.retrieveUserWithName("johnnie"));
        System.out.println(userRepository.getAllWithJPQL());
        System.out.println(userRepository.getAllUsersInAgeRange(20,40));
        System.out.println("email : " + userRepository.retrieveUserWithEmail("lawrence.f@email.com"));

    }
}
