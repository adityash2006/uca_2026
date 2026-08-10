// package JAVA.Base64;

public class Base64encoding {
   public static String encoding(String a) {
    if (a.equals("")) return "";

    char[] map = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"
                    .toCharArray();

    StringBuilder ans = new StringBuilder();

    for (int i = 0; i < a.length(); i += 3) {

        int first = a.charAt(i);
        int second = (i + 1 < a.length()) ? a.charAt(i + 1) : 0;
        int third = (i + 2 < a.length()) ? a.charAt(i + 2) : 0;

        int value1 = first >> 2;
        int value2 = ((first & 3) << 4) | (second >> 4);
        int value3 = ((second & 15) << 2) | (third >> 6);
        int value4 = third & 63;

        ans.append(map[value1]);
        ans.append(map[value2]);

        if (i + 1 < a.length())
            ans.append(map[value3]);
        else
            ans.append('=');

        if (i + 2 < a.length())
            ans.append(map[value4]);
        else
            ans.append('=');
    }

    return ans.toString();
}
   public static String decoding(String a) {
    if (a.equals("")) return "";

    String map = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
    StringBuilder ans = new StringBuilder();

    for (int i = 0; i < a.length(); i += 4) {

        char c1 = a.charAt(i);
        char c2 = a.charAt(i + 1);
        char c3 = a.charAt(i + 2);
        char c4 = a.charAt(i + 3);

        int value1 = map.indexOf(c1);
        int value2 = map.indexOf(c2);

        int value3 = (c3 == '=') ? 0 : map.indexOf(c3);
        int value4 = (c4 == '=') ? 0 : map.indexOf(c4);

        int first = (value1 << 2) | (value2 >> 4);
        int second = ((value2 & 15) << 4) | (value3 >> 2);
        int third = ((value3 & 3) << 6) | value4;

        ans.append((char) first);

        if (c3 != '=')
            ans.append((char) second);

        if (c4 != '=')
            ans.append((char) third);
    }

    return ans.toString();
}    
public static void main(String[] args) {
        System.out.println(encoding("Man"));
        System.out.println(decoding("TWFu"));
    }
}
