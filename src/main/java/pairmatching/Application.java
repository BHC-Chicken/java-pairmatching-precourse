package pairmatching;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        OutputView outputView = new OutputView();
        SelectCategory selectCategory = new SelectCategory();

        boolean loop = true;

        while (loop) {
            try {
                outputView.selectCategory();
                loop = selectCategory.selectCategory();
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

}
