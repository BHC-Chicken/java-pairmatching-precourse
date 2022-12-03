package pairmatching.constant;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Level {
    LEVEL1_CAR(" 레벨1 자동차경주"),
    LEVEL1_LOTTO(" 레벨1 로또"),
    LEVEL1_BASEBALL(" 레벨1 숫자야구게임"),
    LEVEL2_SHOP(" 레벨2 장바구니"),
    LEVEL2_PAY(" 레벨2 결제"),
    LEVEL2_SUBWAY(" 레벨2 지하철노선도"),
    LEVEL4_ENHANCE(" 레벨4 성능개선"),
    LEVEL4_DEPLOY(" 레벨4 배포");

    private final String project;

    Level(final String project) {
        this.project = project;
    }

    public String getProject() {
        return project;
    }

    private static final Map<String, Level> BY_PROJECT =
            Stream.of(values()).collect(Collectors.toMap(Level::getProject, Function.identity()));

    public static void findProject(String project) {
        if (BY_PROJECT.containsKey(project)) {
            BY_PROJECT.get(project);
            return;
        }
        throw new IllegalArgumentException("[ERROR] 존재하지 않는 값 입니다.");
    }

}
