import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Test {

    public static void main(String[] args) {

        String csvFile = "C:\\APP\\JetBrains\\workspace\\SpringExample\\src\\test\\resources\\keywords.csv"; // ÎÄ¼þÂ·¾¶
        String line;
        String csvSplitBy = ",";

        Map<String, Integer> keywordCountMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(csvFile), StandardCharsets.UTF_8))) {
            while ((line = reader.readLine()) != null) {
                String[] keywords = line.split(csvSplitBy);

                for (String keyword : keywords) {
                    keywordCountMap.put(keyword, keywordCountMap.getOrDefault(keyword, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Map.Entry<String, Integer>> keywordCountList = new ArrayList<>(keywordCountMap.entrySet());

        List<String> list = new ArrayList<String>();


        Map.Entry.comparingByValue(Comparator.reverseOrder());
//        keywordCountList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        System.out.println("Top 10 keywords:");
        for (int i = 0; i < 10 && i < keywordCountList.size(); i++) {
            Map.Entry<String, Integer> entry = keywordCountList.get(i);
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }
}
