package se.acroosoft;

public class Persist {
    public static int persistence(long n) {
        int counter = 0;
        String nStr = Long.toString(n);
        while (nStr.length() > 1){
            long total = 1;
            for (int i = 0; i < nStr.length(); i++) {
                total *= Long.parseLong(nStr.charAt(i) + "");
            }
            counter++;
            nStr = Long.toString(total);
        }
        return counter;
    }
}
