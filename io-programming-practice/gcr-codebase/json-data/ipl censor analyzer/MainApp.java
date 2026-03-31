package ipl_censor_analyzer;
public class MainApp {

    public static void main(String[] args) {

        try {
            JsonProcessor.processJson(
                    "ipl_input.json",
                    "ipl_censored.json"
            );

            CsvProcessor.processCsv(
                    "ipl_input.csv",
                    "ipl_censored.csv"
            );

            System.out.println("✅ IPL Data Censorship Completed Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
