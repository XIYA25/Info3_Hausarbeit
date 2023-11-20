package hausarbeit_hsk_2023;

public class EventDescription {
    private int schweregrad;
    private String ort;
    private String besonderheit;

    public EventDescription(int schweregrad, String ort, String besonderheit) {
        this.schweregrad = schweregrad;
        this.ort = ort;
        this.besonderheit = besonderheit;
    }

    public int getSchweregrad() {
        return schweregrad;
    }

    public String getOrt() {
        return ort;
    }

    public String getBesonderheit() {
        return besonderheit;
    }
}
