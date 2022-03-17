/**
 * Mariya Mokrynska
 */
package edu.lwtech.findanybook;

import com.google.gson.annotations.SerializedName;

public class ISBNInfo {
    @SerializedName("type")
    private String type;
    @SerializedName("identifier")
    private String ISBN;

    public ISBNInfo(String type, String ISBN) {
        this.type = type;
        this.ISBN = ISBN;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
}
