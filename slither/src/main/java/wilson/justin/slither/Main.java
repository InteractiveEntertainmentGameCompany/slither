package wilson.justin.slither;

import wilson.justin.slither.entity.player.PlayerProperties;

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
		PlayerProperties player = new PlayerProperties();
    	EngineAwt.start(Constant.NAME, Version.create(Constant.VERSION[0], Constant.VERSION[1], Constant.VERSION[2]), Main.class);
    	System.out.println("Game Engine Started...");
    	Loader.start(Config.windowed(player.getResolution()), Lobby.class);
    	System.out.println("Loading Lobby...");
        
    }
}
