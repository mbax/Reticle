package org.spigot.reticle;

import java.net.MalformedURLException;

import javax.sql.rowset.serial.SerialException;

import org.spigot.reticle.sockets.Reporter;


public class MAIN {
	public static void main(String[] args) throws MalformedURLException, Exception {
		loader runner;
		Thread loader = new Thread(runner = new loader());
		loader.start();
		mcbotapp mainwindow = null;
		try {
			// Start ChatThread
			storage.ChatThread.start();
			mainwindow = new mcbotapp();
			runner.frame.dispose();
			mainwindow.frmReticle.setVisible(true);
			if (storage.getAutoupdate()) {
				storage.checkforupdates();
			}
			if (storage.getAutodebug()) {
				new Reporter(Reporter.ACTION.REPORTUSAGE).start();
			}
			// Start news service
			new News().start();
		} catch (SerialException e) {
			runner.frame.dispose();
			storage.ChatThread.interrupt();
			storage.alert("Configuration error", "Failed to load configuration\n\nReason: Server name cannot be Reticle!");
			System.exit(1);
		} catch (NumberFormatException e) {
			storage.alert("Configuration error", "Failed to load configuration\n\nReason: Numeric field contains illegal characters.\nPlease fix your config!");
			runner.frame.dispose();
			storage.ChatThread.interrupt();
			System.exit(1);
			if (mainwindow != null) {
				if (mainwindow.frmReticle != null) {
					mainwindow.frmReticle.dispose();
				}
			}
			System.exit(1);
		} catch (StringIndexOutOfBoundsException e) {
			storage.ChatThread.interrupt();
			storage.alert("Configuration error", "Failed to load configuration\n\nReason: Malformed configuration format.\nPlease fix your config!");
			runner.frame.dispose();
			if (mainwindow != null) {
				if (mainwindow.frmReticle != null) {
					mainwindow.frmReticle.dispose();
				}
			}
			System.exit(1);
		}
	}
}