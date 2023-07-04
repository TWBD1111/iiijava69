package main;


public class AssetSetter {
  GamePanel gp;
  
  public AssetSetter(GamePanel gp) {
    this.gp = gp;
  }
  
  public void setObject() {
    this.gp.obj[0] = (SuperObject)new OBJ_Key();
    this.gp.getClass();
    (this.gp.obj[0]).worldX = 23 * 48;
    this.gp.getClass();
    (this.gp.obj[0]).worldY = 7 * 48;
    this.gp.obj[1] = (SuperObject)new OBJ_Key();
    this.gp.getClass();
    (this.gp.obj[1]).worldX = 23 * 48;
    this.gp.getClass();
    (this.gp.obj[1]).worldY = 40 * 48;
    this.gp.obj[2] = (SuperObject)new OBJ_Key();
    this.gp.getClass();
    (this.gp.obj[2]).worldX = 38 * 48;
    this.gp.getClass();
    (this.gp.obj[2]).worldY = 8 * 48;
    this.gp.obj[3] = (SuperObject)new OBJ_Door();
    this.gp.getClass();
    (this.gp.obj[3]).worldX = 10 * 48;
    this.gp.getClass();
    (this.gp.obj[3]).worldY = 11 * 48;
    this.gp.obj[4] = (SuperObject)new OBJ_Door();
    this.gp.getClass();
    (this.gp.obj[4]).worldX = 8 * 48;
    this.gp.getClass();
    (this.gp.obj[4]).worldY = 28 * 48;
    this.gp.obj[5] = (SuperObject)new OBJ_Door();
    this.gp.getClass();
    (this.gp.obj[5]).worldX = 12 * 48;
    this.gp.getClass();
    (this.gp.obj[5]).worldY = 22 * 48;
    this.gp.obj[6] = (SuperObject)new OBJ_Chest();
    this.gp.getClass();
    (this.gp.obj[6]).worldX = 10 * 48;
    this.gp.getClass();
    (this.gp.obj[6]).worldY = 7 * 48;
    this.gp.obj[7] = (SuperObject)new OBJ_Boots();
    this.gp.getClass();
    (this.gp.obj[7]).worldX = 37 * 48;
    this.gp.getClass();
    (this.gp.obj[7]).worldY = 42 * 48;
  }
}

