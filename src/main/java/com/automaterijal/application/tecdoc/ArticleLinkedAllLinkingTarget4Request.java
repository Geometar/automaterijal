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
 * <p>Java class for articleLinkedAllLinkingTarget4Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="articleLinkedAllLinkingTarget4Request"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}articleLinkedAllLinkingTarget4RequestSrc"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="articleCountry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="articleId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="countryGroupFlag" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="lang" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="linkingTargetId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="linkingTargetManuId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="linkingTargetType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="provider" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="withMainArticles" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "articleLinkedAllLinkingTarget4Request", propOrder = {
    "articleCountry",
    "articleId",
    "country",
    "countryGroupFlag",
    "lang",
    "linkingTargetId",
    "linkingTargetManuId",
    "linkingTargetType",
    "provider",
    "withMainArticles"
})
public class ArticleLinkedAllLinkingTarget4Request
    extends ArticleLinkedAllLinkingTarget4RequestSrc
{

    protected String articleCountry;
    protected long articleId;
    protected String country;
    protected boolean countryGroupFlag;
    protected String lang;
    protected Long linkingTargetId;
    protected long linkingTargetManuId;
    protected String linkingTargetType;
    protected int provider;
    protected boolean withMainArticles;

    /**
     * Gets the value of the articleCountry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArticleCountry() {
        return articleCountry;
    }

    /**
     * Sets the value of the articleCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArticleCountry(String value) {
        this.articleCountry = value;
    }

    /**
     * Gets the value of the articleId property.
     * 
     */
    public long getArticleId() {
        return articleId;
    }

    /**
     * Sets the value of the articleId property.
     * 
     */
    public void setArticleId(long value) {
        this.articleId = value;
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
     * Gets the value of the countryGroupFlag property.
     * 
     */
    public boolean isCountryGroupFlag() {
        return countryGroupFlag;
    }

    /**
     * Sets the value of the countryGroupFlag property.
     * 
     */
    public void setCountryGroupFlag(boolean value) {
        this.countryGroupFlag = value;
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
     * Gets the value of the linkingTargetManuId property.
     * 
     */
    public long getLinkingTargetManuId() {
        return linkingTargetManuId;
    }

    /**
     * Sets the value of the linkingTargetManuId property.
     * 
     */
    public void setLinkingTargetManuId(long value) {
        this.linkingTargetManuId = value;
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

    /**
     * Gets the value of the withMainArticles property.
     * 
     */
    public boolean isWithMainArticles() {
        return withMainArticles;
    }

    /**
     * Sets the value of the withMainArticles property.
     * 
     */
    public void setWithMainArticles(boolean value) {
        this.withMainArticles = value;
    }

}
