import java.util.Arrays;

public class RedAstronaut extends Player implements Impostor {
    protected String name;
    protected String skill;

    public static final int default_susLevel = 15;
    public static final String default_skill = "experienced";
    // Constructors

    public RedAstronaut(String name) {
        super(name, default_susLevel);
        this.skill = default_skill;
    }

    public RedAstronaut(String name, int susLevel, String skill) {
        super(name, default_susLevel);
        this.name = name;
        this.skill = skill;
    }

    public void emergencyMeeting() {
        int numberOfPlayers = getPlayers().length;
        Player[] players = getPlayers();
        Player highestSusPlayer = players[0];
        for (Player p : players) {
            if (p != this && !p.isFrozen() && p.getSusLevel() > highestSusPlayer.getSusLevel()) {
                highestSusPlayer = p;
            }
        }
        highestSusPlayer.setFrozen(true);
        gameOver();
    }

    public void freeze(Player p) {
        if (!this.isFrozen() && p instanceof Crewmate && this.getSusLevel() < p.getSusLevel()) {
            p.setFrozen(true);
        } else {
            this.setSusLevel(2 * this.getSusLevel());
        }
        gameOver();
    }

    public void sabotage(Player p) {
        if (!this.isFrozen() && !p.isFrozen() && p instanceof Crewmate) {
            if (this.getSusLevel() < 20) {
                p.setSusLevel((int) (p.getSusLevel() * 1.5));
            } else {
                p.setSusLevel((int) (p.getSusLevel() * 1.25));
            }
        }
    }
}