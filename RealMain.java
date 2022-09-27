package matrixsearch;
public class RealMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] matrixArray = {{1, 2, 3, 4},
        {5, 6, 7, 8}, 
        {9, 10, 11, 12}};

        int target = 7;

        FindElement(matrixArray, target);

    }

    public static void FindElement(int[][] matrix, int target){
        //First, find which matrix it is in


        //We will find target at matrix[i][j]
        int i = 0;
        int j = 0;

        int min = 0;
        int max = matrix.length - 1;

        boolean found = false;

        while (!found){
            int mid = GetMid(min, max);

            int length = matrix[mid].length;
            int low = matrix[mid][0];
            int high = matrix[mid][length-1];

            if (low <= target && target <= high){
                found = true;
                i = mid;
            } else if (target < low){
                //min = min; min stays the same
                max = mid;
            } else if (target > max){
                min = mid;
                //max = max; max stays the same
            }

        }


        min = 0;
        max = matrix[i].length;

        found = false;
        while (!found){
            int mid = GetMid(min, max);

            int midVal = matrix[i][mid];

            if (midVal == target){
                found = true;
                j = mid;
            } else if (target < midVal){
                max = mid;
            } else if (max < midVal){
                min = mid;
            }

        }


        System.out.println("["+i+","+j+"]");


    }

    public static int GetMid(int min, int max){
        int diff = max - min;
        int mid = min + diff/2;
        return mid;
    }


}
