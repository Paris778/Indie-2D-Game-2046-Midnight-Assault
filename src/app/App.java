
package app;

import org.jsfml.audio.Music;
import org.jsfml.graphics.*;
import org.jsfml.window.*;
import org.jsfml.system.Vector2f;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.util.LinkedList;

public class App 
{

        private RenderWindow window;
        public static String pathVariable;
        private Character player;
        public static Map currentMap;
        private static LinkedList<FloatRect> intersects;
        private static Controller controller;
        private UserInterface ui;
        private EventHandler events;
        private static EnemyDriver enemyDriver;
        private Music music = new Music();
        public static boolean selectingplayer = false;
        public static boolean displayEndScreen = false;
        public static boolean keepGoing = true;
        public static int counter = 0;
        public static int jumps = 0;
        

        /**
         * Constructor
         */
        public App(String pathVariable) 
        {    
            this.pathVariable = pathVariable;
            window = new RenderWindow();
            window.create(VideoMode.getDesktopMode(), "4067: Twilight Assault");
            window.setFramerateLimit(60);
            window.setKeyRepeatEnabled(false); // Ensures the key repeat doesn't break player movement
            startGame();   
        }

        public void startGame()
        {
            try {
                music.openFromFile(Paths.get("sprites" + pathVariable + "scifi.ogg"));
                music.setLoop(true);
                music.play();
            } catch (IOException e) {e.printStackTrace();}
            player = new Character(window);
            ui = new UserInterface(player, window);
            currentMap = MapList.getMap(MapList.TEST_MAP,player, window);
            intersects = currentMap.getIntersects();
            controller = new Controller(window, player, currentMap, ui, this);
            player.addUi(ui);
            enemyDriver = new EnemyDriver(window, player);
            player.setTextureInt(counter);
            events = new EventHandler(window, controller);
            enemyDriver.initialiseMapEnemies(currentMap.getEnemyPreset());
            jumps = 0;
            run();
        }

        public void stop()
        {
            window.close();
            music.stop();
        }

        /**
         * Method to run main events
         */
        public void run() {
            try
            {
                while (window.isOpen()) {
                    window.clear();
                    events.runEvents();
                    currentMap.drawMap(window);
                    player.draw();
                    enemyDriver.updateEnemies();
                    ui.drawUI();
                    if(!App.selectingplayer && App.keepGoing){selectingplayer = true;}
                    if (ui.isInStartScreen())
                        ui.drawStartScreen();
                    else {
                        if (player.isAlive() && !App.displayEndScreen)
                            player.move(currentMap.getColliders(player), intersects);
                    }
                    if(selectingplayer){
                        runplayerSelection();
                        player.setTextureInt(App.counter);
                    }
                    if(App.displayEndScreen){
                        ui.drawEndScreen();
                    }
                    ui.drawMouse();
                    window.display();
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
                music.stop();
            }
        }

        /**
         * Method to change the current map
         */
        public static void setCurrentMap(Map newMap) {
            currentMap = newMap;
            intersects = currentMap.getIntersects();
            enemyDriver.initialiseMapEnemies(currentMap.getEnemyPreset());
            controller.updateMap(newMap);
        }

        public void runplayerSelection(){
            Vector2f origin = window.getView().getCenter();
            Font font = new Font();
            try {
                    font.loadFromFile(FileSystems.getDefault().getPath(System.getProperty("user.dir") + pathVariable + "sprites" + pathVariable + "Coalition.ttf"));
            } catch (IOException e) {
                    e.printStackTrace();
            }
            Text text = new Text("         select player\n\n\n\n<-  Z                                  C  ->\n\n\n          SPACE To confirm", font);
            text.setCharacterSize(32);
            text.setColor(Color.WHITE);
            text.setPosition(new Vector2f(origin.x-300, origin.y+50));
            RectangleShape menu = new RectangleShape(new Vector2f(1008, 911));
            menu.setPosition(new Vector2f(origin.x-500, origin.y-500));
            menu.setTexture(TextureList.getMenu());

            RectangleShape spriteContainer = new RectangleShape(new Vector2f(250, 250));
            spriteContainer.setPosition(new Vector2f(origin.x-70, origin.y-350));
            while(selectingplayer){
                    events.runEvents();
                    window.clear();
                    spriteContainer.setTexture(TextureList.getPlayerTexture(counter), true);

                    //System.out.println("Selecting.....");
                    window.draw(menu);
                    window.draw(spriteContainer);
                    window.draw(text);
                    ui.drawMouse();
                    window.display();
            }
    }

    public static void addJumps(){
        App.jumps++;
        if(App.jumps==4){
            displayEndScreen = true;
        }
    }

}