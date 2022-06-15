public class BlueAstronaut extends Player implements Crewmate {
    protected int numTasks;
    protected int taskSpeed;

    public static final int default_susLevel = 15;
    public static final int default_numTasks = 6;
    public static final int default_taskSpeed = 10;

    // Constructors

    public BlueAstronaut(String name) {
        this(name, default_susLevel, default_numTasks, default_taskSpeed);
    }

    public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed) {
        super(name, susLevel);
        this.name = name;
        this.numTasks = numTasks;
        this.taskSpeed = taskSpeed;
    }

    public void emergencyMeeting() {

        if (this.isFrozen()) {
            return;
        } else {
            Player[] players = getPlayers();
            double highestSusLevel = (int) Double.NEGATIVE_INFINITY;
            Player highestSusPlayer = null;
            for (Player p : players) {
                if (p != this && !p.isFrozen() && p.getSusLevel() > highestSusLevel) {
                    highestSusLevel = p.getSusLevel();
                    highestSusPlayer = p;
                }
            }

            for (Player q : players) {
                if (q != highestSusPlayer && q != this && !q.isFrozen() && q.getSusLevel() == highestSusLevel) {
                    highestSusPlayer = null;
                } else {
                    break;
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

    public void completeTask() {
        if (!this.isFrozen() && this.taskSpeed > 20) {
            numTasks = numTasks - 2;
            if (numTasks <= 0) {
                numTasks = 0;
                System.out.println("I have completed all my tasks");
                this.setSusLevel((int)(this.getSusLevel() * 0.5));
            }
        } else if (!this.isFrozen() && this.taskSpeed <= 20) {
            numTasks = numTasks - 1;
            if (numTasks <= 0) {
                numTasks = 0;
                System.out.println("I have completed all my tasks");
                this.setSusLevel((int) (this.getSusLevel() * 0.5));
            }
        }
    }

    public boolean equals(Object o) {
        if (o instanceof BlueAstronaut) {
            BlueAstronaut blue = (BlueAstronaut) o;
            return this.name.equals(blue.name) && this.isFrozen() == blue.isFrozen()
                    && this.getSusLevel() == blue.getSusLevel()
                    && this.numTasks == blue.numTasks
                    && this.taskSpeed == blue.taskSpeed;
        }
        return false;
    }

    public String toString() {
        String frozenString = isFrozen() ? "frozen" : "not frozen";
        String returnString = "My name is " + this.name + ", and I have a susLevel of "
                + this.getSusLevel() + ". I am currently " + frozenString + "."
                + " I have " + this.numTasks + " leftover";
        if (this.getSusLevel() > 15) {
            return returnString.toUpperCase();
        } else {
            return returnString;
        }
    }

    public int getNumTasks() {
        return numTasks;
    }

    public int getTaskSpeed() {
        return taskSpeed;
    }

    /**
     * This is the setter for susLevel.
     * @param numTasks the value to change susLevel to
     */
    public void setNumTasks(int numTasks) {
        this.numTasks = numTasks;
    }

    public void setTaskSpeed(int taskSpeed) {
        this.taskSpeed = taskSpeed;
    }
}