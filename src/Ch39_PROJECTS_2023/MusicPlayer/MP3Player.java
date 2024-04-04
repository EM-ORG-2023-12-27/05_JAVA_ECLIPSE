package Ch39_PROJECTS_2023.MusicPlayer;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class MP3Player {
	public static String MusicDbPath = "src/Ch99_Project/MusicPlayer/MusicDb/";
	private final String mp3FileToPlay;
	private Player jlPlayer;

	public MP3Player(String mp3FileToPlay) {
		this.mp3FileToPlay = mp3FileToPlay;

	}

	public void play() {
		FileInputStream fileInputStream;
		BufferedInputStream bufferedInputStream;
		try {
			System.out.println("PLAY() : " + mp3FileToPlay);
			fileInputStream = new FileInputStream(MusicDbPath + mp3FileToPlay);

			bufferedInputStream = new BufferedInputStream(fileInputStream);
			jlPlayer = new Player(bufferedInputStream);

			// 스레드 처리
			new Thread() {
				public void run() {
					try {
						jlPlayer.play();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
			}.start();

		} catch (Exception e) {
			System.out.println("Problem playing mp3 file " + mp3FileToPlay);
			System.out.println(e.getMessage());

		}

	}

	public void close() {
		if (jlPlayer != null)
			jlPlayer.close();

	}
}
