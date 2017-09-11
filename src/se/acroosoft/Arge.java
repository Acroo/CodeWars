package se.acroosoft;

public class Arge {

    /**
     * At the end of the first year there will be:
     1000 + 1000 * 0.02 + 50 => 1070 inhabitants

     At the end of the 2nd year there will be:
     1070 + 1070 * 0.02 + 50 => 1141 inhabitants (number of inhabitants is an integer)

     At the end of the 3rd year there will be:
     1141 + 1141 * 0.02 + 50 => 1213

     It will need 3 entire years.

     * @param p0
     * @param percent
     * @param aug
     * @param p
     * @return
     */

    public static int nbYear(int p0, double percent, int aug, int p) {
        int years = 0;
        long inhabit = p0;
        while(inhabit < p) {
            inhabit = inhabit + (Math.round(inhabit * (percent / 100))) + aug;
            years++;
        }
        return years;
    }
}
