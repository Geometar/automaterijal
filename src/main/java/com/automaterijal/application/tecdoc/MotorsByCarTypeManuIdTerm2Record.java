//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.12.31 at 11:12:31 AM CET 
//


package com.automaterijal.application.tecdoc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for motorsByCarTypeManuIdTerm2Record complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="motorsByCarTypeManuIdTerm2Record"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}motorsByCarTypeManuIdTerm2RecordSrc"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cylinder" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="cylinderCapacity" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="manuId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="manuText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="motorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="motorId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="powerHP" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="powerKW" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="sellsTerm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "motorsByCarTypeManuIdTerm2Record", propOrder = {
    "cylinder",
    "cylinderCapacity",
    "manuId",
    "manuText",
    "motorCode",
    "motorId",
    "powerHP",
    "powerKW",
    "sellsTerm"
})
public class MotorsByCarTypeManuIdTerm2Record
    extends MotorsByCarTypeManuIdTerm2RecordSrc
{

    protected Integer cylinder;
    protected Integer cylinderCapacity;
    protected Long manuId;
    protected String manuText;
    protected String motorCode;
    protected Long motorId;
    protected Integer powerHP;
    protected Integer powerKW;
    protected String sellsTerm;

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
     * Gets the value of the manuText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManuText() {
        return manuText;
    }

    /**
     * Sets the value of the manuText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManuText(String value) {
        this.manuText = value;
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
     * Gets the value of the powerHP property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPowerHP() {
        return powerHP;
    }

    /**
     * Sets the value of the powerHP property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPowerHP(Integer value) {
        this.powerHP = value;
    }

    /**
     * Gets the value of the powerKW property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPowerKW() {
        return powerKW;
    }

    /**
     * Sets the value of the powerKW property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPowerKW(Integer value) {
        this.powerKW = value;
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

}
