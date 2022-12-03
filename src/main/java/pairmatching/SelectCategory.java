package pairmatching;

import camp.nextstep.edu.missionutils.Console;
import java.io.IOException;

public class SelectCategory {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    PairFunction pairFunction = new PairFunction();

    public boolean selectCategory() throws IOException {
        String category = Console.readLine();

        if (category.equals("1"))
            return create();
        if (category.equals("2"))
            return inquiry();
        if (category.equals("3"))
            return initPair();
        if (category.equals("Q"))
            return false;

        throw new IllegalArgumentException("올바른 카테고리가 아닙니다.");
    }

    public boolean create() throws IOException {
        outputView.selectArgument();
        String[] argument = inputView.inputValue().split(",");
        Crew crew;

        if ((crew = pairFunction.validationHistory(argument)) != null) {
            outputView.reMatching();
            String answer = inputView.inputValue();
            if (inputAnswer(answer, crew, argument)) {
                return true;
            }
            throw new IllegalArgumentException("답변이 올바르지 않습니다.");
        }
        return true;
    }

    public boolean inputAnswer(String answer, Crew crew, String [] argument) throws IOException {
        if (answer.equals("네")) {
            pairFunction.reCreateDuplicateCrew(crew, argument);
            return true;
        }
        if (answer.equals("아니오")) {
            return true;
        }
        return false;
    }

    public boolean inquiry() {
        outputView.selectArgument();
        String[] argument = inputView.inputValue().split(",");
        pairFunction.inquiryPair(argument);

        return true;
    }

    public boolean initPair() {
        pairFunction.initPair();
        outputView.init();

        return true;
    }
}
