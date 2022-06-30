package PGO4;

public class Matrix {
    private int[][] matrix;
    private static int[][] tmpMatrix = null;
    private static int nextRowIndex = 0;

    public static void main(String[] args) {
        Matrix.setUpMatrix(3,3);
        Matrix.insertRow(new int[]{1,2,3});
        Matrix.insertRow(new int[]{4,5,6});
        Matrix.insertRow(new int[]{7,8,9});
        Matrix matrixA = Matrix.create();
        System.out.println("Matrix A:");
        matrixA.print();
        Matrix.setUpMatrix(3,3);
        Matrix.insertRow(new int[]{9,8,7});
        Matrix.insertRow(new int[]{6,5,4});
        Matrix.insertRow(new int[]{3,2,1});
        Matrix matrixB = Matrix.create();
        System.out.println("Matrix B:");
        matrixB.print();
        matrixA.add(matrixB);
        System.out.println("Matrix A after adding B");
        matrixA.print();
        matrixA.subtract(matrixB);
        System.out.println("Matrix A after subtracting B");
        matrixA.print();
        Matrix.setUpMatrix(3,3);
        Matrix.insertRow(new int[]{6,3,2});
        Matrix.insertRow(new int[]{14,5,7});
        Matrix.insertRow(new int[]{27,5,15});
        Matrix matrixC= Matrix.create();
        System.out.println("Matrix (A+B)-C+(A-C)");
        Matrix.add(matrixA,matrixB)
                .subtract(matrixC)
                .add(matrixA.subtract(matrixC))
                .print();
    }

    private Matrix() {
        matrix = tmpMatrix;
        tmpMatrix = null;
        nextRowIndex = 0;
    }

    public static Matrix create() {
        return new Matrix();
    }

    public static void setUpMatrix(int i, int i1) {
        if (i < 1 || i1 < 1) {
            throw new Error("Size of matrix must be greater than 0");
        }
        tmpMatrix = new int[i][i1];
    }

    public static void insertRow(int[] ints) {
        if (nextRowIndex >= tmpMatrix[0].length) {
            throw new Error("Too many rows");
        }
        tmpMatrix[nextRowIndex] = ints;
        nextRowIndex++;
    }

    public void print() {
        for (int[] row : matrix) {
            System.out.print("|");
            for (int value: row) {
                System.out.print(" " + value);
            }
            System.out.println(" |");
        }
    }

    public Matrix add(Matrix matrixB) {
        canAddOrSubtract(this, matrixB);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] += matrixB.getMatrix()[i][j];
            }
        }
        return this;
    }

    public Matrix subtract(Matrix matrixB) {
        canAddOrSubtract(this, matrixB);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] -= matrixB.getMatrix()[i][j];
            }
        }
        return this;
    }

    public static Matrix add(Matrix matrixA, Matrix matrixB) {
        canAddOrSubtract(matrixA, matrixB);

        Matrix.setUpMatrix(matrixA.getMatrix().length,matrixA.getMatrix()[0].length);
        Matrix matrix = Matrix.create();

        matrix.add(matrixA);
        matrix.add(matrixB);
        return matrix;
    }

    public static Matrix subtract(Matrix matrixA, Matrix matrixB) {
        canAddOrSubtract(matrixA, matrixB);

        Matrix.setUpMatrix(matrixA.getMatrix().length,matrixA.getMatrix()[0].length);
        Matrix matrix = Matrix.create();

        matrix.subtract(matrixA);
        matrix.subtract(matrixB);
        return matrix;
    }

    private static boolean haveSameSize(Matrix matrixA, Matrix matrixB) {
        return matrixA.getMatrix().length == matrixB.getMatrix().length &&
                matrixA.getMatrix()[0].length == matrixB.getMatrix()[0].length;
    }

    private static void canAddOrSubtract(Matrix matrixA, Matrix matrixB) {
        if (!Matrix.haveSameSize(matrixA, matrixB)) {
            throw new Error("Matrices are not the same size");
        }
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public Matrix multiply(int value) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] *= value;
            }
        }
        return this;
    }
}