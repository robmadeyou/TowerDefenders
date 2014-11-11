package old.com.gmail.robmadeyou;

public class EnemyList {
	
	static int maxEnemies = 500;
	static int enemyNum = 0;
	static Enemy[] enemy = new Enemy[maxEnemies];
	
	public static class Enemies extends Enemy{

		public Enemies(int x, int y, int width, int height, int health) {
			super(x, y, width, height, health);
		}

		@Override
		public boolean isSelected() {
			// TODO Auto-generated method stub
			return false;
		}
	}
	
	public static  void addEnemy(Enemy e){
		for(int i = 0; i < maxEnemies; i++){
			if(enemy[i] == null){
				enemyNum++;
				enemy[i] = e;
				enemy[i].number = i;
				break;
			}
		}
	}
	
	public static void renderAll(){
		for(int i = 0; i < maxEnemies; i++){
			if(enemy[i] != null){
				enemy[i].draw();
			}
		}
	}
	
	public static void updateAll(int delta){
		for(int i = 0; i < maxEnemies; i++){
			if(enemy[i] != null){
				enemy[i].onUpdate();
				if(enemy[i].isLiving){
					enemy[i].x += (int) (delta / 4);
					if(enemy[i].health <= 0){
						enemy[i].isLiving = false;
					}
				}
				if(!enemy[i].isLiving){
					enemy[i] = null;
					enemyNum --;
				}
			}
		}
	}
}
