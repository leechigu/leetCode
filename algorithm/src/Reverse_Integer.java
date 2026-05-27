import java.util.HashMap;
import java.util.Map;

class Reverse_Integer {
    public int reverse(int x) {

        long val = x;
        boolean minus = false;
        if(x<0){
            minus = true;
        }

        if(minus){
            val *=-1;
        }

        String str = String.valueOf(val);
        StringBuilder sb = new StringBuilder(str);
        String rev = sb.reverse().toString();

        long revVal = Long.valueOf(rev);
        if(revVal<Integer.MIN_VALUE || revVal>Integer.MAX_VALUE)
            return 0;

        if(minus){
            revVal*=-1;
        }

        return (int)revVal;
    }
}