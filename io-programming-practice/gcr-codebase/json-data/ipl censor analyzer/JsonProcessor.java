package ipl_censor_analyzer;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class JsonProcessor {

    public static void processJson(String input, String output) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        List<IPLMatch> matches = mapper.readValue(
                new File(input),
                mapper.getTypeFactory().constructCollectionType(List.class, IPLMatch.class)
        );

        for (IPLMatch match : matches) {

            match.team1 = CensorUtil.maskTeam(match.team1);
            match.team2 = CensorUtil.maskTeam(match.team2);
            match.winner = CensorUtil.maskTeam(match.winner);
            match.player_of_match = CensorUtil.redactPlayer();

            Map<String, Integer> censoredScore = new HashMap<>();
            for (Map.Entry<String, Integer> entry : match.score.entrySet()) {
                censoredScore.put(CensorUtil.maskTeam(entry.getKey()), entry.getValue());
            }
            match.score = censoredScore;
        }

        mapper.writerWithDefaultPrettyPrinter()
              .writeValue(new File(output), matches);
    }
}
