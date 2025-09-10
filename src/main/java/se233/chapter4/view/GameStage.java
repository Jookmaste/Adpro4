package se233.chapter4.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import se233.chapter4.Launcher;
import se233.chapter4.model.GameCharacter;
import se233.chapter4.model.Keys;

public class GameStage extends Pane {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 400;
    public final static int GROUND = 300;
    private Image gameStageImg;
    private GameCharacter gameCharacter;
    private GameCharacter mario;
    private GameCharacter rockman;
    public GameCharacter getMario() { return mario; }
    public GameCharacter getRockman() { return rockman; }
    private Keys keys;
    public GameStage () {
        keys = new Keys();
        gameStageImg = new Image(Launcher.class.getResourceAsStream("assets/Background.png"));
        ImageView backgroundImg = new ImageView(gameStageImg);
        backgroundImg.setFitHeight(HEIGHT);
        backgroundImg.setFitWidth(WIDTH);

        mario = new GameCharacter(
                30, 30, 0, 0, "assets/MarioSheet.png", 4, 4, 1, 16, 32, KeyCode.A, KeyCode.D, KeyCode.W
        );
        mario.xMaxVelocity = 7;
        mario.yMaxVelocity = 17;

        rockman = new GameCharacter(
                150, 30, 0, 0, "assets/rockman.png", 10, 5, 2, 404, 384, KeyCode.LEFT, KeyCode.RIGHT, KeyCode.UP
        );
        rockman.xMaxVelocity = 12;
        rockman.yMaxVelocity = 25;

        gameCharacter = mario;
        getChildren().addAll(backgroundImg, mario, rockman);

    }

    public GameCharacter getGameCharacter() {
        return gameCharacter;
    }

    public Keys getKeys() {
        return keys;
    }

    public GameCharacter getGameCharacterList() {
        return gameCharacter;
    }
}