package srp2;

// 메뉴판 상태 있음 public
import java.util.List;

public class Menu {

    private List<MenuItem> items;

    public Menu(List<MenuItem> items) {
        this.items = items;
    }

    public MenuItem choose(String menuName) {
        for (MenuItem item : items) {
            if (item.getName().equals(menuName)) {
                return item;
            }
        }

        return null;
    }
}
