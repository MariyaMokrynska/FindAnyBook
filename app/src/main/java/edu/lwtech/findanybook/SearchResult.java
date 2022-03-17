/**
 * Mariya Mokrynska
 */
package edu.lwtech.findanybook;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SearchResult {
    @SerializedName("kind")
    private String kind;
    @SerializedName("totalItems")
    private Integer totalItems;
    @SerializedName("items")
    private ArrayList<Book> books;

    public SearchResult(String kind, Integer totalItems, ArrayList<Book> books) {
        this.kind = kind;
        this.totalItems = totalItems;
        this.books = books;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
}
