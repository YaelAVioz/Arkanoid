package levels;

import backgrounds.Background3;
import game_settings.*;
import geometry.*;
import interfaces.*;
import sprites.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/***
 * this class defines the level "Green3".
 */
public class Green3 implements LevelInformation {
    static final int BOARD_WIDTH = 800;
    static final int BOARD_HEIGHT = 600;
    static final int BOARDER_SHOT_SIDE = 10;

    static final int BLOCK_HEIGHT = 20;
    static final int BLOCK_WIDTH = 50;

    private Color[] colors = {Color.red, Color.magenta, Color.pink, Color.orange, Color.green};

    /***
     * return the number of balls in this level.
     * @return 1.
     */
    @Override
    public int numberOfBalls() {
        return 2;
    }

    /***
     * The initial velocity of each ball.
     * @return
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocityList = new ArrayList<Velocity>();
        for (int i = 0; i < numberOfBalls(); i++) {
            velocityList.add(new Velocity(0, -1));
        }
        return velocityList;
    }

    /***
     * the paddle speed.
     * @return paddle speed.
     */
    @Override
    public int paddleSpeed() {
        return 1;
    }

    /***
     * return the paddle width.
     * @return the paddle width.
     */
    @Override
    public int paddleWidth() {
        return 150;
    }

    /***
     * The level name will be displayed at the top of the screen.
     * @return the level name.
     */
    @Override
    public String levelName() {
        return "Green 3";
    }

    /***
     * Returns a sprite with the background of the level.
     * @return
     */
    @Override
    public Sprite getBackground() {
        return new Background3();
    }

    /***
     * The Blocks that make up this level.
     * @return
     */
    @Override
    public List<Block> blocks() {
        List<Block> blocksList = new ArrayList<Block>();
        for (int i = 0; i < 5; i++) {
            for (int j = 1; j < 12 - i; j++) {
                Point point = new Point(BOARD_WIDTH - BOARDER_SHOT_SIDE - (j * BLOCK_WIDTH),
                        150 + (i * BLOCK_HEIGHT));
                Rectangle rect = new Rectangle(point, BLOCK_WIDTH, BLOCK_HEIGHT);
                Block block = new Block(rect, colors[i]);
                blocksList.add(block);
            }
        }
        return blocksList;
    }

    /***
     * Number of blocks that should be removed.
     * @return number of blocks.
     */
    @Override
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }

    @Override
    public void createBalls(GameEnvironment environment, GameLevel g) {
        for (int i = 0; i < this.numberOfBalls(); i++) {
            Ball ball = new Ball(330.0 + (i * 60), 400.0, 5, Color.white, environment);
            ball.addToGame(g);
            ball.setVelocity(this.initialBallVelocities().get(i));
            ball.setBounds(800);
        }
    }
}
