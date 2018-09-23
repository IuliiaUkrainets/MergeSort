import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MergeTest {

    @Test
    public void evenLengthList() {
        Integer[] list = new Integer[] {15, 4, 1, -1, 6, 7};
        GenericMerge.mergeSort(list);
        assertArrayEquals(new Integer[] {-1, 1, 4, 6, 7, 15}, list);
    }

    @Test
    public void oddLengthList() {
        Integer[] list = new Integer[] {5, 2, 1, -1, 7};
        GenericMerge.mergeSort(list);
        assertArrayEquals(new Integer[] {-1, 1, 2, 5, 7}, list);
    }

    @Test
    public void stringList() {
        String[] list = new String[] {"Kitkat", "Pistachio", "Marshmallow", "Bounty", "Oreo", "Apple Pie"};
        GenericMerge.mergeSort(list);
        assertArrayEquals(new String[] {"Apple Pie", "Bounty", "Kitkat", "Marshmallow", "Oreo", "Pistachio"}, list);
    }

    @Test
    public void doubleList() {
        Double[] list = new Double[] {3.0, 2.0, 1.0, 0.0, 5.0, 4.0};
        GenericMerge.mergeSort(list);
        assertArrayEquals(new Double[] {0.0, 1.0, 2.0, 3.0, 4.0, 5.0}, list);
    }

    @Test
    public void comparatorList() {
        String[] list = new String[] {"Kitkat", "Donut", "Marshmallow", "Honeycomb", "Oreo", "ApplePie"};
        GenericMerge.mergeSort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o2.length(), o1.length());
            }
        });
        assertArrayEquals(new String[] {"Oreo", "Donut", "Kitkat", "ApplePie", "Honeycomb", "Marshmallow"}, list);
    }
}