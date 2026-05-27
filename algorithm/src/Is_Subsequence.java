import java.util.HashMap;
import java.util.Map;

class Is_Subsequence {
    public boolean isSubsequence(String s, String t) {
        int a = 0;

        if(s.length()==0){
            return true;
        }

        char x = s.charAt(a);

        for(int b=0;b<t.length() && a < s.length();b++){
            char y = t.charAt(b);
            if(x==y){
                a++;
                if(a==s.length())
                    break;
                x = s.charAt(a);
            }
        }
        return a==s.length();
    }
}