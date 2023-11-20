package hausarbeit_hsk_2023;

import java.time.LocalDate;

public class TsunamiEvent extends Event {
    private int hoehe;
    private int geschwindigkeit;
    private int breite;

    public TsunamiEvent(String eventId, int schweregrad, String ort, LocalDate datum, int hoehe, int geschwindigkeit, int breite, String besonderheit) {
        super(eventId, EventType.TSUNAMI, new EventDescription(schweregrad, ort, besonderheit), datum);
        this.hoehe = hoehe;
        this.geschwindigkeit = geschwindigkeit;
        this.breite = breite;
    }

    @Override
    public void ausloesen() {
        System.out.println("Tsunami ausgelöst: " + getEventName() + " in " + getDescription().getOrt() + " am " + getDatum());
    }

    @Override
    public void auswirkungenBerechnen() {
        System.out.println("Berechnung der Auswirkungen des Tsunamis in " + getDescription().getOrt());
    }

    public int getHoehe() {
        return hoehe;
    }

    public int getGeschwindigkeit() {
        return geschwindigkeit;
    }

    public int getBreite() {
        return breite;
    }
}
