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
 * <p>Java class for getArticleLinkedAllLinkingTargetManufacturer2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getArticleLinkedAllLinkingTargetManufacturer2"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="arg0" type="{http://server.cat.tecdoc.net}articleLinkedAllLinkingTargetManufacturer2Request" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getArticleLinkedAllLinkingTargetManufacturer2", propOrder = {
    "arg0"
})
public class GetArticleLinkedAllLinkingTargetManufacturer2 {

    protected ArticleLinkedAllLinkingTargetManufacturer2Request arg0;

    /**
     * Gets the value of the arg0 property.
     * 
     * @return
     *     possible object is
     *     {@link ArticleLinkedAllLinkingTargetManufacturer2Request }
     *     
     */
    public ArticleLinkedAllLinkingTargetManufacturer2Request getArg0() {
        return arg0;
    }

    /**
     * Sets the value of the arg0 property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArticleLinkedAllLinkingTargetManufacturer2Request }
     *     
     */
    public void setArg0(ArticleLinkedAllLinkingTargetManufacturer2Request value) {
        this.arg0 = value;
    }

}
