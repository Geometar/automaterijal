//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.06.25 at 12:34:57 AM CEST 
//


package com.automaterijal.application.tecdoc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getArticleLinkedAllLinkingTargetsByIds3 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getArticleLinkedAllLinkingTargetsByIds3"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="arg0" type="{http://server.cat.tecdoc.net}articleLinkedAllLinkingTargetsByIds3Request" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getArticleLinkedAllLinkingTargetsByIds3", propOrder = {
    "arg0"
})
public class GetArticleLinkedAllLinkingTargetsByIds3 {

    protected ArticleLinkedAllLinkingTargetsByIds3Request arg0;

    /**
     * Gets the value of the arg0 property.
     * 
     * @return
     *     possible object is
     *     {@link ArticleLinkedAllLinkingTargetsByIds3Request }
     *     
     */
    public ArticleLinkedAllLinkingTargetsByIds3Request getArg0() {
        return arg0;
    }

    /**
     * Sets the value of the arg0 property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArticleLinkedAllLinkingTargetsByIds3Request }
     *     
     */
    public void setArg0(ArticleLinkedAllLinkingTargetsByIds3Request value) {
        this.arg0 = value;
    }

}
