package PGO4;

public class Main {

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
        System.out.println("Matrix C:");
        matrixC.print();

        Matrix matrixD = Matrix.subtract(matrixA, matrixA);
        System.out.println("Matrix D:");
        matrixD.print();

        System.out.println("Matrix (A+B)-C+(A-C)");
        Matrix.add(matrixA,matrixB)
                .subtract(matrixC)
                .add(matrixA.subtract(matrixC))
                .print();

        Matrix.setUpMatrix(3,2);
        Matrix.insertRow(new int[]{1,5});
        Matrix.insertRow(new int[]{2,3});
        Matrix.insertRow(new int[]{1,7});
        Matrix matrixX= Matrix.create();
        System.out.println("Matrix x:");
        matrixX.print();

        Matrix.setUpMatrix(2,4);
        Matrix.insertRow(new int[]{1, 2, 3, 7});
        Matrix.insertRow(new int[]{5,2, 8, 1});
        Matrix matrixY= Matrix.create();
        System.out.println("Matrix Y:");
        matrixY.print();

        var multiplied = matrixX.multiply(matrixY);
        System.out.println("Matrix multiplied:");
        multiplied.print();
    }
}