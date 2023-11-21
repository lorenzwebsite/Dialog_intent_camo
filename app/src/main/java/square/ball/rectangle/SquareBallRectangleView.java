package square.ball.rectangle;

import android.graphics.*;
import android.view.*;
import android.content.Context;
import android.util.AttributeSet;

public class SquareBallRectangleView extends View
{
    int view_center_point_x = 100;
    int view_center_point_y = 100;

    String shape_to_draw = "Square";

    public SquareBallRectangleView( Context context )
    {
        super( context );
    }

    //  The following constructor is needed when SquareBallRectangleView object is
    //  specified in an XML file, and is thus created automatically.

    public SquareBallRectangleView( Context context, AttributeSet attributes )
    {
        super( context, attributes );
    }

    public void onSizeChanged( int current_width_of_this_view,
                               int current_height_of_this_view,
                               int old_width_of_this_view,
                               int old_height_of_this_view )
    {
        view_center_point_x  = current_width_of_this_view / 2;
        view_center_point_y  = current_height_of_this_view  / 2;
    }

    public void set_shape_to_draw( String given_shape_to_draw )
    {
        shape_to_draw = given_shape_to_draw;
        invalidate();
    }

    @Override
    protected void onDraw( Canvas canvas )
    {
        Paint filling_paint = new Paint();
        filling_paint.setStyle( Paint.Style.FILL );

        Paint outline_paint = new Paint() ;  // Default color for Paint is black.
        outline_paint.setStyle( Paint.Style.STROKE );

        if ( shape_to_draw.equals( "Square" ) )
        {
            filling_paint.setColor(Color.parseColor("#FFA500"));

            canvas.drawRect( view_center_point_x - 250, view_center_point_y - 250,
                    view_center_point_x + 250, view_center_point_y + 250,
                    filling_paint ) ;

            canvas.drawRect( view_center_point_x - 80, view_center_point_y - 80,
                    view_center_point_x + 80, view_center_point_y + 80,
                    outline_paint ) ;
        }
        else if ( shape_to_draw.equals( "Ball" ) )
        {
            filling_paint.setColor( Color.RED );

            canvas.drawCircle( view_center_point_x,
                    view_center_point_y, 250, filling_paint );

            canvas.drawCircle( view_center_point_x,
                    view_center_point_y, 250, outline_paint );
        }
        else if ( shape_to_draw.equals( "Triangle" ) )
        {
            filling_paint.setColor( Color.BLUE );
            float centerX = getWidth() / 2f;
            float centerY = getHeight() / 2f;

            Path triangle_path = new Path() ;
            triangle_path.moveTo( view_center_point_x, view_center_point_y - 80 ) ;
            triangle_path.lineTo( view_center_point_x + 250, view_center_point_y + 250 ) ;
            triangle_path.lineTo( view_center_point_x - 250, view_center_point_y + 250 ) ;
            triangle_path.close();


            canvas.drawPath(triangle_path, filling_paint);
            canvas.drawPath(triangle_path, outline_paint);


        }else if (shape_to_draw.equals("Cake")){
            filling_paint.setColor( Color.GREEN);
            float centerX = getWidth() / 2f;
            float centerY = getHeight() / 2f;
            float radius = Math.min(centerX, centerY);
            RectF oval = new RectF(centerX - radius + 150, centerY - radius - 10,
                    centerX + radius - 150, centerY + radius - 200);
            canvas.drawArc(oval, 45, 90, true, filling_paint);
            canvas.drawArc(oval, 45, 90, true, outline_paint);
        }
    }
}