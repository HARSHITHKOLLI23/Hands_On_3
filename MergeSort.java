public class MergeSort {
    void merge(int array[], int left, int middle, int right) {
        int leftArraySize = middle - left + 1;
        int rightArraySize = right - middle;

        int leftArray[] = new int[leftArraySize];
        int rightArray[] = new int[rightArraySize];

        for (int i = 0; i < leftArraySize; ++i)
            leftArray[i] = array[left + i];
        for (int j = 0; j < rightArraySize; ++j)
            rightArray[j] = array[middle + 1 + j];

        int i = 0, j = 0;

        int k = left;
        while (i < leftArraySize && j < rightArraySize) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftArraySize) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightArraySize) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    void sort(int array[], int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2; // Middle index calculation

            sort(array, left, middle);
            sort(array, middle + 1, right);

            merge(array, left, middle, right);
        }
    }

    static void printArray(int array[]) {
        int arraySize = array.length;
        for (int i = 0; i < arraySize; ++i)
            System.out.print(array[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        int array[] = {5, 2, 4, 7, 1, 3, 2, 6};

        System.out.println("Given Array ");
        printArray(array);

        MergeSort mergeSortObject = new MergeSort(); // Changed class name
        mergeSortObject.sort(array, 0, array.length - 1);

        System.out.println("\nSorted array");
        printArray(array);
    }
}