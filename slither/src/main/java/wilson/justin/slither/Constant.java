package wilson.justin.slither;

import com.b3dgs.lionengine.LionEngineException;
import com.b3dgs.lionengine.Resolution;

/**
 * 
 * @author Justin
 *
 */
public class Constant {

	// The name of the game. 
	public static final String NAME = "Slitherer";
	
	// Version of the game (Major, Minor, Micro)
	public static final int[] VERSION = {1, 0, 0};
	
	public static final Resolution NATIVE = new Resolution(320, 240, 60);
	
	// Private Constructor
    private Constant() {
        throw new LionEngineException(LionEngineException.ERROR_PRIVATE_CONSTRUCTOR);
    }
}
