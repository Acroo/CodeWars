package se.acroosoft;

import java.util.StringTokenizer;

public class Kata {

    public static String getMiddle(String word) {
        String ret;
        if ((word.length() & 1) == 0) {
            int a = (int) Math.floor(word.length()/2);
            int b = (int) Math.floor(word.length() / 2) + 1;
            ret = word.substring(a -1 ,b);
        }
        else {
            int a = word.length() / 2;
            ret = word.substring(a,a+1);

        }
        return ret;
    }

    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
        // Your code goes here. Have fun!
        while(fighter1.health > 0 && fighter2.health > 0){
            if(fighter1.name.equals(firstAttacker)){
                fighter2.health -= fighter1.damagePerAttack;
                firstAttacker = fighter2.name;
            }
            else {
                fighter1.health -= fighter2.damagePerAttack;
                firstAttacker = fighter1.name;
            }
        }
        return fighter1.health > 0 ? fighter1.name: fighter2.name;
    }

    public static int findShort(String s) {
        StringTokenizer st = new StringTokenizer(s, " ");
        int ret = Integer.MAX_VALUE;
        while(st.hasMoreTokens()){
            String str = st.nextToken();
            if(ret > str.length()) ret = str.length();
        }
        return ret;

    }

    public static String expandedForm(int num)
    {
        String retValue = "";
        String numStr = Integer.toString(num);
        for (int i = 0; i < numStr.length(); i++) {
            if(Integer.valueOf(numStr.charAt(i) + "") >= 1){
                if(!retValue.equals("")){
                    retValue += " + ";
                }
                retValue += numStr.charAt(i);
                for (int j = 0; j < (numStr.length() - 1) - i; j++) {
                    retValue += "0";
                }
            }

        }
        return retValue;
    }
}
