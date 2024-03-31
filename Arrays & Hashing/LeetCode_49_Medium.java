class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();

        if(strs.length == 0){
            return new ArrayList();
        }

        for (String str: strs){
            int count[] = new int[26];
            Arrays.fill(count, 0);
            
            for(int i=0; i<str.length(); i++){
                count[str.charAt(i) - 'a'] += 1;
            }

            StringBuilder sb = new StringBuilder();
            for(int i=0; i<count.length; i++){
                sb.append("#");
                sb.append(count[i]);
            }

            String key = sb.toString();

            if(!map.containsKey(key)){
                map.put(key, new ArrayList());

            }
            map.get(key).add(str);
        }

        return new ArrayList(map.values());
        
    }
}
