package com.template.helpers.webengine;

import org.openqa.selenium.By;

public class Element implements Cloneable {

    private String name;
    private String xpath;
    private String value;
    private String xpathPiece = "";

    public Element(String name, String xpath) {
        this.name = name;
        this.xpath = xpath;
    }

    public Element(Element element) {
        name = element.getName();
        xpath = element.getXpath();
        value = element.getValue();
    }

    public Element addXPathPieceToXPath(String xpathPiece){
        this.xpathPiece += xpathPiece;
        return this;
    }

    public void cleanAdditionalXPath(){
        this.xpathPiece = "";
    }

    public String getName() {
        return name;
    }

    public By getBy() {
        return By.xpath(String.format(xpath + xpathPiece, value));
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getXpath() {
        return xpath + xpathPiece;
    }

    public String getFullXpath() {
        return String.format(xpath + xpathPiece, value);
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        if (value != null) {
            return name + "; value: " + value;
        }
        else {
            return name;
        }
    }

    public Element getClone() {
        try {
            return (Element) this.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
