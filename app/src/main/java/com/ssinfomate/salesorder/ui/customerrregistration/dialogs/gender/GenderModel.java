package com.ssinfomate.salesorder.ui.customerrregistration.dialogs.gender;



import java.util.ArrayList;

public class GenderModel {
    private String id;
    private String name;

    public GenderModel(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static ArrayList<GenderModel> getGenderModelList() {

        ArrayList list = new ArrayList();

        list.add(new GenderModel( "M","Male"));

        list.add(new GenderModel( "F","Female"));

        list.add(new GenderModel( "T","Other"));

        return list;

    }
}
