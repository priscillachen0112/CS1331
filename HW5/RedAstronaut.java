import java.util.Arrays;
import java.util.Locale;

public class RedAstronaut extends Player implements Impostor {
    protected String skill;

    public static final int default_susLevel = 15;
    public static final String default_skill = "experienced";
    // Constructors

    public RedAstronaut(String name) {
        this(name, default_susLevel, default_skill);
    }

    public RedAstronaut(String name, int susLevel, String skill) {
        super(name, susLevel);
        this.name = name;
        this.skill = skill;
    }

    public void emergencyMeeting() {

        if (this.isFrozen()) {
            return;
        } else {
            Player[] players = getPlayers();
            double highestSusLevel = (int) Double.NEGATIVE_INFINITY;
            Player highestSusPlayer = null;
            for (Player p : players) {
                System.out.println(highestSusLevel);
                if (p != this && !p.isFrozen() && p.getSusLevel() > highestSusLevel) {
                    highestSusLevel = p.getSusLevel();
                    highestSusPlayer = p;
                }
            }

            for (Player q : players) {
                //System.out.println(highestSusPlayer);
                //System.out.println(q);
                //System.out.println(q != highestSusPlayer);
                if (q != highestSusPlayer && q != this && !q.isFrozen() && q.getSusLevel() == highestSusLevel) {
                    highestSusPlayer = null;
                }
            }
            if (highestSusPlayer != null) {
                highestSusPlayer.setFrozen(true);
            } else {
                return;
            }
        }
        gameOver();
    }

    public void freeze(Player p) {
        if (this.isFrozen() || p.isFrozen() || p instanceof Impostor) {
            return;
        } else if (!this.isFrozen() && p instanceof Crewmate && this.getSusLevel() < p.getSusLevel()) {
            p.setFrozen(true);
        } else {
            this.setSusLevel(2 * this.getSusLevel());
        }
        gameOver();
    }

    public void sabotage(Player p) {
        if (p instanceof Impostor || p.isFrozen() || this.isFrozen()) {
            return;
        } else if (!this.isFrozen() && !p.isFrozen() && p instanceof Crewmate) {
            if (this.getSusLevel() < 20) {
                p.setSusLevel((int) (p.getSusLevel() * 1.5));
            } else if (this.getSusLevel() >= 20) {
                p.setSusLevel((int) (p.getSusLevel() * 1.25));
            }
        }
    }

    public boolean equals(Object o) {
        if (o instanceof RedAstronaut) {
            RedAstronaut red = (RedAstronaut) o;
        return this.name.equals(red.name) && this.isFrozen() == red.isFrozen()
                    && this.getSusLevel() == red.getSusLevel()
                    && this.skill == red.skill;
        }
        return false;
    }

    public String toString() {
        String frozenString = isFrozen() ? "frozen" : "not frozen";
        int susLevel = getSusLevel();
        String returnString = "My name is " + this.name + ", and I have a susLevel of "
                + susLevel + ". I am currently " + frozenString + "."
                + " I am an " + this.skill + " player!";
        if (susLevel > 15) {
            return returnString.toUpperCase();
        } else {
            return returnString;
        }
    }

    public String getSkillLevel() {
        return skill;
    }

    /**
     * This is the setter for susLevel.
     * @param skillLevel the value to change susLevel to
     */
    public void setSkillLevel(String skillLevel) {
        if (Arrays.asList("inexperienced", "experienced", "expert").contains(skillLevel)) {
            this.skill = skillLevel;
        }
    }
}