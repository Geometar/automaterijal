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
 * <p>Java class for vehicleIdsByKTypeNumberRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="vehicleIdsByKTypeNumberRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}vehicleIdsByKTypeNumberRequestSrc"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="carType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="countriesCarSelection" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="countryGroupFlag" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="lang" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="provider" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="typeNumber" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="rmiTypeId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "vehicleIdsByKTypeNumberRequest", propOrder = {
    "carType",
    "countriesCarSelection",
    "countryGroupFlag",
    "lang",
    "provider",
    "typeNumber",
    "rmiTypeId"
})
public class VehicleIdsByKTypeNumberRequest
    extends VehicleIdsByKTypeNumberRequestSrc
{

    protected String carType;
    protected String countriesCarSelection;
    protected boolean countryGroupFlag;
    protected String lang;
    protected int provider;
    protected int typeNumber;
    protected Integer rmiTypeId;

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
     * Gets the value of the typeNumber property.
     * 
     */
    public int getTypeNumber() {
        return typeNumber;
    }

    /**
     * Sets the value of the typeNumber property.
     * 
     */
    public void setTypeNumber(int value) {
        this.typeNumber = value;
    }

    /**
     * Gets the value of the rmiTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRmiTypeId() {
        return rmiTypeId;
    }

    /**
     * Sets the value of the rmiTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRmiTypeId(Integer value) {
        this.rmiTypeId = value;
    }

}
