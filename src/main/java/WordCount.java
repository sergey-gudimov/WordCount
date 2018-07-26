import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class WordCount {
    public static void main(String[] args) {
        try {
            String filePath = args.length >= 1 ? args[0] : ".\\src\\main\\resources\\input.txt";
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            Map<String, Long> countWordMap = bufferedReader.lines()
                    .map(l -> l.split("\\W+"))
                    .flatMap(Arrays::stream)
                    .collect(groupingBy(identity(), counting()));
            countWordMap
                    .entrySet()
                    .stream()
                    .forEach(entry -> System.out.println(entry.getValue() + " " + entry.getKey()));

        } catch (
                FileNotFoundException e)

        {
            e.printStackTrace();
        }

    }
}
