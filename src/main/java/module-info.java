module io.github.riniwtz.electricfan {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens io.github.riniwtz.electricfan to javafx.fxml;
    exports io.github.riniwtz.electricfan;
}