package org.spigot.mcbot.packets;

import java.io.IOException;
import java.nio.ByteBuffer;

public class SpawnPositionPacket extends packet {
	public static final int ID = 5;
	private ByteBuffer sock;

	public SpawnPositionPacket(ByteBuffer sock) {
		this.sock = sock;
	}

	public void Read() throws IOException {
		super.input = sock;
		// Old packet
		// X
		super.readInt();
		// Y
		super.readInt();
		// Z
		super.readInt();
	}
}
