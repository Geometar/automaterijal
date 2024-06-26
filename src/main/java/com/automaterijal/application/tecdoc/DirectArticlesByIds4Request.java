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
 * <p>Java class for directArticlesByIds4Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="directArticlesByIds4Request"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}directArticlesByIds4RequestSrc"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="articleCountry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="articleId" type="{http://server.cat.tecdoc.net}integerList" minOccurs="0"/&gt;
 *         &lt;element name="attributs" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="basicData" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="documents" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="eanNumbers" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="immediateAttributs" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="immediateInfo" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="info" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="lang" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="mainArticles" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="normalAustauschPrice" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="oeNumbers" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="priceDate" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="prices" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="provider" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="replacedByNumbers" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="replacedNumbers" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="thumbnails" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="usageNumbers" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "directArticlesByIds4Request", propOrder = {
    "articleCountry",
    "articleId",
    "attributs",
    "basicData",
    "documents",
    "eanNumbers",
    "immediateAttributs",
    "immediateInfo",
    "info",
    "lang",
    "mainArticles",
    "normalAustauschPrice",
    "oeNumbers",
    "priceDate",
    "prices",
    "provider",
    "replacedByNumbers",
    "replacedNumbers",
    "thumbnails",
    "usageNumbers"
})
public class DirectArticlesByIds4Request
    extends DirectArticlesByIds4RequestSrc
{

    protected String articleCountry;
    protected IntegerList articleId;
    protected boolean attributs;
    protected boolean basicData;
    protected boolean documents;
    protected boolean eanNumbers;
    protected boolean immediateAttributs;
    protected boolean immediateInfo;
    protected boolean info;
    protected String lang;
    protected boolean mainArticles;
    protected boolean normalAustauschPrice;
    protected boolean oeNumbers;
    protected Integer priceDate;
    protected boolean prices;
    protected int provider;
    protected boolean replacedByNumbers;
    protected boolean replacedNumbers;
    protected boolean thumbnails;
    protected boolean usageNumbers;

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
     * @return
     *     possible object is
     *     {@link IntegerList }
     *     
     */
    public IntegerList getArticleId() {
        return articleId;
    }

    /**
     * Sets the value of the articleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntegerList }
     *     
     */
    public void setArticleId(IntegerList value) {
        this.articleId = value;
    }

    /**
     * Gets the value of the attributs property.
     * 
     */
    public boolean isAttributs() {
        return attributs;
    }

    /**
     * Sets the value of the attributs property.
     * 
     */
    public void setAttributs(boolean value) {
        this.attributs = value;
    }

    /**
     * Gets the value of the basicData property.
     * 
     */
    public boolean isBasicData() {
        return basicData;
    }

    /**
     * Sets the value of the basicData property.
     * 
     */
    public void setBasicData(boolean value) {
        this.basicData = value;
    }

    /**
     * Gets the value of the documents property.
     * 
     */
    public boolean isDocuments() {
        return documents;
    }

    /**
     * Sets the value of the documents property.
     * 
     */
    public void setDocuments(boolean value) {
        this.documents = value;
    }

    /**
     * Gets the value of the eanNumbers property.
     * 
     */
    public boolean isEanNumbers() {
        return eanNumbers;
    }

    /**
     * Sets the value of the eanNumbers property.
     * 
     */
    public void setEanNumbers(boolean value) {
        this.eanNumbers = value;
    }

    /**
     * Gets the value of the immediateAttributs property.
     * 
     */
    public boolean isImmediateAttributs() {
        return immediateAttributs;
    }

    /**
     * Sets the value of the immediateAttributs property.
     * 
     */
    public void setImmediateAttributs(boolean value) {
        this.immediateAttributs = value;
    }

    /**
     * Gets the value of the immediateInfo property.
     * 
     */
    public boolean isImmediateInfo() {
        return immediateInfo;
    }

    /**
     * Sets the value of the immediateInfo property.
     * 
     */
    public void setImmediateInfo(boolean value) {
        this.immediateInfo = value;
    }

    /**
     * Gets the value of the info property.
     * 
     */
    public boolean isInfo() {
        return info;
    }

    /**
     * Sets the value of the info property.
     * 
     */
    public void setInfo(boolean value) {
        this.info = value;
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
     * Gets the value of the mainArticles property.
     * 
     */
    public boolean isMainArticles() {
        return mainArticles;
    }

    /**
     * Sets the value of the mainArticles property.
     * 
     */
    public void setMainArticles(boolean value) {
        this.mainArticles = value;
    }

    /**
     * Gets the value of the normalAustauschPrice property.
     * 
     */
    public boolean isNormalAustauschPrice() {
        return normalAustauschPrice;
    }

    /**
     * Sets the value of the normalAustauschPrice property.
     * 
     */
    public void setNormalAustauschPrice(boolean value) {
        this.normalAustauschPrice = value;
    }

    /**
     * Gets the value of the oeNumbers property.
     * 
     */
    public boolean isOeNumbers() {
        return oeNumbers;
    }

    /**
     * Sets the value of the oeNumbers property.
     * 
     */
    public void setOeNumbers(boolean value) {
        this.oeNumbers = value;
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
     * Gets the value of the prices property.
     * 
     */
    public boolean isPrices() {
        return prices;
    }

    /**
     * Sets the value of the prices property.
     * 
     */
    public void setPrices(boolean value) {
        this.prices = value;
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
     * Gets the value of the replacedByNumbers property.
     * 
     */
    public boolean isReplacedByNumbers() {
        return replacedByNumbers;
    }

    /**
     * Sets the value of the replacedByNumbers property.
     * 
     */
    public void setReplacedByNumbers(boolean value) {
        this.replacedByNumbers = value;
    }

    /**
     * Gets the value of the replacedNumbers property.
     * 
     */
    public boolean isReplacedNumbers() {
        return replacedNumbers;
    }

    /**
     * Sets the value of the replacedNumbers property.
     * 
     */
    public void setReplacedNumbers(boolean value) {
        this.replacedNumbers = value;
    }

    /**
     * Gets the value of the thumbnails property.
     * 
     */
    public boolean isThumbnails() {
        return thumbnails;
    }

    /**
     * Sets the value of the thumbnails property.
     * 
     */
    public void setThumbnails(boolean value) {
        this.thumbnails = value;
    }

    /**
     * Gets the value of the usageNumbers property.
     * 
     */
    public boolean isUsageNumbers() {
        return usageNumbers;
    }

    /**
     * Sets the value of the usageNumbers property.
     * 
     */
    public void setUsageNumbers(boolean value) {
        this.usageNumbers = value;
    }

}
