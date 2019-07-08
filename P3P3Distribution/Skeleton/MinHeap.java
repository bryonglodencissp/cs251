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
    public void swim(int index) {
        //TODO: Implement the swim function
        int parent = (index-1)/2;
        Score bottom = lb[index];

        while (index > 0 && lb[parent].score > bottom.score)
        {
            Score temp = lb[parent];
            lb[parent] = lb[index];
            lb[index] = temp;
            index = parent;
            parent = (parent -1 ) / 2;
        }
        if ( parent == 0 )
            return;
        swim(parent);

    }

    /**
     * Top-down reheapify: sink
     * If the heap order is violated because a node's key becomes larger than one or both of its children's keys,
     * then we can swap the node with the smaller one of its children.
     * Keep sinking until we reach a node with both children larger
     * @param: k is the index of the node to sink in the array
     */
    public void sink(int index) {
        int smallerChild = 0;
        Score top = lb[index];
        while (index < heap_size/2) {
            int leftChild = 2*index+1;
            int rightChild = leftChild+1;


            if (rightChild < heap_size && lb[leftChild].score < lb[rightChild].score)  {
                smallerChild = leftChild;
            }
            else {
                smallerChild = rightChild;
            }

            if (smallerChild >= heap_size)
                break;

            if (lb[smallerChild].score > lb[index].score)
                return;
            Score temp = lb[index];
            lb[index] = lb[smallerChild];
            lb[smallerChild] = temp;
            index = smallerChild;

        }

        if (index == smallerChild)
            return;


        if (heap_size == smallerChild)
            return;


        sink(smallerChild);
    }


    public void heapify(int n, int i) {
        int smallest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && lb[l].score < lb[smallest].score)
            smallest = l;

        if (r < n && lb[r].score < lb[smallest].score)
            smallest = r;

        if (smallest != i) {
            Score temp = lb[i];
            lb[i] = lb[smallest];
            lb[smallest] = temp;
            heapify(n, smallest);
        }
    }

    public void sort() {
        int size = heap_size;

        for (int i = size/2 - 1; i >= 0; i--)
            heapify(size, i);

        for (int i=size-1; i>=0; i--)
        {
            Score x = lb[0];
            lb[0] = lb[i];
            lb[i] = x;
            heapify(i, 0);
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

        Score newScore = new Score(s.uid, s.score);
        if (capacity == heap_size)
        {

            if (newScore.score > lb[0].score) {
                Score delMe = delMin();
                lb[heap_size] = newScore;
                swim(heap_size++);
            }

            return;
        }
        lb[heap_size] = newScore;
        swim(heap_size++);
        return;
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
            heap_size--;
            return lb[0];
        } else {
            Score ret = lb[0];
            lb[0] = null;
            lb[0] = lb[heap_size - 1];
            lb[heap_size - 1] = null;
            heap_size--;
            sink(0);
            return ret;
        }
    }


    public String toString() {
        sort();
        String s = "";
        for(int i = 0; i < lb.length; i++) {
            if(lb[i] != null)
                s += lb[i].toString() + "\n";
        }
        return s;
    }
}
