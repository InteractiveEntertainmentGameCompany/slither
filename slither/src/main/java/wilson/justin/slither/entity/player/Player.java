package wilson.justin.slither.entity.player;

import java.awt.Dimension;
import java.awt.Toolkit;

import com.b3dgs.lionengine.Resolution;

/**
 * 
 * @author Justin
 *
 */
public class Player extends PlayerSettings {
	
	private static Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	private final static Resolution sixteenByNine = new Resolution(320, 240, 60);
    private final static Resolution fullscreen = new Resolution(screen.width, screen.height, 60);
	
	public Player() {
		this.setChatMuted(isChatMuted);
		this.setFriendRequestMuted(isFriendRequestMuted);
		this.setSoundMuted(isSoundMuted);
		this.setTwoFactorAuthenticationEnabled(isTwoFactorAuthenticationEnabled);
		this.setResolution(sixteenByNine.get3x());
	}

	private String username = "Player";
	private String password = "123";
	
	
}
