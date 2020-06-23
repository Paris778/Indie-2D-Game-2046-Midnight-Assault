package app;

import org.jsfml.system.Vector2f;
import org.jsfml.graphics.*;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class EnemyDriver {

    public static int PRESET_ZERO = 0;
    public static int PRESET_ONE = 1;
    public static int PRESET_TWO = 2;
    public static int PRESET_THREE = 3;

    private RenderWindow window;
    private Character player;
    private LinkedList<Enemy> enemyList;

    public EnemyDriver(RenderWindow window, Character player) {
        this.player = player;
        this.window = window;
    }

    public void initialiseMapEnemies(int preset) {
        enemyList = new LinkedList<Enemy>();
        Vector2f origin = window.getView().getCenter();

        switch (preset) {
            case 0: // Safe Hub
                break;
            case 1: // Tutorial
                enemyList.add(new Enemy(window, player, Enemy.TYPE_HORIZONTAL, player.getModel().getPosition().x + 800,
                        player.getModel().getPosition().y + 550, player.getModel().getPosition().x + 1550));
                enemyList.add(new Enemy(window, player, Enemy.TYPE_HORIZONTAL, player.getModel().getPosition().x + 750,
                        player.getModel().getPosition().y + 670, player.getModel().getPosition().x + 1520));
                enemyList.add(new Enemy(window, player, Enemy.TYPE_HORIZONTAL, player.getModel().getPosition().x + 850,
                        player.getModel().getPosition().y + 770, player.getModel().getPosition().x + 1520, 8));
                break;
            case 2: // Level 1
                break;
            case 3: // Level 2

            //BONUS SEG
                enemyList.add(new Enemy(window, player, Enemy.TYPE_HORIZONTAL, (float)(origin.x + 250), (float) (origin.y -600), (float) (origin.x + 950)));
                enemyList.add(new Enemy(window, player, Enemy.TYPE_VERTICAL, (float) (origin.x + 250),
                (float) (origin.y - 800), (float) (origin.y -400)));
                enemyList.add(new Enemy(window, player, Enemy.TYPE_HORIZONTAL, (float)(origin.x + 50), (float) (origin.y -900), (float) (origin.x + 450)));
                enemyList.add(new Enemy(window, player, Enemy.TYPE_HORIZONTAL, (float)(origin.x + 50), (float) (origin.y -1200), (float) (origin.x + 460)));
                enemyList.add(new Enemy(window, player, Enemy.TYPE_HORIZONTAL, (float)(origin.x + 50), (float) (origin.y -1500), (float) (origin.x + 470)));

            //
                // SEG 1
                // enemyList.add(new Enemy(window, player, Enemy.TYPE_HORIZONTAL, (float)
                // (origin.x + 450), (float) (origin.y -200), (float) (origin.x + 950)));
                enemyList.add(new Enemy(window, player, Enemy.TYPE_HORIZONTAL, (float) (origin.x + 450),
                        (float) (origin.y + 100), (float) (origin.x + 2000), 3, 186, 1)); // big patrol
                // enemyList.add(new Enemy(window, player, Enemy.TYPE_HORIZONTAL, (float)
                // (origin.x + 850), (float) (origin.y -140), (float) (origin.x +
                // 2200),6,206,2)); //big patrol 2
                //enemyList.add(new Enemy(window, player, Enemy.TYPE_HORIZONTAL, (float) (origin.x + 850),
                //        (float) (origin.y + 200), (float) (origin.x + 2200), 8, 210, 1)); // big patrol 3
                enemyList.add(new Enemy(window, player, Enemy.TYPE_HORIZONTAL, (float) (origin.x + 550),
                        (float) (origin.y + 290), (float) (origin.x + 2400), 15, 60)); // fast patrol
                // enemyList.add(new Enemy(window, player, Enemy.TYPE_HORIZONTAL, (float)
                // (origin.x + 250), (float) (origin.y +200), (float) (origin.x + 2100),8,60));
                // //fast patrol2
                enemyList.add(new Enemy(window, player, Enemy.TYPE_HORIZONTAL, (float) (origin.x + 250),
                        (float) (origin.y - 120), (float) (origin.x + 2100), 16, 60)); // fast patrol3
                // enemyList.add(new Enemy(window, player, Enemy.TYPE_HORIZONTAL, (float)
                // (origin.x + 450), (float) (origin.y -50), (float) (origin.x + 1800),20,60));
                // //fast patrol4
                enemyList.add(new Enemy(window, player, Enemy.TYPE_VERTICAL, (float) (origin.x + 450),
                        (float) (origin.y - 200), (float) (origin.y + 300)));
                enemyList.add(new Enemy(window, player, Enemy.TYPE_VERTICAL, (float) (origin.x + 950),
                        (float) (origin.y - 200), (float) (origin.y + 300), 4));
                // enemyList.add(new Enemy(window, player, Enemy.TYPE_VERTICAL, (float)
                // (origin.x + 650), (float) (origin.y -200), (float) (origin.y +300)));
                enemyList.add(new Enemy(window, player, Enemy.TYPE_VERTICAL, (float) (origin.x + 1050),
                        (float) (origin.y - 200), (float) (origin.y + 300)));
               // enemyList.add(new Enemy(window, player, Enemy.TYPE_VERTICAL, (float) (origin.x + 1350),
                //        (float) (origin.y - 200), (float) (origin.y + 200), 6));
                enemyList.add(new Enemy(window, player, Enemy.TYPE_VERTICAL, (float)
                (origin.x + 1850), (float) (origin.y +50), (float) (origin.y +200),7));
                ////////////////////
                // SEG 2
                enemyList.add(new Enemy(window, player, Enemy.TYPE_VERTICAL, (float) (origin.x + 2100),
                        (float) (origin.y - 2000), (float) (origin.y + 50), 7)); // corridor wide patrols
                // enemyList.add(new Enemy(window, player, Enemy.TYPE_VERTICAL, (float)
                // (origin.x + 2300), (float) (origin.y -2000), (float) (origin.y +50),7));
                // //corridor wide patrols
                enemyList.add(new Enemy(window, player, Enemy.TYPE_VERTICAL, (float) (origin.x + 2100),
                        (float) (origin.y - 2100), (float) (origin.y + 50), 3)); // corridor wide patrols
                enemyList.add(new Enemy(window, player, Enemy.TYPE_VERTICAL, (float) (origin.x + 2300),
                        (float) (origin.y - 2100), (float) (origin.y + 50), 3)); // corridor wide patrols
                enemyList.add(new Enemy(window, player, Enemy.TYPE_VERTICAL, (float) (origin.x + 1880),
                        (float) (origin.y - 2100), (float) (origin.y + 50), 5, 210, 1)); // side wide patrol left
                enemyList.add(new Enemy(window, player, Enemy.TYPE_VERTICAL, (float) (origin.x + 2500),
                        (float) (origin.y - 2100), (float) (origin.y + 50), 5, 210, 1)); // side wide patrol rigth
                enemyList.add(new Enemy(window, player, Enemy.TYPE_VERTICAL, (float) (origin.x + 1880),
                        (float) (origin.y - 1900), (float) (origin.y + 50), 2, 210, 1)); // side wide patrol left
                enemyList.add(new Enemy(window, player, Enemy.TYPE_VERTICAL, (float) (origin.x + 2500),
                        (float) (origin.y - 1900), (float) (origin.y + 50), 2, 210, 1)); // side wide patrol rigth
                // enemyList.add(new Enemy(window, player, Enemy.TYPE_HORIZONTAL, (float)
                // (origin.x + 1880), (float) (origin.y -450), (float) (origin.x + 2600),9,97));
                // enemyList.add(new Enemy(window, player, Enemy.TYPE_HORIZONTAL, (float)
                // (origin.x + 1680), (float) (origin.y -450), (float) (origin.x +
                // 2700),3,105));
                // enemyList.add(new Enemy(window, player, Enemy.TYPE_HORIZONTAL, (float)
                // (origin.x + 1880), (float) (origin.y -850), (float) (origin.x + 2600),9,97));
                enemyList.add(new Enemy(window, player, Enemy.TYPE_HORIZONTAL, (float) (origin.x + 1880),
                        (float) (origin.y - 1250), (float) (origin.x + 2600), 9, 97));
                // enemyList.add(new Enemy(window, player, Enemy.TYPE_HORIZONTAL, (float)
                // (origin.x + 1880), (float) (origin.y -1650), (float) (origin.x +
                // 2600),9,97));//
                enemyList.add(new Enemy(window, player, Enemy.TYPE_HORIZONTAL, (float) (origin.x + 1650),
                        (float) (origin.y - 750), (float) (origin.x + 2800), 9, 97));
                enemyList.add(new Enemy(window, player, Enemy.TYPE_HORIZONTAL, (float) (origin.x + 1880),
                        (float) (origin.y - 1000), (float) (origin.x + 2900), 8, 97));
                enemyList.add(new Enemy(window, player, Enemy.TYPE_HORIZONTAL, (float) (origin.x + 1650),
                        (float) (origin.y - 1450), (float) (origin.x + 2850), 7, 97));
                enemyList.add(new Enemy(window, player, Enemy.TYPE_HORIZONTAL, (float) (origin.x + 1880),
                        (float) (origin.y - 1850), (float) (origin.x + 2900), 4, 97));
                enemyList.add(new Enemy(window, player, Enemy.TYPE_HORIZONTAL, (float) (origin.x + 1650),
                        (float) (origin.y - 1950), (float) (origin.x + 2600), 11, 75));
                ////////////////////
                // SEG 3 Big Room
                enemyList.add(new Enemy(window, player, Enemy.TYPE_HORIZONTAL, (float) (origin.x + 1650),
                        (float) (origin.y - 2500), (float) (origin.x + 1650), 0, 500, 2)); // HUGE BOI 1
                enemyList.add(new Enemy(window, player, Enemy.TYPE_HORIZONTAL, (float) (origin.x + 2650),
                        (float) (origin.y - 3200), (float) (origin.x + 1650), 0, 500, 2)); // HUGE BOI 2
               enemyList.add(new Enemy(window, player, Enemy.TYPE_HORIZONTAL, (float) (origin.x + 2050),
                       (float) (origin.y - 2500), (float) (origin.x + 2400), 8)); // wall bois
                enemyList.add(new Enemy(window, player, Enemy.TYPE_HORIZONTAL, (float) (origin.x + 1750),
                        (float) (origin.y - 2900), (float) (origin.x + 2100), 8)); // wall bois
                enemyList.add(new Enemy(window, player, Enemy.TYPE_VERTICAL, (float)
                (origin.x + 2050), (float) (origin.y -3100), (float) (origin.y-2600),2,210,3)); //side wide patrol rigth
                enemyList.add(new Enemy(window, player, Enemy.TYPE_VERTICAL, (float) (origin.x + 2700),
                        (float) (origin.y - 2900), (float) (origin.y - 2300), 2, 210, 1)); // side wide patrol rigth
                enemyList.add(new Enemy(window, player, Enemy.TYPE_VERTICAL, (float) (origin.x + 2200),
                       (float) (origin.y - 2900), (float) (origin.y - 2300), 15, 50, 1));
                enemyList.add(new Enemy(window, player, Enemy.TYPE_VERTICAL, (float) (origin.x + 1900),
                        (float) (origin.y - 2900), (float) (origin.y - 2600), 1, 50, 1));
                break;
        }
    }

    public void updateEnemies() {
        for (Enemy enemy : this.enemyList) {
            enemy.update();
            enemy.checkCollision();
            enemy.draw();
        }
    }

}