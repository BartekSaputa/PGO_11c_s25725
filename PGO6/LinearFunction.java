package PGO6;

public class LinearFunction extends Function implements Fun
{
    private double a;
    private double b;

    public void setA(double a) {
        this.a = a; }

    public void setB(double b) {
        this.b = b; }

    public LinearFunction(double a, double b){
        this.a = a;;
        this.b = b;
    }
    public double getA() {
        return a; }

    public double getB() {
        return b; }

    @Override
    void increaseCoefficientsBy(double z) {
        a += z;
        b += z;
    }

    @Override
    void decreaseCoefficientsBy(double z) {
        a -= z;
        b -= z;
    }

    @Override
    public double f(double x) {
        double y;
        y = b+a*x;
        return y;
    }
}
