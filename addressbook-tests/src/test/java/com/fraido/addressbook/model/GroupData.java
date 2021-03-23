package com.fraido.addressbook.model;

import java.util.Objects;

public class GroupData {
    private final String groupName;
    private final String groupHeader;
    private final String groupFooter;
    private int id;

    public GroupData(String groupName, String groupHeader, String groupFooter, int id) {
        this.groupName = groupName;
        this.groupHeader = groupHeader;
        this.groupFooter = groupFooter;
        this.id = id;
    }
    public GroupData(String groupName, String groupHeader, String groupFooter) {
        this.groupName = groupName;
        this.groupHeader = groupHeader;
        this.groupFooter = groupFooter;
        this.id = Integer.MAX_VALUE;
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

    @Override
    public String toString() {
        return "GroupData{" +
                "groupName='" + groupName + '\''+
                "id='" + id + '\''+
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData groupData = (GroupData) o;
        return Objects.equals(groupName, groupData.groupName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupName);
    }
}
