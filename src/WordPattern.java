// Given a pattern and a string s, find if s follows the same pattern.
// Each letter in pattern maps to exactly one unique word in s.
// For example, pattern = "abba", s = "dog cat cat dog" should return true.

// Here we are using 2 hashmaps to map characters from pattern to words in s and vice versa.
// Time Complexity: O(n) where n is the number of words in s.
// Space Complexity: O(1)
class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> hashMap1 = new HashMap();
        HashMap<String, Character> hashMap2 = new HashMap();

        String[] splitArray = s.split(" ");

        if (pattern.length() != splitArray.length) {
            return false;
        }
        for (int i = 0; i<= pattern.length() - 1 ; i++) {
            if (hashMap1.containsKey(pattern.charAt(i))) {
                if (!hashMap1.get(pattern.charAt(i)).equals(splitArray[i])) {
                    return false;
                }
            } else {
                hashMap1.put(pattern.charAt(i), splitArray[i]);
            }
        }

        for (int j = 0; j<= splitArray.length - 1; j++) {
            if (hashMap2.containsKey(splitArray[j])) {
                if (!hashMap2.get(splitArray[j]).equals(pattern.charAt(j))) {
                    return false;
                }
            } else {
                hashMap2.put(splitArray[j], pattern.charAt(j));
            }
        }
        return true;
    }
}