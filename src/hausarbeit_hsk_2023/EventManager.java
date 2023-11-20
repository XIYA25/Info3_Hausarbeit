package hausarbeit_hsk_2023;

import java.util.Map;
import java.util.HashMap;
import java.util.Collection;

public class EventManager {
    private Map<String, Event> ereignisse;
    private Map<String, EventRegistration> registrierungen;

    public EventManager() {
        this.ereignisse = new HashMap<>();
        this.registrierungen = new HashMap<>();
    }

    public void ereignisRegistrieren(Event event) {
        ereignisse.put(event.getEventId(), event);
    }

    public void benutzerRegistrieren(EventRegistration registrierung) {
        registrierungen.put(registrierung.getRegistrierungsId(), registrierung);
    }

    public Event getEreignis(String eventId) {
        return ereignisse.get(eventId);
    }

    // Methode, um alle Ereignisse zurückzugeben
    public Collection<Event> getAlleEreignisse() {
        return ereignisse.values();
    }

    // Methode, um alle Registrierungen zurückzugeben
    public Collection<EventRegistration> getAlleRegistrierungen() {
        return registrierungen.values();
    }
}

