import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Integer[] array = new Integer[]{0,10,1,5,3};
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static <T extends Comparable<T>> void mergeSort(T[] list) {
        T[] array = list;
        int length = list.length;
        T[] temp = (T[]) new Comparable[length];
        doMergeSort(array, temp,0, length - 1);
    }

    private static <T extends Comparable<T>> void doMergeSort(T[] list, T[] temp,int lowerIndex, int higherIndex) {
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            doMergeSort(list, temp, lowerIndex, middle);
            doMergeSort(list, temp, middle + 1, higherIndex);
            merge(list,temp, lowerIndex, middle, higherIndex);
        }
    }

    private static <T extends Comparable<T>> void merge(T[] list, T[] temp, int lowerIndex, int middle, int higherIndex) {
        for (int i = lowerIndex; i <= higherIndex; i++) {
            temp[i] = list[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (temp[i].compareTo(temp[j])<0) {
                list[k] = temp[i];
                i++;
            } else {
                list[k] = temp[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            list[k] = temp[i];
            k++;
            i++;
        }

    }




}
