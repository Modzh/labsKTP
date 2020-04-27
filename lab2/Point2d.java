package lab2;

/**
 * двумерный класс точки.
 **/
public class Point2d {
    /**
     * координата X
     **/
    private double xCoord;
    /**
     * координата Y
     **/
    private double yCoord;

    /**
     * Конструктор инициализации
     **/
    public Point2d(double x, double y) {
        xCoord = x;
        yCoord = y;
    }

    /**
     * Конструктор по умолчанию.
     **/
    public Point2d() {
//Вызовите конструктор с двумя параметрами и определите источник.
        this(0, 0);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Point2d)) return false;

        Point2d point = (Point2d) obj;
        return this.xCoord == point.xCoord && this.yCoord == point.yCoord;
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
}