package shameless;

import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2i;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.GL_QUADS;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;

public class guiButton {
	
	static guiButton[] button = new guiButton[128];

		//Dimensions of box
		int x;
		int y;
		int h;
		int w;
		
		//Original + x,y,h, or w
		int oX;
		int oY;
		int oH;
		int oW;
		
		String state;
		boolean expand;
		
		Texture texture;
		guiButton(int x, int y, int h, int w, String state ,boolean expand,  Texture texture){
		this.x = x;
		this.y = y;
		this.h = h;
		this.w = w;
		
		oX = x;
		oY = y;
		oH = h;
		oW = w;
		
		this.state = state;
		this.expand = expand;
		this.texture = texture;
		}
		
		
		boolean isMouseOver(){
			int mX = Mouse.getX();
			int mY = Display.getHeight() - Mouse.getY();
			if(mX >= x && mX <= x + w && mY >= y && mY <= y + h){
				return true;
			}
			return false;
		}
		
		boolean isPressed(){
			if(isMouseOver()){
				while(Mouse.next()){
					if(Mouse.getEventButtonState()){
						if(Mouse.isButtonDown(1)){
							return true;
						}
					}
				}
			}
			return false;
		}
		
		void expandSize(){
			
			if(isMouseOver()){
				for(int i = 0; i < 20; i++){
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				w += 20;
				h += 20;
				}
			}else{
				if(w != oW){
					w -= 20;
				}
				if(h != oH){
					h -= 20;
				}
			}
		}
		void onUpdate(String gameState){
			if(gameState == state){
				
				isMouseOver();
				isPressed();
				expandSize();
				draw();
			}
		}
		
		
		void draw(){
			texture.bind();
			if(texture != null){
				glBegin(GL_QUADS);
					glTexCoord2f(0 , 0);
					glVertex2i(x , y );
					glTexCoord2f(1 , 0);
					glVertex2i(x + w , y );
					glTexCoord2f(1 , 1);
					glVertex2i(x + w,y + h);
					glTexCoord2f(0 , 1);
					glVertex2i(x , y + h);
				glEnd();
			}else{
				glBegin(GL_QUADS);
					glVertex2i(x , y );
					glVertex2i(x + w , y );
					glVertex2i(x + w,y + h);
					glVertex2i(x , y + h);
				glEnd();
			}
		}
}
