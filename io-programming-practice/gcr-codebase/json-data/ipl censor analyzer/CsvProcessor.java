package ipl_censor_analyzer;

import java.io.*;

public class CsvProcessor {

    public static void processCsv(String input, String output) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader(input));
        BufferedWriter bw = new BufferedWriter(new FileWriter(output));

        String line;
        bw.write(br.readLine()); // header
        bw.newLine();

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");

            data[1] = CensorUtil.maskTeam(data[1]); // team1
            data[2] = CensorUtil.maskTeam(data[2]); // team2
            data[5] = CensorUtil.maskTeam(data[5]); // winner
            data[6] = CensorUtil.redactPlayer();    // player

            bw.write(String.join(",", data));
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
