package view;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import controller.MainController;
import controller.PaneNavigator;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Class;
import model.Course;
import model.Instructor;
import model.Room;
import model.StudentsGroup;

public class App extends Application {

    private Stage primaryStage;
    private ObservableList<Room> RoomData = FXCollections.observableArrayList();
    private ObservableList<StudentsGroup> GroupData = FXCollections.observableArrayList();
    private ObservableList<Course> CourseData = FXCollections.observableArrayList();
    private ObservableList<Instructor> InstructorData = FXCollections.observableArrayList();
    private ObservableList<Class> ClassData = FXCollections.observableArrayList();
    private HashMap<String,Boolean> workingDays = new HashMap<>();
    private ObservableList<Class> generatedTableData = FXCollections.observableArrayList();
    private int periodsCount = 5;

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        initialize();
        primaryStage.setTitle("Time Table Making Software");
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("file:resources/images/logo.png"));
        primaryStage.setScene(createScene(loadMainPane()));
        primaryStage.show();
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void initialize(){
        System.out.println("init");
        Room room501 = new Room("501");
        Room room502 = new Room("502");
        Room room503 = new Room("503");
        Room room504 = new Room("504");
        RoomData.addAll(room501,room502,room503,room504);

        StudentsGroup firstYear = new StudentsGroup("First Year");
        StudentsGroup secondYear = new StudentsGroup("Second Year");
        StudentsGroup thirdYear = new StudentsGroup("Third Year");
        StudentsGroup fourthYear = new StudentsGroup("Fourth Year");
        GroupData.addAll(firstYear,secondYear,thirdYear,fourthYear);

        Course firstUE20CS351 = new Course("Cloud Computing 4","UE20CS351");
        Course firstUE20CS352 = new Course("OOADJ","UE20CS352");
        Course firstUE20CS353 = new Course("Compiler Design","UE20CS353");
        Course firstUE20CS332 = new Course("AIWIR","UE20CS332");
        Course firstUE20CS343 = new Course("Database Technologies","UE20CS343");
        Course firstUE20CS301 = new Course("Constitution of India","UE20CS301");
        CourseData.addAll(firstUE20CS351,firstUE20CS352,firstUE20CS353,firstUE20CS332,firstUE20CS343,firstUE20CS301);

        Instructor ProfJenyJijo = new Instructor("Prof Jeny Jijo");
        Instructor ProfRubyDinakar = new Instructor("Prof Ruby Dinakar");
        Instructor ProfGauri = new Instructor("Prof Gauri");
        Instructor ProfKamatchiPriya = new Instructor("Prof Kamatchi Priya");
        Instructor ProfGeetha = new Instructor("Prof Geetha");
        Instructor ProfRam = new Instructor("Prof Ram");
        Instructor ProfAman = new Instructor("Prof Aman");
        InstructorData.addAll(ProfJenyJijo,ProfRubyDinakar,ProfGauri,ProfKamatchiPriya,ProfGeetha,ProfRam,ProfAman);

        Class digitalLec1 = new Class(firstUE20CS332,"Lec",ProfGeetha,firstYear,room501);
        Class societyLec = new Class(firstUE20CS301,"Lec",ProfAman,firstYear,room501);
        Class DSLec1 = new Class(firstUE20CS353,"Lec",ProfKamatchiPriya,firstYear,room501);
        Class probLec1 = new Class(firstUE20CS352,"Lec",ProfGauri,firstYear,room501);
        Class mathLec1 = new Class(firstUE20CS351,"Lec",ProfJenyJijo,firstYear,room501);
        Class EELec1 = new Class(firstUE20CS343,"Lec",ProfRam,firstYear,room501);
        Class digitalLec2 = new Class(firstUE20CS332,"Lec",ProfGeetha,firstYear,room501);
        Class probLec2 = new Class(firstUE20CS352,"Lec",ProfGauri,firstYear,room501);
        Class mathLec2 = new Class(firstUE20CS351,"Lec",ProfRubyDinakar,firstYear,room501);
        Class DSLec2 = new Class(firstUE20CS353,"Lec",ProfKamatchiPriya,firstYear,room501);
        Class EELec2 = new Class(firstUE20CS343,"Lec",ProfRam,firstYear,room501);

        Class digitalLec11 = new Class(firstUE20CS332,"Lec",ProfGeetha,secondYear,room502);
        Class societyLec1 = new Class(firstUE20CS301,"Lec",ProfAman,secondYear,room502);
        Class DSLec11 = new Class(firstUE20CS353,"Lec",ProfKamatchiPriya,secondYear,room502);
        Class probLec11 = new Class(firstUE20CS352,"Lec",ProfGauri,secondYear,room502);
        Class ccLec11 = new Class(firstUE20CS351,"Lec",ProfJenyJijo,secondYear,room502);
        Class EELec11 = new Class(firstUE20CS343,"Lec",ProfRam,secondYear,room502);
        Class digitalLec21 = new Class(firstUE20CS332,"Lec",ProfGeetha,secondYear,room502);
        Class probLec21 = new Class(firstUE20CS352,"Lec",ProfGauri,secondYear,room502);
        Class mathLec21 = new Class(firstUE20CS351,"Lec",ProfRubyDinakar,secondYear,room502);
        Class DSLec21 = new Class(firstUE20CS353,"Lec",ProfKamatchiPriya,secondYear,room502);
        Class EELec21 = new Class(firstUE20CS343,"Lec",ProfRam,secondYear,room502);

        ClassData.addAll(digitalLec1,societyLec,DSLec1,probLec1,mathLec1,EELec1,digitalLec2,probLec2,
                mathLec2,DSLec2,EELec2,digitalLec11,societyLec1,DSLec11,probLec11,ccLec11,EELec11,
                digitalLec21,probLec21,mathLec21,DSLec21,EELec21);

        workingDays.put("saturday",true);
        workingDays.put("sunday",true);
        workingDays.put("monday",true);
        workingDays.put("tuesday",true);
        workingDays.put("wednesday",true);
        workingDays.put("thursday",false);
    }

    private Pane loadMainPane() throws IOException {
        FXMLLoader loader = new FXMLLoader(new URL("file:resources/fxml/" + PaneNavigator.MAIN_PANE));
        //loader.setLocation(new URL("file:resources/fxml/" + PaneNavigator.MAIN_PANE));
        //Pane mainPane = loader.load();
        Pane mainPane = loader.load();
        MainController mainController = loader.getController();
        PaneNavigator.setMainApp(this);
        PaneNavigator.setMainController(mainController);
        PaneNavigator.loadPane(PaneNavigator.START_PANE);

        return mainPane;
    }

    private Scene createScene(Pane mainPane) {
        Scene scene = new Scene(mainPane);
        //new URL("file:resources/style/tab.css)
        File f = new File("resources/style/tab.css");
        scene.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\", "/"));
        //scene.getStylesheets().add(this.getClass().getResource("/resources/style/tab.css").toExternalForm());
        f = new File("resources/style/style.css");
        scene.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\", "/"));
        return scene;
    }


    public static void main(String[] args) {
        launch();
    }

    public ObservableList<Room> getRoomData() {
        return RoomData;
    }

    public ObservableList<StudentsGroup> getGroupData() {
        return GroupData;
    }

    public ObservableList<Course> getCourseData() {
        return CourseData;
    }

    public ObservableList<Instructor> getInstrutorData() {
        return InstructorData;
    }

    public ObservableList<Class> getClassData() {
        return ClassData;
    }

    public HashMap<String,Boolean> getWorkingDays() {
        return workingDays;
    }

    public int getPeriodsCount() {
        return periodsCount;
    }

    public void setPeriodsCount(int periodsCount) {
        this.periodsCount = periodsCount;
    }

    public ObservableList<Class> getGeneratedTableData() {
        return generatedTableData;
    }

    public void setGeneratedTableData(ArrayList<Class> generatedtable){
        generatedTableData.clear();
        generatedTableData.addAll(generatedtable);
    }
}
