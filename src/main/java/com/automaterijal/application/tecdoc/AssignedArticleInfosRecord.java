//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.12.27 at 11:03:50 AM CET 
//


package com.automaterijal.application.tecdoc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for assignedArticleInfosRecord complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="assignedArticleInfosRecord"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}assignedArticleInfosRecordSrc"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="infoId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="infoText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="infoType" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="infoTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "assignedArticleInfosRecord", propOrder = {
    "infoId",
    "infoText",
    "infoType",
    "infoTypeName"
})
public class AssignedArticleInfosRecord
    extends AssignedArticleInfosRecordSrc
{

    protected Long infoId;
    protected String infoText;
    protected Long infoType;
    protected String infoTypeName;

    /**
     * Gets the value of the infoId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getInfoId() {
        return infoId;
    }

    /**
     * Sets the value of the infoId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setInfoId(Long value) {
        this.infoId = value;
    }

    /**
     * Gets the value of the infoText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInfoText() {
        return infoText;
    }

    /**
     * Sets the value of the infoText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInfoText(String value) {
        this.infoText = value;
    }

    /**
     * Gets the value of the infoType property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getInfoType() {
        return infoType;
    }

    /**
     * Sets the value of the infoType property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setInfoType(Long value) {
        this.infoType = value;
    }

    /**
     * Gets the value of the infoTypeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInfoTypeName() {
        return infoTypeName;
    }

    /**
     * Sets the value of the infoTypeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInfoTypeName(String value) {
        this.infoTypeName = value;
    }

}
