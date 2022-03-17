/**
 * Mariya Mokrynska
 */
package edu.lwtech.findanybook;

import com.google.gson.annotations.SerializedName;

public class ImageLinks {
    @SerializedName("smallThumbnail")
    private String smallImage;
    @SerializedName("thumbnail")
    private String bigImage;

    public ImageLinks(String smallImage, String bigImage) {
        this.smallImage = smallImage;
        this.bigImage = bigImage;
    }

    public String getSmallImage() {
        return smallImage;
    }

    public void setSmallImage(String smallImage) {
        this.smallImage = smallImage;
    }

    public String getBigImage() {
        return bigImage;
    }

    public void setBigImage(String bigImage) {
        this.bigImage = bigImage;
    }
}
