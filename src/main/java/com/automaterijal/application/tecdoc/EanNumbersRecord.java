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
 * <p>Java class for eanNumbersRecord complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="eanNumbersRecord"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}eanNumbersRecordSrc"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="eanNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "eanNumbersRecord", propOrder = {
    "eanNumber"
})
public class EanNumbersRecord
    extends EanNumbersRecordSrc
{

    protected String eanNumber;

    /**
     * Gets the value of the eanNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEanNumber() {
        return eanNumber;
    }

    /**
     * Sets the value of the eanNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEanNumber(String value) {
        this.eanNumber = value;
    }

}
