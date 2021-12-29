//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.12.27 at 11:03:50 AM CET 
//


package com.automaterijal.application.tecdoc;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for articlesResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="articlesResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}articlesResponseSrc"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="totalMatchingArticles" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="maxAllowedPage" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="articles" type="{http://server.cat.tecdoc.net}ArticleRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="dataSupplierFacets" type="{http://server.cat.tecdoc.net}DataSupplierFacetCounts" minOccurs="0"/&gt;
 *         &lt;element name="genericArticleFacets" type="{http://server.cat.tecdoc.net}GenericArticleFacetCounts" minOccurs="0"/&gt;
 *         &lt;element name="criteriaFacets" type="{http://server.cat.tecdoc.net}CriteriaFacetCounts" minOccurs="0"/&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="statusText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="assemblyGroupFacets" type="{http://server.cat.tecdoc.net}AssemblyGroupFacetCounts" minOccurs="0"/&gt;
 *         &lt;element name="articleStatusFacets" type="{http://server.cat.tecdoc.net}ArticleStatusFacetCounts" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "articlesResponse", propOrder = {
    "totalMatchingArticles",
    "maxAllowedPage",
    "articles",
    "dataSupplierFacets",
    "genericArticleFacets",
    "criteriaFacets",
    "status",
    "statusText",
    "assemblyGroupFacets",
    "articleStatusFacets"
})
public class ArticlesResponse
    extends ArticlesResponseSrc
{

    protected long totalMatchingArticles;
    protected int maxAllowedPage;
    protected List<ArticleRecord> articles;
    protected DataSupplierFacetCounts dataSupplierFacets;
    protected GenericArticleFacetCounts genericArticleFacets;
    protected CriteriaFacetCounts criteriaFacets;
    protected int status;
    protected String statusText;
    protected AssemblyGroupFacetCounts assemblyGroupFacets;
    protected ArticleStatusFacetCounts articleStatusFacets;

    /**
     * Gets the value of the totalMatchingArticles property.
     * 
     */
    public long getTotalMatchingArticles() {
        return totalMatchingArticles;
    }

    /**
     * Sets the value of the totalMatchingArticles property.
     * 
     */
    public void setTotalMatchingArticles(long value) {
        this.totalMatchingArticles = value;
    }

    /**
     * Gets the value of the maxAllowedPage property.
     * 
     */
    public int getMaxAllowedPage() {
        return maxAllowedPage;
    }

    /**
     * Sets the value of the maxAllowedPage property.
     * 
     */
    public void setMaxAllowedPage(int value) {
        this.maxAllowedPage = value;
    }

    /**
     * Gets the value of the articles property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the articles property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArticles().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ArticleRecord }
     * 
     * 
     */
    public List<ArticleRecord> getArticles() {
        if (articles == null) {
            articles = new ArrayList<ArticleRecord>();
        }
        return this.articles;
    }

    /**
     * Gets the value of the dataSupplierFacets property.
     * 
     * @return
     *     possible object is
     *     {@link DataSupplierFacetCounts }
     *     
     */
    public DataSupplierFacetCounts getDataSupplierFacets() {
        return dataSupplierFacets;
    }

    /**
     * Sets the value of the dataSupplierFacets property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataSupplierFacetCounts }
     *     
     */
    public void setDataSupplierFacets(DataSupplierFacetCounts value) {
        this.dataSupplierFacets = value;
    }

    /**
     * Gets the value of the genericArticleFacets property.
     * 
     * @return
     *     possible object is
     *     {@link GenericArticleFacetCounts }
     *     
     */
    public GenericArticleFacetCounts getGenericArticleFacets() {
        return genericArticleFacets;
    }

    /**
     * Sets the value of the genericArticleFacets property.
     * 
     * @param value
     *     allowed object is
     *     {@link GenericArticleFacetCounts }
     *     
     */
    public void setGenericArticleFacets(GenericArticleFacetCounts value) {
        this.genericArticleFacets = value;
    }

    /**
     * Gets the value of the criteriaFacets property.
     * 
     * @return
     *     possible object is
     *     {@link CriteriaFacetCounts }
     *     
     */
    public CriteriaFacetCounts getCriteriaFacets() {
        return criteriaFacets;
    }

    /**
     * Sets the value of the criteriaFacets property.
     * 
     * @param value
     *     allowed object is
     *     {@link CriteriaFacetCounts }
     *     
     */
    public void setCriteriaFacets(CriteriaFacetCounts value) {
        this.criteriaFacets = value;
    }

    /**
     * Gets the value of the status property.
     * 
     */
    public int getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     */
    public void setStatus(int value) {
        this.status = value;
    }

    /**
     * Gets the value of the statusText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusText() {
        return statusText;
    }

    /**
     * Sets the value of the statusText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusText(String value) {
        this.statusText = value;
    }

    /**
     * Gets the value of the assemblyGroupFacets property.
     * 
     * @return
     *     possible object is
     *     {@link AssemblyGroupFacetCounts }
     *     
     */
    public AssemblyGroupFacetCounts getAssemblyGroupFacets() {
        return assemblyGroupFacets;
    }

    /**
     * Sets the value of the assemblyGroupFacets property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssemblyGroupFacetCounts }
     *     
     */
    public void setAssemblyGroupFacets(AssemblyGroupFacetCounts value) {
        this.assemblyGroupFacets = value;
    }

    /**
     * Gets the value of the articleStatusFacets property.
     * 
     * @return
     *     possible object is
     *     {@link ArticleStatusFacetCounts }
     *     
     */
    public ArticleStatusFacetCounts getArticleStatusFacets() {
        return articleStatusFacets;
    }

    /**
     * Sets the value of the articleStatusFacets property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArticleStatusFacetCounts }
     *     
     */
    public void setArticleStatusFacets(ArticleStatusFacetCounts value) {
        this.articleStatusFacets = value;
    }

}
