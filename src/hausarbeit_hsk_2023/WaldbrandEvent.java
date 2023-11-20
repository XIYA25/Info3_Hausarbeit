package hausarbeit_hsk_2023;

import java.time.LocalDate;

public class WaldbrandEvent extends Event {
    private int ausdehnung;  // in Hektar

    public WaldbrandEvent(String eventId, int schweregrad, String ort, LocalDate datum, int ausdehnung, String besonderheit) {
        super(eventId, EventType.WALDBRAND, new EventDescription(schweregrad, ort, besonderheit), datum);
        this.ausdehnung = ausdehnung;
    }

    @Override
    public void ausloesen() {
        System.out.println("Waldbrand ausgelöst: " + getEventName() + " in " + getDescription().getOrt() + " am " + getDatum());
    }

    @Override
    public void auswirkungenBerechnen() {
        System.out.println("Berechnung der Auswirkungen des Waldbrands in " + getDescription().getOrt());
    }

    public int getAusdehnung() {
        return ausdehnung;
    }
}
