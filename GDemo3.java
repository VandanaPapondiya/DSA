import java.util.*;

class GDemo3 {
    public static void main(String[] args) {

        String s1 = "aabbddffggc";
        String t = "abc";

        int left = 0, right = 0;
        int count = 0;
        int minLength = Integer.MAX_VALUE;
        int start = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        // Step 1: Frequency map of t
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Step 2: Sliding window
        while (right < s1.length()) {
            char c = s1.charAt(right);

            if (map.containsKey(c)) {
                if (map.get(c) > 0) {
                    count++;
                }
                map.put(c, map.get(c) - 1);
            }

            // Step 3: Try to shrink window
            while (count == t.length()) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }

                char leftChar = s1.charAt(left);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    if (map.get(leftChar) > 0) {
                        count--;
                    }
                }
                left++;
            }
            right++;
        }

        if (minLength == Integer.MAX_VALUE) {
            System.out.println("No window found");
        } else {
            System.out.println("Minimum Window: " + s1.substring(start, start + minLength));
        }
    }
}
