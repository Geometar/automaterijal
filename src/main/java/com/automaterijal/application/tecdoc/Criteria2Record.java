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
 * <p>Java class for criteria2Record complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="criteria2Record"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}criteria2RecordSrc"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="criteriaId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="criteriaName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="criteriaShortName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="criteriaType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="criteriaUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="isInterval" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="successorId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "criteria2Record", propOrder = {
    "criteriaId",
    "criteriaName",
    "criteriaShortName",
    "criteriaType",
    "criteriaUnit",
    "isInterval",
    "successorId"
})
public class Criteria2Record
    extends Criteria2RecordSrc
{

    protected Long criteriaId;
    protected String criteriaName;
    protected String criteriaShortName;
    protected String criteriaType;
    protected String criteriaUnit;
    protected Boolean isInterval;
    protected Long successorId;

    /**
     * Gets the value of the criteriaId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCriteriaId() {
        return criteriaId;
    }

    /**
     * Sets the value of the criteriaId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCriteriaId(Long value) {
        this.criteriaId = value;
    }

    /**
     * Gets the value of the criteriaName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCriteriaName() {
        return criteriaName;
    }

    /**
     * Sets the value of the criteriaName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCriteriaName(String value) {
        this.criteriaName = value;
    }

    /**
     * Gets the value of the criteriaShortName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCriteriaShortName() {
        return criteriaShortName;
    }

    /**
     * Sets the value of the criteriaShortName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCriteriaShortName(String value) {
        this.criteriaShortName = value;
    }

    /**
     * Gets the value of the criteriaType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCriteriaType() {
        return criteriaType;
    }

    /**
     * Sets the value of the criteriaType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCriteriaType(String value) {
        this.criteriaType = value;
    }

    /**
     * Gets the value of the criteriaUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCriteriaUnit() {
        return criteriaUnit;
    }

    /**
     * Sets the value of the criteriaUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCriteriaUnit(String value) {
        this.criteriaUnit = value;
    }

    /**
     * Gets the value of the isInterval property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsInterval() {
        return isInterval;
    }

    /**
     * Sets the value of the isInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsInterval(Boolean value) {
        this.isInterval = value;
    }

    /**
     * Gets the value of the successorId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSuccessorId() {
        return successorId;
    }

    /**
     * Sets the value of the successorId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSuccessorId(Long value) {
        this.successorId = value;
    }

}
