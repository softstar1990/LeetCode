public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<String>();
        result.add("");
        
        if(digits==null || digits.length()==0) return result;

        for(int i=0;i<digits.length();i++){
            String s = getLetters(digits.charAt(i));
            ArrayList<String> temp = new ArrayList<String>();

            for(int j=0;j<result.size();j++){
                for(int k=0;k<s.length();k++){    
                    temp.add(result.get(j)+Character.toString(s.charAt(k)));
                }
            }
            result = temp;
        }
        return result;
    }

    private String getLetters(char digit){
        switch(digit){
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
            case '0':
                return " ";
            default:
                return "";
        }
    }
}