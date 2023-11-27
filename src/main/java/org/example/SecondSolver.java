package org.example;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SecondSolver {
    public static void solve() throws IOException {
        List<String> text = FileUtils.readLines(new File("text_2.txt"), "utf-8");
        List<Integer> sums = new ArrayList<>();

        for (String row: text) {
            String[] words = row.split(",");

            int sum = 0;

            for (String word: words) {
                sum += Integer.parseInt(word);
            }
            sums.add(Integer.valueOf(sum + ""));
        }

        FileUtils.writeLines(new File("text_2_result.txt"), sums);
    }
}
