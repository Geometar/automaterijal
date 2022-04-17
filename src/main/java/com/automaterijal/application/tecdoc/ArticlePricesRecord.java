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
 * <p>Java class for articlePricesRecord complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="articlePricesRecord"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}articlePricesRecordSrc"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="currency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="discount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="hasLessDiscount" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="priceTypeId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="priceTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="priceUnitId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="priceUnitName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="quantityUnitId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="quantityUnitName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="validDateFrom" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="validDateTo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "articlePricesRecord", propOrder = {
    "currency",
    "discount",
    "hasLessDiscount",
    "price",
    "priceTypeId",
    "priceTypeName",
    "priceUnitId",
    "priceUnitName",
    "quantityUnitId",
    "quantityUnitName",
    "validDateFrom",
    "validDateTo"
})
public class ArticlePricesRecord
    extends ArticlePricesRecordSrc
{

    protected String currency;
    protected String discount;
    protected Boolean hasLessDiscount;
    protected Integer price;
    protected Long priceTypeId;
    protected String priceTypeName;
    protected Long priceUnitId;
    protected String priceUnitName;
    protected String quantityUnitId;
    protected String quantityUnitName;
    protected Integer validDateFrom;
    protected Integer validDateTo;

    /**
     * Gets the value of the currency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

    /**
     * Gets the value of the discount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiscount() {
        return discount;
    }

    /**
     * Sets the value of the discount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiscount(String value) {
        this.discount = value;
    }

    /**
     * Gets the value of the hasLessDiscount property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasLessDiscount() {
        return hasLessDiscount;
    }

    /**
     * Sets the value of the hasLessDiscount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasLessDiscount(Boolean value) {
        this.hasLessDiscount = value;
    }

    /**
     * Gets the value of the price property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPrice(Integer value) {
        this.price = value;
    }

    /**
     * Gets the value of the priceTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPriceTypeId() {
        return priceTypeId;
    }

    /**
     * Sets the value of the priceTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPriceTypeId(Long value) {
        this.priceTypeId = value;
    }

    /**
     * Gets the value of the priceTypeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPriceTypeName() {
        return priceTypeName;
    }

    /**
     * Sets the value of the priceTypeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPriceTypeName(String value) {
        this.priceTypeName = value;
    }

    /**
     * Gets the value of the priceUnitId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPriceUnitId() {
        return priceUnitId;
    }

    /**
     * Sets the value of the priceUnitId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPriceUnitId(Long value) {
        this.priceUnitId = value;
    }

    /**
     * Gets the value of the priceUnitName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPriceUnitName() {
        return priceUnitName;
    }

    /**
     * Sets the value of the priceUnitName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPriceUnitName(String value) {
        this.priceUnitName = value;
    }

    /**
     * Gets the value of the quantityUnitId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuantityUnitId() {
        return quantityUnitId;
    }

    /**
     * Sets the value of the quantityUnitId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuantityUnitId(String value) {
        this.quantityUnitId = value;
    }

    /**
     * Gets the value of the quantityUnitName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuantityUnitName() {
        return quantityUnitName;
    }

    /**
     * Sets the value of the quantityUnitName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuantityUnitName(String value) {
        this.quantityUnitName = value;
    }

    /**
     * Gets the value of the validDateFrom property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getValidDateFrom() {
        return validDateFrom;
    }

    /**
     * Sets the value of the validDateFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setValidDateFrom(Integer value) {
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
