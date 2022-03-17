/**
 * Mariya Mokrynska
 */
package edu.lwtech.findanybook;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Locale;

public class VolumeInfo {
    @SerializedName("title")
    private String title;
    @SerializedName("authors")
    private ArrayList<String> authors;
    @SerializedName("categories")
    private ArrayList<String> categories;
    @SerializedName("description")
    private String description;
    @SerializedName("publisher")
    private String publisher;
    @SerializedName("publishedDate")
    private String publishedDate;
    @SerializedName("pageCount")
    private Integer pageCount;
    @SerializedName("industryIdentifiers")
    private ArrayList<ISBNInfo> ISBNs;
    @SerializedName("imageLinks")
    private ImageLinks images;
    private static final int MAX_AUTHOR_IN_TEXTVIEW = 2;
    private static final int MAX_CATEGORIES_IN_TEXTVIEW = 2;

    public VolumeInfo(String title, ArrayList<String> authors, ArrayList<String> categories, String description, String publisher, String publishedDate, Integer pageCount, ArrayList<ISBNInfo> ISBNs, ImageLinks images) {
        this.title = title;
        this.authors = authors;
        this.categories = categories;
        this.description = description;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
        this.pageCount = pageCount;
        this.ISBNs = ISBNs;
        this.images = images;
    }

    public String getTitle() {
        if (title == null) {
            return "";
        }
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getAuthors() {
        if (authors == null) {
            authors = new ArrayList<String>();
        }
        return authors;
    }

    public String getAuthorsText() {
        String result = "";
        if (authors != null) {
            for (int i = 0; i < authors.size(); i++) {
                if (i > 0) {
                    result += ", ";
                }
                if (i < MAX_AUTHOR_IN_TEXTVIEW) {
                    result += authors.get(i);
                } else {
                    result += "et al.";
                    break;
                }
            }
        }
        return result;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }

    public ArrayList<String> getCategories() {
        if (categories == null) {
            categories = new ArrayList<String>();
        }
        return categories;
    }

    public String getCategoriesText() {
        String result = "";
        if (categories == null) return "";
        for (int i = 0; i < categories.size(); i++) {
            if (i > 0) {
                result += ", ";
            }
            if (i < MAX_CATEGORIES_IN_TEXTVIEW) {
                result += categories.get(i);
            } else {
                result += "etc";
                break;
            }
        }
        return result;
    }

    public void setCategories(ArrayList<String> categories) {
        this.categories = categories;
    }

    public String getDescription() {
        if (description == null) {
            return "";
        }
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublisher() {
        if (publisher == null) {
            return "";
        }
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishedDate() {
        if (publishedDate == null) {
            return "";
        }
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public ArrayList<ISBNInfo> getISBNs() {
        if (ISBNs == null) {
            ISBNs = new ArrayList<ISBNInfo>();
        }
        return ISBNs;
    }

    public void setISBNs(ArrayList<ISBNInfo> ISBNs) {
        this.ISBNs = ISBNs;
    }

    private String getISBN(String isbnType) {
        for (ISBNInfo item : getISBNs()) {
            if (item.getType().equals(isbnType)) {
                return item.getISBN();
            }
        }
        return "";
    }

    public String getISBN10() {
        return getISBN("ISBN_10");
    }

    public String getISBN13() {
        return getISBN("ISBN_13");
    }

    public ImageLinks getImages() {
        return images;
    }

    public void setImages(ImageLinks images) {
        this.images = images;
    }

}