package hausarbeit_hsk_2023;

import java.util.List;
import java.util.ArrayList;

public class Team {
    private String teamId;
    private Scientist teamLeiter;
    private List<Scientist> teamMitglieder;

    public Team(Scientist teamLeiter) {
        this.teamLeiter = teamLeiter;
        this.teamMitglieder = new ArrayList<>();
    }

    public void mitgliedHinzufuegen(Scientist mitglied) {
        teamMitglieder.add(mitglied);
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getTeamId() {
        return teamId;
    }

    public Scientist getTeamLeiter() {
        return teamLeiter;
    }

    public List<Scientist> getTeamMitglieder() {
        return new ArrayList<>(teamMitglieder);
    }
}
