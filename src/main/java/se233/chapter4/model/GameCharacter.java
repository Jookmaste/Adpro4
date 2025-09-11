package se233.chapter4.model;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import se233.chapter4.Launcher;
import se233.chapter4.view.GameStage;

public class GameCharacter extends Pane {
    private static final Logger logger = LogManager.getLogger(GameCharacter.class);
    public int CHARACTER_WIDTH ;
    public int CHARACTER_HEIGHT ;
    private Image gameCharacterImg;
    private AnimatedSprite imageView;
    private int x;
    private int y;
    private KeyCode leftKey;
    private KeyCode rightKey;
    private KeyCode upKey;
    int xVelocity = 0;
    boolean isMoveLeft= false;
    boolean isMoveRight= false;
    int yVelocity = 0;
    boolean isFalling = true;
    boolean canJump= false;
    boolean isJumping = false;
    int xAcceleration = 1;
    int yAcceleration = 1;
    public int xMaxVelocity= 7;
    public int yMaxVelocity= 17;

    public GameCharacter(int x, int y, int offsetX, int offsetY, String assetPath, int frameCount, int columns, int rows, int frameWidth, int frameHeight, KeyCode leftKey, KeyCode rightKey, KeyCode upKey, int width, int height ) {
        this.x = x;
        this.y = y;
        this.setTranslateX(x);
        this.setTranslateY(y);
        this.gameCharacterImg = new Image(Launcher.class.getResourceAsStream(assetPath));
        this.CHARACTER_WIDTH = width;
        this.CHARACTER_HEIGHT = height;
        this.imageView = new AnimatedSprite(gameCharacterImg, frameCount, columns, rows, offsetX, offsetY, frameWidth, frameHeight);
        this.imageView.setFitWidth(width);
        this.imageView.setFitHeight(height);
        this.leftKey = leftKey;
        this.rightKey = rightKey;
        this.upKey = upKey;
        this.getChildren().addAll(this.imageView);
    }

    public void moveX(){
        setTranslateX(x);
        if(isMoveLeft){
            xVelocity =xVelocity>=xMaxVelocity? xMaxVelocity: xVelocity+xAcceleration;
            x =x-xVelocity;
        }
        if(isMoveRight){
            xVelocity =xVelocity>=xMaxVelocity? xMaxVelocity: xVelocity+xAcceleration;
            x= x+ xVelocity;
        }
    }
    public void moveY() {
        setTranslateY(y);
        if(isFalling) {
            yVelocity =yVelocity >=yMaxVelocity?yMaxVelocity :yVelocity+yAcceleration;
            y = y + yVelocity;
        }else if(isJumping){
            yVelocity =yVelocity <=0?0: yVelocity-yAcceleration;
            y= y-yVelocity;
        }
    }
    public void repaint() {
        moveX();
        moveY();
    }
    public void moveLeft() {
        setScaleX(-1);
        isMoveLeft= true;
        isMoveRight= false;
    }
        public void moveRight() {
            setScaleX(1);
            isMoveLeft= false;
            isMoveRight= true;
    }
    public void stop() {
        isMoveLeft= false;
        isMoveRight= false;
    }
    public void checkReachGameWall() {
        if(x <= 0) {
            x = 0;
            logger.debug("เดินติดแล้ว");
        } else if( x+getWidth() >= GameStage.WIDTH) {
            x = GameStage.WIDTH-(int)getWidth();
            logger.debug("เดินติดแล้ว");
        }
    }
    public void jump() {
        if (canJump) {
            yVelocity = yMaxVelocity;
            canJump = false;
            isJumping = true;
            isFalling = false;
        }
    }
    public void checkReachHighest () {
        if(isJumping && yVelocity <= 0) {
            isJumping = false;
            isFalling = true;
            yVelocity = 0;
        }
    }
    public void checkReachFloor() {
        if (isFalling && y >= GameStage.GROUND - CHARACTER_HEIGHT) {
            isFalling = false;
            canJump= true;
            yVelocity = 0;
        }
    }
    public void trace() {
        logger.info("x:{} y:{} vx:{} vy:{}",x,y,xVelocity,yVelocity);
        if(x <= 0) {
            x = 0;
        } else if( x+getWidth() >= GameStage.WIDTH) {
            x = GameStage.WIDTH-(int)getWidth();
        }
    }

    public KeyCode getLeftKey() {
        return leftKey;
    }

    public KeyCode getRightKey() {
        return rightKey;
    }

    public KeyCode getUpKey() {
        return upKey;
    }

    public AnimatedSprite getImageView() {
        return imageView;
    }

}
