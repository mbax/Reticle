package org.spigot.mcbot.packets;

import java.io.IOException;
import java.nio.ByteBuffer;

public class RespawnPacket extends packet {
	public static final int ID=7;
	private ByteBuffer sock;

	public RespawnPacket(ByteBuffer sock) {
		this.sock = sock;
	}

	public void Read() throws IOException {
		super.input = sock;
		//Dimension
		super.readInt();
		//Difficulty
		super.readByte();
		//Gamemode
		super.readByte();
		//Level name
		super.readString();
	}
}
