//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.06.25 at 12:34:57 AM CEST 
//


package com.automaterijal.application.tecdoc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for coordinatesByArticleDocumentRecord complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="coordinatesByArticleDocumentRecord"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}coordinatesByArticleDocumentRecordSrc"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="number" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="partArticleId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="partArticleLinkId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="subNumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="x1Value" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="x2Value" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="y1Value" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="y2Value" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "coordinatesByArticleDocumentRecord", propOrder = {
    "number",
    "partArticleId",
    "partArticleLinkId",
    "subNumber",
    "type",
    "x1Value",
    "x2Value",
    "y1Value",
    "y2Value"
})
public class CoordinatesByArticleDocumentRecord
    extends CoordinatesByArticleDocumentRecordSrc
{

    protected Integer number;
    protected Long partArticleId;
    protected Long partArticleLinkId;
    protected Integer subNumber;
    protected Integer type;
    protected Long x1Value;
    protected Long x2Value;
    protected Long y1Value;
    protected Long y2Value;

    /**
     * Gets the value of the number property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumber(Integer value) {
        this.number = value;
    }

    /**
     * Gets the value of the partArticleId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPartArticleId() {
        return partArticleId;
    }

    /**
     * Sets the value of the partArticleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPartArticleId(Long value) {
        this.partArticleId = value;
    }

    /**
     * Gets the value of the partArticleLinkId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPartArticleLinkId() {
        return partArticleLinkId;
    }

    /**
     * Sets the value of the partArticleLinkId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPartArticleLinkId(Long value) {
        this.partArticleLinkId = value;
    }

    /**
     * Gets the value of the subNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSubNumber() {
        return subNumber;
    }

    /**
     * Sets the value of the subNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSubNumber(Integer value) {
        this.subNumber = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setType(Integer value) {
        this.type = value;
    }

    /**
     * Gets the value of the x1Value property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getX1Value() {
        return x1Value;
    }

    /**
     * Sets the value of the x1Value property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setX1Value(Long value) {
        this.x1Value = value;
    }

    /**
     * Gets the value of the x2Value property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getX2Value() {
        return x2Value;
    }

    /**
     * Sets the value of the x2Value property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setX2Value(Long value) {
        this.x2Value = value;
    }

    /**
     * Gets the value of the y1Value property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getY1Value() {
        return y1Value;
    }

    /**
     * Sets the value of the y1Value property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setY1Value(Long value) {
        this.y1Value = value;
    }

    /**
     * Gets the value of the y2Value property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getY2Value() {
        return y2Value;
    }

    /**
     * Sets the value of the y2Value property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setY2Value(Long value) {
        this.y2Value = value;
    }

}
