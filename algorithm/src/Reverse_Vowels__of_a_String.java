import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Reverse_Vowels__of_a_String {
    public String reverseVowels(String s) {

        StringBuilder sb = new StringBuilder();

        List<Character> a = new ArrayList<>();

        List<Character> ahdma = new ArrayList<>();
        ahdma.add('a');
        ahdma.add('e');
        ahdma.add('i');
        ahdma.add('o');
        ahdma.add('u');
        ahdma.add('A');
        ahdma.add('E');
        ahdma.add('I');
        ahdma.add('O');
        ahdma.add('U');

        for(int i=0;i<s.length();i++){
            char cur = s.charAt(i);
            if(ahdma.contains(cur)){
                a.add(cur);
            }
        }
        a = a.reversed();


        int indx = 0;
        for(int i=0;i<s.length();i++){
            char cur = s.charAt(i);
            if(ahdma.contains(cur)){
                sb.append(a.get(indx));
                indx++;
            }else{
                sb.append(cur);
            }
        }
        return sb.toString();
    }
}