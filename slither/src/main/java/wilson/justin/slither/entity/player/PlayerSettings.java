package wilson.justin.slither.entity.player;

import com.b3dgs.lionengine.Resolution;

/**
 * 
 * @author Justin
 *
 */
public class PlayerSettings {

	public Resolution resolution;
	public boolean isSoundMuted, isChatMuted, isFriendRequestMuted, isTwoFactorAuthenticationEnabled;
	
	public Resolution getResolution() {
		return resolution;
	}
	public void setResolution(Resolution resolution) {
		this.resolution = resolution;
	}
	public boolean isSoundMuted() {
		return isSoundMuted;
	}
	public void setSoundMuted(boolean isSoundMuted) {
		this.isSoundMuted = isSoundMuted;
	}
	public boolean isChatMuted() {
		return isChatMuted;
	}
	public void setChatMuted(boolean isChatMuted) {
		this.isChatMuted = isChatMuted;
	}
	public boolean isFriendRequestMuted() {
		return isFriendRequestMuted;
	}
	public void setFriendRequestMuted(boolean isFriendRequestMuted) {
		this.isFriendRequestMuted = isFriendRequestMuted;
	}
	public boolean isTwoFactorAuthenticationEnabled() {
		return isTwoFactorAuthenticationEnabled;
	}
	public void setTwoFactorAuthenticationEnabled(
			boolean isTwoFactorAuthenticationEnabled) {
		this.isTwoFactorAuthenticationEnabled = isTwoFactorAuthenticationEnabled;
	}
}
