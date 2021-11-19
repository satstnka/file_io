package jp.trans_it.file_io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Input extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		FileChooser chooser = new FileChooser();
		chooser.setTitle("ファイル選択");
		File file = chooser.showOpenDialog(primaryStage);
		if(file != null) {
			showFile(file);
		}
	}

	private static void showFile(File file) {
		try {
			BufferedReader reader = new BufferedReader(
				new FileReader(file)
			);

			String line = null;
			while((line = reader.readLine()) != null) {
				System.out.println(line);
			}

			reader.close();
		}
		catch(IOException e) {
			System.out.println("ファイルの読込に失敗しました。");
		}
	}
}
