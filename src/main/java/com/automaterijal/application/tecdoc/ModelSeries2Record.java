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
 * <p>Java class for modelSeries2Record complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="modelSeries2Record"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}modelSeries2RecordSrc"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="favorFlag" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="modelId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="modelname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
@XmlType(name = "modelSeries2Record", propOrder = {
    "favorFlag",
    "modelId",
    "modelname",
    "yearOfConstrFrom",
    "yearOfConstrTo"
})
public class ModelSeries2Record
    extends ModelSeries2RecordSrc
{

    protected Integer favorFlag;
    protected Long modelId;
    protected String modelname;
    protected Integer yearOfConstrFrom;
    protected Integer yearOfConstrTo;

    /**
     * Gets the value of the favorFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFavorFlag() {
        return favorFlag;
    }

    /**
     * Sets the value of the favorFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFavorFlag(Integer value) {
        this.favorFlag = value;
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
     * Gets the value of the modelname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModelname() {
        return modelname;
    }

    /**
     * Sets the value of the modelname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModelname(String value) {
        this.modelname = value;
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
