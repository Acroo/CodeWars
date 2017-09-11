package se.acroosoft;

import java.util.StringTokenizer;

public class JadenCase {
    public String toJadenCase(String phrase) {
        String ret = null;
        if(phrase != null && !phrase.isEmpty())
        {
            StringTokenizer st = new StringTokenizer(phrase, " ");
            ret = "";
            while (st.hasMoreTokens())
            {
                String str = st.nextToken();
                if(!ret.equals("")) ret += " ";
                ret += (str.substring(0,1)).toUpperCase();
                ret += str.substring(1);

            }
        }

        return ret;
    }
}
