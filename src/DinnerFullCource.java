public class DinnerFullCource {
    private Dish[] dishes = new Dish[5];

    public DinnerFullCource() {
        dishes[0] = new Dish();
        dishes[0].setName("Salmon");
        dishes[0].setValune(15);

        dishes[1] = new Dish();
        dishes[1].setName("Steak");
        dishes[1].setValune(20);

        dishes[2] = new Dish();
        dishes[2].setName("Pasta");
        dishes[2].setValune(12);

        dishes[3] = new Dish();
        dishes[3].setName("Sushi");
        dishes[3].setValune(18);

        dishes[4] = new Dish();
        dishes[4].setName("Tacos");
        dishes[4].setValune(10);
    }

    public void showAllDishes() {
        for (int i = 0; i < dishes.length; i++) {
            System.out.println(dishes[i].getName() + ": $" + dishes[i].getValune());
        }
    }

    public static void main(String[] args) {
        DinnerFullCource fullCourse = new DinnerFullCource();
        fullCourse.showAllDishes();
    }
}