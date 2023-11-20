package hausarbeit_hsk_2023;

public class EventRegistration {
    private String registrierungsId;
    private Team team;
    private Event ereignis;

    public EventRegistration(String registrierungsId, Team team, Event ereignis) {
        this.registrierungsId = registrierungsId;
        this.team = team;
        this.ereignis = ereignis;
    }

    public String getRegistrierungsId() {
        return registrierungsId;
    }

    public Team getTeam() {
        return team;
    }

    public Event getEreignis() {
        return ereignis;
    }
}
