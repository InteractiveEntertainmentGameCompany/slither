package wilson.justin.slither.world;

import wilson.justin.slither.World;
import wilson.justin.slither.entity.player.PlayerProperties;

import com.b3dgs.lionengine.Align;
import com.b3dgs.lionengine.Context;
import com.b3dgs.lionengine.Resolution;
import com.b3dgs.lionengine.core.sequence.Sequence;
import com.b3dgs.lionengine.game.Services;
import com.b3dgs.lionengine.game.feature.SequenceGame;
import com.b3dgs.lionengine.game.feature.WorldGame;
import com.b3dgs.lionengine.graphic.ColorRgba;
import com.b3dgs.lionengine.graphic.Graphic;
import com.b3dgs.lionengine.graphic.Graphics;
import com.b3dgs.lionengine.graphic.Text;
import com.b3dgs.lionengine.graphic.TextStyle;

/**
 * 
 * @author Pierre-Alexander, Justin
 *
 */
public class InGameScene extends SequenceGame {
	
	private static PlayerProperties player = new PlayerProperties();
    public final static Resolution IN_GAME_RESOLUTION = player.getResolution();
    private final Text text = Graphics.createText(Text.SANS_SERIF, 14, TextStyle.NORMAL);

    /**
     * Create the scene.
     * 
     * @param context The context reference.
     */
    public InGameScene(Context context)
    {
        super(context, IN_GAME_RESOLUTION, new WorldCreator()
        {
            @Override
            public WorldGame createWorld(Context context, Services services)
            {
                return new World(context, services);
            }
        });
    }

    @Override
    public void load()
    {
        text.setAlign(Align.CENTER);
        text.setColor(ColorRgba.YELLOW);
        text.setLocation(getWidth() - 30, 5);
    }

    @Override
    public void update(double extrp)
    {
        super.update(extrp);
        text.setText("FPS: "+ String.valueOf(getFps()));
    }

    @Override
    public void render(Graphic g)
    {
        super.render(g);
        g.clear(0, 0, getWidth(), getHeight());
        text.render(g);
    }
}
