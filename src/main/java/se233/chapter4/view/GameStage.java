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
    private Keys keys;
    public GameStage () {
        keys = new Keys();
        gameStageImg = new Image(Launcher.class.getResourceAsStream("assets/Background.png"));
        ImageView backgroundImg = new ImageView(gameStageImg);
        backgroundImg.setFitHeight(HEIGHT);
        backgroundImg.setFitWidth(WIDTH);

//        gameCharacter = new GameCharacter(30, 30,0,0, KeyCode.A,KeyCode.D,KeyCode.W);
//        getChildren().addAll(backgroundImg, gameCharacter);
//
//        GameCharacter character2 = new GameCharacter(30, 30, 0, 0, KeyCode.LEFT, KeyCode.RIGHT, KeyCode.UP);
//        character2.xMaxVelocity = 10;
//        character2.yMaxVelocity = 20;
//        character2.getImageView().setImage(new Image(Launcher.class.getResourceAsStream("assets/rockman.png")));
//        getChildren().add(character2);

        GameCharacter mario = new GameCharacter(
                30, 30, 0, 0, "assets/MarioSheet.png", 4, 4, 1, 16, 32, KeyCode.A, KeyCode.D, KeyCode.W
        );

        GameCharacter rockman = new GameCharacter(
                150, 30, 0, 0, "assets/rockman.png", 10, 5, 2, 404, 384, KeyCode.LEFT, KeyCode.RIGHT, KeyCode.UP
        );

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