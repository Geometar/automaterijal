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
 * <p>Java class for vehicleIdsByKTypeNumberRecord complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="vehicleIdsByKTypeNumberRecord"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}vehicleIdsByKTypeNumberRecordSrc"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="carId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="carName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="firstCountry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="kTypeNumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="nTypeNumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
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
@XmlType(name = "vehicleIdsByKTypeNumberRecord", propOrder = {
    "carId",
    "carName",
    "firstCountry",
    "kTypeNumber",
    "nTypeNumber",
    "rmiTypeId"
})
public class VehicleIdsByKTypeNumberRecord
    extends VehicleIdsByKTypeNumberRecordSrc
{

    protected Long carId;
    protected String carName;
    protected String firstCountry;
    protected Integer kTypeNumber;
    protected Integer nTypeNumber;
    protected Integer rmiTypeId;

    /**
     * Gets the value of the carId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCarId() {
        return carId;
    }

    /**
     * Sets the value of the carId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCarId(Long value) {
        this.carId = value;
    }

    /**
     * Gets the value of the carName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarName() {
        return carName;
    }

    /**
     * Sets the value of the carName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarName(String value) {
        this.carName = value;
    }

    /**
     * Gets the value of the firstCountry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstCountry() {
        return firstCountry;
    }

    /**
     * Sets the value of the firstCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstCountry(String value) {
        this.firstCountry = value;
    }

    /**
     * Gets the value of the kTypeNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getKTypeNumber() {
        return kTypeNumber;
    }

    /**
     * Sets the value of the kTypeNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setKTypeNumber(Integer value) {
        this.kTypeNumber = value;
    }

    /**
     * Gets the value of the nTypeNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNTypeNumber() {
        return nTypeNumber;
    }

    /**
     * Sets the value of the nTypeNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNTypeNumber(Integer value) {
        this.nTypeNumber = value;
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
