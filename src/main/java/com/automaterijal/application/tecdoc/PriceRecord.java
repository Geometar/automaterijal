//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.09.04 at 11:53:31 AM CEST 
//


package com.automaterijal.application.tecdoc;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PriceRecord complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PriceRecord"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="currencyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="discountGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="isDiscount" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="priceCents" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="kindOfPriceKey" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="kindOfPriceDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="priceUnitKey" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="priceUnitDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="quantityUnitKey" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="quantityUnitDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="validDateFrom" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="validDateTo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PriceRecord", propOrder = {
    "currencyCode",
    "discountGroup",
    "isDiscount",
    "price",
    "priceCents",
    "kindOfPriceKey",
    "kindOfPriceDescription",
    "priceUnitKey",
    "priceUnitDescription",
    "quantityUnitKey",
    "quantityUnitDescription",
    "validDateFrom",
    "validDateTo"
})
public class PriceRecord {

    protected String currencyCode;
    protected String discountGroup;
    protected Boolean isDiscount;
    protected BigDecimal price;
    protected Integer priceCents;
    protected int kindOfPriceKey;
    protected String kindOfPriceDescription;
    protected int priceUnitKey;
    protected String priceUnitDescription;
    @XmlElement(required = true)
    protected String quantityUnitKey;
    protected String quantityUnitDescription;
    protected int validDateFrom;
    protected Integer validDateTo;

    /**
     * Gets the value of the currencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Sets the value of the currencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrencyCode(String value) {
        this.currencyCode = value;
    }

    /**
     * Gets the value of the discountGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiscountGroup() {
        return discountGroup;
    }

    /**
     * Sets the value of the discountGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiscountGroup(String value) {
        this.discountGroup = value;
    }

    /**
     * Gets the value of the isDiscount property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsDiscount() {
        return isDiscount;
    }

    /**
     * Sets the value of the isDiscount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsDiscount(Boolean value) {
        this.isDiscount = value;
    }

    /**
     * Gets the value of the price property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPrice(BigDecimal value) {
        this.price = value;
    }

    /**
     * Gets the value of the priceCents property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPriceCents() {
        return priceCents;
    }

    /**
     * Sets the value of the priceCents property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPriceCents(Integer value) {
        this.priceCents = value;
    }

    /**
     * Gets the value of the kindOfPriceKey property.
     * 
     */
    public int getKindOfPriceKey() {
        return kindOfPriceKey;
    }

    /**
     * Sets the value of the kindOfPriceKey property.
     * 
     */
    public void setKindOfPriceKey(int value) {
        this.kindOfPriceKey = value;
    }

    /**
     * Gets the value of the kindOfPriceDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKindOfPriceDescription() {
        return kindOfPriceDescription;
    }

    /**
     * Sets the value of the kindOfPriceDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKindOfPriceDescription(String value) {
        this.kindOfPriceDescription = value;
    }

    /**
     * Gets the value of the priceUnitKey property.
     * 
     */
    public int getPriceUnitKey() {
        return priceUnitKey;
    }

    /**
     * Sets the value of the priceUnitKey property.
     * 
     */
    public void setPriceUnitKey(int value) {
        this.priceUnitKey = value;
    }

    /**
     * Gets the value of the priceUnitDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPriceUnitDescription() {
        return priceUnitDescription;
    }

    /**
     * Sets the value of the priceUnitDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPriceUnitDescription(String value) {
        this.priceUnitDescription = value;
    }

    /**
     * Gets the value of the quantityUnitKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuantityUnitKey() {
        return quantityUnitKey;
    }

    /**
     * Sets the value of the quantityUnitKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuantityUnitKey(String value) {
        this.quantityUnitKey = value;
    }

    /**
     * Gets the value of the quantityUnitDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuantityUnitDescription() {
        return quantityUnitDescription;
    }

    /**
     * Sets the value of the quantityUnitDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuantityUnitDescription(String value) {
        this.quantityUnitDescription = value;
    }

    /**
     * Gets the value of the validDateFrom property.
     * 
     */
    public int getValidDateFrom() {
        return validDateFrom;
    }

    /**
     * Sets the value of the validDateFrom property.
     * 
     */
    public void setValidDateFrom(int value) {
        this.validDateFrom = value;
    }

    /**
     * Gets the value of the validDateTo property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getValidDateTo() {
        return validDateTo;
    }

    /**
     * Sets the value of the validDateTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setValidDateTo(Integer value) {
        this.validDateTo = value;
    }

}
