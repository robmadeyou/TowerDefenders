package com.gmail.robmadeyou;

public class BulletList {
	
	static int maxBullets = 600;
	
	static Bullet[] bullet = new Bullet[maxBullets];
	
	public static class bullets extends Bullet{

		public bullets(int x, int y, int w, int h , int enemyNum, int tOO) {
			super(x, y, w, h, enemyNum, tOO);
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
	public static void draw(){
		for(int i = 0; i < maxBullets; i++){
			if(bullet[i] != null){
				bullet[i].draw();
			}
		}
	}
	public static void onUpdate(){
		for(int i = 0; i < maxBullets; i++){
			if(bullet[i] != null){
				if(bullet[i].x != bullet[i].toXc && bullet[i].y != bullet[i].toYc){
					bullet[i].shoot(EnemyList.enemy[TowerList.towerList[bullet[i].tOO].enemyToAttack], 2);
				}
			}
		}
	}
}
