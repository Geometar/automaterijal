//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.12.29 at 02:20:27 PM CET 
//


package com.automaterijal.application.tecdoc;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArticleRecord complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArticleRecord"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="dataSupplierId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="articleNumber" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="mfrId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="mfrName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="misc" type="{http://server.cat.tecdoc.net}MiscArticleDataRecord" minOccurs="0"/&gt;
 *         &lt;element name="genericArticles" type="{http://server.cat.tecdoc.net}GenericArticleRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="articleText" type="{http://server.cat.tecdoc.net}ArticleTextRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="gtins" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="tradeNumbers" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="oemNumbers" type="{http://server.cat.tecdoc.net}ArticleRefRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="replacesArticles" type="{http://server.cat.tecdoc.net}ArticleRefRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="replacedByArticles" type="{http://server.cat.tecdoc.net}ArticleRefRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="articleCriteria" type="{http://server.cat.tecdoc.net}CriteriaRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="linkages" type="{http://server.cat.tecdoc.net}ArticleLinkageRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="pdfs" type="{http://server.cat.tecdoc.net}PDFRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="images" type="{http://server.cat.tecdoc.net}ImageRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="comparableNumbers" type="{http://server.cat.tecdoc.net}ArticleRefRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="searchQueryMatches" type="{http://server.cat.tecdoc.net}SearchQueryMatch" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="links" type="{http://server.cat.tecdoc.net}LinkRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="totalLinkages" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="prices" type="{http://server.cat.tecdoc.net}PriceRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="articleLogisticsCriteria" type="{http://server.cat.tecdoc.net}CriteriaRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArticleRecord", propOrder = {
    "dataSupplierId",
    "articleNumber",
    "mfrId",
    "mfrName",
    "misc",
    "genericArticles",
    "articleText",
    "gtins",
    "tradeNumbers",
    "oemNumbers",
    "replacesArticles",
    "replacedByArticles",
    "articleCriteria",
    "linkages",
    "pdfs",
    "images",
    "comparableNumbers",
    "searchQueryMatches",
    "links",
    "totalLinkages",
    "prices",
    "articleLogisticsCriteria"
})
public class ArticleRecord {

    protected long dataSupplierId;
    @XmlElement(required = true)
    protected String articleNumber;
    protected long mfrId;
    @XmlElement(required = true)
    protected String mfrName;
    protected MiscArticleDataRecord misc;
    protected List<GenericArticleRecord> genericArticles;
    protected List<ArticleTextRecord> articleText;
    protected List<String> gtins;
    protected List<String> tradeNumbers;
    protected List<ArticleRefRecord> oemNumbers;
    protected List<ArticleRefRecord> replacesArticles;
    protected List<ArticleRefRecord> replacedByArticles;
    protected List<CriteriaRecord> articleCriteria;
    protected List<ArticleLinkageRecord> linkages;
    protected List<PDFRecord> pdfs;
    protected List<ImageRecord> images;
    protected List<ArticleRefRecord> comparableNumbers;
    protected List<SearchQueryMatch> searchQueryMatches;
    protected List<LinkRecord> links;
    protected Integer totalLinkages;
    protected List<PriceRecord> prices;
    protected List<CriteriaRecord> articleLogisticsCriteria;

    /**
     * Gets the value of the dataSupplierId property.
     * 
     */
    public long getDataSupplierId() {
        return dataSupplierId;
    }

    /**
     * Sets the value of the dataSupplierId property.
     * 
     */
    public void setDataSupplierId(long value) {
        this.dataSupplierId = value;
    }

    /**
     * Gets the value of the articleNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArticleNumber() {
        return articleNumber;
    }

    /**
     * Sets the value of the articleNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArticleNumber(String value) {
        this.articleNumber = value;
    }

    /**
     * Gets the value of the mfrId property.
     * 
     */
    public long getMfrId() {
        return mfrId;
    }

    /**
     * Sets the value of the mfrId property.
     * 
     */
    public void setMfrId(long value) {
        this.mfrId = value;
    }

    /**
     * Gets the value of the mfrName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMfrName() {
        return mfrName;
    }

    /**
     * Sets the value of the mfrName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMfrName(String value) {
        this.mfrName = value;
    }

    /**
     * Gets the value of the misc property.
     * 
     * @return
     *     possible object is
     *     {@link MiscArticleDataRecord }
     *     
     */
    public MiscArticleDataRecord getMisc() {
        return misc;
    }

    /**
     * Sets the value of the misc property.
     * 
     * @param value
     *     allowed object is
     *     {@link MiscArticleDataRecord }
     *     
     */
    public void setMisc(MiscArticleDataRecord value) {
        this.misc = value;
    }

    /**
     * Gets the value of the genericArticles property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericArticles property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGenericArticles().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GenericArticleRecord }
     * 
     * 
     */
    public List<GenericArticleRecord> getGenericArticles() {
        if (genericArticles == null) {
            genericArticles = new ArrayList<GenericArticleRecord>();
        }
        return this.genericArticles;
    }

    /**
     * Gets the value of the articleText property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the articleText property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArticleText().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ArticleTextRecord }
     * 
     * 
     */
    public List<ArticleTextRecord> getArticleText() {
        if (articleText == null) {
            articleText = new ArrayList<ArticleTextRecord>();
        }
        return this.articleText;
    }

    /**
     * Gets the value of the gtins property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the gtins property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGtins().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getGtins() {
        if (gtins == null) {
            gtins = new ArrayList<String>();
        }
        return this.gtins;
    }

    /**
     * Gets the value of the tradeNumbers property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tradeNumbers property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTradeNumbers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getTradeNumbers() {
        if (tradeNumbers == null) {
            tradeNumbers = new ArrayList<String>();
        }
        return this.tradeNumbers;
    }

    /**
     * Gets the value of the oemNumbers property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the oemNumbers property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOemNumbers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ArticleRefRecord }
     * 
     * 
     */
    public List<ArticleRefRecord> getOemNumbers() {
        if (oemNumbers == null) {
            oemNumbers = new ArrayList<ArticleRefRecord>();
        }
        return this.oemNumbers;
    }

    /**
     * Gets the value of the replacesArticles property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the replacesArticles property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReplacesArticles().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ArticleRefRecord }
     * 
     * 
     */
    public List<ArticleRefRecord> getReplacesArticles() {
        if (replacesArticles == null) {
            replacesArticles = new ArrayList<ArticleRefRecord>();
        }
        return this.replacesArticles;
    }

    /**
     * Gets the value of the replacedByArticles property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the replacedByArticles property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReplacedByArticles().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ArticleRefRecord }
     * 
     * 
     */
    public List<ArticleRefRecord> getReplacedByArticles() {
        if (replacedByArticles == null) {
            replacedByArticles = new ArrayList<ArticleRefRecord>();
        }
        return this.replacedByArticles;
    }

    /**
     * Gets the value of the articleCriteria property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the articleCriteria property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArticleCriteria().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CriteriaRecord }
     * 
     * 
     */
    public List<CriteriaRecord> getArticleCriteria() {
        if (articleCriteria == null) {
            articleCriteria = new ArrayList<CriteriaRecord>();
        }
        return this.articleCriteria;
    }

    /**
     * Gets the value of the linkages property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the linkages property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLinkages().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ArticleLinkageRecord }
     * 
     * 
     */
    public List<ArticleLinkageRecord> getLinkages() {
        if (linkages == null) {
            linkages = new ArrayList<ArticleLinkageRecord>();
        }
        return this.linkages;
    }

    /**
     * Gets the value of the pdfs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pdfs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPdfs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PDFRecord }
     * 
     * 
     */
    public List<PDFRecord> getPdfs() {
        if (pdfs == null) {
            pdfs = new ArrayList<PDFRecord>();
        }
        return this.pdfs;
    }

    /**
     * Gets the value of the images property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the images property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImages().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImageRecord }
     * 
     * 
     */
    public List<ImageRecord> getImages() {
        if (images == null) {
            images = new ArrayList<ImageRecord>();
        }
        return this.images;
    }

    /**
     * Gets the value of the comparableNumbers property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the comparableNumbers property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComparableNumbers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ArticleRefRecord }
     * 
     * 
     */
    public List<ArticleRefRecord> getComparableNumbers() {
        if (comparableNumbers == null) {
            comparableNumbers = new ArrayList<ArticleRefRecord>();
        }
        return this.comparableNumbers;
    }

    /**
     * Gets the value of the searchQueryMatches property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the searchQueryMatches property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSearchQueryMatches().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SearchQueryMatch }
     * 
     * 
     */
    public List<SearchQueryMatch> getSearchQueryMatches() {
        if (searchQueryMatches == null) {
            searchQueryMatches = new ArrayList<SearchQueryMatch>();
        }
        return this.searchQueryMatches;
    }

    /**
     * Gets the value of the links property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the links property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLinks().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LinkRecord }
     * 
     * 
     */
    public List<LinkRecord> getLinks() {
        if (links == null) {
            links = new ArrayList<LinkRecord>();
        }
        return this.links;
    }

    /**
     * Gets the value of the totalLinkages property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTotalLinkages() {
        return totalLinkages;
    }

    /**
     * Sets the value of the totalLinkages property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTotalLinkages(Integer value) {
        this.totalLinkages = value;
    }

    /**
     * Gets the value of the prices property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the prices property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPrices().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PriceRecord }
     * 
     * 
     */
    public List<PriceRecord> getPrices() {
        if (prices == null) {
            prices = new ArrayList<PriceRecord>();
        }
        return this.prices;
    }

    /**
     * Gets the value of the articleLogisticsCriteria property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the articleLogisticsCriteria property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArticleLogisticsCriteria().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CriteriaRecord }
     * 
     * 
     */
    public List<CriteriaRecord> getArticleLogisticsCriteria() {
        if (articleLogisticsCriteria == null) {
            articleLogisticsCriteria = new ArrayList<CriteriaRecord>();
        }
        return this.articleLogisticsCriteria;
    }

}
