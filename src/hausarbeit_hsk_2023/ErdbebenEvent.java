package hausarbeit_hsk_2023;

import java.time.LocalDate;

public class ErdbebenEvent extends Event {
    private int staerke;

    public ErdbebenEvent(String eventId, int schweregrad, String ort, LocalDate datum, int staerke, String besonderheit) {
        super(eventId, EventType.ERDBEBEN, new EventDescription(schweregrad, ort, besonderheit), datum);
        this.staerke = staerke;
    }

    @Override
    public void ausloesen() {
        System.out.println("Erdbeben ausgelöst: " + getEventName() + " in " + getDescription().getOrt() + " am " + getDatum());
    }

    @Override
    public void auswirkungenBerechnen() {
        System.out.println("Berechnung der Auswirkungen des Erdbebens in " + getDescription().getOrt());
    }

    public int getStaerke() {
        return staerke;
    }
}
