package com.panaceasoft.directorydashboard1;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Panacea-Soft on 3/8/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
public class DirectoryCategory {

    @SerializedName("id")
    public String id;

    @SerializedName("name")
    public String name;

    @SerializedName("desc")
    public String desc;

    @SerializedName("image")
    public String image;

    public DirectoryCategory(String id, String name, String desc, String image) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.image = image;
    }

}

