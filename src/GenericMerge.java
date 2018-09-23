import java.util.Arrays;
import java.util.Comparator;

public class GenericMerge {

    public static void main(String[] args) {
        Integer[] array = new Integer[]{0,10,1,5,3};
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static <T extends Comparable<T>> void mergeSort(T[] list) {
        mergeSort(list, null);
    }

    public static <T extends Comparable<T>> void mergeSort(T[] list, Comparator<T> comparator) {
        int length = list.length;
        T[] temp = (T[]) new Comparable[length];
        doMergeSort(list, temp,0, length - 1, comparator);
    }

    private static <T extends Comparable<T>> void doMergeSort(T[] list, T[] temp,int lowerIndex, int higherIndex, Comparator<T> comparator) {
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            doMergeSort(list, temp, lowerIndex, middle, comparator);
            doMergeSort(list, temp, middle + 1, higherIndex, comparator);
            merge(list,temp, lowerIndex, middle, higherIndex, comparator);
        }
    }

    private static <T extends Comparable<T>> void merge(T[] list, T[] temp, int lowerIndex, int middle, int higherIndex, Comparator<T> comparator) {
        for (int i = lowerIndex; i <= higherIndex; i++) {
            temp[i] = list[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (comparator!=null) {
                if (comparator.compare(temp[i],temp[j])>0) {
                    list[k] = temp[i];
                    i++;
                } else {
                    list[k] = temp[j];
                    j++;
                }
            } else {
                if (temp[i].compareTo(temp[j])<0) {
                    list[k] = temp[i];
                    i++;
                } else {
                    list[k] = temp[j];
                    j++;
                }
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
