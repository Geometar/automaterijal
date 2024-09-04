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
 * <p>Java class for genericArticlesByManufacturer6Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="genericArticlesByManufacturer6Request"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}genericArticlesByManufacturer6RequestSrc"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="articleCountry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="assemblyGroupNodeId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="brandNo" type="{http://server.cat.tecdoc.net}integerList" minOccurs="0"/&gt;
 *         &lt;element name="genericArticleId" type="{http://server.cat.tecdoc.net}integerList" minOccurs="0"/&gt;
 *         &lt;element name="lang" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="linkingTargetId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="linkingTargetType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="provider" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="resultMode" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="sortMode" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "genericArticlesByManufacturer6Request", propOrder = {
    "articleCountry",
    "assemblyGroupNodeId",
    "brandNo",
    "genericArticleId",
    "lang",
    "linkingTargetId",
    "linkingTargetType",
    "provider",
    "resultMode",
    "sortMode"
})
public class GenericArticlesByManufacturer6Request
    extends GenericArticlesByManufacturer6RequestSrc
{

    protected String articleCountry;
    protected Long assemblyGroupNodeId;
    protected IntegerList brandNo;
    protected IntegerList genericArticleId;
    protected String lang;
    protected Long linkingTargetId;
    protected String linkingTargetType;
    protected int provider;
    protected Integer resultMode;
    protected int sortMode;

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
     * Gets the value of the assemblyGroupNodeId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAssemblyGroupNodeId() {
        return assemblyGroupNodeId;
    }

    /**
     * Sets the value of the assemblyGroupNodeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAssemblyGroupNodeId(Long value) {
        this.assemblyGroupNodeId = value;
    }

    /**
     * Gets the value of the brandNo property.
     * 
     * @return
     *     possible object is
     *     {@link IntegerList }
     *     
     */
    public IntegerList getBrandNo() {
        return brandNo;
    }

    /**
     * Sets the value of the brandNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntegerList }
     *     
     */
    public void setBrandNo(IntegerList value) {
        this.brandNo = value;
    }

    /**
     * Gets the value of the genericArticleId property.
     * 
     * @return
     *     possible object is
     *     {@link IntegerList }
     *     
     */
    public IntegerList getGenericArticleId() {
        return genericArticleId;
    }

    /**
     * Sets the value of the genericArticleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntegerList }
     *     
     */
    public void setGenericArticleId(IntegerList value) {
        this.genericArticleId = value;
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

    /**
     * Gets the value of the resultMode property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getResultMode() {
        return resultMode;
    }

    /**
     * Sets the value of the resultMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setResultMode(Integer value) {
        this.resultMode = value;
    }

    /**
     * Gets the value of the sortMode property.
     * 
     */
    public int getSortMode() {
        return sortMode;
    }

    /**
     * Sets the value of the sortMode property.
     * 
     */
    public void setSortMode(int value) {
        this.sortMode = value;
    }

}
