// Given two strings s and t, determine if they are isomorphic.
//Two strings s and t are isomorphic if the characters in s can be replaced to get t.
// Here we are using a hashmap to map characters from s to t and
// a hashset to ensure that no two characters from s map to the same character in t.
// Time Complexity: O(n) where n is the length of the strings.
// Space Complexity: O(1)
class Solution {
    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        HashMap <Character, Character> hashmap = new HashMap();
        HashSet <Character> hashSet = new HashSet();

        for (int i =0; i<= s.length()-1; i++) {

            if (!hashmap.containsKey(s.charAt(i))) {
                hashmap.put(s.charAt(i), t.charAt(i));

                if (hashSet.contains(t.charAt(i))) return false;
                hashSet.add(t.charAt(i));
            } else {
                if (hashmap.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            }
        }

        return true;

    }
}