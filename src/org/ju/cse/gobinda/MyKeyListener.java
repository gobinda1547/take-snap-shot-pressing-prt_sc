package org.ju.cse.gobinda;

import org.jnativehook.GlobalScreen;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class MyKeyListener implements NativeKeyListener {

	private static MyKeyListener myKeyListener;

	private MyKeyListener() {
		try {
			GlobalScreen.registerNativeHook();
			GlobalScreen.addNativeKeyListener(this);
		} catch (Exception e) {
		}
	}

	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		
		// code for print screen button
		if (e.getKeyCode() == 3639) {
			if (ComputerManager.takeOneSnapShot()) {
				ComputerManager.playSound();
			}
		}
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent arg0) {

	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent arg0) {

	}

	public static void startTrackingTheKeys() {
		if (myKeyListener == null) {
			myKeyListener = new MyKeyListener();
		}
	}

}
