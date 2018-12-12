package se.acroosoft.play.adventofcode;

public class Eleven {

    int[][] m_matrix = new int[300][300];

    public Eleven(int par_serialNumber) {
        //int n = 345;
        //setRackID(m_matrix);;
        calculateCells(par_serialNumber);
        //printMatrix();

    }

    private void calculateCells(int par_serialNumber) {
        for (int i = 1; i < m_matrix.length; i++) {
            for (int j = 1; j < m_matrix[i].length; j++) {
                int cellValue = i + 10;
                cellValue = cellValue * j;
                cellValue = cellValue + par_serialNumber;
                cellValue = cellValue * (i + 10);
                cellValue = (cellValue%1000)/100;
                cellValue = cellValue -5;
                m_matrix[i][j] = cellValue;
            }

        }
    }

    private void printMatrix() {
        for (int i = 1; i < m_matrix.length; i++) {
            for (int j = 1; j < m_matrix[i].length; j++) {
                int n = m_matrix[i][j];
                if(n>=0) {
                    System.out.print(" " + n + "|");
                }
                else {
                    System.out.print(n + "|");
                }
            }
            System.out.println("");

        }
    }

    private void setRackID(int[][] par_matrix) {
        for (int i = 1; i < par_matrix.length; i++) {
            for (int j = 1; j < par_matrix[i].length; j++) {
                par_matrix[i][j] = i + 10;
            }

        }
    }

    public String solution() {
        int max = 0;
        String result = "x,y";
        for (int i = 1; i < m_matrix.length - 3; i++) {
            for (int j = 0; j < m_matrix[i].length - 3; j++) {
                int sum = m_matrix[i][j] + m_matrix[i][j+1] + m_matrix[i][j+2];
                sum += m_matrix[i+1][j] + m_matrix[i+1][j+1] + m_matrix[i+1][j+2];
                sum += m_matrix[i+2][j] + m_matrix[i+2][j+1] + m_matrix[i+2][j+2];
                if(sum > max)
                {
                    max = sum;
                    result =  i + "," + j;
                }
            }
        }
        System.out.println("Max: " + max);
        return result;
    }
}
