//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.04.05 at 10:10:27 PM CEST 
//


package com.automaterijal.application.tecdoc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for attributeValue complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="attributeValue"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}attributeValueSrc"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="alphaValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="attributeId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="compactValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="count" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="keyValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="keyValueText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="noValue" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="numValue" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="selected" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "attributeValue", propOrder = {
    "alphaValue",
    "attributeId",
    "compactValue",
    "count",
    "keyValue",
    "keyValueText",
    "noValue",
    "numValue",
    "selected",
    "type"
})
public class AttributeValue
    extends AttributeValueSrc
{

    protected String alphaValue;
    protected long attributeId;
    protected String compactValue;
    protected Integer count;
    protected String keyValue;
    protected String keyValueText;
    protected boolean noValue;
    protected Double numValue;
    protected boolean selected;
    protected String type;

    /**
     * Gets the value of the alphaValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlphaValue() {
        return alphaValue;
    }

    /**
     * Sets the value of the alphaValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlphaValue(String value) {
        this.alphaValue = value;
    }

    /**
     * Gets the value of the attributeId property.
     * 
     */
    public long getAttributeId() {
        return attributeId;
    }

    /**
     * Sets the value of the attributeId property.
     * 
     */
    public void setAttributeId(long value) {
        this.attributeId = value;
    }

    /**
     * Gets the value of the compactValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompactValue() {
        return compactValue;
    }

    /**
     * Sets the value of the compactValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompactValue(String value) {
        this.compactValue = value;
    }

    /**
     * Gets the value of the count property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCount() {
        return count;
    }

    /**
     * Sets the value of the count property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCount(Integer value) {
        this.count = value;
    }

    /**
     * Gets the value of the keyValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKeyValue() {
        return keyValue;
    }

    /**
     * Sets the value of the keyValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKeyValue(String value) {
        this.keyValue = value;
    }

    /**
     * Gets the value of the keyValueText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKeyValueText() {
        return keyValueText;
    }

    /**
     * Sets the value of the keyValueText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKeyValueText(String value) {
        this.keyValueText = value;
    }

    /**
     * Gets the value of the noValue property.
     * 
     */
    public boolean isNoValue() {
        return noValue;
    }

    /**
     * Sets the value of the noValue property.
     * 
     */
    public void setNoValue(boolean value) {
        this.noValue = value;
    }

    /**
     * Gets the value of the numValue property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getNumValue() {
        return numValue;
    }

    /**
     * Sets the value of the numValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setNumValue(Double value) {
        this.numValue = value;
    }

    /**
     * Gets the value of the selected property.
     * 
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * Sets the value of the selected property.
     * 
     */
    public void setSelected(boolean value) {
        this.selected = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

}