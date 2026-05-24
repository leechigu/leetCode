import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {


        int left = 0;
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        int length = 0;

        for(int right = 0;right<s.length();right++){

            char cur = s.charAt(right);
            length++;
            if(set.contains(cur)){
                while(true){
                    char leftC = s.charAt(left);
                    left++;
                    length--;
                    if(leftC==cur){
                        break;
                    }else{
                        set.remove(leftC);
                    }
                }
            }else{
                set.add(cur);
                maxLength = Math.max(length,maxLength);
            }

        }
        return maxLength;

    }
}
