package wilson.justin.slither;

import com.b3dgs.lionengine.Context;
import com.b3dgs.lionengine.Resolution;
import com.b3dgs.lionengine.core.sequence.Sequence;
import com.b3dgs.lionengine.graphic.Graphic;

/**
 * 
 * @author Justin
 *
 */
public class Lobby extends Sequence {
	
	private static Resolution lobbyResolution = new Resolution(20, 240, 60).get3x();

    public Lobby(Context context)
    {
        super(context, lobbyResolution);
    }

	@Override
	public void update(double extrp) {
		
	}

	@Override
	public void render(Graphic g) {
		
	}

	@Override
	public void load() {
		
	}

	
}
