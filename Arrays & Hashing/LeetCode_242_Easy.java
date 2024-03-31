class Solution {
    public HashMap<Character, Integer> frequencyOfCharacters(String s){

        HashMap<Character, Integer> freqMap = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            if(freqMap.containsKey(s.charAt(i))){
                freqMap.put(s.charAt(i), freqMap.get(s.charAt(i)) + 1);
            } else {
                freqMap.put(s.charAt(i), 1);
            }
        }

        return freqMap;
    }

    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> freqMap1 = new HashMap<>();
        HashMap<Character, Integer> freqMap2 = new HashMap<>();

        freqMap1 = frequencyOfCharacters(s);
        freqMap2 = frequencyOfCharacters(t);

        return freqMap1.equals(freqMap2);

        
    }
}
