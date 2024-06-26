package com.ssinfomate.salesorder.ui.filters;

import com.ssinfomate.salesorder.weservices.masters.ItemGroupModel;
import com.ssinfomate.salesorder.weservices.masters.ItemSubGroupModel;
import com.ssinfomate.salesorder.weservices.masters.StyleListModel;

public interface IFiltersListener {
    void onItemGroupNameClicked(ItemGroupModel itemGroupModel , int position);
    void onItemSubGroupNameClicked(ItemSubGroupModel itemSubGroupModel, int position);
    void onStyleNameClicked(StyleListModel styleListModel, int position);
}
