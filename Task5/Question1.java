// Question 1
// Purpose: Convert a list of strings into uppercase

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class UpperCase{
    public static void main(String[] args) {
        // Stream of strings
        Stream<String> names = Stream.of("aBc", "d", "ef");

        // Using map() to convert each string
        List<String> upperCaseNames = names
                .map(String::toUpperCase)
                .collect(Collectors.toList()); 

       
        System.out.println(upperCaseNames);
    }
}
