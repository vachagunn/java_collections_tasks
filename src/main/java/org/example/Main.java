package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // FirstSolver.solve();
        // SecondSolver.solve();
        // ThirdSolver.solver();

        // Четвертая задача
        List<Map<String, Object>> items = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(new File("text_4.json"));
        int sumSalary = 0;

        for (int i = 0; i < node.size(); i++) {
            Map<String, Object> item = new HashMap<>();
            JsonNode obj = node.get(i);

            int salary = obj.get("salary").asInt();
            sumSalary += salary;

            int age = obj.get("age").asInt();
            if (age < 20) continue;

            item.put("number", obj.get("number"));
            item.put("firstname", obj.get("firstname"));
            item.put("name", obj.get("name"));
            item.put("age", age);
            item.put("salary", salary);
            items.add(item);
        }

        double avgSalary = (double) sumSalary / node.size();
        System.out.println(avgSalary);

        System.out.println("before: " + items.size());

        Iterator<Map<String, Object>> iterator = items.iterator();
        while (iterator.hasNext()) {
            Map<String, Object> item = iterator.next();
            if ((Integer)(item.get("salary")) < avgSalary) iterator.remove();
        }
        System.out.println("after: " + items.size());

        FileUtils.write(new File("text_4_result.json"), mapper.writerWithDefaultPrettyPrinter().writeValueAsString(items));

    }
}