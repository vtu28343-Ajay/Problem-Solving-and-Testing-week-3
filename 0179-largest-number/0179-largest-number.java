import java.util.Arrays;

class Solution {
    public String largestNumber(int[] nums) {
        // Convert integer array to String array
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        // Custom comparator: compare (b + a) with (a + b)
        Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));

        // Edge case: if the largest number is "0", the result is "0" (e.g., [0, 0])
        if (strs[0].equals("0")) {
            return "0";
        }

        // Build the result string
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }

        return sb.toString();
    }
}