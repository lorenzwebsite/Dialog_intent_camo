package square.ball.rectangle;

import android.os.Bundle;
import android.app.Activity;
import android.view.*;

public class SquareBallRectangleActivity extends Activity
{
    SquareBallRectangleView square_ball_rectangle_view;

    public void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );

        setContentView( R.layout.activity_square_ball_rectangle);

        square_ball_rectangle_view = (SquareBallRectangleView)
                findViewById( R.id.square_ball_rectangle_view);
    }

    public void square_shape_selected( View view )
    {
        square_ball_rectangle_view.set_shape_to_draw( "Square" );
    }

    public void ball_shape_selected( View view )
    {
        square_ball_rectangle_view.set_shape_to_draw( "Ball" );
    }

    public void triangle_shape_selected( View view )
    {
        square_ball_rectangle_view.set_shape_to_draw( "Triangle" );
    }

    public void pieceOfCake_shape_selected( View view )
    {
        square_ball_rectangle_view.set_shape_to_draw( "Cake" );
    }
}