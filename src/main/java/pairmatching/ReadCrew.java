package pairmatching;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCrew {

    public List<String> readCrewBackend() throws IOException {
            List<String> backendCrew = new ArrayList<>();
            BufferedReader backend = new BufferedReader(new FileReader("/Users/phc/development/java-pairmatching-precourse/src/main/resources/backend-crew.md"));
            while (true) {
                String line = backend.readLine();
                if (line == null) {
                    break;
                }
                backendCrew.add(line);
            }
            List<String> shuffleBackendCrew = Randoms.shuffle(backendCrew);
            backend.close();

            return shuffleBackendCrew;
    }

    public List<String> readCrewFrontend() throws IOException {
        BufferedReader frontend = new BufferedReader(new FileReader("/Users/phc/development/java-pairmatching-precourse/src/main/resources/frontend-crew.md"));
        ArrayList<String> frontendCrew = new ArrayList<>();
        while (true) {
            String line = frontend.readLine();
            if (line == null) {
                break;
            }
            frontendCrew.add(line);
        }
        List<String> shuffleFrontendCrew = Randoms.shuffle(frontendCrew);
        frontend.close();

        return shuffleFrontendCrew;
    }

}
