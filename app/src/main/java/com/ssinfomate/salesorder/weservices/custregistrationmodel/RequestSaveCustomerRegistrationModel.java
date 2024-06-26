package com.ssinfomate.salesorder.weservices.custregistrationmodel;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class RequestSaveCustomerRegistrationModel {

    @SerializedName("CoBr_Id")
    @Expose
    private String coBrId;
    @SerializedName("created_by")
    @Expose
    private String createdBy;
    @SerializedName("customername")
    @Expose
    private String customername;
    @SerializedName("coperson")
    @Expose
    private String coperson;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("oaddress")
    @Expose
    private String oaddress;
    @SerializedName("ostnkey")
    @Expose
    private String ostnkey;
    @SerializedName("otel1")
    @Expose
    private String otel1;
    @SerializedName("oEmail")
    @Expose
    private String oEmail;
    @SerializedName("omobile1")
    @Expose
    private String omobile1;
    @SerializedName("Acclgrpkey")
    @Expose
    private String acclgrpkey;
    @SerializedName("pricelistid")
    @Expose
    private String pricelistid;
    @SerializedName("salesledkey")
    @Expose
    private String salesledkey;
    @SerializedName("gstnno")
    @Expose
    private String gstnno;
    @SerializedName("taxtmdts")
    @Expose
    private String taxtmdts;
    @SerializedName("broker_key")
    @Expose
    private String brokerKey;
    @SerializedName("trsp_key")
    @Expose
    private String trspKey;
    @SerializedName("Msg")
    @Expose
    private String msg;

    /**
     * No args constructor for use in serialization
     *
     */
    public RequestSaveCustomerRegistrationModel() {
    }

    /**
     *
     * @param msg
     * @param gender
     * @param oEmail
     * @param pricelistid
     * @param ostnkey
     * @param omobile1
     * @param gstnno
     * @param coperson
     * @param createdBy
     * @param otel1
     * @param acclgrpkey
     * @param coBrId
     * @param customername
     * @param salesledkey
     * @param oaddress
     * @param taxtmdts
     */
    public RequestSaveCustomerRegistrationModel(String coBrId, String createdBy, String customername, String brokerKey, String trspKey, String coperson, String gender, String oaddress, String ostnkey, String otel1, String oEmail, String omobile1, String acclgrpkey, String pricelistid, String salesledkey, String gstnno, String taxtmdts, String msg) {
        super();
        this.coBrId = coBrId;
        this.createdBy = createdBy;
        this.customername = customername;
        this.coperson = coperson;
        this.gender = gender;
        this.oaddress = oaddress;
        this.ostnkey = ostnkey;
        this.otel1 = otel1;
        this.oEmail = oEmail;
        this.omobile1 = omobile1;
        this.acclgrpkey = acclgrpkey;
        this.pricelistid = pricelistid;
        this.salesledkey = salesledkey;
        this.gstnno = gstnno;
        this.taxtmdts = taxtmdts;
        this.brokerKey = brokerKey;
        this.trspKey = trspKey;
        this.msg = msg;
    }

    public String getCoBrId() {
        return coBrId;
    }

    public void setCoBrId(String coBrId) {
        this.coBrId = coBrId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getCoperson() {
        return coperson;
    }

    public void setCoperson(String coperson) {
        this.coperson = coperson;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOaddress() {
        return oaddress;
    }

    public void setOaddress(String oaddress) {
        this.oaddress = oaddress;
    }

    public String getOstnkey() {
        return ostnkey;
    }

    public void setOstnkey(String ostnkey) {
        this.ostnkey = ostnkey;
    }

    public String getOtel1() {
        return otel1;
    }

    public void setOtel1(String otel1) {
        this.otel1 = otel1;
    }

    public String getoEmail() {
        return oEmail;
    }

    public void setoEmail(String oEmail) {
        this.oEmail = oEmail;
    }

    public String getOmobile1() {
        return omobile1;
    }

    public void setOmobile1(String omobile1) {
        this.omobile1 = omobile1;
    }

    public String getAcclgrpkey() {
        return acclgrpkey;
    }

    public void setAcclgrpkey(String acclgrpkey) {
        this.acclgrpkey = acclgrpkey;
    }

    public String getPricelistid() {
        return pricelistid;
    }

    public void setPricelistid(String pricelistid) {
        this.pricelistid = pricelistid;
    }

    public String getSalesledkey() {
        return salesledkey;
    }

    public void setSalesledkey(String salesledkey) {
        this.salesledkey = salesledkey;
    }

    public String getGstnno() {
        return gstnno;
    }

    public void setGstnno(String gstnno) {
        this.gstnno = gstnno;
    }

    public String getTaxtmdts() {
        return taxtmdts;
    }

    public void setTaxtmdts(String taxtmdts) {
        this.taxtmdts = taxtmdts;
    }

    public String getBrokerKey() {
        return brokerKey;
    }

    public void setBrokerKey(String brokerKey) {
        this.brokerKey = brokerKey;
    }

    public String getTrspKey() {
        return trspKey;
    }

    public void setTrspKey(String trspKey) {
        this.trspKey = trspKey;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}