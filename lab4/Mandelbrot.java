package lab4;

import java.awt.geom.Rectangle2D;

public class Mandelbrot extends FractalGenerator {

    public static final int MAX_ITERATIONS = 2000;

    @Override
    public void getInitialRange(Rectangle2D.Double range) {
        range.x = -2;
        range.y = -1.5;
        range.height = 3;
        range.width = 3;
    }

    @Override
    public int numIterations(double x, double y) {
        return count(new Complex(x, y), new Complex(0, 0), 0);
    }

    private int count(Complex z0, Complex z, int n) {
        return n >= MAX_ITERATIONS ? -1
                : z.sqrAbs() > 4 ? n
                : count(z0, z.multiply(z).plus(z0), n + 1);
    }
}

class Complex {
    private double real;
    private double imag;

    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    // return squared absolute value of this complex number
    public double sqrAbs() {
        return real * real + imag * imag;
    }

    public Complex plus(Complex added) {
        this.real += added.real;
        this.imag += added.imag;
        return new Complex(real, imag);
    }


    // multiplies this number by multiplier and returns this
    public Complex multiply(Complex multiplier) {
        this.real = this.real * multiplier.real - this.imag * multiplier.imag;
        this.imag = this.real * multiplier.imag + this.imag * multiplier.real;
        return this;
    }
}
