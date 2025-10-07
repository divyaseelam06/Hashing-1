//Given an array of strings strs, group the anagrams together.
// You can return the answer in any order.

// Using a hashmap to group anagrams by their sorted character representation.
// Time Complexity: O(n * k log k) where n is the number of strings and k is the maximum length of a string.
// Space Complexity: O(n)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> hashmap = new HashMap();

        for (String s: strs) {
            char[] str = s.toCharArray();
            Arrays.sort(str);

            // Sort the characters of the string to form the key
            String sortedString = String.valueOf(str);

            // If the sorted string is not in the hashmap, add it with a new list
            if (!hashmap.containsKey(sortedString)) {
                ArrayList<String> list = new ArrayList();
                list.add(s);
                hashmap.put(sortedString, list);
            } else {
                // If the sorted string is already in the hashmap, append the original string to the existing list
                List<String> anagramList = hashmap.get(sortedString);
                anagramList.add(s);
            }
        }
        return new ArrayList(hashmap.values());
    }
}
