package se.acroosoft.play.adventofcode;

import java.util.*;

public class Twelv {
    //Map<String, String> m_rules = new HashMap<String, String>();
    Properties m_rules = new Properties();
    String init;
    String org;
    int start;
    boolean count = false;
    int generations = 0;

    public Twelv(String par_initValue, String par_rules) {
        //System.out.println("Inital String: " + par_initValue);
        init = par_initValue;
        org = par_initValue;
        String[] rules = par_rules.split("\n");
        for(String rule : rules) {
            m_rules.setProperty(rule.substring(0,rule.indexOf("=")).trim(),rule.substring(rule.indexOf(">")+1).trim());
        }
    }

    public int solution() {
        for (int i = 0; i < 20; i++) {
            if(count) {
                generations++;
            }
            String last = "....." + init + ".....";
            String next = "";
            start+=3;
            for (int j = 2; j < last.length() - 2; j++) {
                next += m_rules.getProperty(last.substring(j-2,j+3),".");
            }
             init = next;
        }
        int totalPots = 0;
        String s = init;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '#'){
                totalPots += i-start;
            }
        }
        return totalPots;
    }

    public long solution2(){

        int last = 0;
        int diff = 0;
        long sum = 0L;
        count = true;
        for (int i = 0; i < 8; i++) {
            sum = solution();
        }
        count = false;
        for (int i = 0; i < 10; i++) {
            int next = solution();
            diff = next - last;
            //System.out.println("Diff:" + diff);
            last = next;
        }

        //System.out.println("Generations: " + generations);
        //System.out.println("Sum:" + sum);
        //System.out.println("Last:" + last);
        //System.out.println("Diff:" + diff);
        sum += ((50_000_000_000L - generations) / 20) * diff;
        return sum;
    }

}
