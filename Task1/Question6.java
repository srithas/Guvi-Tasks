// Question 6
// Purpose: Write a nested loop to print the pattern 

class NestedLoops{
    public static void main(String[] args){
        // Set the number for the pattern
        int n = 5;

        // Use 3 for loops i, j, k, responsible for creating num of rows, decreasing order of num, and adding last nums
        for (int i = 0; i < n; i++){
            for (int j = n; j >= n - i; j--){
                System.out.print(j);
            }
            for (int k = 0; k < n - i - 1; k++){
                    System.out.print(n - i);
                }
            System.out.println();
                    
        }
    }
}
