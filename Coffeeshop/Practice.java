package srp2;

import java.util.ArrayList;
import java.util.List;

public class Practice {
    public static void main(String[] args) {

        Customer customer = new Customer();
        Barista barista = new Barista();

        MenuItem m1 = new MenuItem("아메리카노", 1500);
        MenuItem m2 = new MenuItem("카푸치노", 2700);
        MenuItem m3 = new MenuItem("카라멜 마키아또", 3500);
        MenuItem m4 = new MenuItem("민트카페모카", 4500);
        List<MenuItem> list = new ArrayList<>();
        list.add(m1);
        list.add(m2);
        list.add(m3);
        list.add(m4);

        Menu menu = new Menu(list);

        customer.order("아메리카노", menu, barista);
    }

}
