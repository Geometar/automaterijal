//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.12.27 at 11:03:50 AM CET 
//


package com.automaterijal.application.tecdoc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for linkedArticlesRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="linkedArticlesRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}linkedArticlesRequestSrc"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="brandId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="lang" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="linkingTargetId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="linkingTargetType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="provider" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "linkedArticlesRequest", propOrder = {
    "brandId",
    "country",
    "lang",
    "linkingTargetId",
    "linkingTargetType",
    "provider"
})
public class LinkedArticlesRequest
    extends LinkedArticlesRequestSrc
{

    protected long brandId;
    protected String country;
    protected String lang;
    protected Long linkingTargetId;
    protected String linkingTargetType;
    protected int provider;

    /**
     * Gets the value of the brandId property.
     * 
     */
    public long getBrandId() {
        return brandId;
    }

    /**
     * Sets the value of the brandId property.
     * 
     */
    public void setBrandId(long value) {
        this.brandId = value;
    }

    /**
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountry(String value) {
        this.country = value;
    }

    /**
     * Gets the value of the lang property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLang() {
        return lang;
    }

    /**
     * Sets the value of the lang property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLang(String value) {
        this.lang = value;
    }

    /**
     * Gets the value of the linkingTargetId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLinkingTargetId() {
        return linkingTargetId;
    }

    /**
     * Sets the value of the linkingTargetId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLinkingTargetId(Long value) {
        this.linkingTargetId = value;
    }

    /**
     * Gets the value of the linkingTargetType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinkingTargetType() {
        return linkingTargetType;
    }

    /**
     * Sets the value of the linkingTargetType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinkingTargetType(String value) {
        this.linkingTargetType = value;
    }

    /**
     * Gets the value of the provider property.
     * 
     */
    public int getProvider() {
        return provider;
    }

    /**
     * Sets the value of the provider property.
     * 
     */
    public void setProvider(int value) {
        this.provider = value;
    }

}
