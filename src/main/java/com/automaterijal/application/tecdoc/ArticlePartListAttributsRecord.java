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
 * <p>Java class for articlePartListAttributsRecord complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="articlePartListAttributsRecord"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}articlePartListAttributsRecordSrc"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="attrBlockNo" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="attrId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="attrIsConditional" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="attrIsInterval" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="attrName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="attrShortName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="attrSuccessorId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="attrType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="attrUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="attrValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="isPartlistAttr" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "articlePartListAttributsRecord", propOrder = {
    "attrBlockNo",
    "attrId",
    "attrIsConditional",
    "attrIsInterval",
    "attrName",
    "attrShortName",
    "attrSuccessorId",
    "attrType",
    "attrUnit",
    "attrValue",
    "isPartlistAttr"
})
public class ArticlePartListAttributsRecord
    extends ArticlePartListAttributsRecordSrc
{

    protected Long attrBlockNo;
    protected Long attrId;
    protected Boolean attrIsConditional;
    protected Boolean attrIsInterval;
    protected String attrName;
    protected String attrShortName;
    protected Long attrSuccessorId;
    protected String attrType;
    protected String attrUnit;
    protected String attrValue;
    protected Boolean isPartlistAttr;

    /**
     * Gets the value of the attrBlockNo property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAttrBlockNo() {
        return attrBlockNo;
    }

    /**
     * Sets the value of the attrBlockNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAttrBlockNo(Long value) {
        this.attrBlockNo = value;
    }

    /**
     * Gets the value of the attrId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAttrId() {
        return attrId;
    }

    /**
     * Sets the value of the attrId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAttrId(Long value) {
        this.attrId = value;
    }

    /**
     * Gets the value of the attrIsConditional property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAttrIsConditional() {
        return attrIsConditional;
    }

    /**
     * Sets the value of the attrIsConditional property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAttrIsConditional(Boolean value) {
        this.attrIsConditional = value;
    }

    /**
     * Gets the value of the attrIsInterval property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAttrIsInterval() {
        return attrIsInterval;
    }

    /**
     * Sets the value of the attrIsInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAttrIsInterval(Boolean value) {
        this.attrIsInterval = value;
    }

    /**
     * Gets the value of the attrName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttrName() {
        return attrName;
    }

    /**
     * Sets the value of the attrName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttrName(String value) {
        this.attrName = value;
    }

    /**
     * Gets the value of the attrShortName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttrShortName() {
        return attrShortName;
    }

    /**
     * Sets the value of the attrShortName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttrShortName(String value) {
        this.attrShortName = value;
    }

    /**
     * Gets the value of the attrSuccessorId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAttrSuccessorId() {
        return attrSuccessorId;
    }

    /**
     * Sets the value of the attrSuccessorId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAttrSuccessorId(Long value) {
        this.attrSuccessorId = value;
    }

    /**
     * Gets the value of the attrType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttrType() {
        return attrType;
    }

    /**
     * Sets the value of the attrType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttrType(String value) {
        this.attrType = value;
    }

    /**
     * Gets the value of the attrUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttrUnit() {
        return attrUnit;
    }

    /**
     * Sets the value of the attrUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttrUnit(String value) {
        this.attrUnit = value;
    }

    /**
     * Gets the value of the attrValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttrValue() {
        return attrValue;
    }

    /**
     * Sets the value of the attrValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttrValue(String value) {
        this.attrValue = value;
    }

    /**
     * Gets the value of the isPartlistAttr property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsPartlistAttr() {
        return isPartlistAttr;
    }

    /**
     * Sets the value of the isPartlistAttr property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsPartlistAttr(Boolean value) {
        this.isPartlistAttr = value;
    }

}
