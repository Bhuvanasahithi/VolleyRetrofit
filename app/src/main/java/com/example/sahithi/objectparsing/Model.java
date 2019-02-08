package com.example.sahithi.objectparsing;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Model  {
    @SerializedName("glossary")
    @Expose
    private Glossary glossary;

    public Glossary getGlossary() {
        return glossary;
    }

    public void setGlossary(Glossary glossary) {
        this.glossary = glossary;
    }
    public class GlossDef {

        @SerializedName("para")
        @Expose
        private String para;
        @SerializedName("GlossSeeAlso")
        @Expose
        private List<String> glossSeeAlso = null;

        public String getPara() {
            return para;
        }

        public void setPara(String para) {
            this.para = para;
        }

        public List<String> getGlossSeeAlso() {
            return glossSeeAlso;
        }

        public void setGlossSeeAlso(List<String> glossSeeAlso) {
            this.glossSeeAlso = glossSeeAlso;
        }
    }
    public class GlossDiv {

        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("GlossList")
        @Expose
        private GlossList glossList;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public GlossList getGlossList() {
            return glossList;
        }

        public void setGlossList(GlossList glossList) {
            this.glossList = glossList;
        }

    }
    public class GlossEntry {

        @SerializedName("ID")
        @Expose
        private String iD;
        @SerializedName("SortAs")
        @Expose
        private String sortAs;
        @SerializedName("GlossTerm")
        @Expose
        private String glossTerm;
        @SerializedName("Acronym")
        @Expose
        private String acronym;
        @SerializedName("Abbrev")
        @Expose
        private String abbrev;
        @SerializedName("GlossDef")
        @Expose
        private GlossDef glossDef;
        @SerializedName("GlossSee")
        @Expose
        private String glossSee;

        public String getID() {
            return iD;
        }

        public void setID(String iD) {
            this.iD = iD;
        }

        public String getSortAs() {
            return sortAs;
        }

        public void setSortAs(String sortAs) {
            this.sortAs = sortAs;
        }

        public String getGlossTerm() {
            return glossTerm;
        }

        public void setGlossTerm(String glossTerm) {
            this.glossTerm = glossTerm;
        }

        public String getAcronym() {
            return acronym;
        }

        public void setAcronym(String acronym) {
            this.acronym = acronym;
        }

        public String getAbbrev() {
            return abbrev;
        }

        public void setAbbrev(String abbrev) {
            this.abbrev = abbrev;
        }

        public GlossDef getGlossDef() {
            return glossDef;
        }

        public void setGlossDef(GlossDef glossDef) {
            this.glossDef = glossDef;
        }

        public String getGlossSee() {
            return glossSee;
        }

        public void setGlossSee(String glossSee) {
            this.glossSee = glossSee;
        }

    }
    public class GlossList {

        @SerializedName("GlossEntry")
        @Expose
        private GlossEntry glossEntry;

        public GlossEntry getGlossEntry() {
            return glossEntry;
        }

        public void setGlossEntry(GlossEntry glossEntry) {
            this.glossEntry = glossEntry;
        }

    }
    public class Glossary {

        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("GlossDiv")
        @Expose
        private GlossDiv glossDiv;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public GlossDiv getGlossDiv() {
            return glossDiv;
        }

        public void setGlossDiv(GlossDiv glossDiv) {
            this.glossDiv = glossDiv;
        }

    }
}





