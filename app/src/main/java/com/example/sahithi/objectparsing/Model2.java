package com.example.sahithi.objectparsing;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Model2 {
    @SerializedName("menu")
    @Expose
    private Menu menu;

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
    public class Menu {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("value")
        @Expose
        private String value;
        @SerializedName("popup")
        @Expose
        private Popup popup;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Popup getPopup() {
            return popup;
        }

        public void setPopup(Popup popup) {
            this.popup = popup;
        }

    }
    public class Menuitem {

        @SerializedName("value")
        @Expose
        private String value;
        @SerializedName("onclick")
        @Expose
        private String onclick;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getOnclick() {
            return onclick;
        }

        public void setOnclick(String onclick) {
            this.onclick = onclick;
        }

    }
    public class Popup {

        @SerializedName("menuitem")
        @Expose
        private List<Menuitem> menuitem = null;

        public List<Menuitem> getMenuitem() {
            return menuitem;
        }

        public void setMenuitem(List<Menuitem> menuitem) {
            this.menuitem = menuitem;
        }

    }
}
