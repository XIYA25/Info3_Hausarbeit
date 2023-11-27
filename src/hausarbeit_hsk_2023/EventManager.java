package hausarbeit_hsk_2023;

import java.util.List;
import java.util.ArrayList;

public class EventManager {
    private List<Event> ereignisse;
    private List<EventRegistration> registrierungen;

    public EventManager() {
        this.ereignisse = new ArrayList<>();
        this.registrierungen = new ArrayList<>();
    }

    public void ereignisRegistrieren(Event event) {
        ereignisse.add(event);
    }

    public void benutzerRegistrieren(EventRegistration registrierung) {
        registrierungen.add(registrierung);
    }

    public Event getEreignis(String eventId) {
        for (Event event : ereignisse) {
            if (event.getEventId().equals(eventId)) {
                return event;
            }
        }
        return null;
    }

    public List<Event> getAlleEreignisse() {
        return new ArrayList<>(ereignisse);
    }

    public List<EventRegistration> getAlleRegistrierungen() {
        return new ArrayList<>(registrierungen);
    }
}
