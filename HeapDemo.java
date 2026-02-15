public class HeapDemo {

    public static void main(String[] args) {
        WordFreq[] arr = {
            new WordFreq("happy", 400),
            new WordFreq("satisfied", 100),
            new WordFreq("neutral", 300),
            new WordFreq("would buy again", 200),
            new WordFreq("terrible", 160),
            new WordFreq("inconvenient", 900),
            new WordFreq("difficult to use", 100),
            new WordFreq("easy to use", 140),
            new WordFreq("would recommend to friends", 800),
            new WordFreq("visit the store", 700)
        };
        
        System.out.println("Initial array:");
        for (WordFreq wf : arr) {
            System.out.println(wf);
        }

        buildMaxHeap(arr);

        System.out.println("\nMax-heap array:");
        for (WordFreq wf : arr) {
            System.out.println(wf);
        }
    }
    
    public static void maxHeapify(WordFreq[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left].frequency > arr[largest].frequency) {
            largest = left;
        }

        if (right < n && arr[right].frequency > arr[largest].frequency) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            maxHeapify(arr, n, largest);
        }
    }

    public static void swap(WordFreq[] arr, int i, int j) {
        WordFreq temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void buildMaxHeap(WordFreq[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(arr, n, i);
        }
    }
}
