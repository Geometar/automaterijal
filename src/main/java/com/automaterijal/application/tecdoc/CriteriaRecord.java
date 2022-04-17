//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.04.05 at 10:10:27 PM CEST 
//


package com.automaterijal.application.tecdoc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CriteriaRecord complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CriteriaRecord"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="criteriaId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="criteriaDescription" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="criteriaAbbrDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="criteriaUnitDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="criteriaType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="successorCriteriaId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="rawValue" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="formattedValue" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="immediateDisplay" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="isMandatory" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="isInterval" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="matchesSearchQuery" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CriteriaRecord", propOrder = {
    "criteriaId",
    "criteriaDescription",
    "criteriaAbbrDescription",
    "criteriaUnitDescription",
    "criteriaType",
    "successorCriteriaId",
    "rawValue",
    "formattedValue",
    "immediateDisplay",
    "isMandatory",
    "isInterval",
    "matchesSearchQuery"
})
public class CriteriaRecord {

    protected int criteriaId;
    @XmlElement(required = true)
    protected String criteriaDescription;
    protected String criteriaAbbrDescription;
    protected String criteriaUnitDescription;
    @XmlElement(required = true)
    protected String criteriaType;
    protected Integer successorCriteriaId;
    @XmlElement(required = true)
    protected String rawValue;
    @XmlElement(required = true)
    protected String formattedValue;
    protected Boolean immediateDisplay;
    protected boolean isMandatory;
    protected boolean isInterval;
    protected Boolean matchesSearchQuery;

    /**
     * Gets the value of the criteriaId property.
     * 
     */
    public int getCriteriaId() {
        return criteriaId;
    }

    /**
     * Sets the value of the criteriaId property.
     * 
     */
    public void setCriteriaId(int value) {
        this.criteriaId = value;
    }

    /**
     * Gets the value of the criteriaDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCriteriaDescription() {
        return criteriaDescription;
    }

    /**
     * Sets the value of the criteriaDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCriteriaDescription(String value) {
        this.criteriaDescription = value;
    }

    /**
     * Gets the value of the criteriaAbbrDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCriteriaAbbrDescription() {
        return criteriaAbbrDescription;
    }

    /**
     * Sets the value of the criteriaAbbrDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCriteriaAbbrDescription(String value) {
        this.criteriaAbbrDescription = value;
    }

    /**
     * Gets the value of the criteriaUnitDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCriteriaUnitDescription() {
        return criteriaUnitDescription;
    }

    /**
     * Sets the value of the criteriaUnitDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCriteriaUnitDescription(String value) {
        this.criteriaUnitDescription = value;
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
     * Gets the value of the successorCriteriaId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSuccessorCriteriaId() {
        return successorCriteriaId;
    }

    /**
     * Sets the value of the successorCriteriaId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSuccessorCriteriaId(Integer value) {
        this.successorCriteriaId = value;
    }

    /**
     * Gets the value of the rawValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRawValue() {
        return rawValue;
    }

    /**
     * Sets the value of the rawValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRawValue(String value) {
        this.rawValue = value;
    }

    /**
     * Gets the value of the formattedValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormattedValue() {
        return formattedValue;
    }

    /**
     * Sets the value of the formattedValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormattedValue(String value) {
        this.formattedValue = value;
    }

    /**
     * Gets the value of the immediateDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isImmediateDisplay() {
        return immediateDisplay;
    }

    /**
     * Sets the value of the immediateDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setImmediateDisplay(Boolean value) {
        this.immediateDisplay = value;
    }

    /**
     * Gets the value of the isMandatory property.
     * 
     */
    public boolean isIsMandatory() {
        return isMandatory;
    }

    /**
     * Sets the value of the isMandatory property.
     * 
     */
    public void setIsMandatory(boolean value) {
        this.isMandatory = value;
    }

    /**
     * Gets the value of the isInterval property.
     * 
     */
    public boolean isIsInterval() {
        return isInterval;
    }

    /**
     * Sets the value of the isInterval property.
     * 
     */
    public void setIsInterval(boolean value) {
        this.isInterval = value;
    }

    /**
     * Gets the value of the matchesSearchQuery property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMatchesSearchQuery() {
        return matchesSearchQuery;
    }

    /**
     * Sets the value of the matchesSearchQuery property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMatchesSearchQuery(Boolean value) {
        this.matchesSearchQuery = value;
    }

}
