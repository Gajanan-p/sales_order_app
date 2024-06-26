package com.ssinfomate.salesorder.weservices.custregistrationmodel;


import java.util.ArrayList;


public class CategoryModel {
     private int categoryId;
     private String categoryName;

    public CategoryModel(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public static ArrayList<CategoryModel> getCategoryModelList() {

        ArrayList list = new ArrayList();

        list.add(new CategoryModel( 1,"Customer "));

        list.add(new CategoryModel( 2,"Consignee"));


        return list;

    }
}