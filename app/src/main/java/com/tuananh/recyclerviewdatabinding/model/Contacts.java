package com.tuananh.recyclerviewdatabinding.model;

/**
 * Created by framgia on 27/12/2016.
 */
public class Contacts {
    private String mName;
    private String mCompany;
    private String mMobile;
    private String mEmail;
    private String mGroupName;

    public Contacts(String name, String company, String mobile, String email,
                    String groupName) {
        mName = name;
        mCompany = company;
        mMobile = mobile;
        mEmail = email;
        mGroupName = groupName;
    }

    public String getName() {
        return mName;
    }

    public String getCompany() {
        return mCompany;
    }

    public String getMobile() {
        return mMobile;
    }

    public String getEmail() {
        return mEmail;
    }

    public String getGroupName() {
        return mGroupName;
    }
}
