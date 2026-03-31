package linearsearch_binarysearch_stringbuilder_stringbuffer_bufferedreader_filereader_inputstreamreader;

public class FindRotationPoint {
    public static int findRotationPoint(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left; // index of the smallest element
    }

    public static void main(String[] args) {
        int[] arr = {15, 18, 2, 3, 6, 12};

        int rotationIndex = findRotationPoint(arr);

        System.out.println("Rotation point (smallest element) is at index: " + rotationIndex);
        System.out.println("Smallest element is: " + arr[rotationIndex]);
    }

}
