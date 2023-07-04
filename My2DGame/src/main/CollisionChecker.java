package main;



public class CollisionChecker {
  GamePanel gp;
  
  public CollisionChecker(GamePanel gp) {
    this.gp = gp;
  }
  
  public void checkTile(Entity entity) {
    int tileNum1, tileNum2, entityLeftWorldX = entity.worldX + entity.solidArea.x;
    int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
    int entityTopWorldY = entity.worldY + entity.solidArea.y;
    int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;
    this.gp.getClass();
    int entityLeftCol = entityLeftWorldX / 48;
    this.gp.getClass();
    int entityRightCol = entityRightWorldX / 48;
    this.gp.getClass();
    int entityTopRow = entityTopWorldY / 48;
    this.gp.getClass();
    int entityBottomRow = entityBottomWorldY / 48;
    String str;
    switch ((str = entity.direction).hashCode()) {
      case 3739:
        if (!str.equals("up"))
          break; 
        this.gp.getClass();
        entityTopRow = (entityTopWorldY - entity.speed) / 48;
        tileNum1 = this.gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
        tileNum2 = this.gp.tileM.mapTileNum[entityRightCol][entityTopRow];
        if ((this.gp.tileM.tile[tileNum1]).collision || (this.gp.tileM.tile[tileNum2]).collision)
          entity.collisionOn = true; 
        break;
      case 3089570:
        if (!str.equals("down"))
          break; 
        this.gp.getClass();
        entityBottomRow = (entityBottomWorldY + entity.speed) / 48;
        tileNum1 = this.gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
        tileNum2 = this.gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
        if ((this.gp.tileM.tile[tileNum1]).collision || (this.gp.tileM.tile[tileNum2]).collision)
          entity.collisionOn = true; 
        break;
      case 3317767:
        if (!str.equals("left"))
          break; 
        this.gp.getClass();
        entityLeftCol = (entityLeftWorldX - entity.speed) / 48;
        tileNum1 = this.gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
        tileNum2 = this.gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
        if ((this.gp.tileM.tile[tileNum1]).collision || (this.gp.tileM.tile[tileNum2]).collision)
          entity.collisionOn = true; 
        break;
      case 108511772:
        if (!str.equals("right"))
          break; 
        this.gp.getClass();
        entityRightCol = (entityRightWorldX + entity.speed) / 48;
        tileNum1 = this.gp.tileM.mapTileNum[entityRightCol][entityTopRow];
        tileNum2 = this.gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
        if ((this.gp.tileM.tile[tileNum1]).collision || (this.gp.tileM.tile[tileNum2]).collision)
          entity.collisionOn = true; 
        break;
    } 
  }
  
  public int checkObject(Entity entity, boolean player) {
    int index = 999;
    for (int i = 0; i < this.gp.obj.length; i++) {
      if (this.gp.obj[i] != null) {
        entity.solidArea.x = entity.worldX + entity.solidArea.x;
        entity.solidArea.y = entity.worldY + entity.solidArea.y;
        (this.gp.obj[i]).solidArea.x = (this.gp.obj[i]).worldX + (this.gp.obj[i]).solidArea.x;
        (this.gp.obj[i]).solidArea.y = (this.gp.obj[i]).worldY + (this.gp.obj[i]).solidArea.y;
        String str;
        switch ((str = entity.direction).hashCode()) {
          case 3739:
            if (!str.equals("up"))
              break; 
            entity.solidArea.y -= entity.speed;
            if (entity.solidArea.intersects((this.gp.obj[i]).solidArea)) {
              if ((this.gp.obj[i]).collision)
                entity.collisionOn = true; 
              if (player)
                index = i; 
            } 
            break;
          case 3089570:
            if (!str.equals("down"))
              break; 
            entity.solidArea.y += entity.speed;
            if (entity.solidArea.intersects((this.gp.obj[i]).solidArea)) {
              if ((this.gp.obj[i]).collision)
                entity.collisionOn = true; 
              if (player)
                index = i; 
            } 
            break;
          case 3317767:
            if (!str.equals("left"))
              break; 
            entity.solidArea.x -= entity.speed;
            if (entity.solidArea.intersects((this.gp.obj[i]).solidArea)) {
              if ((this.gp.obj[i]).collision)
                entity.collisionOn = true; 
              if (player)
                index = i; 
            } 
            break;
          case 108511772:
            if (!str.equals("right"))
              break; 
            entity.solidArea.x += entity.speed;
            if (entity.solidArea.intersects((this.gp.obj[i]).solidArea)) {
              if ((this.gp.obj[i]).collision)
                entity.collisionOn = true; 
              if (player)
                index = i; 
            } 
            break;
        } 
        entity.solidArea.x = entity.solidAreaDefaultX;
        entity.solidArea.y = entity.solidAreaDefaultY;
        (this.gp.obj[i]).solidArea.x = (this.gp.obj[i]).solidAreaDefaultX;
        (this.gp.obj[i]).solidArea.y = (this.gp.obj[i]).solidAreaDefaultY;
      } 
    } 
    return index;
  }
}
