package com.gmail.robmadeyou;

public class EnemyList {
	
	static int maxEnemies = 500;
	static int enemyNum = 0;
	static int enemyAttack = 0;
	static Enemy[] enemy = new Enemy[maxEnemies];
	
	public static class Enemies extends Enemy{

		public Enemies(int x, int y, int width, int height) {
			super(x, y, width, height);
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
				enemy[i] = e;
				enemyNum++;
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
	
	public static void updateAll(){
		for(int i = 0; i < maxEnemies; i++){
			if(enemy[i] != null){
				if(!enemy[i].isLiving){
					enemy[i] = null;
				}
			}
		}
	}
	public static int attackEnemy(int mX, int mY, int mW, int mH){
		for(int i = 0; i < maxEnemies; i++){
			if(enemy[i] != null){
				if((enemy[i].x + (enemy[i].width / 2) <= mX + mW && enemy[i].getX() + (enemy[i].getWidth() / 2) >= mX && enemy[i].getY() + (enemy[i].getHeight() / 2) >= mY
						&& enemy[i].getY() + (enemy[i].getHeight() / 2) <= mY + mH)){
					enemyAttack = i;
					return i;
				}
			}
		}
		return 0;
	}
}
