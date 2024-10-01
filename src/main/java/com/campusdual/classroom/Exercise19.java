package com.campusdual.classroom;

public class Exercise19 {

    private static String getTridimensionalString(int[][][] intArrayTri, int[][] flatMatrix) {

        int rows = intArrayTri[0].length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            sb.append(stringFlatMatrixRow(flatMatrix, i));
            sb.append("   →   ");
            sb.append(stringTriMatrixRow(intArrayTri, i));
            sb.append("\n");
        }
        sb.delete(sb.length()-1, sb.length());
        return sb.toString();

    }

    private static String stringTriMatrixRow(int[][][] intArrayTri, int row) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intArrayTri.length-1; i++){
            sb.append(getUnidimensionalString(intArrayTri[i][row]));
            sb.append("   ");
        }
        sb.append(getUnidimensionalString(intArrayTri[intArrayTri.length-1][row]));

        return sb.toString();
    }

    private static String stringFlatMatrixRow(int[][] flatMatrix, int row) {
        return getUnidimensionalString(flatMatrix[row]);
    }

    public static String getTridimensionalString(int[][][] intArrayTri) {
        int[][] flatMatrix = flatTridimensionalArray(intArrayTri);
        return getTridimensionalString(intArrayTri, flatMatrix);
    }

    //TODO
    public static int[][] flatTridimensionalArray(int[][][] intArrayTri) {

        int ancho = intArrayTri[0].length;
        int alto = intArrayTri[0][0].length;
        int[][] arr = new int[ancho][alto];
        for (int i = 0; i < intArrayTri.length; i++) {
            for (int j = 0; j < intArrayTri[i].length; j++) {
                for (int k = 0; k < intArrayTri[i][j].length; k++) {
                    arr[j][k] += intArrayTri[i][j][k]; // Sumamos en la posición correspondiente
                }
            }
        }
        return arr;
    }


    // TODO
    public static String getBidimensionalString(int[][] intArrayBi) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intArrayBi.length; i++) {
            for (int j = 0; j < intArrayBi[i].length; j++) {
                if(j>0){
                    sb.append(" ");
                }
                sb.append(intArrayBi[i][j]);
            }
            if(i<intArrayBi.length -1){
                sb.append("\n");
            }
        }
        return sb.toString();

    }

    // TODO
    public static String getUnidimensionalString(int[] uniArray) {
        StringBuilder  res = new StringBuilder();

        for (int i = 0; i < uniArray.length; i++) {
            if(i>0){
                res.append(" ");
            }
            res.append(uniArray[i]);

        }
        return res.toString();
    }

    // TODO
    public static int[] createAndPopulateUnidimensionalArray(int columns) {
        int[] unidimensional = new int[columns];
        for (int i = 0; i < columns; i++) {
            unidimensional[i] = (i + 1);
        }
        return unidimensional;
    }

    // TODO
    public static int[][] createAndPopulateBidimensionalArray(int rows, int columns) {
        int[][] bidimensional = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                bidimensional[i][j] = (i * columns) + (j + 1);
            }
        }
        return bidimensional;
    }

    // TODO
    public static int[][][] createAndPopulateTridimensionalArray(int depth, int rows, int columns) {
        int[][][] tridimensional = new int[depth][rows][columns];
        int cont = 1;
        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < columns; k++) {
                    tridimensional[i][j][k] = cont++;  
                }
            }
        }
        return tridimensional;
    }

    public static void main(String[] args) {
        int[] uniArray = createAndPopulateUnidimensionalArray(5);
        System.out.println(getUnidimensionalString(uniArray));
        System.out.println("===================");
        int[][] intArrayBi = createAndPopulateBidimensionalArray(5, 5);
        System.out.println(getBidimensionalString(intArrayBi));
        System.out.println("===================");
        int[][][] intArrayTri = createAndPopulateTridimensionalArray(3, 3, 3);
        System.out.println(getTridimensionalString(intArrayTri));
    }
}
