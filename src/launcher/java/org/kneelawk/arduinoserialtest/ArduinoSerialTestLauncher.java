package org.kneelawk.arduinoserialtest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.kneelawk.cpcontrol.CPControl3;

public class ArduinoSerialTestLauncher {
	public static void main(String[] args) {
		try {
			File baseDir = Files.createTempDirectory("arduinoSerialTest").toFile();
			CPControl3 cp = new CPControl3("org.kneelawk.arduinoserialtest.ArduinoSerialTest", baseDir);

			cp.addExtractingFromFileLibrary(CPControl3.ME)
					.addLibrary("application", new CPControl3.DirectoryEntryFilter("app"), CPControl3.ALWAYS_DELETE)
					.addLibrary("libraries", new CPControl3.DirectoryEntryFilter("libs"), CPControl3.ALWAYS_DELETE);

			cp.launch(args);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}