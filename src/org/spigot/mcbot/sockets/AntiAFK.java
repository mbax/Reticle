package org.spigot.mcbot.sockets;

public class AntiAFK extends Thread {
	private connector con;

	public AntiAFK(connector con) {
		this.con = con;
	}

	@Override
	public void run() {
		// Necessary semaphore to wait on
		Object sync = new Object();
		synchronized (sync) {
			try {
				while (true) {
					sync.wait(1000 * con.getantiafkperiod());
					String[] cmds=con.getafkcommands();
					for(String cmd:cmds) {
						con.sendtoserver(cmd);
					}
				}
			} catch (InterruptedException e) {
			}
		}
	}
}
