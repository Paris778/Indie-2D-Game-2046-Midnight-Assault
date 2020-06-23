package app;

import org.jsfml.graphics.*;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.EventListener;

public class TextureList {

    //floor numbers, since there's so fucking many of them
    public static final int FLOOR_BLOODSTAINED_SHORT = 0;
    public static final int FLOOR_BLOODSTAINED_LONG = 1;
    public static final int FLOOR_CLEAN = 2;
    public static final int FLOOR_3_3_TILES = 3;
    public static final int FLOOR_4_3_TILES = 4;
    public static final int FLOOR_2_5_TILES = 5;
    public static final int FLOOR_2_2_TILES = 6;
    public static final int FLOOR_STAIRS_1 = 7;
    public static final int FLOOR_STAIRS_2 = 8;
    public static final int FLOOR_PORTAL_2_2 = 9;
    public static final int FLOOR_PORTAL_3_3 = 10;
    public static final int FLOOR_PORTAL_STUDDED = 11;
    public static final int FLOOR_CORRIDOR = 12;
    public static final int FLOOR_CORRIDOR_HORIZONTAL = 13;
    public static final int FLOOR_HUGE_ROOM_HORIZONTAL = 14;       //  1190 x 547
    public static final int FLOOR_HUGE_ROOM_VERTICAL = 15;         //  547  x 1189
    public static final int FLOOR_MERCHANT_DROID = 16;             //  427  x 419

    public static final int PLAYER_1_BLUE = 0;
    public static final int PLAYER_1_CYAN = 1;
    public static final int PLAYER_1_PINK = 2;
    public static final int PLAYER_1_RED = 3;
    public static final int PLAYER_1_YELLOW = 4;
    public static final int PLAYER_2_BLUE = 5;
    public static final int PLAYER_2_CYAN = 6;
    public static final int PLAYER_2_PINK = 7;
    public static final int PLAYER_2_RED = 8;
    public static final int PLAYER_2_YELLOW = 9;
    public static final int ENEMY = 10;

    // Test Map Base Texture
    public static final Texture getTestMapTexture() {

        Texture fl = new Texture();
        try {
            fl.loadFromFile(FileSystems.getDefault()
            .getPath(System.getProperty("user.dir") + App.pathVariable + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "Map1-extended.png"));
            //.getPath(System.getProperty("user.dir") + App.pathVariable + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "Map1.png"));
            fl.setRepeated(true);
            fl.setSmooth(true);
        } catch (IOException e) {
            System.out.println("Opps");
            e.printStackTrace();
        }
        return fl;
    }

    

    public static final Texture getPlayerTexture(int type) {

        Texture fl = new Texture();
        try {
            switch (type)
            {
                case 0:
                    fl.loadFromFile(FileSystems.getDefault().getPath(System.getProperty("user.dir") + App.pathVariable
                            + "sprites" + App.pathVariable + "playerSprites" + App.pathVariable + "player1Blue.png"));
                    break;
                case 1:
                    fl.loadFromFile(FileSystems.getDefault().getPath(System.getProperty("user.dir") + App.pathVariable
                            + "sprites" + App.pathVariable + "playerSprites" + App.pathVariable + "player1Cyan.png"));
                    break;
                case 2:
                    fl.loadFromFile(FileSystems.getDefault().getPath(System.getProperty("user.dir") + App.pathVariable
                            + "sprites" + App.pathVariable + "playerSprites" + App.pathVariable + "player1Pink.png"));
                    break;
                case 3:
                    fl.loadFromFile(FileSystems.getDefault().getPath(System.getProperty("user.dir") + App.pathVariable
                            + "sprites" + App.pathVariable + "playerSprites" + App.pathVariable + "player1Red.png"));
                    break;
                case 4:
                    fl.loadFromFile(FileSystems.getDefault().getPath(System.getProperty("user.dir") + App.pathVariable
                            + "sprites" + App.pathVariable + "playerSprites" + App.pathVariable + "player1Yellow.png"));
                    break;
                case 5:
                    fl.loadFromFile(FileSystems.getDefault().getPath(System.getProperty("user.dir") + App.pathVariable
                            + "sprites" + App.pathVariable + "playerSprites" + App.pathVariable + "player2Blue.png"));
                    break;
                case 6:
                    fl.loadFromFile(FileSystems.getDefault().getPath(System.getProperty("user.dir") + App.pathVariable
                            + "sprites" + App.pathVariable + "playerSprites" + App.pathVariable + "player2Cyan.png"));
                    break;
                case 7:
                    fl.loadFromFile(FileSystems.getDefault().getPath(System.getProperty("user.dir") + App.pathVariable
                            + "sprites" + App.pathVariable + "playerSprites" + App.pathVariable + "player2Pink.png"));
                    break;
                case 8:
                    fl.loadFromFile(FileSystems.getDefault().getPath(System.getProperty("user.dir") + App.pathVariable
                            + "sprites" + App.pathVariable + "playerSprites" + App.pathVariable + "player2Red.png"));
                    break;
                case 9:
                    fl.loadFromFile(FileSystems.getDefault().getPath(System.getProperty("user.dir") + App.pathVariable
                            + "sprites" + App.pathVariable + "playerSprites" + App.pathVariable + "Player2Yellow.png"));
                    break;
                case 10:
                    fl.loadFromFile(FileSystems.getDefault().getPath(System.getProperty("user.dir") + App.pathVariable
                            + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "Enemy.png"));
                    break;
            }
            //.getPath(System.getProperty("user.dir") + App.pathVariable + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "Map1.png"));
            fl.setRepeated(false);
            fl.setSmooth(true);
        } catch (IOException e) {
            System.out.println("Opps");
            e.printStackTrace();
        }
        return fl;
    }

    //Floor texture, I think
    public static final Texture getFloor(int floorType) {

        Texture fl = new Texture();
        try {
            switch(floorType)
            {
                case 0:
                    fl.loadFromFile(FileSystems.getDefault().getPath(
                    System.getProperty("user.dir") + App.pathVariable + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "SCC-210-Sci-Fi_-_0000s_0002_Floor-Tiles-2.png"));
                    break;
                case 1:
                    fl.loadFromFile(FileSystems.getDefault().getPath(
                    System.getProperty("user.dir") + App.pathVariable + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "SCC-210-Sci-Fi_-_0000s_0003_Floor-Tiles-4-Hor..png"));
                    break;
                case 2:
                    fl.loadFromFile(FileSystems.getDefault().getPath(
                    System.getProperty("user.dir") + App.pathVariable + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "SCC-210-Sci-Fi_-_0000s_0001_Floor-Tiles-1.png"));
                    break;
                case 3:
                    fl.loadFromFile(FileSystems.getDefault().getPath(
                    System.getProperty("user.dir") + App.pathVariable + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "SCC-210-Sci-Fi_-_0000s_0005_Floor-Tiles-1.1.png"));
                    break;
                case 4:
                    fl.loadFromFile(FileSystems.getDefault().getPath(
                    System.getProperty("user.dir") + App.pathVariable + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "SCC-210-Sci-Fi_-_0000s_0006_Floor-Tiles-1.2.png"));
                    break;
                case 5:
                    fl.loadFromFile(FileSystems.getDefault().getPath(
                    System.getProperty("user.dir") + App.pathVariable + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "SCC-210-Sci-Fi_-_0000s_0007_Floor-Tiles-2.1.png"));
                    break;
                case 6:
                    fl.loadFromFile(FileSystems.getDefault().getPath(
                    System.getProperty("user.dir") + App.pathVariable + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "SCC-210-Sci-Fi_-_0000s_0008_Floor-Tiles-2.2.png"));
                    break;
                case 7:
                    fl.loadFromFile(FileSystems.getDefault().getPath(
                    System.getProperty("user.dir") + App.pathVariable + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "SCC-210-Sci-Fi_-_0000s_0009_Staris-1.png"));
                    break;
                case 8:
                    fl.loadFromFile(FileSystems.getDefault().getPath(
                    System.getProperty("user.dir") + App.pathVariable + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "SCC-210-Sci-Fi_-_0000s_0010_Stairs-2.png"));
                    break;
                case 9:
                    fl.loadFromFile(FileSystems.getDefault().getPath(
                    System.getProperty("user.dir") + App.pathVariable + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "SCC-210_0001_portalTiles1.png"));
                    break;
                case 10:
                    fl.loadFromFile(FileSystems.getDefault().getPath(
                    System.getProperty("user.dir") + App.pathVariable + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "SCC-210_0003_portalTiles3.png"));
                    break;
                case 11:
                    fl.loadFromFile(FileSystems.getDefault().getPath(
                    System.getProperty("user.dir") + App.pathVariable + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "SCC-210_0002_portalTiles2.png"));
                    break;
                case 12:
                    fl.loadFromFile(FileSystems.getDefault().getPath(
                    System.getProperty("user.dir") + App.pathVariable + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "SCC-210-Sci-Fi_-_0000s_0004_Floor-Tiles-3-Hor..png"));
                    break;
                case 13:
                    fl.loadFromFile(FileSystems.getDefault().getPath(
                    System.getProperty("user.dir") + App.pathVariable + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "SCC-210-Sci-Fi_-_0000s_0004_Floor-Tiles-3-Hor Horizontal.png"));
                    break;
                case 14:
                    fl.loadFromFile(FileSystems.getDefault().getPath(
                    System.getProperty("user.dir") + App.pathVariable + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "SCC-210_HugeRoom.png"));
                    break;
                case 15:
                    fl.loadFromFile(FileSystems.getDefault().getPath(
                    System.getProperty("user.dir") + App.pathVariable + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "SCC-210_HugeRoomVertical.png"));
                    break;
                case 16:
                    fl.loadFromFile(FileSystems.getDefault().getPath(
                    System.getProperty("user.dir") + App.pathVariable + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "SCC-210_MerchantDroid.png"));
                    break;
            }
            fl.setRepeated(false);
            fl.setSmooth(true);
        } catch (IOException e) {
            System.out.println("Opps");
            e.printStackTrace();
        }
        return fl;
    }

    // User Interface Base Texture
    public static final Texture getUiTexture() {

        Texture fl = new Texture();
        try {
            fl.loadFromFile(FileSystems.getDefault().getPath(System.getProperty("user.dir")
                    + App.pathVariable + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "UI.png"));
            fl.setRepeated(false);
            fl.setSmooth(true);
        } catch (IOException e) {
            System.out.println("Opps");
            e.printStackTrace();
        }
        return fl;
    }

    public static final Texture getMenu() {

        Texture fl = new Texture();
        try {
            fl.loadFromFile(FileSystems.getDefault().getPath(System.getProperty("user.dir")
                    + App.pathVariable + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "menu.png"));
            fl.setRepeated(true);
            fl.setSmooth(true);
        } catch (IOException e) {
            System.out.println("Opps");
            e.printStackTrace();
        }
        return fl;
    }

    public static final Texture getInventory()
    {
        Texture fl = new Texture();
        try {
            fl.loadFromFile(FileSystems.getDefault().getPath(System.getProperty("user.dir")
                    + App.pathVariable + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "Inventory.png"));
            fl.setRepeated(false);
            fl.setSmooth(true);
        } catch (IOException e) {
            System.out.println("Opps");
            e.printStackTrace();
        }
        return fl;
    }

    public static final Texture getCustomMouseTexture() {

        Texture fl = new Texture();
        try {
            fl.loadFromFile(FileSystems.getDefault().getPath(
                    System.getProperty("user.dir") + App.pathVariable + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "mouseIcon.png"));
            fl.setRepeated(false);
            fl.setSmooth(true);
        } catch (IOException e) {
            System.out.println("Opps");
            e.printStackTrace();
        }
        return fl;
    }

    // Locked Gate Texture
    public static final Texture getLockedGateTexture(boolean vertical) {

        Texture fl = new Texture();
        try {
            if (vertical)
            fl.loadFromFile(FileSystems.getDefault().getPath(System.getProperty("user.dir")
                    + App.pathVariable + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "SCC-210-Sci-Fi_-_0000s_0012_Door-1 vertical.png"));
            else
                fl.loadFromFile(FileSystems.getDefault().getPath(System.getProperty("user.dir")
                    + App.pathVariable + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "SCC-210-Sci-Fi_-_0000s_0012_Door-1.png"));
            fl.setRepeated(true);
            fl.setSmooth(true);
        } catch (IOException e) {
            System.out.println("Opps");
            e.printStackTrace();
        }
        return fl;
    }

    // Unlocked Gate Texture LEFT
    public static final Texture getUnlockedGateLeft(boolean vertical) {

        Texture fl = new Texture();
        try {
            if (vertical)
                fl.loadFromFile(FileSystems.getDefault()
                    .getPath(System.getProperty("user.dir") + App.pathVariable + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "SCC-210_0001_Layer-0 vertical.png"));
            else
                fl.loadFromFile(FileSystems.getDefault()
                    .getPath(System.getProperty("user.dir") + App.pathVariable + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "SCC-210_0001_Layer-0.png"));
            fl.setRepeated(true);
            fl.setSmooth(true);
        } catch (IOException e) {
            System.out.println("Opps");
            e.printStackTrace();
        }
        return fl;
    }

    // Unlocked Gate Texture RIGHT
    public static final Texture getUnlockedGateRight(boolean vertical) {

        Texture fl = new Texture();
        try {
            if (vertical)
                fl.loadFromFile(FileSystems.getDefault().getPath(
                    System.getProperty("user.dir") + App.pathVariable + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "SCC-210_0000_Layer-0-copy vertical.png"));
            else
                fl.loadFromFile(FileSystems.getDefault().getPath(
                    System.getProperty("user.dir") + App.pathVariable + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "SCC-210_0000_Layer-0-copy.png"));
            fl.setRepeated(true);
            fl.setSmooth(true);
        } catch (IOException e) {
            System.out.println("Opps");
            e.printStackTrace();
        }
        return fl;
    }

    //Red gate
    public static final Texture getEnergyGateTextureRed(boolean vertical) {

        Texture fl = new Texture();
        try {
            if (vertical)
                fl.loadFromFile(FileSystems.getDefault().getPath(System.getProperty("user.dir")
                    + App.pathVariable + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "SCC-210_0000_RED-Locked vertical.png"));
            else
                fl.loadFromFile(FileSystems.getDefault().getPath(System.getProperty("user.dir")
                    + App.pathVariable + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "SCC-210_0000_RED-Locked.png"));
            fl.setRepeated(true);
            fl.setSmooth(true);
        } catch (IOException e) {
            System.out.println("Opps");
            e.printStackTrace();
        }
        return fl;
    }

    //Blue gate
    public static final Texture getEnergyGateTextureBlue(boolean vertical) {

        Texture fl = new Texture();
        try {
            if (vertical)
                fl.loadFromFile(FileSystems.getDefault().getPath(System.getProperty("user.dir")
                    + App.pathVariable + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "SCC-210-Sci-Fi_-_0000s_0019_Enenrgy-Gate-2 vertical.png"));
            else
                fl.loadFromFile(FileSystems.getDefault().getPath(System.getProperty("user.dir")
                    + App.pathVariable + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "SCC-210-Sci-Fi_-_0000s_0019_Enenrgy-Gate-2.png"));
            fl.setRepeated(true);
            fl.setSmooth(true);
        } catch (IOException e) {
            System.out.println("Opps");
            e.printStackTrace();
        }
        return fl;
    }

    //Yellow gate
    public static final Texture getEnergyGateTextureYellow(boolean vertical) {

        Texture fl = new Texture();
        try {
            if (vertical)
                fl.loadFromFile(FileSystems.getDefault().getPath(System.getProperty("user.dir")
                    + App.pathVariable + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "SCC-210_0001_Yellow-Locked vertical.png"));
            else
                fl.loadFromFile(FileSystems.getDefault().getPath(System.getProperty("user.dir")
                    + App.pathVariable + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "SCC-210_0001_Yellow-Locked.png"));
            fl.setRepeated(true);
            fl.setSmooth(true);
        } catch (IOException e) {
            System.out.println("Opps");
            e.printStackTrace();
        }
        return fl;
    }

    //Energy gate unlocked LEFT
    public static final Texture getEnergyGateUnlockedLeft(boolean vertical) {

        Texture fl = new Texture();
        try {
            if (vertical)
                fl.loadFromFile(FileSystems.getDefault().getPath(System.getProperty("user.dir")
                    + App.pathVariable + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "SCC-210_0000_unlocked_Left vertical.png"));
            else
                fl.loadFromFile(FileSystems.getDefault().getPath(System.getProperty("user.dir")
                    + App.pathVariable + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "SCC-210_0000_unlocked_Left.png"));
            fl.setRepeated(true);
            fl.setSmooth(true);
        } catch (IOException e) {
            System.out.println("Opps");
            e.printStackTrace();
        }
        return fl;
    }

    //Energy gate unlocked RIGHT
    public static final Texture getEnergyGateUnlockedRight(boolean vertical) {

        Texture fl = new Texture();
        try {
            if (vertical)
                fl.loadFromFile(FileSystems.getDefault().getPath(
                    System.getProperty("user.dir") + App.pathVariable + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "SCC-210_0001_unlocked_right vertical.png"));
            else
                fl.loadFromFile(FileSystems.getDefault().getPath(
                    System.getProperty("user.dir") + App.pathVariable + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "SCC-210_0001_unlocked_right.png"));
            fl.setRepeated(true);
            fl.setSmooth(true);
        } catch (IOException e) {
            System.out.println("Opps");
            e.printStackTrace();
        }
        return fl;
    }

    public static final Texture getStartScreenBack() {
        Texture fl = new Texture();
        try {
            fl.loadFromFile(FileSystems.getDefault()
                    .getPath(System.getProperty("user.dir") + App.pathVariable + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "StartScreen.jpg"));
            fl.setRepeated(false);
            fl.setSmooth(true);
        } catch (IOException e) {
            System.out.println("Opps");
            e.printStackTrace();
        }
        return fl;
    }

    public static final Texture getEndScreen() {
        Texture fl = new Texture();
        try {
            fl.loadFromFile(FileSystems.getDefault()
                    .getPath(System.getProperty("user.dir") + App.pathVariable + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "END-SCREEN.jpg"));
            fl.setRepeated(false);
            fl.setSmooth(true);
        } catch (IOException e) {
            System.out.println("Opps");
            e.printStackTrace();
        }
        return fl;
    }


    public static final Texture getPC() {

        Texture fl = new Texture();
        try {
            fl.loadFromFile(FileSystems.getDefault()
                    .getPath(System.getProperty("user.dir") + App.pathVariable + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "SCC-210_0000_PC.png"));
            fl.setRepeated(true);
            fl.setSmooth(true);
        } catch (IOException e) {
            System.out.println("Opps");
            e.printStackTrace();
        }
        return fl;
    }

    public static final Texture getGenerator(boolean state) {

        Texture fl = new Texture();
        try {
            if (state)
                fl.loadFromFile(FileSystems.getDefault().getPath(System.getProperty("user.dir") + App.pathVariable + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "SCC-210_Generator_Green.png"));
            else
                fl.loadFromFile(FileSystems.getDefault().getPath(System.getProperty("user.dir") + App.pathVariable + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "SCC-210_Generator_Red.png"));
            
            fl.setRepeated(true);
            fl.setSmooth(true);
        } catch (IOException e) {
            System.out.println("Opps");
            e.printStackTrace();
        }
        return fl;
    }

    public static final Texture getHealth() {
        Texture fl = new Texture();
        try {
            fl.loadFromFile(FileSystems.getDefault()
                    .getPath(System.getProperty("user.dir") + App.pathVariable + "sprites" + App.pathVariable + "ItemSprites" + App.pathVariable + "SCC-210_0001_heal-module.png"));
            fl.setRepeated(false);
            fl.setSmooth(true);
        } catch (IOException e) {
            System.out.println("Opps");
            e.printStackTrace();
        }
        return fl;
    }

    public static final Texture getHack() {
        Texture fl = new Texture();
        try {
            fl.loadFromFile(FileSystems.getDefault()
                    .getPath(System.getProperty("user.dir") + App.pathVariable + "sprites" + App.pathVariable + "ItemSprites" + App.pathVariable + "SCC-210_0003_hack-tool.png"));
            fl.setRepeated(false);
            fl.setSmooth(true);
        } catch (IOException e) {
            System.out.println("Opps");
            e.printStackTrace();
        }
        return fl;
    }

    public static final Texture getBomb() {
        Texture fl = new Texture();
        try {
            fl.loadFromFile(FileSystems.getDefault()
                    .getPath(System.getProperty("user.dir") + App.pathVariable + "sprites" + App.pathVariable + "ItemSprites" + App.pathVariable + "SCC-210_0000_bomb1.png"));
            fl.setRepeated(false);
            fl.setSmooth(true);
        } catch (IOException e) {
            System.out.println("Opps");
            e.printStackTrace();
        }
        return fl;
    }

    public static final Texture getBattery() {
        Texture fl = new Texture();
        try {
            fl.loadFromFile(FileSystems.getDefault()
                    .getPath(System.getProperty("user.dir") + App.pathVariable + "sprites" + App.pathVariable + "ItemSprites" + App.pathVariable + "SCC-210_0004_battery.png"));
            fl.setRepeated(false);
            fl.setSmooth(true);
        } catch (IOException e) {
            System.out.println("Opps");
            e.printStackTrace();
        }
        return fl;
    }

    public static final Texture getEMP() {
        Texture fl = new Texture();
        try {
            fl.loadFromFile(FileSystems.getDefault()
                    .getPath(System.getProperty("user.dir") + App.pathVariable + "sprites" + App.pathVariable + "ItemSprites" + App.pathVariable + "SCC-210_0005_EMP-Module.png"));
            fl.setRepeated(false);
            fl.setSmooth(true);
        } catch (IOException e) {
            System.out.println("Opps");
            e.printStackTrace();
        }
        return fl;
    }

    public static final Texture getBox() {
        Texture fl = new Texture();
        try {
            fl.loadFromFile(FileSystems.getDefault().getPath(
                    System.getProperty("user.dir") + App.pathVariable + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "SCC-210-Sci-Fi_-_0000_BigBox1.png"));
            fl.setRepeated(false);
            fl.setSmooth(true);
        } catch (IOException e) {
            System.out.println("Opps");
            e.printStackTrace();
        }
        return fl;

    }

    public static final Texture getDeathScreen() {
        Texture fl = new Texture();
        try {
            fl.loadFromFile(FileSystems.getDefault().getPath(
                    System.getProperty("user.dir") + App.pathVariable + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "Death Screen.png"));
            fl.setRepeated(false);
            fl.setSmooth(true);
        } catch (IOException e) {
            System.out.println("Opps");
            e.printStackTrace();
        }
        return fl;

    }

    public static final Texture getButton(boolean active, int type) {
        Texture fl = new Texture();
        try {
            switch(type)
            {
                case Button.BLUE:
                    if (active)
                        fl.loadFromFile(FileSystems.getDefault().getPath(System.getProperty("user.dir") + App.pathVariable + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "SCC-210_0003_Button-Activated.png"));
                    else
                        fl.loadFromFile(FileSystems.getDefault().getPath(System.getProperty("user.dir") + App.pathVariable + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "SCC-210_0006_Button-Deactivated.png"));
                    break;
                case Button.GREEN:
                    if (active)
                        fl.loadFromFile(FileSystems.getDefault().getPath(System.getProperty("user.dir") + App.pathVariable + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "SCC-210_0002_Button-Activated-Green.png"));
                    else
                        fl.loadFromFile(FileSystems.getDefault().getPath(System.getProperty("user.dir") + App.pathVariable + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "SCC-210_0005_Button-Deactivated-Green.png"));
                    break;
                case Button.RED:
                    if (active)
                        fl.loadFromFile(FileSystems.getDefault().getPath(System.getProperty("user.dir") + App.pathVariable + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "SCC-210_0001_Button-Activated-Red.png"));
                    else
                        fl.loadFromFile(FileSystems.getDefault().getPath(System.getProperty("user.dir") + App.pathVariable + "sprites" + App.pathVariable + "SCC-210 Icons" + App.pathVariable + "SCC-210_0004_Button-Deactivated-Red.png"));
                    break;
            }
            fl.setRepeated(false);
            fl.setSmooth(true);
        } catch (IOException e) {
            System.out.println("Opps");
            e.printStackTrace();
        }
        return fl;

    }
}