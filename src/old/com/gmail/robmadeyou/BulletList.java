package old.com.gmail.robmadeyou;


public class BulletList {
	
	static int maxBullets = 600;
	
	static Bullet[] bullet = new Bullet[maxBullets];
	
	public static class bullets extends Bullet{

		public bullets(int x, int y, int w, int h , int enemyNum, double speed, int tOO) {
			super(x, y, w, h, enemyNum,speed, tOO);
		}

		@Override
		public boolean isSelected() {
			// TODO Auto-generated method stub
			return false;
		}
		
	}
	
	public static void addBullet(Bullet e){
		for(int i = 0; i < maxBullets; i++){
			if(bullet[i] == null){
				bullet[i] = e;
				break;
			}
		}
	}
	public static void draw(int i){
		bullet[i].draw();
	}
	public static void onUpdate(int delta){
		for(int i = 0; i < maxBullets; i++){
			if(bullet[i] != null){
				draw(i);
				moveToTarget(i, delta);
			}
		}
	}
	public static void moveToTarget(int i, int speed){
		
		if(bullet[i] != null && EnemyList.enemy[BulletList.bullet[i].enemyNum] != null){
		bullet[i].hasTarget = true;
		int x = bullet[i].x;
		int y = bullet[i].y;
		int w = bullet[i].w;
		int h = bullet[i].h;
		int toX = bullet[i].toXc;
		int toY = bullet[i].toYc;
		
		int eX = EnemyList.enemy[BulletList.bullet[i].enemyNum].x;
		int eY = EnemyList.enemy[BulletList.bullet[i].enemyNum].y;
		int eW = EnemyList.enemy[BulletList.bullet[i].enemyNum].width;
		int eH = EnemyList.enemy[BulletList.bullet[i].enemyNum].height;
		boolean one = eX >= x && eX <= x + w && eY >= y && eY <= y + h;
		boolean two = x >= eX && x <= eX + eW && y >= eY && y <= eY + eH;
		if(x != toX && y != toY){
			bullet[i].shoot(EnemyList.enemy[BulletList.bullet[i].enemyNum], speed);
		}
		if(one || two){
			EnemyList.enemy[BulletList.bullet[i].enemyNum].health --;
			bullet[i] = null;
		}
		}
		if(bullet[i] != null){
			bullet[i].hasTarget = false;
			bullet[i].moveAfterShoot(bullet[i].ldX, bullet[i].ldY, speed);
		}
	}
}
