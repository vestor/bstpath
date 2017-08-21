import model.Tree;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        //Init Data
         String initString = "17, 8, 25, 4, 12, 21, 29, 2, 6, 10, 14, 19, 23, 27, 31, 1, 3, 5, 7, 9, 11, 13, 16, 30, 32, 15, 18, 20, 22, 24, 26, 28, 33";
        List<String> strings = Arrays.asList(initString.split(", "));
        List<Integer> integers = strings.stream().map(Integer::parseInt).collect(Collectors.toList());
        Tree tree = new Tree(integers.toArray(new Integer[integers.size()]));
        tree.printPath(1,7);


    }
}
