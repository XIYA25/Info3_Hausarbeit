package hausarbeit_hsk_2023;

public class Scientist {
    private String name;
    private String fachgebiet;
    private int erfahrungsjahre;

    public Scientist(String name, String fachgebiet, int erfahrungsjahre) {
        this.name = name;
        this.fachgebiet = fachgebiet;
        this.erfahrungsjahre = erfahrungsjahre;
    }

    public String getName() {
        return name;
    }

    public String getFachgebiet() {
        return fachgebiet;
    }

    public int getErfahrungsjahre() {
        return erfahrungsjahre;
    }
}
