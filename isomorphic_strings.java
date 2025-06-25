// In this solution, we determine if the given two strings are isomorphic by using two hashmaps to establish two-way mapping
// While iterating, for each character, we check if mapping exists in both the maps and verify if the current mapping does not contradict previous mappings
// Time complexity: O(n) <-- linear time complexity as we are iterating over each letter of the two strings only once
// Space complexity: O(1) <-- two hashmaps occupy space but at max they would each hold 26 mappings and therefore, we have constant usage of space


class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() == 0 && t.length() == 0){
            return true;
        }

        if(s.length()!=t.length()){
            return false;
        }
        // Holds mapping of first strings' letters to second string's leters
        Map<Character, Character> firstMapping = new HashMap<>();
        // Holds mapping of second string's letters to first string's leters
        Map<Character, Character> secondMapping = new HashMap<>();

        int i = 0;
        while(i<s.length()){
            char schar = s.charAt(i);
            char tchar = t.charAt(i);
            // Check if first map has character in s string
            if(firstMapping.containsKey(schar)){
                if(tchar != firstMapping.get(schar)){
                    return false;
                }
            }
            else{
                firstMapping.put(schar, tchar);
            }
            // Check if second map has character in t string
            if(secondMapping.containsKey(tchar)){
                if(schar != secondMapping.get(tchar)){
                    return false;
                }
            }
            else{
                secondMapping.put(tchar, schar);
            }
            i++;
        }
        return true;
    }
}
