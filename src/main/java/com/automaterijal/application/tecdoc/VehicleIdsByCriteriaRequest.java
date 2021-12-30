//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.12.29 at 02:20:27 PM CET 
//


package com.automaterijal.application.tecdoc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for vehicleIdsByCriteriaRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="vehicleIdsByCriteriaRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}vehicleIdsByCriteriaRequestSrc"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="axisConfigurationId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="carType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="constructionTypeId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="countriesCarSelection" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="countryGroupFlag" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="cylinderCapacityFrom" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="cylinderCapacityTo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="favouredList" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="fuelTypeId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="lang" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="manuId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="modId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="modelDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="powerFrom" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="powerHpType" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="powerTo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="provider" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="tonnageFrom" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="tonnageTo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="yearOfConstruction" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "vehicleIdsByCriteriaRequest", propOrder = {
    "axisConfigurationId",
    "carType",
    "constructionTypeId",
    "countriesCarSelection",
    "countryGroupFlag",
    "cylinderCapacityFrom",
    "cylinderCapacityTo",
    "favouredList",
    "fuelTypeId",
    "lang",
    "manuId",
    "modId",
    "modelDescription",
    "powerFrom",
    "powerHpType",
    "powerTo",
    "provider",
    "tonnageFrom",
    "tonnageTo",
    "yearOfConstruction"
})
public class VehicleIdsByCriteriaRequest
    extends VehicleIdsByCriteriaRequestSrc
{

    protected Long axisConfigurationId;
    protected String carType;
    protected Long constructionTypeId;
    protected String countriesCarSelection;
    protected boolean countryGroupFlag;
    protected Integer cylinderCapacityFrom;
    protected Integer cylinderCapacityTo;
    protected Integer favouredList;
    protected Long fuelTypeId;
    protected String lang;
    protected Long manuId;
    protected Long modId;
    protected String modelDescription;
    protected Integer powerFrom;
    protected Boolean powerHpType;
    protected Integer powerTo;
    protected int provider;
    protected Integer tonnageFrom;
    protected Integer tonnageTo;
    protected Integer yearOfConstruction;

    /**
     * Gets the value of the axisConfigurationId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAxisConfigurationId() {
        return axisConfigurationId;
    }

    /**
     * Sets the value of the axisConfigurationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAxisConfigurationId(Long value) {
        this.axisConfigurationId = value;
    }

    /**
     * Gets the value of the carType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarType() {
        return carType;
    }

    /**
     * Sets the value of the carType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarType(String value) {
        this.carType = value;
    }

    /**
     * Gets the value of the constructionTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getConstructionTypeId() {
        return constructionTypeId;
    }

    /**
     * Sets the value of the constructionTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setConstructionTypeId(Long value) {
        this.constructionTypeId = value;
    }

    /**
     * Gets the value of the countriesCarSelection property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountriesCarSelection() {
        return countriesCarSelection;
    }

    /**
     * Sets the value of the countriesCarSelection property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountriesCarSelection(String value) {
        this.countriesCarSelection = value;
    }

    /**
     * Gets the value of the countryGroupFlag property.
     * 
     */
    public boolean isCountryGroupFlag() {
        return countryGroupFlag;
    }

    /**
     * Sets the value of the countryGroupFlag property.
     * 
     */
    public void setCountryGroupFlag(boolean value) {
        this.countryGroupFlag = value;
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
     * Gets the value of the favouredList property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFavouredList() {
        return favouredList;
    }

    /**
     * Sets the value of the favouredList property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFavouredList(Integer value) {
        this.favouredList = value;
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
     * Gets the value of the modId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getModId() {
        return modId;
    }

    /**
     * Sets the value of the modId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setModId(Long value) {
        this.modId = value;
    }

    /**
     * Gets the value of the modelDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModelDescription() {
        return modelDescription;
    }

    /**
     * Sets the value of the modelDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModelDescription(String value) {
        this.modelDescription = value;
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
     * Gets the value of the tonnageFrom property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTonnageFrom() {
        return tonnageFrom;
    }

    /**
     * Sets the value of the tonnageFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTonnageFrom(Integer value) {
        this.tonnageFrom = value;
    }

    /**
     * Gets the value of the tonnageTo property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTonnageTo() {
        return tonnageTo;
    }

    /**
     * Sets the value of the tonnageTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTonnageTo(Integer value) {
        this.tonnageTo = value;
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

}
