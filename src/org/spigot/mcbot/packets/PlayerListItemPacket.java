package org.spigot.mcbot.packets;

import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;

public class PlayerListItemPacket extends packet {

	private Socket sock;
	private String name;
	private boolean online;
	private short ping;

	public PlayerListItemPacket(Socket sock) {
		this.sock = sock;
	}

	public void Read() throws IOException {
		super.input = sock.getInputStream();
		// Following stuff is for 1.8 (Will update when servers are out)
		/*
		 * int action=super.readVarInt(); int len=super.readVarInt(); //UUID
		 * (Don't really care about the correct value if you read it this way
		 * every time) String UUID=""+(super.readLong() << 64 &
		 * super.readLong());
		 */
		name = super.readString();
		online = super.readBoolean();
		ping = super.readShort();

	}

	public void Serve(HashMap<String, Short> tablist) {
		if(tablist.containsKey(name)) {
			//We are already in tablist
			if(online) {
				//And online (Correct)
			} else {
				//Bot not online (Suicide)
				tablist.remove(name);
			}
		} else {
			//We are not in tablist yet
			if(online) {
				//But online (Must add)
				tablist.put(name, ping);
			} else {
				//And not online (correct)
			}
		}
	}
}
