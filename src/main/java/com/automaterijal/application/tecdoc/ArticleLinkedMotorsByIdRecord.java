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
 * <p>Java class for articleLinkedMotorsByIdRecord complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="articleLinkedMotorsByIdRecord"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}articleLinkedMotorsByIdRecordSrc"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="assembledFrom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="assembledTo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cylinder" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="cylinderCapacity" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="manuDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="manuId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="motorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="motorId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="powerHp" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="powerKw" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "articleLinkedMotorsByIdRecord", propOrder = {
    "assembledFrom",
    "assembledTo",
    "cylinder",
    "cylinderCapacity",
    "manuDesc",
    "manuId",
    "motorCode",
    "motorId",
    "powerHp",
    "powerKw"
})
public class ArticleLinkedMotorsByIdRecord
    extends ArticleLinkedMotorsByIdRecordSrc
{

    protected String assembledFrom;
    protected String assembledTo;
    protected Integer cylinder;
    protected Integer cylinderCapacity;
    protected String manuDesc;
    protected Long manuId;
    protected String motorCode;
    protected Long motorId;
    protected Integer powerHp;
    protected Integer powerKw;

    /**
     * Gets the value of the assembledFrom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAssembledFrom() {
        return assembledFrom;
    }

    /**
     * Sets the value of the assembledFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAssembledFrom(String value) {
        this.assembledFrom = value;
    }

    /**
     * Gets the value of the assembledTo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAssembledTo() {
        return assembledTo;
    }

    /**
     * Sets the value of the assembledTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAssembledTo(String value) {
        this.assembledTo = value;
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
     * Gets the value of the cylinderCapacity property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCylinderCapacity() {
        return cylinderCapacity;
    }

    /**
     * Sets the value of the cylinderCapacity property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCylinderCapacity(Integer value) {
        this.cylinderCapacity = value;
    }

    /**
     * Gets the value of the manuDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManuDesc() {
        return manuDesc;
    }

    /**
     * Sets the value of the manuDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManuDesc(String value) {
        this.manuDesc = value;
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
     * Gets the value of the motorId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMotorId() {
        return motorId;
    }

    /**
     * Sets the value of the motorId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMotorId(Long value) {
        this.motorId = value;
    }

    /**
     * Gets the value of the powerHp property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPowerHp() {
        return powerHp;
    }

    /**
     * Sets the value of the powerHp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPowerHp(Integer value) {
        this.powerHp = value;
    }

    /**
     * Gets the value of the powerKw property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPowerKw() {
        return powerKw;
    }

    /**
     * Sets the value of the powerKw property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPowerKw(Integer value) {
        this.powerKw = value;
    }

}
