package org.spigot.mcbot.settings;

import java.util.HashMap;

import org.spigot.mcbot.storage;

public class botsettings {
	public String servername = "Unknown";
	public String serverip = "127.0.0.1";
	public int serverport = 25565;
	public String nick = "Reticle";
	public boolean autoconnect = false;
	public boolean autologin = false;
	public boolean autologout = false;
	public boolean autoantiafk = true;
	public boolean activenotify = false;
	public String[] autologincmd = new String[0];
	public String[] autologoutcmd = new String[0];
	public String[] autoantiafkcmd = new String[0];
	public String bottabname = "???";

	public botsettings(String name) {
		this.nick = name;
		this.bottabname = gettabname();
	}

	public String gettabname() {
		return this.nick + "@" + this.servername;
	}

	public boolean isExclusive() {
		HashMap<String, botsettings> bots = storage.getInstance().settin.settings;
		String bottabname = gettabname().toLowerCase();
		for (String bot : bots.keySet()) {
			if (bot.toLowerCase().equals(bottabname.toLowerCase())) {
				return false;
			}
		}
		return true;
	}

	public boolean isDoubleExclusive() {
		boolean hasthis = false;
		HashMap<String, botsettings> bots = storage.getInstance().settin.settings;
		String bottabname = gettabname().toLowerCase();
		for (String bot : bots.keySet()) {
			if (bot.toLowerCase().equals(bottabname.toLowerCase())) {
				/*
				if(!bots.get(bot).equals(this)) {
					return false;
				}
				*/
				if (hasthis) {
					return false;
				} else if(bots.get(bot).equals(this)) {
					hasthis = true;
				}
				
			}
		}
		return true;
	}

	public void registerbot() {
		this.bottabname = gettabname();
		storage.getInstance().settin.settings.put(bottabname, this);
	}

	public void unregisterbot() {
		storage.getInstance().settin.settings.remove(bottabname);
	}

	public void renamebot(String newname) {
		unregisterbot();
		bottabname = newname;
		registerbot();
	}

}