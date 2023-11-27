package hausarbeit_hsk_2023;

import java.util.UUID;
import java.time.LocalDate;

public class Hauptprogramm {
    public static void main(String[] args) {
        // Initialisierung der Manager
        TeamManager teamManager = new TeamManager();
        EventManager eventManager = new EventManager();

        // Teamleiter und Wissenschaftler erstellen
        Scientist teamLeiter = new Scientist("Dr. Müller", "Geophysik", 15);
        Scientist mitglied1 = new Scientist("Dr. Schmidt", "Meteorologie", 10);
        Scientist mitglied2 = new Scientist("Dr. Fischer", "Hydrologie", 8);

        // Teams erstellen und registrieren
        Team team1 = new Team(teamLeiter);
        team1.mitgliedHinzufuegen(mitglied1);
        team1.mitgliedHinzufuegen(mitglied2);
        teamManager.teamRegistrieren(team1);

        Team team2 = new Team(teamLeiter);
        team2.mitgliedHinzufuegen(new Scientist("Dr. Bauer", "Seismologie", 7));
        team2.mitgliedHinzufuegen(new Scientist("Dr. Klein", "Geologie", 9));
        teamManager.teamRegistrieren(team2);

        // Naturkatastrophen erstellen und registrieren
        String erdbebenId = UUID.randomUUID().toString();
        eventManager.ereignisRegistrieren(new ErdbebenEvent(erdbebenId, 8, "Tokio", LocalDate.of(2021, 3, 11), 9, "Starke Erschütterungen"));

        String tsunamiId = UUID.randomUUID().toString();
        eventManager.ereignisRegistrieren(new TsunamiEvent(tsunamiId, 9, "Jakarta", LocalDate.of(2004, 12, 26), 15, 80, 300, "Hohe Wellen"));
        
        String weitererWaldbrandId = UUID.randomUUID().toString();
        eventManager.ereignisRegistrieren(new WaldbrandEvent(weitererWaldbrandId, 6, "Amazonas", LocalDate.of(2022, 7, 15), 80000, "Umfangreiche Brände im Regenwaldgebiet"));

        // Teams den Naturkatastrophen zuweisen
        String registrierungId1 = UUID.randomUUID().toString();
        eventManager.benutzerRegistrieren(new EventRegistration(registrierungId1, team1, eventManager.getEreignis(erdbebenId)));

        String registrierungId2 = UUID.randomUUID().toString();
        eventManager.benutzerRegistrieren(new EventRegistration(registrierungId2, team2, eventManager.getEreignis(tsunamiId)));
        
        String registrierungIdWeitererWaldbrand = UUID.randomUUID().toString();
        eventManager.benutzerRegistrieren(new EventRegistration(registrierungIdWeitererWaldbrand, team1, eventManager.getEreignis(weitererWaldbrandId)));

        // Ausgabe der Teams
        System.out.println("Alle Teams:");
        System.out.println("---------------------");
        for (Team team : teamManager.getAlleTeams()) {
            System.out.println("> Team ID: " + team.getTeamId());
            System.out.println("> Teamleiter: " + team.getTeamLeiter().getName() + " (" + team.getTeamLeiter().getFachgebiet() + ")");
            for (Scientist mitglied : team.getTeamMitglieder()) {
                System.out.println("> Mitglied: " + mitglied.getName() + " (" + mitglied.getFachgebiet() + ")");
            }
            System.out.println();
        }

        // Ausgabe der Naturkatastrophen
        System.out.println("Alle Naturkatastrophen:");
        System.out.println("---------------------");
        for (Event ereignis : eventManager.getAlleEreignisse()) {
            System.out.println("> Name: " + ereignis.getEventName());
            System.out.println("> Typ: " + ereignis.getEventType());
            System.out.println("> Datum: " + ereignis.getDatum());
            System.out.println("> Ort: " + ereignis.getDescription().getOrt());
            System.out.println("> Beschreibung: " + ereignis.getDescription().getBesonderheit());
            System.out.println();
        }

        // Ausgabe der Benutzerregistrierungen
        System.out.println("Benutzer Registrierungen:");
        System.out.println("-------------------------");
        for (EventRegistration registrierung : eventManager.getAlleRegistrierungen()) {
            Event registriertesEreignis = registrierung.getEreignis();
            System.out.println("> Team: " + registrierung.getTeam().getTeamId());
            System.out.println("> Katastrophe: " + registriertesEreignis.getEventName());
            System.out.println("> Datum der Katastrophe: " + registriertesEreignis.getDatum());
            System.out.println("> Beschreibung: " + registriertesEreignis.getDescription().getBesonderheit());

            // Spezifische Details für verschiedene Ereignistypen mit Einheiten
            if (registriertesEreignis instanceof ErdbebenEvent) {
                ErdbebenEvent erdbeben = (ErdbebenEvent) registriertesEreignis;
                System.out.println("> Stärke: " + erdbeben.getStaerke() + " (Richterskala)");
            } else if (registriertesEreignis instanceof TsunamiEvent) {
                TsunamiEvent tsunami = (TsunamiEvent) registriertesEreignis;
                System.out.println("> Höhe: " + tsunami.getHoehe() + " Meter");
                System.out.println("> Geschwindigkeit: " + tsunami.getGeschwindigkeit() + " km/h");
                System.out.println("> Breite: " + tsunami.getBreite() + " km");
            } else if (registriertesEreignis instanceof WaldbrandEvent) {
                WaldbrandEvent waldbrand = (WaldbrandEvent) registriertesEreignis;
                System.out.println("> Ausdehnung: " + waldbrand.getAusdehnung() + " Hektar");
            }
           System.out.println();
        }
    }
}
