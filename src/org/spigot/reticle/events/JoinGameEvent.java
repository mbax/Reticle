package org.spigot.reticle.events;

public class JoinGameEvent extends event{
	private String leveltype;
	private int EntityId;
	private byte Gamemode;
	private byte Dimension;
	private byte Difficulty;
	private byte MaxPlayers;
	private boolean rdebug;
	
	public JoinGameEvent(int entityid,byte gm,byte dim,byte diff,byte maxplayers,String leveltype, boolean rdebug) {
		this.leveltype=leveltype;
		this.EntityId=entityid;
		this.Gamemode=gm;
		this.Dimension=dim;
		this.Difficulty=diff;
		this.MaxPlayers=maxplayers;
		this.rdebug=rdebug;
	}
	
	public JoinGameEvent(int entityid,byte gm,byte dim,byte diff,byte maxplayers,String leveltype) {
		this.leveltype=leveltype;
		this.EntityId=entityid;
		this.Gamemode=gm;
		this.Dimension=dim;
		this.Difficulty=diff;
		this.MaxPlayers=maxplayers;
	}
	
	public boolean getReducedDebug() {
		return this.rdebug;
	}
	
	public String getLevelType() {
		return this.leveltype;
	}
	
	public byte getMaxPlayers() {
		return this.MaxPlayers;
	}
	
	public byte getDifficulty() {
		return this.Difficulty;
	}
	
	public byte getDimension() {
		return this.Dimension;
	}
	
	public byte getGameMode() {
		return this.Gamemode;
	}
	
	public int getEntityId() {
		return this.EntityId;
	}
}