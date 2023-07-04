package main;


import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Player extends Entity {
  GamePanel gp;
  
  KeyHandler keyH;
  
  public final int screenX;
  
  public final int screenY;
  
  public int hasKey = 0;
  
  boolean bootsOn = false;
  
  int bootsCounter = 0;
  
  public Player(GamePanel gp, KeyHandler keyH) {
    this.gp = gp;
    this.keyH = keyH;
    gp.getClass();
    gp.getClass();
    this.screenX = 768 / 2 - 48 / 2;
    gp.getClass();
    gp.getClass();
    this.screenY = 576 / 2 - 48 / 2;
    this.solidArea = new Rectangle();
    this.solidArea.x = 8;
    this.solidArea.y = 16;
    this.solidAreaDefaultX = this.solidArea.x;
    this.solidAreaDefaultY = this.solidArea.y;
    this.solidArea.width = 32;
    this.solidArea.height = 32;
    setDefaultValues();
    getPlayerImage();
  }
  
  public void setDefaultValues() {
    this.gp.getClass();
    this.worldX = 48 * 23;
    this.gp.getClass();
    this.worldY = 48 * 21;
    this.speed = 4;
    this.direction = "down";
  }
  
  public void getPlayerImage() {
    try {
      this.up1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_1.png"));
      this.up2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_2.png"));
      this.down1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1.png"));
      this.down2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_2.png"));
      this.left1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_1.png"));
      this.left2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_2.png"));
      this.right1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_1.png"));
      this.right2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_2.png"));
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
  
  public void update() {
    if (this.keyH.upPressed || this.keyH.downPressed || 
      this.keyH.leftPressed || this.keyH.rightPressed) {
      if (this.keyH.upPressed) {
        this.direction = "up";
      } else if (this.keyH.downPressed) {
        this.direction = "down";
      } else if (this.keyH.leftPressed) {
        this.direction = "left";
      } else if (this.keyH.rightPressed) {
        this.direction = "right";
      } 
      this.collisionOn = false;
      this.gp.cChecker.checkTile(this);
      int objIndex = this.gp.cChecker.checkObject(this, true);
      pickUpObject(objIndex);
      if (!this.collisionOn) {
        String str;
        switch ((str = this.direction).hashCode()) {
          case 3739:
            if (!str.equals("up"))
              break; 
            this.worldY -= this.speed;
            break;
          case 3089570:
            if (!str.equals("down"))
              break; 
            this.worldY += this.speed;
            break;
          case 3317767:
            if (!str.equals("left"))
              break; 
            this.worldX -= this.speed;
            break;
          case 108511772:
            if (!str.equals("right"))
              break; 
            this.worldX += this.speed;
            break;
        } 
      } 
      this
        
        .spriteCounter = this.spriteCounter + 1;
      if (this.spriteCounter > 12) {
        if (this.spriteNum == 1) {
          this.spriteNum = 2;
        } else if (this.spriteNum == 2) {
          this.spriteNum = 1;
        } 
        this.spriteCounter = 0;
      } 
    } 
  }
  
  public void pickUpObject(int i) {
    if (i != 999) {
      String objectName = (this.gp.obj[i]).name;
      String str1;
      switch ((str1 = objectName).hashCode()) {
        case 75327:
          if (!str1.equals("Key"))
            break; 
          this.gp.playSE(1);
          this.hasKey++;
          this.gp.obj[i] = null;
          this.gp.ui.showMessage("You got a key!");
          break;
        case 2136014:
          if (!str1.equals("Door"))
            break; 
          if (this.hasKey > 0) {
            this.gp.playSE(3);
            this.gp.obj[i] = null;
            this.hasKey--;
            this.gp.ui.showMessage("You opened the door!");
            break;
          } 
          this.gp.ui.showMessage("You need a key!");
          break;
        case 64369569:
          if (!str1.equals("Boots"))
            break; 
          this.gp.playSE(2);
          this.speed++;
          this.gp.obj[i] = null;
          this.gp.ui.showMessage("Speed up!");
          break;
        case 65074913:
          if (!str1.equals("Chest"))
            break; 
          this.gp.ui.gameFinished = true;
          this.gp.stopMusic();
          this.gp.playSE(4);
          break;
      } 
    } 
  }
  
  public void draw(Graphics2D g2) {
    BufferedImage image = null;
    String str;
    switch ((str = this.direction).hashCode()) {
      case 3739:
        if (!str.equals("up"))
          break; 
        if (this.spriteNum == 1)
          image = this.up1; 
        if (this.spriteNum == 2)
          image = this.up2; 
        break;
      case 3089570:
        if (!str.equals("down"))
          break; 
        if (this.spriteNum == 1)
          image = this.down1; 
        if (this.spriteNum == 2)
          image = this.down2; 
        break;
      case 3317767:
        if (!str.equals("left"))
          break; 
        if (this.spriteNum == 1)
          image = this.left1; 
        if (this.spriteNum == 2)
          image = this.left2; 
        break;
      case 108511772:
        if (!str.equals("right"))
          break; 
        if (this.spriteNum == 1)
          image = this.right1; 
        if (this.spriteNum == 2)
          image = this.right2; 
        break;
    } 
    this.gp.getClass();
    this.gp.getClass();
    g2.drawImage(image, this.screenX, this.screenY, 48, 48, null);
  }
}
