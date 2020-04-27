package lab2;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.lang.Math.pow;

/**
 * двумерный класс точки.
 **/
public class Point3d {
    public static void main(String[] args) {
        System.out.println();
    }

    /**
     * координата X
     **/
    private double xCoord;
    /**
     * координата Y
     **/
    private double yCoord;
    /**
     * координата Z
     **/
    private double zCoord;

    /**
     * Конструктор инициализации
     **/
    public Point3d(double x, double y, double z) {
        xCoord = x;
        yCoord = y;
        zCoord = z;
    }

    /**
     * Конструктор по умолчанию.
     **/
    public Point3d() {
//Вызовите конструктор с двумя параметрами и определите источник.
        this(0, 0, 0);
    }

    public double distanceTo(Point3d point) {
        return BigDecimal.valueOf(Math.sqrt(pow(xCoord - point.getX(), 2)
                                            + pow(yCoord - point.getY(), 2)
                                            + pow(zCoord - point.getZ(), 2)))
                .setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Point3d)) return false;

        Point3d point = (Point3d) obj;
        return xCoord == point.getX()
                && yCoord == point.getY()
                && zCoord == point.getZ();
    }

    /**
     * Возвращение координаты X
     **/
    public double getX() {
        return xCoord;
    }

    /**
     * Возвращение координаты Y
     **/
    public double getY() {
        return yCoord;
    }

    /**
     * Возвращение координаты Z
     **/
    public double getZ() {
        return zCoord;
    }

    /**
     * Установка значения координаты X.
     **/
    public void setX(double val) {
        xCoord = val;
    }

    /**
     * Установка значения координаты Y.
     **/
    public void setY(double val) {
        yCoord = val;
    }

    /**
     * Установка значения координаты Z.
     **/
    public void setZ(double val) {
        zCoord = val;
    }

}