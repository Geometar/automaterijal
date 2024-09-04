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
 * <p>Java class for articleAccessoryList4Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="articleAccessoryList4Request"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}articleAccessoryList4RequestSrc"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="articleCountry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="articleId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="articleLinkId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="lang" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="linkingTargetId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="linkingTargetType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="manuId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="modId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="priceDate" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
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
@XmlType(name = "articleAccessoryList4Request", propOrder = {
    "articleCountry",
    "articleId",
    "articleLinkId",
    "lang",
    "linkingTargetId",
    "linkingTargetType",
    "manuId",
    "modId",
    "priceDate",
    "provider"
})
public class ArticleAccessoryList4Request
    extends ArticleAccessoryList4RequestSrc
{

    protected String articleCountry;
    protected long articleId;
    protected Long articleLinkId;
    protected String lang;
    protected Long linkingTargetId;
    protected String linkingTargetType;
    protected Long manuId;
    protected Long modId;
    protected Integer priceDate;
    protected int provider;

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
     * Gets the value of the articleLinkId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getArticleLinkId() {
        return articleLinkId;
    }

    /**
     * Sets the value of the articleLinkId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setArticleLinkId(Long value) {
        this.articleLinkId = value;
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
     * Gets the value of the modId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getModId() {
        return modId;
    }

    /**
     * Sets the value of the modId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setModId(Long value) {
        this.modId = value;
    }

    /**
     * Gets the value of the priceDate property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPriceDate() {
        return priceDate;
    }

    /**
     * Sets the value of the priceDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPriceDate(Integer value) {
        this.priceDate = value;
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
