//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.04.05 at 10:10:27 PM CEST 
//


package com.automaterijal.application.tecdoc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for axleIdByTypeManCriteria3Record complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="axleIdByTypeManCriteria3Record"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}axleIdByTypeManCriteria3RecordSrc"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="axleId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "axleIdByTypeManCriteria3Record", propOrder = {
    "axleId"
})
public class AxleIdByTypeManCriteria3Record
    extends AxleIdByTypeManCriteria3RecordSrc
{

    protected Long axleId;

    /**
     * Gets the value of the axleId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAxleId() {
        return axleId;
    }

    /**
     * Sets the value of the axleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAxleId(Long value) {
        this.axleId = value;
    }

}
