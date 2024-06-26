package com.ssinfomate.salesorder.ui.customerrregistration.dialogs;

import com.ssinfomate.salesorder.weservices.custregistrationmodel.AccountTypeModel;
import com.ssinfomate.salesorder.weservices.custregistrationmodel.BrokerListModel;
import com.ssinfomate.salesorder.weservices.custregistrationmodel.CategoryModel;
import com.ssinfomate.salesorder.weservices.custregistrationmodel.DiscountModel;
import com.ssinfomate.salesorder.weservices.custregistrationmodel.PriceListModel;
import com.ssinfomate.salesorder.weservices.custregistrationmodel.SaleTypeModel;
import com.ssinfomate.salesorder.weservices.custregistrationmodel.StationListModel;
import com.ssinfomate.salesorder.weservices.custregistrationmodel.TransporterListModel;

public interface IListener{
    void onAccountTypeClicked(AccountTypeModel accountTypeModel, int position);
    void onCategoryClicked(CategoryModel categoryModel, int position);
    void onDiscountClicked(DiscountModel discountModel, int position);
    void onSaleTypeClicked(SaleTypeModel saleTypeModel, int position);
    void onPriceListClicked(PriceListModel priceListModel, int position);
    void onStationNameClicked(StationListModel stationListModel, int position);
    void onBrokerNameClicked(BrokerListModel brokerListModel,int position);
    void onTransporterNameClicked(TransporterListModel transporterListModel, int position);

}
