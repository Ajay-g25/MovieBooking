import java.util.ArrayList;
import java.util.List;
 
public class Theater {
    private String name;
    private List<Screen> screens;
 
    public Theater(String name) {
        this.name = name;
        this.screens = new ArrayList<>();
    }
 
    public String getName() {
        return name;
    }
 
    public List<Screen> getScreens() {
        return screens;
    }
 
    public void addScreen(Screen screen) {
        screens.add(screen);
    }
}
 
