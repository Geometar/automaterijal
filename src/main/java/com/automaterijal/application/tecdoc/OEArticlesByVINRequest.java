//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.06.25 at 12:34:57 AM CEST 
//


package com.automaterijal.application.tecdoc;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for oEArticlesByVINRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="oEArticlesByVINRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}oEArticlesByVINRequestSrc"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="vin" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="articleCountry" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="provider" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="aftermarketDataSupplierIds" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="genericArticleIds" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="assemblyGroupNodeIds" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="lang" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="perPage" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="page" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="sort" type="{http://server.cat.tecdoc.net}Sort" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="includeAftermarketMatches" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="includeGenericArticleFacets" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="includeAftermarketDataSupplierFacets" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="assemblyGroupFacetOptions" type="{http://server.cat.tecdoc.net}AssemblyGroupFacetOptions" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "oEArticlesByVINRequest", propOrder = {
    "vin",
    "articleCountry",
    "provider",
    "aftermarketDataSupplierIds",
    "genericArticleIds",
    "assemblyGroupNodeIds",
    "lang",
    "perPage",
    "page",
    "sort",
    "includeAftermarketMatches",
    "includeGenericArticleFacets",
    "includeAftermarketDataSupplierFacets",
    "assemblyGroupFacetOptions"
})
public class OEArticlesByVINRequest
    extends OEArticlesByVINRequestSrc
{

    @XmlElement(required = true)
    protected String vin;
    @XmlElement(required = true)
    protected String articleCountry;
    protected int provider;
    @XmlElement(type = Integer.class)
    protected List<Integer> aftermarketDataSupplierIds;
    @XmlElement(type = Integer.class)
    protected List<Integer> genericArticleIds;
    @XmlElement(type = Long.class)
    protected List<Long> assemblyGroupNodeIds;
    protected String lang;
    protected Integer perPage;
    protected Integer page;
    protected List<Sort> sort;
    protected Boolean includeAftermarketMatches;
    protected Boolean includeGenericArticleFacets;
    protected Boolean includeAftermarketDataSupplierFacets;
    protected AssemblyGroupFacetOptions assemblyGroupFacetOptions;

    /**
     * Gets the value of the vin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVin() {
        return vin;
    }

    /**
     * Sets the value of the vin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVin(String value) {
        this.vin = value;
    }

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
     * Gets the value of the aftermarketDataSupplierIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the aftermarketDataSupplierIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAftermarketDataSupplierIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getAftermarketDataSupplierIds() {
        if (aftermarketDataSupplierIds == null) {
            aftermarketDataSupplierIds = new ArrayList<Integer>();
        }
        return this.aftermarketDataSupplierIds;
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
     * Gets the value of the includeAftermarketMatches property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeAftermarketMatches() {
        return includeAftermarketMatches;
    }

    /**
     * Sets the value of the includeAftermarketMatches property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeAftermarketMatches(Boolean value) {
        this.includeAftermarketMatches = value;
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
     * Gets the value of the includeAftermarketDataSupplierFacets property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeAftermarketDataSupplierFacets() {
        return includeAftermarketDataSupplierFacets;
    }

    /**
     * Sets the value of the includeAftermarketDataSupplierFacets property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeAftermarketDataSupplierFacets(Boolean value) {
        this.includeAftermarketDataSupplierFacets = value;
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

}
