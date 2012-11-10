package com.gmail.robmadeyou;


public abstract class TowerList{
	
	static int maxTowers = 100;
	static Towers[] towerList = new Towers[maxTowers];
	
    public static class Towerse extends Towers{

		public Towerse(int x, int y, int width, int height, String name) {
			super(x, y, width, height, name);
		}

		@Override
		public void draw() {
			// TODO Auto-generated method stub
			
		}
    }
	
	 public static void addEntity(Towers tower)
     {
         for (int i = 0; i < maxTowers; i++)
         {
             if (towerList[i] == null)
             {
                 towerList[i] = tower;
                 towerList[i].number = i;
                 break;
             }
         }
     }
	 
	 public static void renderAll(){
		 for (int x = 0; x < maxTowers; x++)
		    {
		      if (towerList[x] == null)
		        continue;
		      towerList[x].Render();
		    }
	 }
	 public static void updateAll(int delta){
		 for(int x = 0; x < maxTowers; x++){
			 if(towerList[x] != null){
				 towerList[x].onUpdate(delta);
			 }
		 }
	 }
	
}
