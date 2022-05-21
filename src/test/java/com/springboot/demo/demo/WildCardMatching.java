package com.springboot.demo.demo;

public class WildCardMatching {
    public static void main(String[] args) {
        System.out.println();
        Long l = System.currentTimeMillis();
        System.out.println(isMatch("bbaaaabaaaaabbabbabbabbababaabababaabbabaaabbaababababbabaabbabbbbbbaaaaaabaabbbbbabbbbabbabababaaaaa",
                "******aa*bbb*aa*a*bb*ab***bbba*a*babaab*b*aa*a****"));

        Long l2 = System.currentTimeMillis();
        System.out.println("time taken=" + (l2 - l));
    }

    public static boolean isMatch(String s, String p) {
        return findMatch(s, p, 0, 0);

    }

    static int i = 0;

    public static boolean findMatch(String s, String p, int indexS, int indexP) {
        if (indexP >= p.length() && indexS >= s.length()) {
            return true;
        }

        System.out.println(i++);
        boolean match = false;
        if (indexP < p.length() && indexS < s.length()) {
            if (p.charAt(p.length() - 1) != '*') {
                if (!(p.charAt(p.length() - 1) == '?' || s.charAt(s.length() - 1) == p.charAt(p.length() - 1))) {
                    return false;
                }
            }
            if (p.charAt(indexP) == '?' || s.charAt(indexS) == p.charAt(indexP)) {
                match = findMatch(s, p, indexS + 1, indexP + 1);
            } else if (p.charAt(indexP) == '*') {
                if (indexP + 1 < p.length()) {
                    if (p.charAt(indexP + 1) == '*')
                        match = findMatch(s, p, indexS, indexP + 1);
                    else if (p.charAt(indexP + 1) == '?') {
                       String p1 = p.substring(0, indexP + 1)
                                + "*"
                                + p.substring(indexP + 2);
                        match = findMatch(s, p1, indexS+1, indexP + 1);
                    } else {
                        while(indexS>=0 && s.substring(indexS).indexOf(p.charAt(indexP + 1))!=-1){
                            match= findMatch(s.substring(indexS), p, s.substring(indexS).indexOf(p.charAt(indexP + 1)), indexP + 1);


                            if(match){
                                break;
                                 /* if(s.charAt(indexS)==s.charAt(indexS+1)){
                                indexS=s.indexOf(p.charAt(indexP + 1))+1;
                                continue;
                            }*/

                            }

                            s= s.substring(indexS+1);
                            indexS=s.indexOf(p.charAt(indexP + 1));

                        }
                    }
                }else {
                    match=true;
                }
            }
        } else if (indexP < p.length() && p.charAt(indexP) == '*') {
            match = findMatch(s, p, indexS, indexP + 1);
        }
        return match;
    }


}
