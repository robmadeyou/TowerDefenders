package com.gmail.robmadeyou.views;

import com.abereth.event.TimedEvent;
import com.abereth.game.Game;
import com.abereth.game.View;
import com.abereth.input.Keyboard;
import com.abereth.input.Mouse;
import org.dyn4j.dynamics.Body;
import org.dyn4j.dynamics.BodyFixture;
import org.dyn4j.dynamics.World;
import org.dyn4j.geometry.*;

import java.util.function.Consumer;

import static org.lwjgl.opengl.GL11.*;

/**
 * Created by jeremiah on 11/11/2014.
 */
public class IntroLoading extends View
{
	public IntroLoading( Game game )
	{
		super(game);
	}
	private long last = 0;
	public static final double NANO_TO_BASE = 1.0e9;
	public World world;
	@Override
	public void Initialize()
	{
		super.Initialize();
		this.world = new World();

		// create all your bodies/joints

		// create the floor
		Rectangle floorRect = new Rectangle(40, 0.5);
		Body floor = new Body();
		floor.addFixture(new BodyFixture(floorRect));
		floor.setMass( Mass.Type.INFINITE );
		// move the floor down a bit
		floor.translate(2, -10);
		floor.getFixtures().forEach( new Consumer<BodyFixture>()
		{
			@Override
			public void accept( BodyFixture bodyFixture )
			{
				bodyFixture.setRestitution( 1 );
			}
		} );
		this.world.addBody(floor);


		/*Body issTri = new Body();
		issTri.addFixture(Geometry.createIsoscelesTriangle(1.0, 3.0));
		issTri.setMass();
		issTri.translate(0.2, 3.0);
		this.world.addBody(issTri);

		Body equTri = new Body();
		equTri.addFixture(Geometry.createEquilateralTriangle(2.0));
		equTri.setMass();
		equTri.translate(0.2, 3.0);
		this.world.addBody(equTri);*/

		Body rightTri = new Body();
		rightTri.addFixture(Geometry.createRightTriangle(2.0, 1.0));
		rightTri.setMassType( Mass.Type.INFINITE );
		rightTri.setMass();
		rightTri.translate( 1, 0);
		this.world.addBody(rightTri);

		Body rectangle = new Body();
		rectangle.addFixture( Geometry.createSquare( 2 ) );
		rectangle.setMass();
		Transform t = new Transform();
		t.setRotation( Math.random() * 360 );
		rectangle.setTransform( t );
		// move the floor down a bit
		this.world.addBody(rectangle);

		this.getGame().GetEventManager().add( new TimedEvent<Game>()
		{
			@Override
			public void init( Game game )
			{
				super.init( game );

				SetInterval( 1000 );
			}

			@Override
			public void EachInterval( int delta, Game o )
			{
				Body rectangle = new Body();
				rectangle.addFixture( Geometry.createSquare( 2 ) );
				rectangle.setMass();
				Transform t = new Transform();
				t.setRotation( Math.random() * 360 );
				rectangle.setTransform( t );
				rectangle.translate( Math.random() * 20, 0 );
				// move the floor down a bit
				world.addBody(rectangle);
			}

			@Override
			public boolean isDone( Game o )
			{
				return false;
			}
		}, false );
	}

	@Override
	public void update(int delta)
	{

		if( Keyboard.isKeyPressed( Keyboard.Key.Space  ) )
		{
			this.world.setGravity( new Vector2( 2, 4 ) );
		}

		if( Mouse.isLeftMouseClicked() )
		{
			Body rightTri = new Body();
			rightTri.addFixture(Geometry.createRightTriangle( 2.0, 1.0 ));
			rightTri.setMassType( Mass.Type.INFINITE );
			rightTri.setMass();
			rightTri.translate( Mouse.getX() / 45, -Mouse.getY() / 45 );
			rightTri.getFixtures().forEach( new Consumer<BodyFixture>()
			{
				@Override
				public void accept( BodyFixture bodyFixture )
				{
					bodyFixture.setFriction( 41 );
					bodyFixture.setDensity( 999999999 );
					bodyFixture.setRestitution( 0.5 );
				}
			} );
			this.world.addBody( rightTri );
		}
		else if( Mouse.isRightMouseDown() )
		{
			Body rectangle = new Body();
			rectangle.addFixture( Geometry.createRightTriangle( 5, 1, true ) );
			rectangle.setMass();
			Transform t = new Transform();
			t.setRotation( Math.random() * 90 );
			rectangle.getFixtures().forEach( new Consumer<BodyFixture>()
			{
				@Override
				public void accept( BodyFixture bodyFixture )
				{
					bodyFixture.setFriction( 41 );
					bodyFixture.setDensity( 999999999 );
					bodyFixture.setRestitution( 0.4 );
				}
			} );
			rectangle.setTransform( t );
			rectangle.setGravityScale( Math.random() * 10 );
			rectangle.translate( Mouse.getX() / 45, -Mouse.getY() / 45 );
			// move the floor down a bit
			this.world.addBody(rectangle);
		}
		for (int i = 0; i < this.world.getBodyCount(); i++) {
			glPushMatrix();
			glScaled( 45, 45, 45 );
			// transform the coordinate system from world coordinates to local coordinates
			glTranslated(this.world.getBody(i).getTransform().getTranslationX(), -this.world.getBody(i).getTransform().getTranslationY(), 0.0);
			// rotate about the z-axis
			glRotated( -Math.toDegrees( this.world.getBody( i ).getTransform().getRotation() ), 0.0, 0.0, 1.0 );
			// get the object
			Body go = this.world.getBody(i);
			Polygon p = ( Polygon ) go.getFixture( 0 ).getShape();
			glColor3d( Math.random() - 0.5, Math.random() - 0.5, Math.random() - 0.5);
			glBegin( GL_POLYGON );
				for( Vector2 v : p.getVertices() )
				{
					glVertex2d( v.x, -v.y );
				}
			glEnd();
			glPopMatrix();
		}
		long time = System.nanoTime();
		// get the elapsed time from the last iteration
		long diff = time - this.last;
		// set the last time
		this.last = time;
		// convert from nanoseconds to seconds
		double elapsedTime = (double)diff / NANO_TO_BASE;
		// update the world with the elapsed time
		this.world.update(elapsedTime);
	}
}
