package PGO6;

public class SquareFunction extends Function implements Fun {
    private double a;
    private double b;
    private double c;

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }
    public SquareFunction(double a, double b, double c){
        this.a = a;;
        this.b = b;
        this.c = c;
    }

    @Override
    void increaseCoefficientsBy(double delta) {
        a += delta;
        b += delta;
        c += delta;
    }

    @Override
    void decreaseCoefficientsBy(double delta) {
        a -= delta;
        b -= delta;
        c -= delta;
    }

    @Override
    public double f(double x) {
        double y;
        y = ((x*x)*a)+(b*x)+c;
        return y;
    }
}
