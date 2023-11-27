package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class FirstSolver {
    public static void solve() throws IOException {
        List<String> text = FileUtils.readLines(new File("text_1.txt"), "utf-8");
        Map<String, Integer> freq = new HashMap<>();

        System.out.println(text);
        System.out.println(text.size());

        for (String row: text) {
            String[] words = row.replaceAll("[!?\\.,]", " ").split(" ");

            for (String word: words) {
                freq.compute(word, (k, v) -> (v == null) ? 1 : v + 1);
// посчитать частоту слов можно еще так
//                if (!freq.containsKey(word)) {
//                    freq.put(word, 1);
//                } else {
//                    freq.put(word, freq.get(word) + 1);
//                }
            }

            System.out.println(Arrays.toString(words));
        }

        for (Map.Entry<String, Integer> entry: freq.entrySet()) { // Возвращает множество пар
            System.out.printf("%15s:%5d\n", entry.getKey(), entry.getValue());
        }

        List<Map.Entry<String, Integer>> set = new ArrayList<>(freq.entrySet());
        set.sort(Comparator.comparingInt(Map.Entry::getValue));

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(set);
        FileUtils.write(new File("text_1_result.json"), json, "utf-8");
    }
}
