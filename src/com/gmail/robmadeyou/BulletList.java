package com.gmail.robmadeyou;

import org.lwjgl.opengl.Display;

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
	public static void onUpdate(int delta){
		for(int i = 0; i < maxBullets; i++){
			if(bullet[i] != null){
				//TODO Fix the bullets... so they actually move out after they have been shot rather than get stuck and keep moving forward and back
				Enemy e = EnemyList.enemy[TowerList.towerList[bullet[i].tOO].enemyToAttack];
				Bullet b = bullet[i];
				if(e != null){
					if(!e.hasBulletTargeted){
				if(bullet[i].x != bullet[i].toXc && bullet[i].y != bullet[i].toYc && b.hasTarget){
					b.hasTarget = true;
					bullet[i].shoot(EnemyList.enemy[TowerList.towerList[bullet[i].tOO].enemyToAttack], (int) (delta * 0.5));
				}
				}
				}
				if(e != null){
					if(e.x <=  b.x + (b.w / 2) && e.x + e.width >= b.x + (b.w / 2) && e.y <= b.y + (b.h / 2) && e.y + e.height >= b.y + (b.h / 2)){
						e.health -= TowerList.towerList[bullet[i].tOO].bulletUpgrade;
						bullet[i] = null;
						}
				}
				if(b.hasTarget){
					int dX = b.ldX;
					int dY = b.ldY;
					b.x -= dX;
					b.y -= dY;
			}
				if(b.x < 0 || b.x > Display.getWidth() || b.y > Display.getHeight() || b.y < 0){
					b = null;
				}
			}
		}
	}
}
