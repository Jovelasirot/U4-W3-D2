package org.example;

import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.DAO.EventDAO;
import org.example.entities.Event;
import org.example.entities.TypeEvent;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("eventManager");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventDAO sd = new EventDAO(em);

        Supplier<Event> eventSupplier = getEventSupplier();
        List<Event> eventList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            eventList.add(eventSupplier.get());
        }

        eventList.forEach(sd::save);
        System.out.println("It worked ig");

        em.close();
        emf.close();
    }

    public static Supplier<Event> getEventSupplier() {
        Random rdm = new Random();
        Faker faker = new Faker();
        TypeEvent[] typeEvents = TypeEvent.values();

        return () -> {

            String title = faker.esports().event();
            String description = faker.esports().game();


            LocalDate dateEvent = LocalDate.now().plusDays(rdm.nextInt(365));

            int rdmTypeEvent = rdm.nextInt(typeEvents.length);
            TypeEvent typeEvent = typeEvents[rdmTypeEvent];

            int maxParticipant = rdm.nextInt(1, 50);

            return new Event(title, dateEvent, description, typeEvent, maxParticipant);
        };
    }
}
