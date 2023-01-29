package xyz.apna.bazaar.ui.home;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import xyz.apna.bazaar.R;

class Vegies {
    public static String[] titles = {"Tomato", "Garlic", "Potato", "Onions", "Lemon", "Lettuce", "Cabbage", "Cucumber", "Bell Pepper"};

    public static Double[] prices = {9.63, 1.87, 9.67, 1.60, 3.92, 4.47, 6.83, 8.12, 1.81};

    public static String[] subTitles = {
            "22 mins ⭐ 4.8",
            "15 mins ⭐ 4.6",
            "30 mins ⭐ 4.9",
            "20 mins ⭐ 4.1",
            "10 mins ⭐ 4.4",
            "12 mins ⭐ 4.7",
            "25 mins ⭐ 4.2",
            "18 mins ⭐ 4.8",
            "32 mins ⭐ 4.7"
    };

    public static Integer[] imgIDs = {
            R.drawable.tomatoes_hd,
            R.drawable.garlic_hd,
            R.drawable.potatoes_hd,
            R.drawable.onion_hd,
            R.drawable.lemons_hd,
            R.drawable.lettuce_hd,
            R.drawable.cabbage_hd,
            R.drawable.cucumber_hd,
            R.drawable.pepper_hd
    };

}

class Fruit {
    public static String[] titles = {"Banana", "Apple", "Watermelon", "Blueberry", "Strawberry", "Pineapple", "Orange"};

    public static Double[] prices = {5.91, 5.47, 14.80, 8.12, 9.81, 12.3, 8.41};

    public static String[] subTitles = {
            "12 mins ⭐ 4.9",
            "5 mins ⭐ 5.0",
            "20 mins ⭐ 4.3",
            "14 mins ⭐ 4.2",
            "17 mins ⭐ 4.7",
            "8 mins ⭐ 4.8",
            "23 mins ⭐ 4.4"
    };

    public static Integer[] imgIDs = {
            R.drawable.bananas_hd,
            R.drawable.apples_hd,
            R.drawable.watermelon_hd,
            R.drawable.blueberries_hd,
            R.drawable.strawberries_hd,
            R.drawable.pineapple_hd,
            R.drawable.oranges_hd
    };
}


public class Inventory {
    public static ArrayList<ItemCardModel> getTopSellingProducts() {
        final int LENGTH = 6;
        List<String> titles = Stream.concat(Arrays.stream(Vegies.titles), Arrays.stream(Fruit.titles)).collect(Collectors.toList());
        List<String> subTitles = Stream.concat(Arrays.stream(Vegies.subTitles), Arrays.stream(Fruit.subTitles)).collect(Collectors.toList());
        List<Double> prices = Stream.concat(Arrays.stream(Vegies.prices), Arrays.stream(Fruit.prices)).collect(Collectors.toList());
        List<Integer> imgIDs = Stream.concat(Arrays.stream(Vegies.imgIDs), Arrays.stream(Fruit.imgIDs)).collect(Collectors.toList());

        int seed = ThreadLocalRandom.current().nextInt();
        Collections.shuffle(titles, new Random(seed));
        Collections.shuffle(subTitles, new Random(seed));
        Collections.shuffle(prices, new Random(seed));
        Collections.shuffle(imgIDs, new Random(seed));

        ArrayList<ItemCardModel> items = new ArrayList<>();
        for (int i = 0; i < LENGTH; ++i) {
            items.add(new ItemCardModel(titles.get(i), subTitles.get(i), prices.get(i), imgIDs.get(i)));
        }
        return items;
    }

    public static ArrayList<ItemCardModel> getVegies() {
        return ItemCardModel.makeCards(Vegies.titles, Vegies.subTitles, Vegies.prices, Vegies.imgIDs);
    }

    public static ArrayList<ItemCardModel> getFruits() {
        return ItemCardModel.makeCards(Fruit.titles, Fruit.subTitles, Fruit.prices, Fruit.imgIDs);
    }
}
