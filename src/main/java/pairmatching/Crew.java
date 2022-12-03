package pairmatching;

import java.util.ArrayList;
import java.util.List;

public class Crew {
    private final String course;
    private final List<String> crew;
    private final String level;
    private final String project;

    ArrayList<String> crewName = new ArrayList<>();

    public Crew(String course, List<String> crew, String level, String project) {
        this.course = course;
        this.crew = crew;
        this.level = level;
        this.project = project;
        crewName.addAll(crew);
    }

    public void printCrews() {
        System.out.println("");
        System.out.println("페어 매칭 결과입니다.");

        for (int i = 0; i < crew.size() - 1; i += 2) {
            System.out.print(crew.get(i) + " : " + crew.get(i + 1));
            if (crew.size() % 2 == 1 && i == crew.size() - 3) {
                System.out.print(" : " + crew.get(i + 2));
            }

            System.out.println("");
        }
    }

    public boolean compareDuplicateNameInSameLevel(ArrayList<String> newCrew) {
        for (int i = 0; i < crew.size(); i += 2) {
            if (crewName.get(i).equals(newCrew.get(i)) && crewName.get(i + 1).equals(newCrew.get(i + 1))) {
                return false;
            }

            if ((crew.size() % 2 == 1 && i == crew.size() - 3) && crewName.get(i).equals(newCrew.get(i))
                    && crewName.get(i + 1).equals(newCrew.get(i + 1)) && crewName.get(i + 2)
                    .equals(newCrew.get(i + 2))) {
                return false;
            }
        }
        return true;
    }

    public String getCourse() {
        return course;
    }

    public String getLevel() {
        return level;
    }

    public String getProject() {
        return project;
    }
}
