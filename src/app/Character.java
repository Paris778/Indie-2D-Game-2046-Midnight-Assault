package app;

import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.View;
import org.jsfml.system.Vector2f;
import org.jsfml.graphics.Texture;
import org.jsfml.graphics.*;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Character {

    static final int MAX_HEALTH = 102;
    static final int MAX_ENERGY = 50;

    private RenderWindow window;
    private View view;

    // Player hitbox/container
    private RectangleShape model = new RectangleShape(new Vector2f(80, 80));

    // Interaction Area Region
    private RectangleShape interArea = new RectangleShape(new Vector2f(model.getSize().x * 3, model.getSize().x * 3));

    private UserInterface ui;

    private float moveSpeed = 9;
    private int health = 102;
    private int energy = 50;
    private int scrap = 5; // currency
    private boolean alive = true;

    private Collider col;
    private boolean left = false;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;
    private Inventory inventory;

    public Character(RenderWindow window) {
        this.window = window;
        // Sets character position to centre of screen
        window.setView(new View(new Vector2f(0, 0), window.getView().getSize()));
        model.setPosition(0, 0);

        // set interaction area positions
        interArea.setPosition(model.getPosition().x - 120, model.getPosition().y - 120);

        interArea.setFillColor(Color.TRANSPARENT);
        inventory = new Inventory(this);

        col = new Collider(model.getGlobalBounds(), moveSpeed, true);
        model.setOrigin(40, 40);
        window.draw(model);
        view = new View(window.getView().getCenter(), window.getView().getSize());
    }

    private boolean toggle(boolean in) {
        if (in) {
            return false;
        } else {
            return true;
        }
    }

    public void up() {
        up = toggle(up);
    }

    public void down() {
        down = toggle(down);
    }

    public void left() {
        left = toggle(left);
    }

    public void right() {
        right = toggle(right);
    }

    // Move player left
    private void moveLeft() {
        model.move(moveSpeed * -1, 0);
        view.move(moveSpeed * -1, 0);

        interArea.move(moveSpeed * -1, 0);
        ui.move(moveSpeed * -1, 0);

    }

    // Move player right
    private void moveRight() {
        model.move(moveSpeed, 0);
        view.move(moveSpeed, 0);

        interArea.move(moveSpeed, 0);
        ui.move(moveSpeed, 0);

    }

    // Move player up
    private void moveUp() {
        model.move(0, moveSpeed * -1);
        view.move(0, moveSpeed * -1);

        interArea.move(0, moveSpeed * -1);
        ui.move(0, moveSpeed * -1);

    }

    // Move player down
    private void moveDown() {
        model.move(0, moveSpeed);
        view.move(0, moveSpeed);

        interArea.move(0, moveSpeed);
        ui.move(0, moveSpeed);

    }

    // Draw character on the screen
    public void draw() {

        window.draw(model);
        window.draw(interArea);

    }

    public void setTexture(String path) {
        Texture texture = new Texture();
        try {
            texture.loadFromFile(FileSystems.getDefault().getPath(path));
        } catch (IOException e) {
            System.out.println("UNKNOWN PATH");
        }

        model.setTexture(texture, false);
    }

    public void setTextureInt(int count) {
        model.setTexture(TextureList.getPlayerTexture(count), true);
    }

    /**
     * Moves the player
     * 
     * @param objects    the colliders to check for
     * @param intersects the spaces in colliders to check for
     */
    public void move(LinkedHashMap<String, Collider> objects, LinkedList<FloatRect> intersects) {
        boolean colDown = false;
        boolean colUp = false;
        boolean colLeft = false;
        boolean colRight = false;
        for (Collider i : objects.values())
            if (col.testCollision(i)) {
                if (col.testBottom(i) && colDown == false) {
                    colDown = true;
                    for (FloatRect rect : intersects)
                        if (col.testBottom(new Collider(rect, 0, false)) && i.getAbsolute() == false)
                            colDown = false;
                }
                if (col.testTop(i) && colUp == false) {
                    colUp = true;
                    for (FloatRect rect : intersects)
                        if (col.testTop(new Collider(rect, 0, false)) && i.getAbsolute() == false)
                            colUp = false;
                }
                if (col.testLeft(i) && colLeft == false) {
                    colLeft = true;
                    for (FloatRect rect : intersects)
                        if (col.testLeft(new Collider(rect, 0, false)) && i.getAbsolute() == false)
                            colLeft = false;
                }
                if (col.testRight(i) && colRight == false) {
                    colRight = true;
                    for (FloatRect rect : intersects)
                        if (col.testRight(new Collider(rect, 0, false)) && i.getAbsolute() == false)
                            colRight = false;
                }
            }
        if (up && colUp == false) {
            moveUp();
            model.setRotation(0);
        }

        if (down && colDown == false) {
            moveDown();
            model.setRotation(180);
        }

        if (left && colLeft == false) {
            moveLeft();
            model.setRotation(270);
        }

        if (right && colRight == false) {
            moveRight();
            model.setRotation(90);
        }
        window.setView(view);
        col.setBounds(model.getGlobalBounds());
    }

    // Accessor methods for the interactive area

    public RectangleShape getInterArea() {
        return this.interArea;
    }

    public boolean checkIntersection(FloatRect test) {
        if (test.intersection(interArea.getGlobalBounds()) == null)
            return false;
        else
            return true;
    }

    public boolean checkPlayerModelCollisio(FloatRect test) {
        if (test.intersection(this.model.getGlobalBounds()) == null)
            return false;
        else
            return true;
    }

    public void addUi(UserInterface ui) {
        this.ui = ui;
    }

    public UserInterface getUI() {
        return ui;
    }

    public Color getColour() {
        return model.getFillColor();
    }

    public RectangleShape getModel() {
        return this.model;
    }

    public View getView() {
        return this.view;
    }

    public Inventory getInventory() {
        return inventory;
    }

    // Lose stats mehtods
    public int takeDamage(int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            this.health = 0;
            if (this.alive) {
                ui.getFeed().add("You have died. Press X\n to restart");
            }
            alive = false;
        }
        ui.updateHealthBar();
        return this.health;
    }

    public int loseEnergy(int amount) {
        this.energy -= amount;
        if (this.energy <= 0) {
            this.energy = 0;
        }
        ui.updateEnergyBar();
        return this.energy;
    }

    // Add stats methods
    public int healHealth(int healAmount) {
        this.health += healAmount;
        if (this.health <= 0) {
            this.health = 0;
        }
        ui.updateHealthBar();
        return this.health;
    }

    public int getHealth() {
        return this.health;
    }

    public int getEnergy() {
        return this.energy;
    }

    public void resetStatsToFull() {
        this.health = MAX_HEALTH;
        this.energy = MAX_ENERGY;
    }

    public void setHealth(int newHealth) {
        this.health = newHealth;
        if (this.health <= 0) {
            this.health = 0;
        }
    }

    public void setAlive(boolean x) {
        this.alive = x;
    }

    public boolean isAlive() {
        return this.alive;
    }

    public int getScrap() {
        return this.scrap;
    }

    public void setScrap(int newScrap) {
        this.scrap = newScrap;
    }

    public void addScrap(int valueToAdd) {
        this.scrap += valueToAdd;
    }
}