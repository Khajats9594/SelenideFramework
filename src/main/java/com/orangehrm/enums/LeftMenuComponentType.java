package com.orangehrm.enums;

public enum LeftMenuComponentType {

    ADMIN("Admin"),
    PIM("PIM"),
    LEAVE("Leave");

    private String menuName;
    public String getMenuName() {
        return menuName;
    }
    LeftMenuComponentType(String menuName){
        this.menuName = menuName;
    }
}
