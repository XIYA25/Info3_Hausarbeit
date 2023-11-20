package hausarbeit_hsk_2023;

import java.util.Random;
import java.util.Arrays;
import java.util.List;
import java.time.LocalDate;

public abstract class Event {
    private String eventId;
    private String eventName;
    private EventType eventType;
    private EventDescription description;
    private LocalDate datum;

    private static final List<String> frauennamen = Arrays.asList("Anna", "Maria", "Eva", "Julia", "Sophie");
    private static final List<String> maennernamen = Arrays.asList("Max", "Paul", "Tom", "David", "Lukas");

    public Event(String eventId, EventType eventType, EventDescription description, LocalDate datum) {
        this.eventId = eventId;
        this.eventName = generiereZufaelligenNamen();
        this.eventType = eventType;
        this.description = description;
        this.datum = datum;
    }

    private String generiereZufaelligenNamen() {
        Random rand = new Random();
        if (rand.nextBoolean()) {
            return frauennamen.get(rand.nextInt(frauennamen.size()));
        } else {
            return maennernamen.get(rand.nextInt(maennernamen.size()));
        }
    }

    public abstract void ausloesen();
    public abstract void auswirkungenBerechnen();

    public String getEventId() {
        return eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public EventType getEventType() {
        return eventType;
    }

    public EventDescription getDescription() {
        return description;
    }

    public LocalDate getDatum() {
        return datum;
    }
}
