// Given an array of strings, return all groups of strings that are anagrams.
// Note: All inputs will be in lower-case.
public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> result = new ArrayList<String>();
        if(strs == null || strs.length == 0) return result;
        
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for(int i=0; i<strs.length; i++){
            char[] charArr = strs[i].toCharArray();
            Arrays.sort(charArr);
            String str = new String(charArr);
            
            if(map.containsKey(str)){
                map.get(str).add(strs[i]);
            } else {
                ArrayList<String> list = new ArrayList<String>();
                list.add(strs[i]);
                map.put(str,list);
            }
        }
        
        Iterator iter = map.values().iterator();
        while(iter.hasNext()){
            ArrayList<String> item = (ArrayList<String>)iter.next();
            if(item.size()>1) result.addAll(item);
        }
        
        return result;
    }
}