package Model;

import java.util.ArrayList;

/**
 * Created by HAMMAX on 31.03.2016.
 */
public class SortedFileModel {
    String letter;
    ArrayList<String> products = new ArrayList<>();

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public ArrayList<String> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<String> products) {
        this.products = products;
    }
}
