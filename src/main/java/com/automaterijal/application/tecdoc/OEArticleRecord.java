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
 * <p>Java class for OEArticleRecord complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OEArticleRecord"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="articleNumber" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="mfrId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="mfrName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="genericArticleId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="genericArticleDescription" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="replacedByArticles" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="tecDocCriteria" type="{http://server.cat.tecdoc.net}CriteriaRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="oeAttributes" type="{http://server.cat.tecdoc.net}OEAttributeRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="matchingAftermarketArticles" type="{http://server.cat.tecdoc.net}ArticleRefRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OEArticleRecord", propOrder = {
    "articleNumber",
    "mfrId",
    "mfrName",
    "genericArticleId",
    "genericArticleDescription",
    "replacedByArticles",
    "tecDocCriteria",
    "oeAttributes",
    "matchingAftermarketArticles"
})
public class OEArticleRecord {

    @XmlElement(required = true)
    protected String articleNumber;
    protected int mfrId;
    @XmlElement(required = true)
    protected String mfrName;
    protected int genericArticleId;
    @XmlElement(required = true)
    protected String genericArticleDescription;
    protected List<String> replacedByArticles;
    protected List<CriteriaRecord> tecDocCriteria;
    protected List<OEAttributeRecord> oeAttributes;
    protected List<ArticleRefRecord> matchingAftermarketArticles;

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
    public int getMfrId() {
        return mfrId;
    }

    /**
     * Sets the value of the mfrId property.
     * 
     */
    public void setMfrId(int value) {
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
     * Gets the value of the genericArticleId property.
     * 
     */
    public int getGenericArticleId() {
        return genericArticleId;
    }

    /**
     * Sets the value of the genericArticleId property.
     * 
     */
    public void setGenericArticleId(int value) {
        this.genericArticleId = value;
    }

    /**
     * Gets the value of the genericArticleDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGenericArticleDescription() {
        return genericArticleDescription;
    }

    /**
     * Sets the value of the genericArticleDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGenericArticleDescription(String value) {
        this.genericArticleDescription = value;
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
     * {@link String }
     * 
     * 
     */
    public List<String> getReplacedByArticles() {
        if (replacedByArticles == null) {
            replacedByArticles = new ArrayList<String>();
        }
        return this.replacedByArticles;
    }

    /**
     * Gets the value of the tecDocCriteria property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tecDocCriteria property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTecDocCriteria().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CriteriaRecord }
     * 
     * 
     */
    public List<CriteriaRecord> getTecDocCriteria() {
        if (tecDocCriteria == null) {
            tecDocCriteria = new ArrayList<CriteriaRecord>();
        }
        return this.tecDocCriteria;
    }

    /**
     * Gets the value of the oeAttributes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the oeAttributes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOeAttributes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OEAttributeRecord }
     * 
     * 
     */
    public List<OEAttributeRecord> getOeAttributes() {
        if (oeAttributes == null) {
            oeAttributes = new ArrayList<OEAttributeRecord>();
        }
        return this.oeAttributes;
    }

    /**
     * Gets the value of the matchingAftermarketArticles property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the matchingAftermarketArticles property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMatchingAftermarketArticles().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ArticleRefRecord }
     * 
     * 
     */
    public List<ArticleRefRecord> getMatchingAftermarketArticles() {
        if (matchingAftermarketArticles == null) {
            matchingAftermarketArticles = new ArrayList<ArticleRefRecord>();
        }
        return this.matchingAftermarketArticles;
    }

}
