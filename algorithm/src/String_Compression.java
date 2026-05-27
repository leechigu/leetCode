import java.util.ArrayList;
import java.util.List;

class String_Compression {
    public int compress(char[] chars) {

        char cur = chars[0];
        int cnt = 1;

        StringBuilder sb = new StringBuilder();

        for(int i=1;i<chars.length;i++){
            char next = chars[i];
            if(next==cur){
                cnt++;
            }else{
                sb.append(cur);
                if(cnt>1){
                    sb.append(cnt);
                }
                cur = next;
                cnt = 1;
            }
        }

        sb.append(cur);
        if(cnt>1){
            sb.append(cnt);
        }

        String newStr = sb.toString();

        for (int i = 0; i < newStr.length(); i++) {
            chars[i] = newStr.charAt(i);
        }
        return sb.toString().length();
    }
}