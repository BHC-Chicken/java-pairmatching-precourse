package pairmatching;

public class ConditionCheck {

    public boolean fullConditionCheck(Crew historyCrew, String [] argument) {
        if (historyCrew.getCourse().equals(argument[0]) && historyCrew.getLevel().equals(argument[1])
                && historyCrew.getProject().equals(argument[2])) {
            return true;
        }

        return false;
    }

    public boolean differentProjectConditionCheck(Crew historyCrew, String [] argument) {
        if (historyCrew.getCourse().equals(argument[0]) && historyCrew.getLevel().equals(argument[1])
                && !(historyCrew.getProject().equals(argument[2]))) {
            return true;
        }
        return false;
    }

}
