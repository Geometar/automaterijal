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
 * <p>Java class for articleLinkedAllLinkingTargetManufacturerRecord complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="articleLinkedAllLinkingTargetManufacturerRecord"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}articleLinkedAllLinkingTargetManufacturerRecordSrc"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="manuId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="manuName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "articleLinkedAllLinkingTargetManufacturerRecord", propOrder = {
    "manuId",
    "manuName"
})
public class ArticleLinkedAllLinkingTargetManufacturerRecord
    extends ArticleLinkedAllLinkingTargetManufacturerRecordSrc
{

    protected Long manuId;
    protected String manuName;

    /**
     * Gets the value of the manuId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getManuId() {
        return manuId;
    }

    /**
     * Sets the value of the manuId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setManuId(Long value) {
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
