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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for oEArticlesByVINResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="oEArticlesByVINResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}oEArticlesByVINResponseSrc"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="totalMatchingOEArticles" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="oeArticles" type="{http://server.cat.tecdoc.net}OEArticleRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="aftermarketDataSupplierFacets" type="{http://server.cat.tecdoc.net}DataSupplierFacetCounts" minOccurs="0"/&gt;
 *         &lt;element name="genericArticleFacets" type="{http://server.cat.tecdoc.net}GenericArticleFacetCounts" minOccurs="0"/&gt;
 *         &lt;element name="assemblyGroupFacets" type="{http://server.cat.tecdoc.net}AssemblyGroupFacetCounts" minOccurs="0"/&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="statusText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "oEArticlesByVINResponse", propOrder = {
    "totalMatchingOEArticles",
    "oeArticles",
    "aftermarketDataSupplierFacets",
    "genericArticleFacets",
    "assemblyGroupFacets",
    "status",
    "statusText"
})
public class OEArticlesByVINResponse
    extends OEArticlesByVINResponseSrc
{

    protected long totalMatchingOEArticles;
    protected List<OEArticleRecord> oeArticles;
    protected DataSupplierFacetCounts aftermarketDataSupplierFacets;
    protected GenericArticleFacetCounts genericArticleFacets;
    protected AssemblyGroupFacetCounts assemblyGroupFacets;
    protected int status;
    protected String statusText;

    /**
     * Gets the value of the totalMatchingOEArticles property.
     * 
     */
    public long getTotalMatchingOEArticles() {
        return totalMatchingOEArticles;
    }

    /**
     * Sets the value of the totalMatchingOEArticles property.
     * 
     */
    public void setTotalMatchingOEArticles(long value) {
        this.totalMatchingOEArticles = value;
    }

    /**
     * Gets the value of the oeArticles property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the oeArticles property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOeArticles().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OEArticleRecord }
     * 
     * 
     */
    public List<OEArticleRecord> getOeArticles() {
        if (oeArticles == null) {
            oeArticles = new ArrayList<OEArticleRecord>();
        }
        return this.oeArticles;
    }

    /**
     * Gets the value of the aftermarketDataSupplierFacets property.
     * 
     * @return
     *     possible object is
     *     {@link DataSupplierFacetCounts }
     *     
     */
    public DataSupplierFacetCounts getAftermarketDataSupplierFacets() {
        return aftermarketDataSupplierFacets;
    }

    /**
     * Sets the value of the aftermarketDataSupplierFacets property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataSupplierFacetCounts }
     *     
     */
    public void setAftermarketDataSupplierFacets(DataSupplierFacetCounts value) {
        this.aftermarketDataSupplierFacets = value;
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

}
