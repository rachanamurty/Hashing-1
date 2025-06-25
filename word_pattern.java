// We need to check if given pattern is isomorphic to the given string of words
// Similar to isomorphic solution, we make use of two hashmaps to map the pattern's characters to the words given in the string
// We use two maps to  check two way mapping
// time Complexity: O(n*k) to split the string to words and then O(n) to compare 
// Space Complexity : For array of words - O(n) rest is O(1) so overall O(n)

class Solution {
    public boolean wordPattern(String pattern, String s) {
        if(pattern == null || pattern.length() == 0 || s == null || 
        s.length() == 0){
            return false;
        }
        String[] words = s.split(" ");
        Map<Character, String> firstMapping = new HashMap<>();
        Map<String, Character> secondMapping = new HashMap<>();
        
        if(words.length != pattern.length()){
            return false;
        }

        for(int i=0;i<pattern.length();i++){
            char c = pattern.charAt(i);
            String word = words[i];
            if(firstMapping.containsKey(c)){
                if(!firstMapping.get(c).equals(word)){
                    return false;
                }
            }
            else{
                firstMapping.put(c, word);
            }

            if(secondMapping.containsKey(word)){
                if(secondMapping.get(word) != c){
                    return false;
                }
            }
            else{
                secondMapping.put(word, c);
            }
        }
        return true;
    }
}
