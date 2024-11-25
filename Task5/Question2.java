// Question 2
// Purpose: Check whether the Strings in a list are empty or not 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class NonEmpty{
    public static void main(String[] args) {
        // List of strings
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");

        // A list to store non-empty strings
        List<String> nonEmptyStrings = new ArrayList<>();

        // Using for loop to iterate through list and check if string is empty or not 
        for (String str : strings) {
            if (!str.isEmpty()) { 
                nonEmptyStrings.add(str);
            }
        }

        System.out.println(nonEmptyStrings);
    }
}
