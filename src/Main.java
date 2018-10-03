import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final String key = "FU60G6OYXRtefPEvaEAsLw";
    public static final String secret = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
    static final String[] matches =
                    {"id", "average_rating", "title", "name",
                                    "image_url"};

    public static void main(String[] args) {
        System.out.println("Enter a book title");

        Scanner input = new Scanner(System.in);
        String textInput = input.nextLine();
        ArrayList<String> information = new ArrayList<>();
        try {
            URL url = new URL("https://www.goodreads.com/search.xml?key=" + key + "&q="
                                              + textInput);
            try {
                BufferedReader reader = new BufferedReader(
                                new InputStreamReader(url.openStream(), "UTF-8"));
                String line = reader.readLine();
                while (line != null) {

                    for (String a : matches) {
                        if (line.contains(a)) {
                            information.add(line.replace("<" + a + ">", "").replace("</" + a +
                                                                                                    ">", ""));

                        }
                    }
                    line = reader.readLine();
                    if (line.contains("</work>")) {
                        break;
                    }
                }

                for (int i = 0; i < information.size(); i++) {
                    if (information.get(i).contains("<")) {
                        information.remove(i);
                    }
                }
                for (String anInformation : information) {
                    System.out.println(anInformation);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }

    public class displayer extends Application {

        private void initUI(Stage stage) {
            StackPane root = new StackPane();
            Scene scene = new Scene(root, 300, 250);

            Label lbl = new Label("HOW DO I ADD INFORMATION");
            lbl.setFont(Font.font("Serif", FontWeight.THIN, 20));
            root.getChildren().add(lbl);

            stage.setTitle("BookFinder");
            stage.setScene(scene);
            stage.show();
        }

        @Override public void start(Stage primaryStage) {
            initUI(primaryStage);
        }
    }

}
