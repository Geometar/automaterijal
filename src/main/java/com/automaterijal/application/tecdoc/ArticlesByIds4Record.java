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
 * <p>Java class for articlesByIds4Record complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="articlesByIds4Record"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}articlesByIds4RecordSrc"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="articleAttributes" type="{http://server.cat.tecdoc.net}assignedArticleAttributs2RecordSeq" minOccurs="0"/&gt;
 *         &lt;element name="articleDocuments" type="{http://server.cat.tecdoc.net}articleDocumentsRecordSeq" minOccurs="0"/&gt;
 *         &lt;element name="articleInfo" type="{http://server.cat.tecdoc.net}assignedArticleInfosRecordSeq" minOccurs="0"/&gt;
 *         &lt;element name="articlePrices" type="{http://server.cat.tecdoc.net}articlePricesRecordSeq" minOccurs="0"/&gt;
 *         &lt;element name="articleThumbnails" type="{http://server.cat.tecdoc.net}thumbnailByArticleIdRecordSeq" minOccurs="0"/&gt;
 *         &lt;element name="assignedArticle" type="{http://server.cat.tecdoc.net}assignedArticleById3Record" minOccurs="0"/&gt;
 *         &lt;element name="directArticle" type="{http://server.cat.tecdoc.net}articleDirectSearchById3Record" minOccurs="0"/&gt;
 *         &lt;element name="eanNumber" type="{http://server.cat.tecdoc.net}eanNumbersRecordSeq" minOccurs="0"/&gt;
 *         &lt;element name="immediateAttributs" type="{http://server.cat.tecdoc.net}immediateAttributs2RecordSeq" minOccurs="0"/&gt;
 *         &lt;element name="immediateInfo" type="{http://server.cat.tecdoc.net}immediateInfosRecordSeq" minOccurs="0"/&gt;
 *         &lt;element name="mainArticle" type="{http://server.cat.tecdoc.net}mainArticlesRecordSeq" minOccurs="0"/&gt;
 *         &lt;element name="normalAustauschPrice" type="{http://server.cat.tecdoc.net}articlePricesNormalAustauschRecordSeq" minOccurs="0"/&gt;
 *         &lt;element name="oenNumbers" type="{http://server.cat.tecdoc.net}articleOENumbersRecordSeq" minOccurs="0"/&gt;
 *         &lt;element name="replacedByNumber" type="{http://server.cat.tecdoc.net}replacedByNumbersRecordSeq" minOccurs="0"/&gt;
 *         &lt;element name="replacedNumber" type="{http://server.cat.tecdoc.net}replacedNumbersRecordSeq" minOccurs="0"/&gt;
 *         &lt;element name="usageNumbers" type="{http://server.cat.tecdoc.net}usageNumbersRecordSeq" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "articlesByIds4Record", propOrder = {
    "articleAttributes",
    "articleDocuments",
    "articleInfo",
    "articlePrices",
    "articleThumbnails",
    "assignedArticle",
    "directArticle",
    "eanNumber",
    "immediateAttributs",
    "immediateInfo",
    "mainArticle",
    "normalAustauschPrice",
    "oenNumbers",
    "replacedByNumber",
    "replacedNumber",
    "usageNumbers"
})
public class ArticlesByIds4Record
    extends ArticlesByIds4RecordSrc
{

    protected AssignedArticleAttributs2RecordSeq articleAttributes;
    protected ArticleDocumentsRecordSeq articleDocuments;
    protected AssignedArticleInfosRecordSeq articleInfo;
    protected ArticlePricesRecordSeq articlePrices;
    protected ThumbnailByArticleIdRecordSeq articleThumbnails;
    protected AssignedArticleById3Record assignedArticle;
    protected ArticleDirectSearchById3Record directArticle;
    protected EanNumbersRecordSeq eanNumber;
    protected ImmediateAttributs2RecordSeq immediateAttributs;
    protected ImmediateInfosRecordSeq immediateInfo;
    protected MainArticlesRecordSeq mainArticle;
    protected ArticlePricesNormalAustauschRecordSeq normalAustauschPrice;
    protected ArticleOENumbersRecordSeq oenNumbers;
    protected ReplacedByNumbersRecordSeq replacedByNumber;
    protected ReplacedNumbersRecordSeq replacedNumber;
    protected UsageNumbersRecordSeq usageNumbers;

    /**
     * Gets the value of the articleAttributes property.
     * 
     * @return
     *     possible object is
     *     {@link AssignedArticleAttributs2RecordSeq }
     *     
     */
    public AssignedArticleAttributs2RecordSeq getArticleAttributes() {
        return articleAttributes;
    }

    /**
     * Sets the value of the articleAttributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssignedArticleAttributs2RecordSeq }
     *     
     */
    public void setArticleAttributes(AssignedArticleAttributs2RecordSeq value) {
        this.articleAttributes = value;
    }

    /**
     * Gets the value of the articleDocuments property.
     * 
     * @return
     *     possible object is
     *     {@link ArticleDocumentsRecordSeq }
     *     
     */
    public ArticleDocumentsRecordSeq getArticleDocuments() {
        return articleDocuments;
    }

    /**
     * Sets the value of the articleDocuments property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArticleDocumentsRecordSeq }
     *     
     */
    public void setArticleDocuments(ArticleDocumentsRecordSeq value) {
        this.articleDocuments = value;
    }

    /**
     * Gets the value of the articleInfo property.
     * 
     * @return
     *     possible object is
     *     {@link AssignedArticleInfosRecordSeq }
     *     
     */
    public AssignedArticleInfosRecordSeq getArticleInfo() {
        return articleInfo;
    }

    /**
     * Sets the value of the articleInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssignedArticleInfosRecordSeq }
     *     
     */
    public void setArticleInfo(AssignedArticleInfosRecordSeq value) {
        this.articleInfo = value;
    }

    /**
     * Gets the value of the articlePrices property.
     * 
     * @return
     *     possible object is
     *     {@link ArticlePricesRecordSeq }
     *     
     */
    public ArticlePricesRecordSeq getArticlePrices() {
        return articlePrices;
    }

    /**
     * Sets the value of the articlePrices property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArticlePricesRecordSeq }
     *     
     */
    public void setArticlePrices(ArticlePricesRecordSeq value) {
        this.articlePrices = value;
    }

    /**
     * Gets the value of the articleThumbnails property.
     * 
     * @return
     *     possible object is
     *     {@link ThumbnailByArticleIdRecordSeq }
     *     
     */
    public ThumbnailByArticleIdRecordSeq getArticleThumbnails() {
        return articleThumbnails;
    }

    /**
     * Sets the value of the articleThumbnails property.
     * 
     * @param value
     *     allowed object is
     *     {@link ThumbnailByArticleIdRecordSeq }
     *     
     */
    public void setArticleThumbnails(ThumbnailByArticleIdRecordSeq value) {
        this.articleThumbnails = value;
    }

    /**
     * Gets the value of the assignedArticle property.
     * 
     * @return
     *     possible object is
     *     {@link AssignedArticleById3Record }
     *     
     */
    public AssignedArticleById3Record getAssignedArticle() {
        return assignedArticle;
    }

    /**
     * Sets the value of the assignedArticle property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssignedArticleById3Record }
     *     
     */
    public void setAssignedArticle(AssignedArticleById3Record value) {
        this.assignedArticle = value;
    }

    /**
     * Gets the value of the directArticle property.
     * 
     * @return
     *     possible object is
     *     {@link ArticleDirectSearchById3Record }
     *     
     */
    public ArticleDirectSearchById3Record getDirectArticle() {
        return directArticle;
    }

    /**
     * Sets the value of the directArticle property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArticleDirectSearchById3Record }
     *     
     */
    public void setDirectArticle(ArticleDirectSearchById3Record value) {
        this.directArticle = value;
    }

    /**
     * Gets the value of the eanNumber property.
     * 
     * @return
     *     possible object is
     *     {@link EanNumbersRecordSeq }
     *     
     */
    public EanNumbersRecordSeq getEanNumber() {
        return eanNumber;
    }

    /**
     * Sets the value of the eanNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link EanNumbersRecordSeq }
     *     
     */
    public void setEanNumber(EanNumbersRecordSeq value) {
        this.eanNumber = value;
    }

    /**
     * Gets the value of the immediateAttributs property.
     * 
     * @return
     *     possible object is
     *     {@link ImmediateAttributs2RecordSeq }
     *     
     */
    public ImmediateAttributs2RecordSeq getImmediateAttributs() {
        return immediateAttributs;
    }

    /**
     * Sets the value of the immediateAttributs property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImmediateAttributs2RecordSeq }
     *     
     */
    public void setImmediateAttributs(ImmediateAttributs2RecordSeq value) {
        this.immediateAttributs = value;
    }

    /**
     * Gets the value of the immediateInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ImmediateInfosRecordSeq }
     *     
     */
    public ImmediateInfosRecordSeq getImmediateInfo() {
        return immediateInfo;
    }

    /**
     * Sets the value of the immediateInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImmediateInfosRecordSeq }
     *     
     */
    public void setImmediateInfo(ImmediateInfosRecordSeq value) {
        this.immediateInfo = value;
    }

    /**
     * Gets the value of the mainArticle property.
     * 
     * @return
     *     possible object is
     *     {@link MainArticlesRecordSeq }
     *     
     */
    public MainArticlesRecordSeq getMainArticle() {
        return mainArticle;
    }

    /**
     * Sets the value of the mainArticle property.
     * 
     * @param value
     *     allowed object is
     *     {@link MainArticlesRecordSeq }
     *     
     */
    public void setMainArticle(MainArticlesRecordSeq value) {
        this.mainArticle = value;
    }

    /**
     * Gets the value of the normalAustauschPrice property.
     * 
     * @return
     *     possible object is
     *     {@link ArticlePricesNormalAustauschRecordSeq }
     *     
     */
    public ArticlePricesNormalAustauschRecordSeq getNormalAustauschPrice() {
        return normalAustauschPrice;
    }

    /**
     * Sets the value of the normalAustauschPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArticlePricesNormalAustauschRecordSeq }
     *     
     */
    public void setNormalAustauschPrice(ArticlePricesNormalAustauschRecordSeq value) {
        this.normalAustauschPrice = value;
    }

    /**
     * Gets the value of the oenNumbers property.
     * 
     * @return
     *     possible object is
     *     {@link ArticleOENumbersRecordSeq }
     *     
     */
    public ArticleOENumbersRecordSeq getOenNumbers() {
        return oenNumbers;
    }

    /**
     * Sets the value of the oenNumbers property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArticleOENumbersRecordSeq }
     *     
     */
    public void setOenNumbers(ArticleOENumbersRecordSeq value) {
        this.oenNumbers = value;
    }

    /**
     * Gets the value of the replacedByNumber property.
     * 
     * @return
     *     possible object is
     *     {@link ReplacedByNumbersRecordSeq }
     *     
     */
    public ReplacedByNumbersRecordSeq getReplacedByNumber() {
        return replacedByNumber;
    }

    /**
     * Sets the value of the replacedByNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReplacedByNumbersRecordSeq }
     *     
     */
    public void setReplacedByNumber(ReplacedByNumbersRecordSeq value) {
        this.replacedByNumber = value;
    }

    /**
     * Gets the value of the replacedNumber property.
     * 
     * @return
     *     possible object is
     *     {@link ReplacedNumbersRecordSeq }
     *     
     */
    public ReplacedNumbersRecordSeq getReplacedNumber() {
        return replacedNumber;
    }

    /**
     * Sets the value of the replacedNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReplacedNumbersRecordSeq }
     *     
     */
    public void setReplacedNumber(ReplacedNumbersRecordSeq value) {
        this.replacedNumber = value;
    }

    /**
     * Gets the value of the usageNumbers property.
     * 
     * @return
     *     possible object is
     *     {@link UsageNumbersRecordSeq }
     *     
     */
    public UsageNumbersRecordSeq getUsageNumbers() {
        return usageNumbers;
    }

    /**
     * Sets the value of the usageNumbers property.
     * 
     * @param value
     *     allowed object is
     *     {@link UsageNumbersRecordSeq }
     *     
     */
    public void setUsageNumbers(UsageNumbersRecordSeq value) {
        this.usageNumbers = value;
    }

}
