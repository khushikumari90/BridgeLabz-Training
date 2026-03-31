package linearsearch_binarysearch_stringbuilder_stringbuffer_bufferedreader_filereader_inputstreamreader;

public class CompareStringBufferAndStringBuilderForStringConcatenation {
    public static void main(String[] args) {
        long startTime, endTime;
        
        // Testing StringBuilder Performance
        startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder("Java");
        for (int i = 0; i < 100000; i++) {
            sb.append(" hello");
        }
        endTime = System.nanoTime();
        System.out.println("StringBuilder Time: " + (endTime - startTime) + " ns");
        
        // Testing StringBuffer Performance
        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer("Java");
        for (int i = 0; i < 100000; i++) {
            sbf.append(" hello");
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer Time: " + (endTime - startTime) + " ns");
    }

}
