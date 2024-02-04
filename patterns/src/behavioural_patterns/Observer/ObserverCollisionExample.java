package behavioural_patterns.Observer;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

// CollisionObserver interface represents an observer interested in collision events
interface CollisionObserver {
    void handleCollision();
}

// GameObject represents a basic game object with position and dimensions
class GameObject {
    private int x, y, width, height;

    public GameObject(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public void draw(Graphics g) {
        g.drawRect(x, y, width, height);
    }

    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }
}

// GamePanel is a JPanel that handles the game loop, drawing, and collision notifications
class GamePanel extends JPanel implements KeyListener {
    private GameObject player, obstacle;
    private List<CollisionObserver> collisionObservers;

    public GamePanel() {
        player = new GameObject(50, 50, 30, 30);
        obstacle = new GameObject(100, 100, 40, 40);
        collisionObservers = new ArrayList<>();

        setFocusable(true);
        addKeyListener(this);
        setPreferredSize(new Dimension(400, 400));
    }

    // Register observers interested in collision events
    public void registerCollisionObserver(CollisionObserver observer) {
        collisionObservers.add(observer);
    }

    private void notifyCollisionObservers() {
        // Notify all registered observers about the collision event
        for (CollisionObserver observer : collisionObservers) {
            observer.handleCollision();
        }
    }

    public void update() {
        // Check for collision
        if (player.getBounds().intersects(obstacle.getBounds())) {
            handleCollision();
        }
    }

    private void handleCollision() {
        // In a real game, you might implement a response, like reducing player health or changing game state
        System.out.println("Collision Detected!");

        // Notify collision observers
        notifyCollisionObservers();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw game objects
        player.draw(g);
        obstacle.draw(g);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        // Move the player based on arrow key input
        if (keyCode == KeyEvent.VK_LEFT) {
            player.move(-5, 0);
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            player.move(5, 0);
        } else if (keyCode == KeyEvent.VK_UP) {
            player.move(0, -5);
        } else if (keyCode == KeyEvent.VK_DOWN) {
            player.move(0, 5);
        }

        // Repaint the panel after moving the player
        repaint();

        // Check for collision after each move
        update();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Unused
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Unused
    }
}

// GameFrame is a JFrame that contains the game panel
class GameFrame extends JFrame {
    public GameFrame() {
        setTitle("Collision Detection Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create and add the game panel
        GamePanel gamePanel = new GamePanel();
        getContentPane().add(gamePanel);

        // Create a collision observer and register it with the game panel
        CollisionObserver collisionObserver = new CollisionObserver() {
            @Override
            public void handleCollision() {
                System.out.println("Custom Collision Observer: Collision Event Received!");
            }
        };

        gamePanel.registerCollisionObserver(collisionObserver);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

public class ObserverCollisionExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GameFrame();
        });
    }
}
