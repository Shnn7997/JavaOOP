package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Создание объектов класса Product
        Product product1 = new Product("Телефон", 1000.0, 4);
        Product product2 = new Product("Ноутбук", 2000.0, 5);
        Product product3 = new Product("Планшет", 500.0, 3);
        Product product4 = new Product("Наушники", 100.0, 4);
        Product product5 = new Product("Мышь", 50.0, 3);
        Product product6 = new Product("Клавиатура", 200.0, 5);
        Product product7 = new Product("Футболка", 500.0, 4);
        Product product8 = new Product("Джинсы", 800.0, 5);
        Product product9 = new Product("Куртка", 1500.0, 4);

        // Создание объектов класса Category
        ArrayList<Product> electronicsProducts = new ArrayList<>();
        electronicsProducts.add(product1);
        electronicsProducts.add(product2);
        electronicsProducts.add(product3);
        electronicsProducts.add(product4);
        electronicsProducts.add(product5);
        electronicsProducts.add(product6);
        Category electronics = new Category("Электроника", electronicsProducts);

        ArrayList<Product> clothesProducts = new ArrayList<>();
        clothesProducts.add(product7);
        clothesProducts.add(product8);
        clothesProducts.add(product9);
        Category clothes = new Category("Одежда", clothesProducts);

        // Вывод на консоль первоначального каталога продуктов
        System.out.println("Первоначальный каталог продуктов:");
        for (Product product : electronics.getProducts()) {
            System.out.println(product.getName() + " - " + product.getPrice() + " руб., рейтинг: " + product.getRating());
        }
        for (Product product : clothes.getProducts()) {
            System.out.println(product.getName() + " - " + product.getPrice() + " руб., рейтинг: " + product.getRating());
        }

        // Создание объектов класса Basket и User
        Basket basket = new Basket();
        User user1 = new User("user1", "password1", basket);
        User user2 = new User("user2", "password2", basket);

        // Добавление товаров в корзину пользователя
        user1.getBasket().addProduct(product1);
        user1.getBasket().addProduct(product2);
        user2.getBasket().addProduct(product3);
        user2.getBasket().addProduct(product4);
        user2.getBasket().addProduct(product7);

        // Удаление товаров, купленных пользователями, из каталога продуктов
        electronics.getProducts().removeAll(user1.getBasket().getProducts());
        electronics.getProducts().removeAll(user2.getBasket().getProducts());
        clothes.getProducts().removeAll(user2.getBasket().getProducts());

        // Вывод на консоль каталога продуктов после покупок
        System.out.println("Каталог продуктов после покупок:");
        for (Product product : electronics.getProducts()) {
            System.out.println(product.getName() + " - " + product.getPrice() + " руб., рейтинг: " + product.getRating());
        }
        for (Product product : clothes.getProducts()) {
            System.out.println(product.getName() + " - " + product.getPrice() + " руб., рейтинг: " + product.getRating());
        }

        // Вывод на консоль покупок пользователей
        System.out.println("Покупки пользователей:");
        System.out.println(user1.getLogin() + ":");
        for (Product product : user1.getBasket().getProducts()) {
            System.out.println(product.getName() + " - " + product.getPrice() + " руб., рейтинг: " + product.getRating());
        }
        System.out.println(user2.getLogin() + ":");
        for (Product product : user2.getBasket().getProducts()) {
            System.out.println(product.getName() + " - " + product.getPrice() + " руб., рейтинг: " + product.getRating());
        }
    }
}