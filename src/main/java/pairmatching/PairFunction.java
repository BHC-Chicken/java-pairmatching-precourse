package pairmatching;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import pairmatching.constant.Level;

public class PairFunction {
    ArrayList<Crew> matchingHistory = new ArrayList<>();
    ConditionCheck conditionCheck = new ConditionCheck();
    ReadCrew readCrew = new ReadCrew();

    public Crew createCrew(String[] argument) throws IOException {
        List<String> crews = curriculum(argument[0]);

        Level.findProject(argument[1].concat(argument[2]));

        return new Crew(argument[0], crews, argument[1], argument[2]);
    }

    public List<String> curriculum(String curriculum) throws IOException {
        if (curriculum.equals("백엔드")) {
            return readCrew.readCrewBackend();
        }
        if (curriculum.equals("프론트엔드")) {
            return readCrew.readCrewFrontend();
        }
        throw new IllegalArgumentException("올바른 과정을 입력해주세요.");
    }

    public Crew validationHistory(String[] crewArgument) throws IOException {
        Crew crew;

        if (!matchingHistory.isEmpty()) {
            if ((crew = check(crewArgument)) != null) {
                return crew;
            }
            return null;
        }
        crew = createCrew(crewArgument);
        matchingHistory.add(crew);
        crew.printCrews();

        return null;
    }

    public Crew check(String[] crewArgument) throws IOException {
        for (Crew crew : matchingHistory) {
            if (conditionCheck.fullConditionCheck(crew, crewArgument)) {
                return crew;
            }
            if (conditionCheck.differentProjectConditionCheck(crew, crewArgument)) {
                reMatching(crew, crewArgument);
                return null;
            }
        }
        matchingHistory.add(createCrew(crewArgument));
        matchingHistory.get((matchingHistory.size() - 1)).printCrews();

        return null;
    }

    public void reMatching(Crew historyCrew, String[] crewArgument) throws IOException {
        for (int i = 0; i < 3; i++) {
            Crew newCrew = createCrew(crewArgument);

            if (historyCrew.compareDuplicateNameInSameLevel(newCrew.crewName)) {
                matchingHistory.add(newCrew);
                matchingHistory.get((matchingHistory.size() - 1)).printCrews();

                return;
            }
        }

        throw new IllegalArgumentException("3회 반복 후 실패");
    }

    public void reCreateDuplicateCrew(Crew crew, String[] crewArgument) throws IOException {
        int index = matchingHistory.indexOf(crew);
        Crew newCrew;

        for (int i = 0; i < 3; i++) {
            newCrew = createCrew(crewArgument);

            if (crew.compareDuplicateNameInSameLevel(newCrew.crewName)) {
                matchingHistory.set(index, newCrew);
                newCrew.printCrews();

                return;
            }
        }
    }

    public void inquiryPair(String[] argument) {
        for (Crew crew : matchingHistory) {
            if (conditionCheck.fullConditionCheck(crew, argument)) {
                crew.printCrews();
                return;
            }
        }
        throw new IllegalArgumentException("조회 정보 없음");
    }

    public void initPair() {
        if (matchingHistory.isEmpty()) {
            throw new IllegalArgumentException("초기화 불가");
        }
        matchingHistory.clear();
    }

}
