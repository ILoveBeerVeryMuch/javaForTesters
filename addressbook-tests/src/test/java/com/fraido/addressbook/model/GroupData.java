package com.fraido.addressbook.model;

import com.google.gson.annotations.Expose;

import java.util.Objects;

public class GroupData {
    @Expose
    private String groupName;
    @Expose
    private String groupHeader;
    @Expose
    private String groupFooter;
    private int id = Integer.MAX_VALUE;

    public GroupData withHeader(String groupHeader) {
        this.groupHeader = groupHeader;
        return this;
    }

    public GroupData withFooter(String groupFooter) {
        this.groupFooter = groupFooter;
        return this;
    }

    public GroupData withName(String groupName) {
        this.groupName = groupName;
        return this;
    }

    public GroupData withId(int id) {
        this.id = id;
        return this;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getGroupHeader() {
        return groupHeader;
    }

    public String getGroupFooter() {
        return groupFooter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "groupName='" + groupName + '\''+
                "id='" + id + '\''+
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData groupData = (GroupData) o;
        return id == groupData.id &&
                Objects.equals(groupName, groupData.groupName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupName, id);
    }
}
