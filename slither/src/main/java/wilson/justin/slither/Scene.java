package wilson.justin.slither;

import wilson.justin.slither.entity.player.PlayerProperties;

import com.b3dgs.lionengine.Context;
import com.b3dgs.lionengine.Resolution;
import com.b3dgs.lionengine.core.sequence.Sequence;
import com.b3dgs.lionengine.graphic.Graphic;

public class Scene extends Sequence {
	
	private static PlayerProperties player = new PlayerProperties();
    public final static Resolution resolution = player.getResolution();

    public Scene(Context context)
    {
        super(context, resolution);
    }

    @Override
    public void load()
    {
    	// load game
    }

    public void update(double extrp)
    {
        // Update game
    }

    public void render(Graphic g)
    {
        // Render game
    }
}
