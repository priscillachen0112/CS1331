public class selectionSort {
    public static void main(String[] args) {
        selectionSort([3,4,2,5]);
    }

    public static void selectionSort(int[] list) {
        int minIndex = 0;
        int nextSmallest = 0;

        for (int unsortedStart=0; unsortedStart<list.length-1; unsortedStart++) {
            minIndex = unsortedStart;
            for (int currentIndex=unsortedStart+1; currentIndex<list.length; currentIndex++) {
                if (list[currentIndex] < list[minIndex]) {
                        minIndex = currentIndex;
                }
            }

            nextSmallest = list[minIndex];
            list[minIndex] = list[unsortedStart];
            list[unsortedStart] = nextSmallest;
        }
    }

    public static void insertionSort(int[] list) {
        for (int unsortedStart = 1; unsortedStart <= list.length, unsortedStart++) {
            int nextInsert = list[unsortedStart];
            int currentIndex = unsortedStart - 1;

            while (currentIndex >= 0 && nextInsert < list[currentIndex]) {
                list[currentIndex+1] = list[currentIndex];
                currentIndex--;
            }
            list[currentIndex+1] = nextInsert;
        }
    }
}