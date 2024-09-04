//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.09.04 at 11:53:31 AM CEST 
//


package com.automaterijal.application.tecdoc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for axleByIdRecord complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="axleByIdRecord"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}axleByIdRecordSrc"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="axleBodyType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="axleDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="axleId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="axleLoadFrom" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="axleLoadUpto" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="axleManufacturer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="axleModel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="axleStyle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="axleType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="axleTypeId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="brakeType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="driveHeightFrom" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="driveHeightTo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="hubSystem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="manuId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="manuName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="manuShortName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="modelId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="modelName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="trackGauge" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="wheelMount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="yearOfConstrFrom" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="yearOfConstrTo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "axleByIdRecord", propOrder = {
    "axleBodyType",
    "axleDescription",
    "axleId",
    "axleLoadFrom",
    "axleLoadUpto",
    "axleManufacturer",
    "axleModel",
    "axleStyle",
    "axleType",
    "axleTypeId",
    "brakeType",
    "driveHeightFrom",
    "driveHeightTo",
    "hubSystem",
    "manuId",
    "manuName",
    "manuShortName",
    "modelId",
    "modelName",
    "trackGauge",
    "wheelMount",
    "yearOfConstrFrom",
    "yearOfConstrTo"
})
public class AxleByIdRecord
    extends AxleByIdRecordSrc
{

    protected String axleBodyType;
    protected String axleDescription;
    protected Long axleId;
    protected Integer axleLoadFrom;
    protected Integer axleLoadUpto;
    protected String axleManufacturer;
    protected String axleModel;
    protected String axleStyle;
    protected String axleType;
    protected Long axleTypeId;
    protected String brakeType;
    protected Integer driveHeightFrom;
    protected Integer driveHeightTo;
    protected String hubSystem;
    protected Long manuId;
    protected String manuName;
    protected String manuShortName;
    protected Long modelId;
    protected String modelName;
    protected Integer trackGauge;
    protected String wheelMount;
    protected Integer yearOfConstrFrom;
    protected Integer yearOfConstrTo;

    /**
     * Gets the value of the axleBodyType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAxleBodyType() {
        return axleBodyType;
    }

    /**
     * Sets the value of the axleBodyType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAxleBodyType(String value) {
        this.axleBodyType = value;
    }

    /**
     * Gets the value of the axleDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAxleDescription() {
        return axleDescription;
    }

    /**
     * Sets the value of the axleDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAxleDescription(String value) {
        this.axleDescription = value;
    }

    /**
     * Gets the value of the axleId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAxleId() {
        return axleId;
    }

    /**
     * Sets the value of the axleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAxleId(Long value) {
        this.axleId = value;
    }

    /**
     * Gets the value of the axleLoadFrom property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAxleLoadFrom() {
        return axleLoadFrom;
    }

    /**
     * Sets the value of the axleLoadFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAxleLoadFrom(Integer value) {
        this.axleLoadFrom = value;
    }

    /**
     * Gets the value of the axleLoadUpto property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAxleLoadUpto() {
        return axleLoadUpto;
    }

    /**
     * Sets the value of the axleLoadUpto property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAxleLoadUpto(Integer value) {
        this.axleLoadUpto = value;
    }

    /**
     * Gets the value of the axleManufacturer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAxleManufacturer() {
        return axleManufacturer;
    }

    /**
     * Sets the value of the axleManufacturer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAxleManufacturer(String value) {
        this.axleManufacturer = value;
    }

    /**
     * Gets the value of the axleModel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAxleModel() {
        return axleModel;
    }

    /**
     * Sets the value of the axleModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAxleModel(String value) {
        this.axleModel = value;
    }

    /**
     * Gets the value of the axleStyle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAxleStyle() {
        return axleStyle;
    }

    /**
     * Sets the value of the axleStyle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAxleStyle(String value) {
        this.axleStyle = value;
    }

    /**
     * Gets the value of the axleType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAxleType() {
        return axleType;
    }

    /**
     * Sets the value of the axleType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAxleType(String value) {
        this.axleType = value;
    }

    /**
     * Gets the value of the axleTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAxleTypeId() {
        return axleTypeId;
    }

    /**
     * Sets the value of the axleTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAxleTypeId(Long value) {
        this.axleTypeId = value;
    }

    /**
     * Gets the value of the brakeType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrakeType() {
        return brakeType;
    }

    /**
     * Sets the value of the brakeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrakeType(String value) {
        this.brakeType = value;
    }

    /**
     * Gets the value of the driveHeightFrom property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDriveHeightFrom() {
        return driveHeightFrom;
    }

    /**
     * Sets the value of the driveHeightFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDriveHeightFrom(Integer value) {
        this.driveHeightFrom = value;
    }

    /**
     * Gets the value of the driveHeightTo property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDriveHeightTo() {
        return driveHeightTo;
    }

    /**
     * Sets the value of the driveHeightTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDriveHeightTo(Integer value) {
        this.driveHeightTo = value;
    }

    /**
     * Gets the value of the hubSystem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHubSystem() {
        return hubSystem;
    }

    /**
     * Sets the value of the hubSystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHubSystem(String value) {
        this.hubSystem = value;
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
     * Gets the value of the manuName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManuName() {
        return manuName;
    }

    /**
     * Sets the value of the manuName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManuName(String value) {
        this.manuName = value;
    }

    /**
     * Gets the value of the manuShortName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManuShortName() {
        return manuShortName;
    }

    /**
     * Sets the value of the manuShortName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManuShortName(String value) {
        this.manuShortName = value;
    }

    /**
     * Gets the value of the modelId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getModelId() {
        return modelId;
    }

    /**
     * Sets the value of the modelId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setModelId(Long value) {
        this.modelId = value;
    }

    /**
     * Gets the value of the modelName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * Sets the value of the modelName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModelName(String value) {
        this.modelName = value;
    }

    /**
     * Gets the value of the trackGauge property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTrackGauge() {
        return trackGauge;
    }

    /**
     * Sets the value of the trackGauge property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTrackGauge(Integer value) {
        this.trackGauge = value;
    }

    /**
     * Gets the value of the wheelMount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWheelMount() {
        return wheelMount;
    }

    /**
     * Sets the value of the wheelMount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWheelMount(String value) {
        this.wheelMount = value;
    }

    /**
     * Gets the value of the yearOfConstrFrom property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getYearOfConstrFrom() {
        return yearOfConstrFrom;
    }

    /**
     * Sets the value of the yearOfConstrFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setYearOfConstrFrom(Integer value) {
        this.yearOfConstrFrom = value;
    }

    /**
     * Gets the value of the yearOfConstrTo property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getYearOfConstrTo() {
        return yearOfConstrTo;
    }

    /**
     * Sets the value of the yearOfConstrTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setYearOfConstrTo(Integer value) {
        this.yearOfConstrTo = value;
    }

}
