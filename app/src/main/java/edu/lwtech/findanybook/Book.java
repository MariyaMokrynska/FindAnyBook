/**
 * Mariya Mokrynska
 */
package edu.lwtech.findanybook;

import com.google.gson.annotations.SerializedName;

public class Book {
    @SerializedName("selfLink")
    private String selfLink;
    @SerializedName("volumeInfo")
    private VolumeInfo volumeInfo;

    public Book(String selfLink, VolumeInfo volumeInfo) {
        this.selfLink = selfLink;
        this.volumeInfo = volumeInfo;
    }

    public String getSelfLink() {
        return selfLink;
    }

    public void setSelfLink(String selfLink) {
        this.selfLink = selfLink;
    }

    public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }

    public void setVolumeInfo(VolumeInfo volumeInfo) {
        this.volumeInfo = volumeInfo;
    }
}
