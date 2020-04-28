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

    /**
     * returns amount of iterations of mandelbrot if it's < MAX_ITERATIONS
     * or returns -1 otherwise
     * @param z0 initial point of complex plane
     * @param z current result of mandelbrot algorithm
     * @param n current iteration number
     * @return amount of iterations of mandelbrot if it's < MAX_ITERATIONS;
     *         otherwise -1
     */
    private int count(Complex z0, Complex z, int n) {
        return n >= MAX_ITERATIONS ? -1
                : z.sqrAbs() > 4 ? n
                : count(z0, z.multiply(z).plus(z0), n + 1);
    }
}

/**
 * complex number with provided methods
 */
class Complex {
    private double real;
    private double imag;

    Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    /**
     * @return squared absolute value of this complex number
     */
    public double sqrAbs() {
        return real * real + imag * imag;
    }

    /**
     * sums this number with added and returns this
     * @param added summand
     * @return this number with added summand
     */
    public Complex plus(Complex added) {
        this.real += added.real;
        this.imag += added.imag;
        return this;
    }

    /**
     * multiplies this number by multiplier and returns this
     * @param b multiplier
     * @return this object, multiplied by b
     */
    public Complex multiply(Complex b) {
        double real = this.real * b.real - this.imag * b.imag;
        double imag = this.real * b.imag + this.imag * b.real;
        this.real = real;
        this.imag = imag;
        return this;
    }
}
