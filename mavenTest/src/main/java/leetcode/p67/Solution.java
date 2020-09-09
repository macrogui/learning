package leetcode.p67;

public class Solution {
    public String addBinary(String a, String b) {
        int needAdd = 0;
        StringBuilder ret = new StringBuilder();
        while(a.length()!=0||b.length()!=0){
            int lastA = 0;
            int lastB = 0;
            if (a.length()!=0)
                lastA = Integer.parseInt(a.substring(a.length()-1));
            if (b.length()!=0)
                lastB = Integer.parseInt(b.substring(b.length()-1));
            if (lastA+lastB+needAdd == 0){
                ret.insert(0, 0);
                needAdd = 0;
            }
            else if (lastA+lastB+needAdd == 1){
                ret.insert(0, 1);
                needAdd = 0;
            }
            else if (lastA+lastB+needAdd == 2){
                ret.insert(0, 0);
                needAdd = 1;
            }
            else if (lastA+lastB+needAdd == 3){
                ret.insert(0, 1);
                needAdd = 1;
            }
            a = a.substring(0, Math.max(a.length() - 1, 0));
            b = b.substring(0, Math.max(b.length() - 1, 0));
        }
        if (needAdd == 1){
            ret.insert(0, 1);
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addBinary("11", "1"));
    }
}
