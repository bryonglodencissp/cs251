import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class insertionSortTest {
    @Test
    public void test1(){
        insertionSort inSort = new insertionSort();
        int array1[] = {992, 20, 122, 308, 774, 3944, 30, 58, 604, 3224, 9000, 44223};
        int array2[] = {992, 20, 122, 308, 774, 3944, 30, 58, 604, 3224, 9000, 44223};
        Arrays.sort(array1);
        int count = inSort.insertionSort(array2);
        System.out.println("number of swaps: " + count);
        assertArrayEquals("Sorting not correct", array1, array2);
        assertEquals("number of swaps not correct", 18, count);
    }

    @Test
    public void test2(){
        insertionSort inSort = new insertionSort();
        int array1[] = {-22394, 99393, 22, 348, 48, 3222, 3, -3940, 89332, 39, 39482, 34, 586, 49244, 592045, -591, 94923, 9040, 493, 4052, 4493, 9553, 949};
        int array2[] = {-22394, 99393, 22, 348, 48, 3222, 3, -3940, 89332, 39, 39482, 34, 586, 49244, 592045, -591, 94923, 9040, 493, 4052, 4493, 9553, 949};
        Arrays.sort(array1);
        int count = inSort.insertionSort(array2);
        System.out.println("number of swaps: " + count);
        assertArrayEquals("Sorting not correct", array1, array2);
        assertEquals("number of swaps not correct", 98, count);
    }

    @Test
    public void test3(){
        insertionSort inSort = new insertionSort();
        int array1[] = {20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int array2[] = {20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        Arrays.sort(array1);
        int count = inSort.insertionSort(array2);
        System.out.println("number of swaps: " + count);
        assertArrayEquals("Sorting not correct", array1, array2);
        assertEquals("number of swaps not correct", 190, count);
    }

    @Test
    public void test4(){
        insertionSort inSort = new insertionSort();
        int array1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 20, 20};
        int array2[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 20, 20};
        Arrays.sort(array1);
        int count = inSort.insertionSort(array2);
        System.out.println("number of swaps: " + count);
        assertArrayEquals("Sorting not correct", array1, array2);
        assertEquals("number of swaps not correct", 0, count);
    }
}