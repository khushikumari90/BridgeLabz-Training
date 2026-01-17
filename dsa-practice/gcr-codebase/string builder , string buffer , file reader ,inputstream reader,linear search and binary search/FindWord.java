package linearsearch_binarysearch_stringbuilder_stringbuffer_bufferedreader_filereader_inputstreamreader;

public class FindWord {
    public static String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {
            "Java is a popular programming language",
            "Python is easy to learn",
            "Linear search is simple",
            "Data structures are important"
        };

        String wordToSearch = "Linear";

        String result = findSentenceWithWord(sentences, wordToSearch);

        System.out.println(result);
    }

}
