import sun.jvm.hotspot.debugger.NotInHeapException;

public class MinHeap {
    //instance variables
    private Score[] lb;
    private int capacity;
    private int heap_size;

    //constructor
    public MinHeap(int m) {
        //TODO: Initialize instance variables
        // the easiest implementation index-wise is to ignore index 0
        this.heap_size = 0;
        this.capacity = m;
        lb = new Score[m];
    }

    //Helper functions: You don't have to use them. They are here to help you.

    // Helper functions to find the index of parent of child of each node
    private int parent(int childIndex) {
        return childIndex/2;
    }

    // Helper functions to find the index of the left child of each node
    private int leftChild(int parentIndex) {
        return 2*parentIndex;
    }

    // Helper functions to find the index of the right child of each node
    private int rightChild(int parentIndex) {
        return 2*parentIndex + 1;
    }


    // Helper function to find if the key of one node is smaller than the other node
    // Return True when the key of the first node is smaller than the key for the second node
    private boolean less(int i, int j) {
        return lb[i].compareTo(lb[j]) < 0;
    }

    //Helper function to swap two nodes
    private void swap(int i, int j) {
        Score temp = lb[i];
        lb[i] = lb[j];
        lb[j] = temp;
    }

    /**
     * Bottom-up re-heapify: swim
     * If the heap order is violated because a node's key becomes smaller than that node's parent's key,
     * then we will swap the node with its parent.
     * Keep fixing the heap until we reach a node with a smaller key or the root.
     * @param: k is the index of the node to swim in the array
     */
    public void swim(int k) {
        //TODO: Implement the swim function
        int parentIndex; //, tmp;

        if (k != 0) {

            parentIndex = parent(k);

            if (lb[parentIndex].compareTo(lb[k]) > 0) {

                //tmp = lb[parentIndex].getScore();

                swap(parentIndex, k);
               // lb[parentIndex] = lb[k];
                //lb[k].score = tmp;
                //lb[k].uid = parentIndex;
                swim(parentIndex);

            }

        }
    }

    /**
     * Top-down reheapify: sink
     * If the heap order is violated because a node's key becomes larger than one or both of its children's keys,
     * then we can swap the node with the smaller one of its children.
     * Keep sinking until we reach a node with both children larger
     * @param: k is the index of the node to sink in the array
     */
    public void sink(int k) {
        //TODO: Implement the sink function
        int leftChildIndex, rightChildIndex, minIndex, tmp;

        leftChildIndex = leftChild(k);

        rightChildIndex = rightChild(k);

        if (rightChildIndex >= capacity) {

            if (leftChildIndex >= capacity)

                return;

            else

                minIndex = leftChildIndex;

        } else {

            if (lb[leftChildIndex].compareTo(lb[rightChildIndex]) <= 0)

                minIndex = leftChildIndex;

            else

                minIndex = rightChildIndex;

        }

        if (lb[k].compareTo(lb[minIndex]) > 0) {

            tmp = lb[minIndex].getScore();

            lb[minIndex] = lb[k];

            lb[k].score = tmp;

            sink(minIndex);

        }

    }


    public void sort() {


        //TODO: Sort the heap from Big to Small
        //Hint: A min-heap is sorted from small to big
        for (int i = 1; i < heap_size; i++) {
            for(int j = i ; j > 0 ; j--){
                if(lb[j].compareTo(lb[j-1]) > 0){
                    Score temp = new Score(lb[j].uid, lb[j].score);
                    lb[j].score = lb[j-1].score;
                    lb[j].uid = lb[j-1].uid;
                    lb[j-1].score = temp.score;
                    lb[j-1].uid = temp.uid;
   //                 temp = lb;
   //                 lb[j] = lb[j-1];
   //                 lb = temp;
                }
            }
        }
    }

    /**
     * Insert:
     * The function adds the new key at the end of the array,
     * increases the size of the heap,
     * if the heap size reaches the capacity and the new key is larger than the minimum of the current heap,
     * remove the minimum of the heap and insert the new key at the end of the heap.
     * Finally, swim up through the heap with the inserted key to restore the heap
     * @param: s is the new key (Score) added
     */
    public void insert(Score s) {
        //TODO: Implement the insert function
        // Score tmp = new Score(s.uid, s.score);

        if (capacity == heap_size)
        {
            //heap_size--;
            //capacity++;

            Score temp = delMin();
            return;
        }


        heap_size++;
        int i = heap_size - 1;
        lb[i] = new Score(s.uid, s.score);
        capacity--;

        //swim(i);
        // Fix the min heap property if it is violated
    }


    /**
     * delMin:
     * The function removes the minimum item from the root of the heap,
     * put the item from the end of the heap on top,
     * decrease the size of the heap,
     * and sink down through the heap with the key to restore the heap condition
     * @return: The minimum item (Score) of the heap
     */
    public Score delMin() {
        if (heap_size <= 0)
            return null;
        if (heap_size == 1){
            return lb[0];
        } else {
            sink(heap_size);
            return lb[0];
        }
        // Store the minimum value and remote it from heap
    }


    public String toString() {
        sort();
        String s = "";
        for(int i = 0; i < lb.length; i++) {
            if(lb[i] != null)
                s += lb[i].toString() + "\r\n";
        }
        return s;
    }

}
