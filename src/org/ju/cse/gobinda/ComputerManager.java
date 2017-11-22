package org.ju.cse.gobinda;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class ComputerManager {

	public static boolean takeOneSnapShot() {
		try {
			String filePath = "C:/Users/" + System.getProperty("user.name") + "/Pictures/";
			filePath += new Date().toString().replaceAll(":", "_") + ".jpg";
			File file = new File(filePath);
			Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			BufferedImage capture = new Robot().createScreenCapture(screenRect);
			ImageIO.write(capture, "jpg", file);
			return true;
		} catch (Exception e) {
		}
		return false;
	}

	public static synchronized void playSound() {
		class PlayMusic implements Runnable {
			@Override
			public void run() {
				try {
					InputStream is = getClass().getResourceAsStream("click.wav");
					AudioInputStream ais = AudioSystem.getAudioInputStream(new BufferedInputStream(is));
					Clip clip = AudioSystem.getClip();
					clip.open(ais);
					clip.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		new Thread(new PlayMusic()).start();
	}

}
