package wilson.justin.slither;

import wilson.justin.slither.entity.player.Player;

import com.b3dgs.lionengine.Config;
import com.b3dgs.lionengine.Version;
import com.b3dgs.lionengine.core.awt.EngineAwt;
import com.b3dgs.lionengine.core.sequence.Loader;

/**
 * 
 * @author Justin
 *
 */
public class Main {
	
    public static void main( String[] args ) {
		Player player = new Player();
    	EngineAwt.start(Constant.NAME, Version.create(Constant.VERSION[0], Constant.VERSION[1], Constant.VERSION[2]), Main.class);
    	System.out.println("Game Engine Started...");
    	Loader.start(Config.windowed(player.getResolution()), Scene.class);
    	System.out.println("Loading Scene...");
        
    }
}
