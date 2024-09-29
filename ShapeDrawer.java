import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Абстрактний клас Shape
abstract class Shape implements Transformable {
    protected int x, y;

    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Абстрактний метод для малювання фігури
    public abstract void draw(Graphics g);
    public abstract boolean contains(int x, int y);  // Перевірка, чи міститься точка в фігурі
}

// Клас Circle (Коло)
class Circle extends Shape {
    private int radius;

    public Circle(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }

    @Override
    public void draw(Graphics g) {
        g.drawOval(x - radius, y - radius, 2 * radius, 2 * radius);
    }

    @Override
    public boolean contains(int mouseX, int mouseY) {
        double distance = Math.sqrt(Math.pow(mouseX - x, 2) + Math.pow(mouseY - y, 2));
        return distance <= radius;
    }

    @Override
    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    @Override
    public void resize(double factor) {
        radius = (int)(radius * factor);
    }
}

// Клас Square (Квадрат)
class Square extends Shape {
    private int sideLength;

    public Square(int x, int y, int sideLength) {
        super(x, y);
        this.sideLength = sideLength;
    }

    @Override
    public void draw(Graphics g) {
        g.drawRect(x - sideLength / 2, y - sideLength / 2, sideLength, sideLength);
    }

    @Override
    public boolean contains(int mouseX, int mouseY) {
        return mouseX >= x - sideLength / 2 && mouseX <= x + sideLength / 2 &&
                mouseY >= y - sideLength / 2 && mouseY <= y + sideLength / 2;
    }

    @Override
    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    @Override
    public void resize(double factor) {
        sideLength = (int)(sideLength * factor);
    }
}

// Клас Triangle (Трикутник)
class Triangle extends Shape {
    private int size;

    public Triangle(int x, int y, int size) {
        super(x, y);
        this.size = size;
    }

    @Override
    public void draw(Graphics g) {
        int[] xPoints = {x, x - size / 2, x + size / 2};
        int[] yPoints = {y - size / 2, y + size / 2, y + size / 2};
        g.drawPolygon(xPoints, yPoints, 3);
    }

    @Override
    public boolean contains(int mouseX, int mouseY) {
        // Проста перевірка на трикутник
        return mouseX >= x - size / 2 && mouseX <= x + size / 2 &&
                mouseY >= y - size / 2 && mouseY <= y + size / 2;
    }

    @Override
    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    @Override
    public void resize(double factor) {
        size = (int)(size * factor);
    }
}

// Клас для обробки подій і малювання фігур
public class ShapeDrawer extends JPanel implements MouseListener, MouseMotionListener {
    private Shape[] shapes;
    private Shape selectedShape = null;  // Вибрана фігура
    private int prevX, prevY;             // Попередні координати миші

    public ShapeDrawer(Shape[] shapes) {
        this.shapes = shapes;
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape shape : shapes) {
            shape.draw(g);
        }
    }

    // Обробка натискання миші
    @Override
    public void mousePressed(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        for (Shape shape : shapes) {
            if (shape.contains(mouseX, mouseY)) {
                selectedShape = shape;
                prevX = mouseX;
                prevY = mouseY;
                break;
            }
        }
    }

    // Обробка відпускання миші
    @Override
    public void mouseReleased(MouseEvent e) {
        selectedShape = null;
    }

    // Обробка переміщення миші
    @Override
    public void mouseDragged(MouseEvent e) {
        if (selectedShape != null) {
            int mouseX = e.getX();
            int mouseY = e.getY();
            int dx = mouseX - prevX;
            int dy = mouseY - prevY;
            selectedShape.move(dx, dy);
            prevX = mouseX;
            prevY = mouseY;
            repaint();  // Перемальовуємо фігуру
        }
    }

    // Інші методи, які необхідні для MouseListener і MouseMotionListener
    @Override
    public void mouseMoved(MouseEvent e) {}
    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        Shape[] shapes = {
                new Circle(100, 100, 50),
                new Square(200, 200, 100),
                new Triangle(300, 300, 80)
        };

        JFrame frame = new JFrame();
        ShapeDrawer panel = new ShapeDrawer(shapes);
        frame.add(panel);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
