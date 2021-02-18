/*
 * Dawid Skraba 19433692
 * Loghlen Rickard 1836227
 * Adi Gatt 19202928
 */
public class Player {
    private String name;
    private String team;
    private String[] territories;

    public Player(String name, String[] territories) {
        this.name = name;
        this.territories = territories;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getTerritories() {
        return territories;
    }

    public void setTerritories(String[] territories) {
        this.territories = territories;
    }
}
