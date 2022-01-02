package entities;

import java.io.Serializable;

public class PlayStoreApp implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String category;
    private String rating;
    private String reviews;
    //private Double rating;
    //private Integer reviews;
    private String size;
    private String installs;
    private String type;
    private String price;
    private String contentRating;
    private String genres;
    private String lastUpdated;
    private String currentVer;
    private String androidVer;

    public PlayStoreApp () {

    }

    public PlayStoreApp(String name, String category, String rating, String reviews, String size, String installs, String type, String price, String contentRating, String genres, String lastUpdated, String currentVer, String androidVer) {
        this.name = name;
        this.category = category;
        this.rating = rating;
        this.reviews = reviews;
        this.size = size;
        this.installs = installs;
        this.type = type;
        this.price = price;
        this.contentRating = contentRating;
        this.genres = genres;
        this.lastUpdated = lastUpdated;
        this.currentVer = currentVer;
        this.androidVer = androidVer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getInstalls() {
        return installs;
    }

    public void setInstalls(String installs) {
        this.installs = installs;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getContentRating() {
        return contentRating;
    }

    public void setContentRating(String contentRating) {
        this.contentRating = contentRating;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getCurrentVer() {
        return currentVer;
    }

    public void setCurrentVer(String currentVer) {
        this.currentVer = currentVer;
    }

    public String getAndroidVer() {
        return androidVer;
    }

    public void setAndroidVer(String androidVer) {
        this.androidVer = androidVer;
    }

    @Override
    public String toString() {
        return "PlayStoreApp{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", rating='" + rating + '\'' +
                ", reviews='" + reviews + '\'' +
                ", size='" + size + '\'' +
                ", installs='" + installs + '\'' +
                ", type='" + type + '\'' +
                ", price='" + price + '\'' +
                ", contentRating='" + contentRating + '\'' +
                ", genres='" + genres + '\'' +
                ", lastUpdated='" + lastUpdated + '\'' +
                ", currentVer='" + currentVer + '\'' +
                ", androidVer='" + androidVer + '\'' +
                '}';
    }
}