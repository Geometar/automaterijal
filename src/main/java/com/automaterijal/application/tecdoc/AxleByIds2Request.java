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
 * <p>Java class for axleByIds2Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="axleByIds2Request"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}axleByIds2RequestSrc"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="axleIds" type="{http://server.cat.tecdoc.net}integerList" minOccurs="0"/&gt;
 *         &lt;element name="bodyTypes" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="lang" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="provider" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
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
@XmlType(name = "axleByIds2Request", propOrder = {
    "axleIds",
    "bodyTypes",
    "country",
    "lang",
    "provider",
    "countryGroupFlag"
})
public class AxleByIds2Request
    extends AxleByIds2RequestSrc
{

    protected IntegerList axleIds;
    protected boolean bodyTypes;
    protected String country;
    protected String lang;
    protected int provider;
    protected Boolean countryGroupFlag;

    /**
     * Gets the value of the axleIds property.
     * 
     * @return
     *     possible object is
     *     {@link IntegerList }
     *     
     */
    public IntegerList getAxleIds() {
        return axleIds;
    }

    /**
     * Sets the value of the axleIds property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntegerList }
     *     
     */
    public void setAxleIds(IntegerList value) {
        this.axleIds = value;
    }

    /**
     * Gets the value of the bodyTypes property.
     * 
     */
    public boolean isBodyTypes() {
        return bodyTypes;
    }

    /**
     * Sets the value of the bodyTypes property.
     * 
     */
    public void setBodyTypes(boolean value) {
        this.bodyTypes = value;
    }

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
