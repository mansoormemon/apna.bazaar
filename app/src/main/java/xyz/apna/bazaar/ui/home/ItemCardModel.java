package xyz.apna.bazaar.ui.home;

import java.util.ArrayList;

public class ItemCardModel {
    private final String title;
    private final String subTitle;
    private final Integer imgID;
    private final Double price;

    public ItemCardModel(String title_, String subTitle_, Double price_, Integer imgID_) {
        title = title_;
        subTitle = subTitle_;
        imgID = imgID_;
        price = price_;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public Integer getImgID() {
        return imgID;
    }

    public double getPrice() {
        return price;
    }

    public static ArrayList<ItemCardModel> makeCards(String[] titles, String[] subTitles, Double[] prices, Integer[] imgIDs) {
        ArrayList<ItemCardModel> items = new ArrayList<>();
        for (int i = 0; i < titles.length; ++i) {
            items.add(new ItemCardModel(titles[i], subTitles[i], prices[i], imgIDs[i]));
        }
        return items;
    }
}
