package hausarbeit_hsk_2023;

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
        team2.mitgliedHinzufuegen(new Scientist("Dr..prof. Klein ", "Geologie", 9));
        teamManager.teamRegistrieren(team2);

        // Naturkatastrophen erstellen und registrieren
        eventManager.ereignisRegistrieren(new ErdbebenEvent("E01", 8, "Tokio", LocalDate.of(2021, 3, 11), 9, "Starke Erschütterungen"));
        eventManager.ereignisRegistrieren(new TsunamiEvent("E02", 9, "Jakarta", LocalDate.of(2004, 12, 26), 15, 80, 200, "Hohe Wellen"));
        eventManager.ereignisRegistrieren(new WaldbrandEvent("E03", 5, "Kalifornien", LocalDate.of(2020, 8, 20), 50000, "Großflächige Waldbrände"));
        eventManager.ereignisRegistrieren(new ErdbebenEvent("E04", 7, "Mexiko-Stadt", LocalDate.of(1985, 9, 19), 8, "Gebäudeschäden"));

        // Teams den Naturkatastrophen zuweisen
        eventManager.benutzerRegistrieren(new EventRegistration("R01", team1, eventManager.getEreignis("E01")));
        eventManager.benutzerRegistrieren(new EventRegistration("R02", team2, eventManager.getEreignis("E02")));
        eventManager.benutzerRegistrieren(new EventRegistration("R03", team1, eventManager.getEreignis("E03")));
        eventManager.benutzerRegistrieren(new EventRegistration("R04", team2, eventManager.getEreignis("E04")));

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
                    System.out.println("> Team: " + registrierung.getTeam().getTeamId());
                    System.out.println("> Katastrophe: " + registrierung.getEreignis().getEventName());
                    // Optional: Weitere Details der Registrierung
                    System.out.println();
                }
            }
}