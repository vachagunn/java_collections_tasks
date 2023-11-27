package org.example;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ThirdSolver {
    public static void solver() throws IOException {
        List<String> text = FileUtils.readLines(new File("text_3.txt"), "utf-8");
        List<List<Double>> result = new ArrayList<>();

        int s = 0;
        for (String row: text) {
            String[] words = row.split(",");
            List<Double> nums = new ArrayList<>();

            for (int i = 0; i < words.length; i++) {
                if (words[i].equals("NA")) {
                    nums.add((nums.get(i - 1) + Double.parseDouble(words[i + 1])) / 2);
                } else {
                    nums.add(Double.parseDouble(words[i]));
                }
                s++;
            }

            System.out.println(nums);

            result.add(nums);
        }
        System.out.println("before: " + s);
        s = 0;

        for (List<Double> row: result) {
            Iterator<Double> iterator = row.iterator();

            while (iterator.hasNext()) {    // пока есть элементы
                double current = iterator.next();
                if (Math.sqrt(current) < 50) iterator.remove();
            }

            s += row.size();
        }

        System.out.println("after: " + s);

        FileUtils.writeLines(new File("text_3_result.txt"), result);
    }
}
