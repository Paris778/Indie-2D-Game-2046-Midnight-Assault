package app;

import org.jsfml.system.Vector2f;
import org.jsfml.window.Mouse;
import org.jsfml.graphics.*;

import java.io.IOException;
import java.nio.file.FileSystems;

public class UserInterface {

    private RenderWindow window;
    private RectangleShape baseShape = new RectangleShape(new Vector2f(800, 250));
    private RectangleShape healthBox = new RectangleShape(new Vector2f(400, 15));
    private RectangleShape energyBox = new RectangleShape(new Vector2f(185, 15));
    private RectangleShape customMouse = new RectangleShape(new Vector2f(50, 70));
    private RectangleShape deathScreen;
    private TextWriter feed;
    private RectangleShape inventory = new RectangleShape(new Vector2f(250, 620));
    private InventoryShape[] boxes = {new InventoryShape(95, 95, Color.BLUE, Color.WHITE, 0), new InventoryShape(95, 95, Color.BLUE, Color.WHITE, 0), new InventoryShape(95, 95, Color.BLUE, Color.WHITE, 0), new InventoryShape(95, 95, Color.BLUE, Color.WHITE, 0), new InventoryShape(95, 95,Color.BLUE, Color.WHITE, 0)};
    private RectangleShape startScreen;
    private Text currencyDisplay;
    private Text startScreenText;
    private Font font = new Font();
    private boolean inStartScreen = true;
    private Character character;
    private RectangleShape endScreen;

    public UserInterface(Character character, RenderWindow window) {
        this.character = character;
        this.window = window;
        feed = new TextWriter(window);
        baseShape.setPosition(0 - (window.getView().getSize().x / 2) - 170 , 0 - (window.getView().getSize().y / 2) - 50);
        initialiseUi(); 
    }

    public void drawUI() {
        this.updateHealthBar();
        this.updateEnergyBar();
        this.updateCurrencyDisplay();
        if (character.getHealth() <= 0) 
        {
            window.draw(deathScreen);
        }
        window.draw(baseShape);
        window.draw(healthBox);
        window.draw(energyBox);
        window.draw(currencyDisplay);
        feed.run();
        drawInventory();
    }

    public void drawMouse(){
        customMouse.setPosition(window.mapPixelToCoords(Mouse.getPosition(), character.getView()).x-34,
                window.mapPixelToCoords(Mouse.getPosition(), character.getView()).y-30);
        window.draw(customMouse);
    }

    public void drawInventory() {
        window.draw(inventory);
        for (int i = 0; i < boxes.length; i++) {
            Texture view = this.character.getInventory().itemView(i);
            // System.out.println(view);
            if (view == null)
                boxes[i].getrecc().setFillColor(Color.TRANSPARENT);
            else
            {
                boxes[i].getrecc().setFillColor(Color.WHITE);
                boxes[i].getrecc().setTexture(view);
            }
            window.draw(boxes[i].getrecc());
        }

    }

    public void drawStartScreen() {
        window.draw(startScreen);
        window.draw(startScreenText);
    }

    public void drawEndScreen() {
        window.draw(endScreen);
    }

    public void startGame() {
        this.inStartScreen = false;
    }

    public boolean isInStartScreen(){
        return this.inStartScreen;
    }

    private void initialiseUi() {
        Vector2f origin = window.getView().getCenter();
        
        startScreen = new RectangleShape(new Vector2f(window.getSize().x, window.getSize().y));
        endScreen = new RectangleShape(new Vector2f(window.getSize().x, window.getSize().y));
        deathScreen = new RectangleShape(new Vector2f(window.getSize().x, window.getSize().y));
        baseShape.setPosition(0 - (window.getView().getSize().x / 2) - 170 , 0 - (window.getView().getSize().y / 2) - 50);
        deathScreen.setPosition(0 - (window.getView().getSize().x / 2), 0 - (window.getView().getSize().y / 2));
        startScreen.setPosition(0 - (window.getView().getSize().x / 2), 0 - (window.getView().getSize().y / 2));
        startScreen.setTexture(TextureList.getStartScreenBack());
        endScreen.setPosition(0 - (window.getView().getSize().x / 2), 0 - (window.getView().getSize().y / 2));
        endScreen.setTexture(TextureList.getEndScreen());
        deathScreen.setTexture(TextureList.getDeathScreen());
        window.setMouseCursorVisible(false);
        healthBox.setPosition(0 - (window.getView().getSize().x / 2) + 170, 0 - (window.getView().getSize().y / 2) + 40);
        energyBox.setPosition(0 - (window.getView().getSize().x / 2) + 170, 0 - (window.getView().getSize().y / 2) + 75);
        baseShape.setTexture(TextureList.getUiTexture(), true);

        healthBox.setFillColor(Color.RED);
        healthBox.setOutlineColor(Color.BLACK);
        healthBox.setOutlineThickness(2);
        energyBox.setFillColor(Color.BLUE);
        energyBox.setOutlineColor(Color.BLACK);
        energyBox.setOutlineThickness(2);

        customMouse.setTexture(TextureList.getCustomMouseTexture());
        // deathScreen.setTexture(TextureList.getDeathScreenTexture());
        // startScreen.setTexture(TextureList.getStartScreenBack());
        customMouse.setOrigin(0, 0);
        customMouse.rotate(-20);
        customMouse.setPosition((Mouse.getPosition().x - 10), (Mouse.getPosition().y - 10));
        inventory.setPosition(((window.getView().getSize().x / 2) - 314), 0 - (window.getView().getSize().y / 2 - 50));
        inventory.setTexture(TextureList.getInventory());
        boxes[0].getrecc().setPosition(((window.getView().getSize().x / 2) - 237),
                0 - (window.getView().getSize().y / 2) + 120);
        boxes[1].getrecc().setPosition(((window.getView().getSize().x / 2) - 237),
                0 - (window.getView().getSize().y / 2) + 215);
        boxes[2].getrecc().setPosition(((window.getView().getSize().x / 2) - 237),
                0 - (window.getView().getSize().y / 2) + 305);
        boxes[3].getrecc().setPosition(((window.getView().getSize().x / 2) - 237),
                0 - (window.getView().getSize().y / 2) + 396);
        boxes[4].getrecc().setPosition(((window.getView().getSize().x / 2) - 237),
                0 - (window.getView().getSize().y / 2) + 487);
        try {
            font.loadFromFile(
                    FileSystems.getDefault().getPath(System.getProperty("user.dir") + App.pathVariable + "sprites" + App.pathVariable + "Coalition.ttf"));
            currencyDisplay = new Text(String.valueOf(character.getScrap()), font);
            currencyDisplay.setCharacterSize(25);
            currencyDisplay.setColor(Color.WHITE);
            // currencyDisplay.setPosition(190, 120);
            currencyDisplay.setPosition(0 - (window.getView().getSize().x / 2) + 200, 0 - (window.getView().getSize().y / 2) + 120);
            // Start screen
            startScreenText = new Text("Press X to start game", font);
            startScreenText.setCharacterSize(50);
            startScreenText.setColor(Color.WHITE);
            startScreenText.setPosition(startScreen.getPosition().x + 560, startScreen.getPosition().y + 750);
        } catch (IOException ex) {
            // Failed to load font
            ex.printStackTrace();
        }

    }

    public static Font getFont()
    {
        try
        {
            Font font = new Font();
            font.loadFromFile(FileSystems.getDefault().getPath(System.getProperty("user.dir") + App.pathVariable + "sprites" + App.pathVariable + "Coalition.ttf"));
            return font;
        }
        catch(IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public void move(float x, float y) {
        baseShape.move(x, y);
        healthBox.move(x, y);
        energyBox.move(x, y);
        currencyDisplay.move(x, y);
        customMouse.move(x, y);
        feed.move(x, y);
        inventory.move(x, y);
        deathScreen.move(x, y);
        endScreen.move(x, y);
        for (InventoryShape inventoryShape : boxes) 
        {
            inventoryShape.move(x, y);
        }
    }

    public void updateHealthBar(){   
        this.healthBox.setSize(new Vector2f((float)(400*((float)this.character.getHealth()/Character.MAX_HEALTH)),15));
    }

    public void updateEnergyBar(){
        this.energyBox.setSize(new Vector2f((float)(185*((float)this.character.getEnergy()/Character.MAX_ENERGY)),15));
    }

    public void updateCurrencyDisplay() {
        this.currencyDisplay.setString(String.valueOf(character.getScrap()));
    }

    public RectangleShape getStartScreen() {
        return this.startScreen;
    }

    public TextWriter getFeed()
    {
        return feed;
    }

    public InventoryShape[] getBoxes() {
        return boxes;
    }

    public void setBoxes(InventoryShape[] boxes) {
        this.boxes = boxes;
    }
}