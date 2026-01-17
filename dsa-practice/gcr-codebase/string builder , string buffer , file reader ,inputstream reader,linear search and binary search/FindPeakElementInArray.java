package linearsearch_binarysearch_stringbuilder_stringbuffer_bufferedreader_filereader_inputstreamreader;

public class FindPeakElementInArray {
    public static int findPeak(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            boolean leftIsSmaller = (mid == 0) || (arr[mid] > arr[mid - 1]);
            boolean rightIsSmaller = (mid == arr.length - 1) || (arr[mid] > arr[mid + 1]);

            if (leftIsSmaller && rightIsSmaller) {
                return mid; // peak element found
            } else if (mid > 0 && arr[mid - 1] > arr[mid]) {
                right = mid - 1; // search left half
            } else {
                left = mid + 1; // search right half
            }
        }

        return -1; // this will never happen if array has at least one element
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 20, 4, 1, 0};

        int peakIndex = findPeak(arr);

        System.out.println("Peak element is at index: " + peakIndex);
        System.out.println("Peak element value: " + arr[peakIndex]);
    }

}
