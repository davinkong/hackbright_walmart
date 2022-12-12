package Part3;

/**
 * Choose one of the following to implement: Insertion Sort Quick Sort Merge Sort
 *
 * What sorting algorithms have the best runtime efficiency? What are the scenarios
 * for the best case, worst case, and average case runtime efficiency?
 */
public class Sorting {
    public static void main(String[] args) {
        int[] arr = {20, 35, -15, 7, 55, 1, -22};
        insertionSort(arr);
        for(int i: arr){
            System.out.println(i);
        }

    }
    static void insertionSort(int[] inputArr){ //O(n^2)

        for (int j = 0; j < inputArr.length; j++) {
            int temp = inputArr[j];
            int i = j -1;
            while ((i>-1) && (inputArr[i]>temp)){
                inputArr[i+1] = inputArr[i];
                i--;
            }
            inputArr[i+1] = temp;

        }



    }
}
