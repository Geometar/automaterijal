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
 * <p>Java class for motorByIds2Record complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="motorByIds2Record"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}motorByIds2RecordSrc"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="motorDetails" type="{http://server.cat.tecdoc.net}motorByIdRecord" minOccurs="0"/&gt;
 *         &lt;element name="motorId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "motorByIds2Record", propOrder = {
    "motorDetails",
    "motorId"
})
public class MotorByIds2Record
    extends MotorByIds2RecordSrc
{

    protected MotorByIdRecord motorDetails;
    protected long motorId;

    /**
     * Gets the value of the motorDetails property.
     * 
     * @return
     *     possible object is
     *     {@link MotorByIdRecord }
     *     
     */
    public MotorByIdRecord getMotorDetails() {
        return motorDetails;
    }

    /**
     * Sets the value of the motorDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link MotorByIdRecord }
     *     
     */
    public void setMotorDetails(MotorByIdRecord value) {
        this.motorDetails = value;
    }

    /**
     * Gets the value of the motorId property.
     * 
     */
    public long getMotorId() {
        return motorId;
    }

    /**
     * Sets the value of the motorId property.
     * 
     */
    public void setMotorId(long value) {
        this.motorId = value;
    }

}
