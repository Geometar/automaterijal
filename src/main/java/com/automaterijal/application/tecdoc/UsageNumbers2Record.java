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
 * <p>Java class for usageNumbers2Record complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="usageNumbers2Record"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}usageNumbers2RecordSrc"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="displayImmediate" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="usageNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "usageNumbers2Record", propOrder = {
    "displayImmediate",
    "usageNumber"
})
public class UsageNumbers2Record
    extends UsageNumbers2RecordSrc
{

    protected Boolean displayImmediate;
    protected String usageNumber;

    /**
     * Gets the value of the displayImmediate property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDisplayImmediate() {
        return displayImmediate;
    }

    /**
     * Sets the value of the displayImmediate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDisplayImmediate(Boolean value) {
        this.displayImmediate = value;
    }

    /**
     * Gets the value of the usageNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsageNumber() {
        return usageNumber;
    }

    /**
     * Sets the value of the usageNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsageNumber(String value) {
        this.usageNumber = value;
    }

}
