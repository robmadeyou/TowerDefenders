package com.gmail.robmadeyou;

import com.abereth.draw.Color;
import com.abereth.game.Game;
import com.abereth.tests.trianges.TriangleTests;

/**
 * Created by jeremiah on 11/11/2014.
 */
public class Main {

	public static void main ( String[] args )
	{
		Game g = new Game( 1024, 512 );
		g.setTaskBarIcon( "res\\icon16.png", "res\\icon32.png" );
		TriangleTests view = new TriangleTests( g );
		view.VIEW_COLOR = Color.BISQUE_2;
		view.fadeIn( 1 );
		g.addView ( view );
		g.start();
	}
}
