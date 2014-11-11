package com.gmail.robmadeyou;

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
		g.addView ( new TriangleTests( g ) );
		g.start();
	}
}
