package se.acroosoft.play.adventofcode;

import java.util.*;

public class Twelv {
    //Map<String, String> m_rules = new HashMap<String, String>();
    Properties m_rules = new Properties();
    String init;
    String org;
    int start;

    public Twelv(String par_initValue, String par_rules) {
        System.out.println("Inital String: " + par_initValue);
        init = par_initValue;
        org = par_initValue;
        String[] rules = par_rules.split("\n");
        for(String rule : rules) {
            m_rules.setProperty(rule.substring(0,rule.indexOf("=")).trim(),rule.substring(rule.indexOf(">")+1).trim());
        }
    }

    public int solution() {
        for (int i = 0; i < 20; i++) {
            String last = "....." + init + ".....";
            String next = "";
            start+=3;
            for (int j = 2; j < last.length() - 2; j++) {
                next += m_rules.getProperty(last.substring(j-2,j+3),".");
            }
            //System.out.print(i + ": ");
            //System.out.println(next);
            init = next;
        }
        int totalPots = 0;
        String s = init;
        //System.out.print(s);
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '#'){
                totalPots += i-start;
            }
        }
        //System.out.println(" -> " + totalPots);

        return totalPots;
    }

    public long solution2(){

        int last = 0;
        int diff = 0;
        long sum = 0L;
        for (int i = 0; i < 4; i++) {
            sum = solution();
        }

        for (int i = 0; i < 10; i++) {
            int next = solution();
            diff = next - last;
            System.out.println("Diff:" + diff);
            last = next;
        }

        System.out.println("Sum:" + sum);
        System.out.println("Last:" + last);
        System.out.println("Diff:" + diff);
        sum += ((50_000_000_000L - 100) / 20) * diff;
        return sum;
    }

    private String prepareLine(String newLine) {
        if(!newLine.startsWith("..")){
            newLine = ".." + newLine;
        }
        if(!newLine.endsWith("..")){
            newLine = newLine + "..";
        }
        return newLine;
    }

    private String char2String(char[] par_chars){
        String s = "";
        for (int i = 0; i < par_chars.length; i++) {
            s = s + par_chars[i];
        }
        return s;
    }


    private String prepareFirstLine(String s) {
        return "..." + s + ".................";
    }
}
