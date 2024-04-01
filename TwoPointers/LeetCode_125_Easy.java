class Solution {
    public boolean isPalindrome(String s) {
        // Remove the special char and numbers from the string
        s = s.replaceAll("[^a-zA-Z0-9]", "");

        // Convert uppercase to lowercase
        s = s.toLowerCase();

        // Use 2-ptr to compare
        int l=0, r=s.length()-1;
        while(l <= r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
