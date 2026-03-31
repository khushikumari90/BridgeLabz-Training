package sorting_algorithms;
public class ProductPricesQuickSort {

    static void quickSort(int[] prices, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(prices, low, high);

            quickSort(prices, low, pivotIndex - 1);
            quickSort(prices, pivotIndex + 1, high);
        }
    }

 
    static int partition(int[] prices, int low, int high) {
        int pivot = prices[high]; // pivot element
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (prices[j] <= pivot) {
                i++;
                int temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }

        int temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        return i + 1;
    }

   
    public static void main(String[] args) {
        int[] productPrices = {1500, 299, 799, 1200, 450};

        quickSort(productPrices, 0, productPrices.length - 1);

        System.out.println("Sorted Product Prices:");
        for (int price : productPrices) {
            System.out.print(price + " ");
        }
    }
}

