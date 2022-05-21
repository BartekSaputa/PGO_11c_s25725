package PGO4;

public class Matrix {

    private int[][] content;

    private static int[][] temporaryContent;
    private static int nextRow;

    private Matrix() {};

    void print() {
        for (int i = 0; i < content.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < content[i].length; j++) {
                var current = content[i][j];
                System.out.print(current);
                System.out.print(" ");
            }
            System.out.println("|");
        }
    }

    Matrix add(Matrix m) {
        validateForAddOrSubtract(this, m);

        for (int i = 0; i < this.content.length; i++) {
            for (int j = 0; j <this.content[i].length; j++){
                this.content[i][j] = this.content[i][j] + m.content[i][j];
            }
        }

        return this;
    }

    static Matrix add(Matrix m1, Matrix m2) {
        validateForAddOrSubtract(m1, m2);

        var rows = m1.content.length;
        var cols = m1.content[0].length;

        setUpMatrix(rows, cols);

        for (int i = 0; i < rows; i++) {
            var row = new int[cols];
            for (int j = 0; j < cols; j++) {
                row[j] = m1.content[i][j] + m2.content[i][j];
            }
            insertRow(row);
        }

        Matrix result = create();

        return result;
    }

    Matrix subtract(Matrix m) {
        validateForAddOrSubtract(this, m);

        for (int i = 0; i < this.content.length; i++) {
            for (int j = 0; j <this.content[i].length; j++){
                this.content[i][j] = this.content[i][j] - m.content[i][j];
            }
        }

        return this;
    }

    static Matrix subtract(Matrix m1, Matrix m2) {
        validateForAddOrSubtract(m1, m2);
        var rows = m1.content.length;
        var cols = m1.content[0].length;

        setUpMatrix(rows, cols);

        for (int i = 0; i < rows; i++) {
            var row = new int[cols];
            for (int j = 0; j < cols; j++) {
                row[j] = m1.content[i][j] - m2.content[i][j];
            }
            insertRow(row);
        }

        Matrix result = create();

        return result;
    }

    Matrix multiply(Matrix m) {
        var result = multiply(this, m);

        return result;
    }

    Matrix multiply(Matrix m1, Matrix m2) {
        validateForMultiply(m1, m2);

        var r1 = m1.content.length;
        var c2 = m2.content[0].length;
        var c1 = m1.content[0].length;
        setUpMatrix(r1, c2);

        for(int i = 0; i < r1; i++) {
            var newRow = new int[c2];

            for (int j = 0; j < c2; j++) {
                var cell = 0;
                for (int k = 0; k < c1; k++) {
                    cell += m1.content[i][k] * m2.content[k][j];
                }

                newRow[j] = cell;
            }
            insertRow(newRow);
        }

        var result = create();
        return result;
    }

    static void setUpMatrix(int rowCount, int columnCount) {
        if (rowCount <= 0 || columnCount <= 0) {
            System.out.printf("Macierz musi mieć rozmiar co najmniej 1x1. Ustal rozmiar macierzy", rowCount, columnCount);
            return;
        }
        temporaryContent = new int[rowCount][columnCount];
        nextRow = 0;
    }

    static void insertRow(int[] row) {
        if (temporaryContent == null) {
            System.out.println("Najpierw należy wywołać 'setUpMatrix' ");
            return;
        }

        if (row == null) {
            System.out.println("Nie można wstawić pustego wiersza");
            return;
        }

        if (row.length != temporaryContent[0].length) {
            System.out.println("Długość wiersza musi być równa zadeklarowanej długości wiersza: " + temporaryContent[0].length);
            return;
        }

        if( nextRow > temporaryContent.length) {
            System.out.println("Nie można dodać więcej wierszy niż zadeklarowano: " + temporaryContent.length);
            return;
        }

        for (int i = 0; i < row.length; i++) {
            temporaryContent[nextRow][i] = row[i];
        }
        nextRow++;
    }

    static Matrix create() {
        if (temporaryContent == null) {
            throw new RuntimeException("Najpierw należy wywołać 'setUpMatrix' ");
        }

        var m = new Matrix();
        m.content = temporaryContent;
        releaseTemporary();
        return m;
    }

    private static void releaseTemporary() {
        temporaryContent = null;
        nextRow = 0;
    }

    private static void validateForAddOrSubtract(Matrix m1, Matrix m2) {
        if (m1 == null || m2 == null) {
            throw new IllegalArgumentException("Macierz nie może być pusta");
        }
        if (m1.content == null || m2.content == null) {
            throw new IllegalArgumentException("Macierz musi być zainicjalizowana");
        }

        if (m1.content.length != m2.content.length
                || m1.content[0].length != m2.content[0].length) {
            throw new ArithmeticException("Obie macierze muszą mieć ten sam wymiar");
        }
    }

    private static void validateForMultiply(Matrix m1, Matrix m2) {
        if (m1 == null || m2 == null) {
            throw new IllegalArgumentException("Macierz nie może być pusta");
        }
        if (m1.content == null || m2.content == null) {
            throw new IllegalArgumentException("Macierz musi być zainicjalizowana");
        }
        if (m1.content[0].length != m2.content.length) {
            throw new ArithmeticException("Aby pomnożyć macierze, szerokość pierwszej z nich musi być równa wysokości drugiej");
        }
    }
}