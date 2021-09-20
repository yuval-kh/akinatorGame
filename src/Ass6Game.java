import animationsandgame.AnimationRunner;
import animationsandgame.GameLevel;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import interfaces.LevelInformation;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Ass3Game.
 * The main class creates a new game
 * @author Yuval Khanimov
 * <yuval953@gmail.com>
 * ID 318970902 */
public class Ass6Game {
    /**
     * create a new game initializing it and runs the game.
     * @param args the levels order.
     */
    public static void main(String[] args) {
        int width = GameLevel.getWIDTH();
        int height = GameLevel.getHEIGHT();
        List<LevelInformation> levels = argsToLevels(args); //gets the levels order list
        GUI gui = new GUI("arkanoid", width, height); //new gui
        KeyboardSensor keyboardSensor = gui.getKeyboardSensor(); //new keyboardSensor
        AnimationRunner ar = new AnimationRunner(gui); //new animation runner
        levels.GameFlow g = new levels.GameFlow(ar, keyboardSensor, gui);
        g.runLevels(levels); //run all the levels using the GameFlow class
        gui.close(); //close the gui at the end.
    }

    /**
     * gets from the args string the list of levels.
     * @param args the arguments of the program.
     * @return the list of levels.
     */
    private static List<LevelInformation> argsToLevels(String[] args) {
        if (args.length == 0) {
            //if there are no arguments its the regular order.
            return emptyArgs();
        }
        List<LevelInformation> levels = new ArrayList<>(); //new level list.
        for (int i = 0; i < args.length; i++) {
            //for every argument
            int level = toInteger(args[i]); //try to make int of it.
            switch (level) {
                //for every legal level - add it to levels list.
                case 1: levels.add(new levels.DirectHitLevel());
                    break;
                case 2: levels.add(new levels.WideEasyLevel());
                    break;
                case 3: levels.add(new levels.Green3Level());
                    break;
                case 4: levels.add(new levels.FinalFourLevel());
                    break;
                default:break;
            }
        }
        if (levels.isEmpty()) {
            //if all the arguments were illegal create a regular order of levels.
            return emptyArgs();
        }
        return levels; //return the final list.
    }

    /**
     * converts a string to int of level number.
     * @param s the string that should be level number.
     * @return the number.
     */
    private static int toInteger(String s) {
        try {
            //if the string can be converted to int- return the int
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            //if not its illegal return 0 (there isn't level 0 anyway)
            return 0;
        } catch (NullPointerException e) {
            return 0;
        }
    }

    /**
     * create a list of standard order of levels.
     * @return list with the regular order.
     */
    private static List<LevelInformation> emptyArgs() {
        List<LevelInformation> levels = new ArrayList<>();
        levels.add(new levels.DirectHitLevel());
        levels.add(new levels.WideEasyLevel());
        levels.add(new levels.Green3Level());
        levels.add(new levels.FinalFourLevel());
        return  levels;
    }
}
