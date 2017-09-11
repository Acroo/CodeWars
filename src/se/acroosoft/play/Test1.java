package se.acroosoft.play;

public class Test1 {
    public Test1()
    {
        System.out.println();
    }

    public String tellMe(int par_i)
    {
        String ret = "";
        for (int i = 0; i < par_i; i++) {
            ret += i + ",";

        }
        return ret;
    }
}
