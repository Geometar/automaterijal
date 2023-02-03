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
 * <p>Java class for vehicleByIdRecord complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="vehicleByIdRecord"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}vehicleByIdRecordSrc"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="axisConfiguration" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="brakeSystem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="carId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="ccmTech" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="constructionType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cylinder" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="cylinderCapacityCcm" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="cylinderCapacityLiter" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="fuelType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fuelTypeProcess" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="impulsionType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="manuId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="manuName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="modId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="modelName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="motorType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="powerHpFrom" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="powerHpTo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="powerKwFrom" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="powerKwTo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="tonnage" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="typeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="typeNumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="valves" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="yearOfConstrFrom" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="yearOfConstrTo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
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
@XmlType(name = "vehicleByIdRecord", propOrder = {
    "axisConfiguration",
    "brakeSystem",
    "carId",
    "ccmTech",
    "constructionType",
    "cylinder",
    "cylinderCapacityCcm",
    "cylinderCapacityLiter",
    "fuelType",
    "fuelTypeProcess",
    "impulsionType",
    "manuId",
    "manuName",
    "modId",
    "modelName",
    "motorType",
    "powerHpFrom",
    "powerHpTo",
    "powerKwFrom",
    "powerKwTo",
    "tonnage",
    "typeName",
    "typeNumber",
    "valves",
    "yearOfConstrFrom",
    "yearOfConstrTo",
    "rmiTypeId"
})
public class VehicleByIdRecord
    extends VehicleByIdRecordSrc
{

    protected String axisConfiguration;
    protected String brakeSystem;
    protected Long carId;
    protected Integer ccmTech;
    protected String constructionType;
    protected Integer cylinder;
    protected Integer cylinderCapacityCcm;
    protected Integer cylinderCapacityLiter;
    protected String fuelType;
    protected String fuelTypeProcess;
    protected String impulsionType;
    protected Long manuId;
    protected String manuName;
    protected Long modId;
    protected String modelName;
    protected String motorType;
    protected Integer powerHpFrom;
    protected Integer powerHpTo;
    protected Integer powerKwFrom;
    protected Integer powerKwTo;
    protected Integer tonnage;
    protected String typeName;
    protected Integer typeNumber;
    protected Integer valves;
    protected Integer yearOfConstrFrom;
    protected Integer yearOfConstrTo;
    protected Integer rmiTypeId;

    /**
     * Gets the value of the axisConfiguration property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAxisConfiguration() {
        return axisConfiguration;
    }

    /**
     * Sets the value of the axisConfiguration property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAxisConfiguration(String value) {
        this.axisConfiguration = value;
    }

    /**
     * Gets the value of the brakeSystem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrakeSystem() {
        return brakeSystem;
    }

    /**
     * Sets the value of the brakeSystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrakeSystem(String value) {
        this.brakeSystem = value;
    }

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
     * Gets the value of the ccmTech property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCcmTech() {
        return ccmTech;
    }

    /**
     * Sets the value of the ccmTech property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCcmTech(Integer value) {
        this.ccmTech = value;
    }

    /**
     * Gets the value of the constructionType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConstructionType() {
        return constructionType;
    }

    /**
     * Sets the value of the constructionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConstructionType(String value) {
        this.constructionType = value;
    }

    /**
     * Gets the value of the cylinder property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCylinder() {
        return cylinder;
    }

    /**
     * Sets the value of the cylinder property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCylinder(Integer value) {
        this.cylinder = value;
    }

    /**
     * Gets the value of the cylinderCapacityCcm property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCylinderCapacityCcm() {
        return cylinderCapacityCcm;
    }

    /**
     * Sets the value of the cylinderCapacityCcm property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCylinderCapacityCcm(Integer value) {
        this.cylinderCapacityCcm = value;
    }

    /**
     * Gets the value of the cylinderCapacityLiter property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCylinderCapacityLiter() {
        return cylinderCapacityLiter;
    }

    /**
     * Sets the value of the cylinderCapacityLiter property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCylinderCapacityLiter(Integer value) {
        this.cylinderCapacityLiter = value;
    }

    /**
     * Gets the value of the fuelType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFuelType() {
        return fuelType;
    }

    /**
     * Sets the value of the fuelType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFuelType(String value) {
        this.fuelType = value;
    }

    /**
     * Gets the value of the fuelTypeProcess property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFuelTypeProcess() {
        return fuelTypeProcess;
    }

    /**
     * Sets the value of the fuelTypeProcess property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFuelTypeProcess(String value) {
        this.fuelTypeProcess = value;
    }

    /**
     * Gets the value of the impulsionType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImpulsionType() {
        return impulsionType;
    }

    /**
     * Sets the value of the impulsionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImpulsionType(String value) {
        this.impulsionType = value;
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
     * Gets the value of the motorType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMotorType() {
        return motorType;
    }

    /**
     * Sets the value of the motorType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMotorType(String value) {
        this.motorType = value;
    }

    /**
     * Gets the value of the powerHpFrom property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPowerHpFrom() {
        return powerHpFrom;
    }

    /**
     * Sets the value of the powerHpFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPowerHpFrom(Integer value) {
        this.powerHpFrom = value;
    }

    /**
     * Gets the value of the powerHpTo property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPowerHpTo() {
        return powerHpTo;
    }

    /**
     * Sets the value of the powerHpTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPowerHpTo(Integer value) {
        this.powerHpTo = value;
    }

    /**
     * Gets the value of the powerKwFrom property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPowerKwFrom() {
        return powerKwFrom;
    }

    /**
     * Sets the value of the powerKwFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPowerKwFrom(Integer value) {
        this.powerKwFrom = value;
    }

    /**
     * Gets the value of the powerKwTo property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPowerKwTo() {
        return powerKwTo;
    }

    /**
     * Sets the value of the powerKwTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPowerKwTo(Integer value) {
        this.powerKwTo = value;
    }

    /**
     * Gets the value of the tonnage property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTonnage() {
        return tonnage;
    }

    /**
     * Sets the value of the tonnage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTonnage(Integer value) {
        this.tonnage = value;
    }

    /**
     * Gets the value of the typeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * Sets the value of the typeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeName(String value) {
        this.typeName = value;
    }

    /**
     * Gets the value of the typeNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTypeNumber() {
        return typeNumber;
    }

    /**
     * Sets the value of the typeNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTypeNumber(Integer value) {
        this.typeNumber = value;
    }

    /**
     * Gets the value of the valves property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getValves() {
        return valves;
    }

    /**
     * Sets the value of the valves property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setValves(Integer value) {
        this.valves = value;
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