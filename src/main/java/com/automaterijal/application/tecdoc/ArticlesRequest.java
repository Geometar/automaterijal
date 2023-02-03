//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.04.05 at 10:10:27 PM CEST 
//


package com.automaterijal.application.tecdoc;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for articlesRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="articlesRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}articlesRequestSrc"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="articleCountry" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="provider" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="searchQuery" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="searchType" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="searchMatchType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="legacyArticleIds" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="dataSupplierIds" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="genericArticleIds" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="assemblyGroupNodeIds" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="criteriaFilters" type="{http://server.cat.tecdoc.net}CriteriaFilter" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="linkageTargetId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="linkageTargetType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="newArticlesDateFrom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="newArticlesDateTo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="newLinkagesDateFrom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="newLinkagesDateTo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="newLinkagesMfrId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="lang" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="perPage" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="page" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="linkagesPerPage" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="linkagesPage" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="sort" type="{http://server.cat.tecdoc.net}Sort" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="includeAll" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="includeMisc" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="includeGenericArticles" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="includeArticleText" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="includeGTINs" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="includeTradeNumbers" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="includeOEMNumbers" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="includeReplacesArticles" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="includeReplacedByArticles" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="includeArticleCriteria" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="includeLinkages" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="includePDFs" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="includeImages" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="includeDataSupplierFacets" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="includeGenericArticleFacets" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="assemblyGroupFacetOptions" type="{http://server.cat.tecdoc.net}AssemblyGroupFacetOptions" minOccurs="0"/&gt;
 *         &lt;element name="includeCriteriaFacets" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="includeArticleStatusFacets" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="includeComparableNumbers" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="includeLinks" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="includePrices" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="priceDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="includeArticleLogisticsCriteria" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="articleStatusIds" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="articleStatusDateFrom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="articleStatusDateTo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "articlesRequest", propOrder = {
    "articleCountry",
    "provider",
    "searchQuery",
    "searchType",
    "searchMatchType",
    "legacyArticleIds",
    "dataSupplierIds",
    "genericArticleIds",
    "assemblyGroupNodeIds",
    "criteriaFilters",
    "linkageTargetId",
    "linkageTargetType",
    "newArticlesDateFrom",
    "newArticlesDateTo",
    "newLinkagesDateFrom",
    "newLinkagesDateTo",
    "newLinkagesMfrId",
    "lang",
    "perPage",
    "page",
    "linkagesPerPage",
    "linkagesPage",
    "sort",
    "includeAll",
    "includeMisc",
    "includeGenericArticles",
    "includeArticleText",
    "includeGTINs",
    "includeTradeNumbers",
    "includeOEMNumbers",
    "includeReplacesArticles",
    "includeReplacedByArticles",
    "includeArticleCriteria",
    "includeLinkages",
    "includePDFs",
    "includeImages",
    "includeDataSupplierFacets",
    "includeGenericArticleFacets",
    "assemblyGroupFacetOptions",
    "includeCriteriaFacets",
    "includeArticleStatusFacets",
    "includeComparableNumbers",
    "includeLinks",
    "includePrices",
    "priceDate",
    "includeArticleLogisticsCriteria",
    "articleStatusIds",
    "articleStatusDateFrom",
    "articleStatusDateTo"
})
public class ArticlesRequest
    extends ArticlesRequestSrc
{

    @XmlElement(required = true)
    protected String articleCountry;
    protected int provider;
    protected String searchQuery;
    protected Integer searchType;
    protected String searchMatchType;
    @XmlElement(type = Long.class)
    protected List<Long> legacyArticleIds;
    @XmlElement(type = Integer.class)
    protected List<Integer> dataSupplierIds;
    @XmlElement(type = Integer.class)
    protected List<Integer> genericArticleIds;
    @XmlElement(type = Long.class)
    protected List<Long> assemblyGroupNodeIds;
    protected List<CriteriaFilter> criteriaFilters;
    protected Long linkageTargetId;
    protected String linkageTargetType;
    protected String newArticlesDateFrom;
    protected String newArticlesDateTo;
    protected String newLinkagesDateFrom;
    protected String newLinkagesDateTo;
    protected Integer newLinkagesMfrId;
    protected String lang;
    protected Integer perPage;
    protected Integer page;
    protected Integer linkagesPerPage;
    protected Integer linkagesPage;
    protected List<Sort> sort;
    protected Boolean includeAll;
    protected Boolean includeMisc;
    protected Boolean includeGenericArticles;
    protected Boolean includeArticleText;
    protected Boolean includeGTINs;
    protected Boolean includeTradeNumbers;
    protected Boolean includeOEMNumbers;
    protected Boolean includeReplacesArticles;
    protected Boolean includeReplacedByArticles;
    protected Boolean includeArticleCriteria;
    protected Boolean includeLinkages;
    protected Boolean includePDFs;
    protected Boolean includeImages;
    protected Boolean includeDataSupplierFacets;
    protected Boolean includeGenericArticleFacets;
    protected AssemblyGroupFacetOptions assemblyGroupFacetOptions;
    protected Boolean includeCriteriaFacets;
    protected Boolean includeArticleStatusFacets;
    protected Boolean includeComparableNumbers;
    protected Boolean includeLinks;
    protected Boolean includePrices;
    protected String priceDate;
    protected Boolean includeArticleLogisticsCriteria;
    @XmlElement(type = Integer.class)
    protected List<Integer> articleStatusIds;
    protected String articleStatusDateFrom;
    protected String articleStatusDateTo;

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
     * Gets the value of the searchQuery property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSearchQuery() {
        return searchQuery;
    }

    /**
     * Sets the value of the searchQuery property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSearchQuery(String value) {
        this.searchQuery = value;
    }

    /**
     * Gets the value of the searchType property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSearchType() {
        return searchType;
    }

    /**
     * Sets the value of the searchType property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSearchType(Integer value) {
        this.searchType = value;
    }

    /**
     * Gets the value of the searchMatchType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSearchMatchType() {
        return searchMatchType;
    }

    /**
     * Sets the value of the searchMatchType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSearchMatchType(String value) {
        this.searchMatchType = value;
    }

    /**
     * Gets the value of the legacyArticleIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the legacyArticleIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLegacyArticleIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getLegacyArticleIds() {
        if (legacyArticleIds == null) {
            legacyArticleIds = new ArrayList<Long>();
        }
        return this.legacyArticleIds;
    }

    /**
     * Gets the value of the dataSupplierIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dataSupplierIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDataSupplierIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getDataSupplierIds() {
        if (dataSupplierIds == null) {
            dataSupplierIds = new ArrayList<Integer>();
        }
        return this.dataSupplierIds;
    }

    /**
     * Gets the value of the genericArticleIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericArticleIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGenericArticleIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getGenericArticleIds() {
        if (genericArticleIds == null) {
            genericArticleIds = new ArrayList<Integer>();
        }
        return this.genericArticleIds;
    }

    /**
     * Gets the value of the assemblyGroupNodeIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the assemblyGroupNodeIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAssemblyGroupNodeIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getAssemblyGroupNodeIds() {
        if (assemblyGroupNodeIds == null) {
            assemblyGroupNodeIds = new ArrayList<Long>();
        }
        return this.assemblyGroupNodeIds;
    }

    /**
     * Gets the value of the criteriaFilters property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the criteriaFilters property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCriteriaFilters().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CriteriaFilter }
     * 
     * 
     */
    public List<CriteriaFilter> getCriteriaFilters() {
        if (criteriaFilters == null) {
            criteriaFilters = new ArrayList<CriteriaFilter>();
        }
        return this.criteriaFilters;
    }

    /**
     * Gets the value of the linkageTargetId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLinkageTargetId() {
        return linkageTargetId;
    }

    /**
     * Sets the value of the linkageTargetId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLinkageTargetId(Long value) {
        this.linkageTargetId = value;
    }

    /**
     * Gets the value of the linkageTargetType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinkageTargetType() {
        return linkageTargetType;
    }

    /**
     * Sets the value of the linkageTargetType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinkageTargetType(String value) {
        this.linkageTargetType = value;
    }

    /**
     * Gets the value of the newArticlesDateFrom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewArticlesDateFrom() {
        return newArticlesDateFrom;
    }

    /**
     * Sets the value of the newArticlesDateFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewArticlesDateFrom(String value) {
        this.newArticlesDateFrom = value;
    }

    /**
     * Gets the value of the newArticlesDateTo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewArticlesDateTo() {
        return newArticlesDateTo;
    }

    /**
     * Sets the value of the newArticlesDateTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewArticlesDateTo(String value) {
        this.newArticlesDateTo = value;
    }

    /**
     * Gets the value of the newLinkagesDateFrom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewLinkagesDateFrom() {
        return newLinkagesDateFrom;
    }

    /**
     * Sets the value of the newLinkagesDateFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewLinkagesDateFrom(String value) {
        this.newLinkagesDateFrom = value;
    }

    /**
     * Gets the value of the newLinkagesDateTo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewLinkagesDateTo() {
        return newLinkagesDateTo;
    }

    /**
     * Sets the value of the newLinkagesDateTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewLinkagesDateTo(String value) {
        this.newLinkagesDateTo = value;
    }

    /**
     * Gets the value of the newLinkagesMfrId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNewLinkagesMfrId() {
        return newLinkagesMfrId;
    }

    /**
     * Sets the value of the newLinkagesMfrId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNewLinkagesMfrId(Integer value) {
        this.newLinkagesMfrId = value;
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
     * Gets the value of the perPage property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPerPage() {
        return perPage;
    }

    /**
     * Sets the value of the perPage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPerPage(Integer value) {
        this.perPage = value;
    }

    /**
     * Gets the value of the page property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPage() {
        return page;
    }

    /**
     * Sets the value of the page property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPage(Integer value) {
        this.page = value;
    }

    /**
     * Gets the value of the linkagesPerPage property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLinkagesPerPage() {
        return linkagesPerPage;
    }

    /**
     * Sets the value of the linkagesPerPage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLinkagesPerPage(Integer value) {
        this.linkagesPerPage = value;
    }

    /**
     * Gets the value of the linkagesPage property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLinkagesPage() {
        return linkagesPage;
    }

    /**
     * Sets the value of the linkagesPage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLinkagesPage(Integer value) {
        this.linkagesPage = value;
    }

    /**
     * Gets the value of the sort property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sort property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSort().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Sort }
     * 
     * 
     */
    public List<Sort> getSort() {
        if (sort == null) {
            sort = new ArrayList<Sort>();
        }
        return this.sort;
    }

    /**
     * Gets the value of the includeAll property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeAll() {
        return includeAll;
    }

    /**
     * Sets the value of the includeAll property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeAll(Boolean value) {
        this.includeAll = value;
    }

    /**
     * Gets the value of the includeMisc property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeMisc() {
        return includeMisc;
    }

    /**
     * Sets the value of the includeMisc property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeMisc(Boolean value) {
        this.includeMisc = value;
    }

    /**
     * Gets the value of the includeGenericArticles property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeGenericArticles() {
        return includeGenericArticles;
    }

    /**
     * Sets the value of the includeGenericArticles property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeGenericArticles(Boolean value) {
        this.includeGenericArticles = value;
    }

    /**
     * Gets the value of the includeArticleText property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeArticleText() {
        return includeArticleText;
    }

    /**
     * Sets the value of the includeArticleText property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeArticleText(Boolean value) {
        this.includeArticleText = value;
    }

    /**
     * Gets the value of the includeGTINs property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeGTINs() {
        return includeGTINs;
    }

    /**
     * Sets the value of the includeGTINs property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeGTINs(Boolean value) {
        this.includeGTINs = value;
    }

    /**
     * Gets the value of the includeTradeNumbers property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeTradeNumbers() {
        return includeTradeNumbers;
    }

    /**
     * Sets the value of the includeTradeNumbers property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeTradeNumbers(Boolean value) {
        this.includeTradeNumbers = value;
    }

    /**
     * Gets the value of the includeOEMNumbers property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeOEMNumbers() {
        return includeOEMNumbers;
    }

    /**
     * Sets the value of the includeOEMNumbers property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeOEMNumbers(Boolean value) {
        this.includeOEMNumbers = value;
    }

    /**
     * Gets the value of the includeReplacesArticles property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeReplacesArticles() {
        return includeReplacesArticles;
    }

    /**
     * Sets the value of the includeReplacesArticles property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeReplacesArticles(Boolean value) {
        this.includeReplacesArticles = value;
    }

    /**
     * Gets the value of the includeReplacedByArticles property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeReplacedByArticles() {
        return includeReplacedByArticles;
    }

    /**
     * Sets the value of the includeReplacedByArticles property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeReplacedByArticles(Boolean value) {
        this.includeReplacedByArticles = value;
    }

    /**
     * Gets the value of the includeArticleCriteria property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeArticleCriteria() {
        return includeArticleCriteria;
    }

    /**
     * Sets the value of the includeArticleCriteria property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeArticleCriteria(Boolean value) {
        this.includeArticleCriteria = value;
    }

    /**
     * Gets the value of the includeLinkages property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeLinkages() {
        return includeLinkages;
    }

    /**
     * Sets the value of the includeLinkages property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeLinkages(Boolean value) {
        this.includeLinkages = value;
    }

    /**
     * Gets the value of the includePDFs property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludePDFs() {
        return includePDFs;
    }

    /**
     * Sets the value of the includePDFs property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludePDFs(Boolean value) {
        this.includePDFs = value;
    }

    /**
     * Gets the value of the includeImages property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeImages() {
        return includeImages;
    }

    /**
     * Sets the value of the includeImages property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeImages(Boolean value) {
        this.includeImages = value;
    }

    /**
     * Gets the value of the includeDataSupplierFacets property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeDataSupplierFacets() {
        return includeDataSupplierFacets;
    }

    /**
     * Sets the value of the includeDataSupplierFacets property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeDataSupplierFacets(Boolean value) {
        this.includeDataSupplierFacets = value;
    }

    /**
     * Gets the value of the includeGenericArticleFacets property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeGenericArticleFacets() {
        return includeGenericArticleFacets;
    }

    /**
     * Sets the value of the includeGenericArticleFacets property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeGenericArticleFacets(Boolean value) {
        this.includeGenericArticleFacets = value;
    }

    /**
     * Gets the value of the assemblyGroupFacetOptions property.
     * 
     * @return
     *     possible object is
     *     {@link AssemblyGroupFacetOptions }
     *     
     */
    public AssemblyGroupFacetOptions getAssemblyGroupFacetOptions() {
        return assemblyGroupFacetOptions;
    }

    /**
     * Sets the value of the assemblyGroupFacetOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssemblyGroupFacetOptions }
     *     
     */
    public void setAssemblyGroupFacetOptions(AssemblyGroupFacetOptions value) {
        this.assemblyGroupFacetOptions = value;
    }

    /**
     * Gets the value of the includeCriteriaFacets property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeCriteriaFacets() {
        return includeCriteriaFacets;
    }

    /**
     * Sets the value of the includeCriteriaFacets property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeCriteriaFacets(Boolean value) {
        this.includeCriteriaFacets = value;
    }

    /**
     * Gets the value of the includeArticleStatusFacets property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeArticleStatusFacets() {
        return includeArticleStatusFacets;
    }

    /**
     * Sets the value of the includeArticleStatusFacets property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeArticleStatusFacets(Boolean value) {
        this.includeArticleStatusFacets = value;
    }

    /**
     * Gets the value of the includeComparableNumbers property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeComparableNumbers() {
        return includeComparableNumbers;
    }

    /**
     * Sets the value of the includeComparableNumbers property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeComparableNumbers(Boolean value) {
        this.includeComparableNumbers = value;
    }

    /**
     * Gets the value of the includeLinks property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeLinks() {
        return includeLinks;
    }

    /**
     * Sets the value of the includeLinks property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeLinks(Boolean value) {
        this.includeLinks = value;
    }

    /**
     * Gets the value of the includePrices property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludePrices() {
        return includePrices;
    }

    /**
     * Sets the value of the includePrices property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludePrices(Boolean value) {
        this.includePrices = value;
    }

    /**
     * Gets the value of the priceDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPriceDate() {
        return priceDate;
    }

    /**
     * Sets the value of the priceDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPriceDate(String value) {
        this.priceDate = value;
    }

    /**
     * Gets the value of the includeArticleLogisticsCriteria property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeArticleLogisticsCriteria() {
        return includeArticleLogisticsCriteria;
    }

    /**
     * Sets the value of the includeArticleLogisticsCriteria property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeArticleLogisticsCriteria(Boolean value) {
        this.includeArticleLogisticsCriteria = value;
    }

    /**
     * Gets the value of the articleStatusIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the articleStatusIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArticleStatusIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getArticleStatusIds() {
        if (articleStatusIds == null) {
            articleStatusIds = new ArrayList<Integer>();
        }
        return this.articleStatusIds;
    }

    /**
     * Gets the value of the articleStatusDateFrom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArticleStatusDateFrom() {
        return articleStatusDateFrom;
    }

    /**
     * Sets the value of the articleStatusDateFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArticleStatusDateFrom(String value) {
        this.articleStatusDateFrom = value;
    }

    /**
     * Gets the value of the articleStatusDateTo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArticleStatusDateTo() {
        return articleStatusDateTo;
    }

    /**
     * Sets the value of the articleStatusDateTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArticleStatusDateTo(String value) {
        this.articleStatusDateTo = value;
    }

}