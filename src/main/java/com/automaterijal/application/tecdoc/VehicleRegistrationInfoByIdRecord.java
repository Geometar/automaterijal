//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.12.29 at 02:20:27 PM CET 
//


package com.automaterijal.application.tecdoc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for vehicleRegistrationInfoByIdRecord complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="vehicleRegistrationInfoByIdRecord"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}vehicleRegistrationInfoByIdRecordSrc"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="numberplateCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "vehicleRegistrationInfoByIdRecord", propOrder = {
    "numberplateCount"
})
public class VehicleRegistrationInfoByIdRecord
    extends VehicleRegistrationInfoByIdRecordSrc
{

    protected Integer numberplateCount;

    /**
     * Gets the value of the numberplateCount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumberplateCount() {
        return numberplateCount;
    }

    /**
     * Sets the value of the numberplateCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumberplateCount(Integer value) {
        this.numberplateCount = value;
    }

}
