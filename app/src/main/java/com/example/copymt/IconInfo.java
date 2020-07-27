package com.example.copymt;

public class IconInfo {

    String iconName;
    int iconID;

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    public int getIconID() {
        return iconID;
    }

    public void setIconID(int iconID) {
        this.iconID = iconID;
    }

    public IconInfo(String iconName, int iconID) {
        this.iconName = iconName;
        this.iconID = iconID;
    }
}
