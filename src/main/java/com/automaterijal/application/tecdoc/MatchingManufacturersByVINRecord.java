//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.06.25 at 12:34:57 AM CEST 
//


package com.automaterijal.application.tecdoc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for matchingManufacturersByVINRecord complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="matchingManufacturersByVINRecord"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}matchingManufacturersByVINRecordSrc"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="manuId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="manuName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "matchingManufacturersByVINRecord", propOrder = {
    "manuId",
    "manuName"
})
public class MatchingManufacturersByVINRecord
    extends MatchingManufacturersByVINRecordSrc
{

    protected int manuId;
    @XmlElement(required = true)
    protected String manuName;

    /**
     * Gets the value of the manuId property.
     * 
     */
    public int getManuId() {
        return manuId;
    }

    /**
     * Sets the value of the manuId property.
     * 
     */
    public void setManuId(int value) {
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

}
