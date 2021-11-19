package jp.trans_it.file_io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Output extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		FileChooser chooser = new FileChooser();
		chooser.setTitle("九九ファイル出力");
		chooser.getExtensionFilters().addAll(
			new FileChooser.ExtensionFilter("テキストファイル", "*.txt")
		);

		File file = chooser.showSaveDialog(primaryStage);

		if(file != null) {
			saveFile(file);
		}
	}

	private static void saveFile(File file) {
		try {
			PrintWriter writer = new PrintWriter(
				new FileWriter(file)
			);

			for(int m = 1; m <= 9; m++) {
				for(int n = 1; n <= 9; n++) {
					writer.print(
						String.format(
							"%d x %d = %2d\t",
							n,
							m,
							m * n
						)
					);
				}
				writer.println("");
			}

			writer.close();
		}
		catch(IOException e) {
			System.out.println("ファイルの出力に失敗しました。");
		}
	}
}
