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
 * <p>Java class for motorByIds3Record complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="motorByIds3Record"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}motorByIds3RecordSrc"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="motorDetails2" type="{http://server.cat.tecdoc.net}motorDetails2Record" minOccurs="0"/&gt;
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
@XmlType(name = "motorByIds3Record", propOrder = {
    "motorDetails2",
    "motorId"
})
public class MotorByIds3Record
    extends MotorByIds3RecordSrc
{

    protected MotorDetails2Record motorDetails2;
    protected long motorId;

    /**
     * Gets the value of the motorDetails2 property.
     * 
     * @return
     *     possible object is
     *     {@link MotorDetails2Record }
     *     
     */
    public MotorDetails2Record getMotorDetails2() {
        return motorDetails2;
    }

    /**
     * Sets the value of the motorDetails2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link MotorDetails2Record }
     *     
     */
    public void setMotorDetails2(MotorDetails2Record value) {
        this.motorDetails2 = value;
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
