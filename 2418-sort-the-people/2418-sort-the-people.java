import java.util.*;

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        // Store heights as keys mapped to names, sorted in descending order
        Map<Integer, String> map = new TreeMap<>(Collections.reverseOrder());
        
        for (int i = 0; i < n; i++) {
            map.put(heights[i], names[i]);
        }

        String[] result = new String[n];
        int index = 0;
        for (String name : map.values()) {
            result[index++] = name;
        }

        return result;
    }
}