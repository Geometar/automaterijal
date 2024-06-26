//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.06.25 at 12:34:57 AM CEST 
//


package com.automaterijal.application.tecdoc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for motorIdsByManuIdCriteria2Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="motorIdsByManuIdCriteria2Request"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}motorIdsByManuIdCriteria2RequestSrc"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cylinderCapacityFrom" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="cylinderCapacityTo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="fuelTypeId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="lang" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="manuId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="motorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="powerFrom" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="powerHpType" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="powerTo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="provider" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="searchExactCode" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="searchExactTerm" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="sellsTerm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="yearOfConstruction" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="countryGroupFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "motorIdsByManuIdCriteria2Request", propOrder = {
    "country",
    "cylinderCapacityFrom",
    "cylinderCapacityTo",
    "fuelTypeId",
    "lang",
    "manuId",
    "motorCode",
    "powerFrom",
    "powerHpType",
    "powerTo",
    "provider",
    "searchExactCode",
    "searchExactTerm",
    "sellsTerm",
    "yearOfConstruction",
    "countryGroupFlag"
})
public class MotorIdsByManuIdCriteria2Request
    extends MotorIdsByManuIdCriteria2RequestSrc
{

    protected String country;
    protected Integer cylinderCapacityFrom;
    protected Integer cylinderCapacityTo;
    protected Long fuelTypeId;
    protected String lang;
    protected Long manuId;
    protected String motorCode;
    protected Integer powerFrom;
    protected Boolean powerHpType;
    protected Integer powerTo;
    protected int provider;
    protected Boolean searchExactCode;
    protected Boolean searchExactTerm;
    protected String sellsTerm;
    protected Integer yearOfConstruction;
    protected Boolean countryGroupFlag;

    /**
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountry(String value) {
        this.country = value;
    }

    /**
     * Gets the value of the cylinderCapacityFrom property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCylinderCapacityFrom() {
        return cylinderCapacityFrom;
    }

    /**
     * Sets the value of the cylinderCapacityFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCylinderCapacityFrom(Integer value) {
        this.cylinderCapacityFrom = value;
    }

    /**
     * Gets the value of the cylinderCapacityTo property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCylinderCapacityTo() {
        return cylinderCapacityTo;
    }

    /**
     * Sets the value of the cylinderCapacityTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCylinderCapacityTo(Integer value) {
        this.cylinderCapacityTo = value;
    }

    /**
     * Gets the value of the fuelTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFuelTypeId() {
        return fuelTypeId;
    }

    /**
     * Sets the value of the fuelTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFuelTypeId(Long value) {
        this.fuelTypeId = value;
    }

    /**
     * Gets the value of the lang property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLang() {
        return lang;
    }

    /**
     * Sets the value of the lang property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLang(String value) {
        this.lang = value;
    }

    /**
     * Gets the value of the manuId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getManuId() {
        return manuId;
    }

    /**
     * Sets the value of the manuId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setManuId(Long value) {
        this.manuId = value;
    }

    /**
     * Gets the value of the motorCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMotorCode() {
        return motorCode;
    }

    /**
     * Sets the value of the motorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMotorCode(String value) {
        this.motorCode = value;
    }

    /**
     * Gets the value of the powerFrom property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPowerFrom() {
        return powerFrom;
    }

    /**
     * Sets the value of the powerFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPowerFrom(Integer value) {
        this.powerFrom = value;
    }

    /**
     * Gets the value of the powerHpType property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPowerHpType() {
        return powerHpType;
    }

    /**
     * Sets the value of the powerHpType property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPowerHpType(Boolean value) {
        this.powerHpType = value;
    }

    /**
     * Gets the value of the powerTo property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPowerTo() {
        return powerTo;
    }

    /**
     * Sets the value of the powerTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPowerTo(Integer value) {
        this.powerTo = value;
    }

    /**
     * Gets the value of the provider property.
     * 
     */
    public int getProvider() {
        return provider;
    }

    /**
     * Sets the value of the provider property.
     * 
     */
    public void setProvider(int value) {
        this.provider = value;
    }

    /**
     * Gets the value of the searchExactCode property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSearchExactCode() {
        return searchExactCode;
    }

    /**
     * Sets the value of the searchExactCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSearchExactCode(Boolean value) {
        this.searchExactCode = value;
    }

    /**
     * Gets the value of the searchExactTerm property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSearchExactTerm() {
        return searchExactTerm;
    }

    /**
     * Sets the value of the searchExactTerm property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSearchExactTerm(Boolean value) {
        this.searchExactTerm = value;
    }

    /**
     * Gets the value of the sellsTerm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSellsTerm() {
        return sellsTerm;
    }

    /**
     * Sets the value of the sellsTerm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSellsTerm(String value) {
        this.sellsTerm = value;
    }

    /**
     * Gets the value of the yearOfConstruction property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getYearOfConstruction() {
        return yearOfConstruction;
    }

    /**
     * Sets the value of the yearOfConstruction property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setYearOfConstruction(Integer value) {
        this.yearOfConstruction = value;
    }

    /**
     * Gets the value of the countryGroupFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCountryGroupFlag() {
        return countryGroupFlag;
    }

    /**
     * Sets the value of the countryGroupFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCountryGroupFlag(Boolean value) {
        this.countryGroupFlag = value;
    }

}
