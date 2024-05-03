/*
Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.

Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.
*/
class Solution {
    public int characterReplacement(String s, int k) {
        int charArray[] = new int[26];
        int windowLength = 0;
        int maxFreq = 0;
        int leftIndex = 0;
        for(int rightIndex=0; rightIndex < s.length(); rightIndex++){
            charArray[s.charAt(rightIndex) - 'A']++;
            maxFreq = Math.max(maxFreq, charArray[s.charAt(rightIndex) - 'A']);
            while((rightIndex - leftIndex + 1) - maxFreq > k ){
                // Window is out of range
                charArray[s.charAt(leftIndex) - 'A']--;
                leftIndex++;

            }
            windowLength = Math.max(windowLength, rightIndex - leftIndex + 1);
        }
        return windowLength;
        
    }
}
