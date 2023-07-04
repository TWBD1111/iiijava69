package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

public class UI {
  GamePanel gp;
  
  Font arial_40;
  
  Font arial_80B;
  
  BufferedImage keyImage;
  
  public boolean messageOn = false;
  
  public String message = "";
  
  int messageCounter = 0;
  
  public boolean gameFinished = false;
  
  double playTime;
  
  DecimalFormat dFormat = new DecimalFormat("#0.00");
  
  public UI(GamePanel gp) {
    this.gp = gp;
    this.arial_40 = new Font("Arial", 0, 40);
    this.arial_80B = new Font("Arial", 1, 80);
    OBJ_Key key = new OBJ_Key();
    this.keyImage = key.image;
  }
  
  public void showMessage(String text) {
    this.message = text;
    this.messageOn = true;
  }
  
  public void draw(Graphics2D g2) {
    if (this.gameFinished) {
      g2.setFont(this.arial_40);
      g2.setColor(Color.white);
      String text = "You found the treasure!";
      int textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
      this.gp.getClass();
      int x = 768 / 2 - textLength / 2;
      this.gp.getClass();
      this.gp.getClass();
      int y = 576 / 2 - 48 * 3;
      g2.drawString(text, x, y);
      text = "Your Time is " + this.dFormat.format(this.playTime) + "!";
      textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
      this.gp.getClass();
      x = 768 / 2 - textLength / 2;
      this.gp.getClass();
      this.gp.getClass();
      y = 576 / 2 + 48 * 4;
      g2.drawString(text, x, y);
      g2.setFont(this.arial_80B);
      g2.setColor(Color.yellow);
      text = "Congratulations!";
      textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
      this.gp.getClass();
      x = 768 / 2 - textLength / 2;
      this.gp.getClass();
      this.gp.getClass();
      y = 576 / 2 + 48 * 2;
      g2.drawString(text, x, y);
      this.gp.gameThread = null;
    } else {
      g2.setFont(this.arial_40);
      g2.setColor(Color.white);
      this.gp.getClass();
      this.gp.getClass();
      this.gp.getClass();
      this.gp.getClass();
      g2.drawImage(this.keyImage, 48 / 2, 48 / 2, 48, 48, null);
      g2.drawString("x " + this.gp.player.hasKey, 74, 65);
      this.playTime += 0.016666666666666666D;
      this.gp.getClass();
      g2.drawString("Time:" + this.dFormat.format(this.playTime), 48 * 11, 65);
      if (this.messageOn) {
        g2.setFont(g2.getFont().deriveFont(30.0F));
        this.gp.getClass();
        this.gp.getClass();
        g2.drawString(this.message, 48 / 2, 48 * 5);
        this.messageCounter++;
        if (this.messageCounter > 120) {
          this.messageCounter = 0;
          this.messageOn = false;
        } 
      } 
    } 
  }
}
