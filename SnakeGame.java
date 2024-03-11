import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class SnakeGame extends JFrame implements KeyListener {
    private static final int GRID_SIZE = 20;
    private static final int GRID_WIDTH = 30;
    private static final int GRID_HEIGHT = 20;
    private static final int CELL_SIZE = 20;
    private static final int INITIAL_SNAKE_LENGTH = 3;
    private ArrayList<Point> snake;
    private Point food;
    private Direction direction;
    private boolean gameOver;

    private enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    public SnakeGame() {
        setTitle("Snake Game");
        setSize(GRID_WIDTH * CELL_SIZE, GRID_HEIGHT * CELL_SIZE);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        snake = new ArrayList<>();
        snake.add(new Point(GRID_WIDTH / 2, GRID_HEIGHT / 2));
        direction = Direction.RIGHT;
        generateFood();

        addKeyListener(this);

        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!gameOver) {
                    move();
                    checkCollision();
                    checkFood();
                    repaint();
                }
            }
        });
        timer.start();
    }

    private void generateFood() {
        Random random = new Random();
        int x, y;
        do {
            x = random.nextInt(GRID_WIDTH);
            y = random.nextInt(GRID_HEIGHT);
        } while (snake.contains(new Point(x, y)));
        food = new Point(x, y);
    }

    private void move() {
        Point head = snake.get(0);
        Point newHead = new Point(head);
        switch (direction) {
            case UP:
                newHead.y--;
                break;
            case DOWN:
                newHead.y++;
                break;
            case LEFT:
                newHead.x--;
                break;
            case RIGHT:
                newHead.x++;
                break;
        }
        snake.add(0, newHead);
        if (snake.size() > INITIAL_SNAKE_LENGTH) {
            snake.remove(snake.size() - 1);
        }
    }

    private void checkCollision() {
        Point head = snake.get(0);
        if (head.x < 0 || head.x >= GRID_WIDTH || head.y < 0 || head.y >= GRID_HEIGHT || snake.subList(1, snake.size()).contains(head)) {
            gameOver = true;
        }
    }

    private void checkFood() {
        Point head = snake.get(0);
        if (head.equals(food)) {
            generateFood();
            snake.add(snake.get(snake.size() - 1));
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.clearRect(0, 0, getWidth(), getHeight());
        if (!gameOver) {
            // Draw food
            g.setColor(Color.RED);
            g.fillRect(food.x * CELL_SIZE, food.y * CELL_SIZE, CELL_SIZE, CELL_SIZE);

            // Draw snake
            g.setColor(Color.GREEN);
            for (Point point : snake) {
                g.fillRect(point.x * CELL_SIZE, point.y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            }
        } else {
            // Game over message
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 40));
            g.drawString("Game Over!", getWidth() / 2 - 120, getHeight() / 2);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                if (direction != Direction.DOWN)
                    direction = Direction.UP;
                break;
            case KeyEvent.VK_DOWN:
                if (direction != Direction.UP)
                    direction = Direction.DOWN;
                break;
            case KeyEvent.VK_LEFT:
                if (direction != Direction.RIGHT)
                    direction = Direction.LEFT;
                break;
            case KeyEvent.VK_RIGHT:
                if (direction != Direction.LEFT)
                    direction = Direction.RIGHT;
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SnakeGame().setVisible(true);
            }
        });
    }
}
