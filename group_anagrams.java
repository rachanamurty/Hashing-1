// This solution creats groups of anagrams from a given array of Strings by calculating value for each string in two ways: 
// either by multiplying each character's value mapped to a prime number as product of primes is unique 
// or by creating an array which tracks frequency of each character in a string and concats that as a string
// Time complexity: in both scenarios the time complexity is O(n*k) where n is the number of words and k is the number of charactersin each string
// Space complexity: O(n) where n is the number of words and they are stored in a map

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Double, List<String>> map = new HashMap<>();

        for(String str: strs){
            double value = getValue2(str);
            if(map.containsKey(value)) {
                map.get(value).add(str);
            }
            else{
                List<String> r = new ArrayList<>();
                r.add(str);
                map.put(value, r);
            }
        }
        return new ArrayList<>(map.values());
    }

    private String getValue(String s){
        int[] values = new int[26];
        for(char c: s.toCharArray()) {
            values[c - 'a'] = values[c - 'a'] + 1;
        }
        return Arrays.toString(values);
    }

    private double getValue2(String s){
        int[] primes = {2, 3, 5, 7, 9, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        double value = 1.0;
        for(char c: s.toCharArray()){
            value = value * primes[c - 'a'];
        }
        return value;
    }

    // public static void main(String[] args){
    //     String[] strs = {"eat","tea","tan","ate","nat","bat"};
    //     List<List<String>> groups = groupAnagrams(strs);
    //     System.out.println(groups);
    // }
}
