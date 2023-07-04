package main;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class SuperObject {
  public BufferedImage image;
  
  public String name;
  
  public boolean collision = false;
  
  public int worldX;
  
  public int worldY;
  
  public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
  
  public int solidAreaDefaultX = 0;
  
  public int solidAreaDefaultY = 0;
  
  public void draw(Graphics2D g2, GamePanel gp) {
    int screenX = this.worldX - gp.player.worldX + gp.player.screenX;
    int screenY = this.worldY - gp.player.worldY + gp.player.screenY;
    gp.getClass();
    gp.getClass();
    gp.getClass();
    gp.getClass();
    if (this.worldX + 48 > gp.player.worldX - gp.player.screenX && this.worldX - 48 < gp.player.worldX + gp.player.screenX && this.worldY + 48 > gp.player.worldY - gp.player.screenY && this.worldY - 48 < gp.player.worldY + gp.player.screenY) {
      gp.getClass();
      gp.getClass();
      g2.drawImage(this.image, screenX, screenY, 48, 48, null);
    } 
  }
}
