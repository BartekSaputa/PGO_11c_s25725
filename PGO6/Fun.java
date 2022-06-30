package PGO6;

public interface Fun {
    double f(double x);

    static double minimum(Fun func, double a, double b, double alpha) {
        double minimum = a;
        double c = a;
        while ( c <= b ){
                c=alpha+c;
                if (func.f(c) < func.f(minimum)){
                    minimum = c;
            }
        }
        return minimum;
    }

}
