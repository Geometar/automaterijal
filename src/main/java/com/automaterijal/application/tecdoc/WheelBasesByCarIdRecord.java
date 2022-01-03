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
 * <p>Java class for wheelBasesByCarIdRecord complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wheelBasesByCarIdRecord"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}wheelBasesByCarIdRecordSrc"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="axlePosition" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="wheelbase" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="wheelbaseId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wheelBasesByCarIdRecord", propOrder = {
    "axlePosition",
    "wheelbase",
    "wheelbaseId"
})
public class WheelBasesByCarIdRecord
    extends WheelBasesByCarIdRecordSrc
{

    protected String axlePosition;
    protected Integer wheelbase;
    protected Long wheelbaseId;

    /**
     * Gets the value of the axlePosition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAxlePosition() {
        return axlePosition;
    }

    /**
     * Sets the value of the axlePosition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAxlePosition(String value) {
        this.axlePosition = value;
    }

    /**
     * Gets the value of the wheelbase property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getWheelbase() {
        return wheelbase;
    }

    /**
     * Sets the value of the wheelbase property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWheelbase(Integer value) {
        this.wheelbase = value;
    }

    /**
     * Gets the value of the wheelbaseId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getWheelbaseId() {
        return wheelbaseId;
    }

    /**
     * Sets the value of the wheelbaseId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setWheelbaseId(Long value) {
        this.wheelbaseId = value;
    }

}
