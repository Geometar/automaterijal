//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.12.27 at 11:03:50 AM CET 
//


package com.automaterijal.application.tecdoc;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LinkageTextRecord complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LinkageTextRecord"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="informationTypeKey" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="informationTypeDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="isImmediateDisplay" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LinkageTextRecord", propOrder = {
    "informationTypeKey",
    "informationTypeDescription",
    "isImmediateDisplay",
    "text"
})
public class LinkageTextRecord {

    protected int informationTypeKey;
    protected String informationTypeDescription;
    protected boolean isImmediateDisplay;
    protected List<String> text;

    /**
     * Gets the value of the informationTypeKey property.
     * 
     */
    public int getInformationTypeKey() {
        return informationTypeKey;
    }

    /**
     * Sets the value of the informationTypeKey property.
     * 
     */
    public void setInformationTypeKey(int value) {
        this.informationTypeKey = value;
    }

    /**
     * Gets the value of the informationTypeDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInformationTypeDescription() {
        return informationTypeDescription;
    }

    /**
     * Sets the value of the informationTypeDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInformationTypeDescription(String value) {
        this.informationTypeDescription = value;
    }

    /**
     * Gets the value of the isImmediateDisplay property.
     * 
     */
    public boolean isIsImmediateDisplay() {
        return isImmediateDisplay;
    }

    /**
     * Sets the value of the isImmediateDisplay property.
     * 
     */
    public void setIsImmediateDisplay(boolean value) {
        this.isImmediateDisplay = value;
    }

    /**
     * Gets the value of the text property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the text property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getText().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getText() {
        if (text == null) {
            text = new ArrayList<String>();
        }
        return this.text;
    }

}
