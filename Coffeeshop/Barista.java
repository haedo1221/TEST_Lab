package srp2;

// 바리스타 상태 없음 private

class 바리스타 {
    String baristaName() {
        return "";
    }
}

class 공유 extends 바리스타 {
    String baristaName = "공유";
}

public class Barista {
    public Coffee makeCoffee(MenuItem menuItem) {
        Coffee coffee = new Coffee(menuItem);
        return coffee;
    }
}
