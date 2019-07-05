public class insertionSort {
    public int insertionSort(int[] array){
        /* sort array in place and return the number of element swaps */

        int count = 0;
        //sort array
        int temp;
        for (int i = 1; i < array.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(array[j] < array[j-1]){
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                    count++;
                }
            }
        }
        //return input;
        return count;
    }
}
