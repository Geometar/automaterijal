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
 * <p>Java class for articleDirectSearchAllNumbersWithStateRecord complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="articleDirectSearchAllNumbersWithStateRecord"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}articleDirectSearchAllNumbersWithStateRecordSrc"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="articleId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="articleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="articleNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="articleSearchNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="articleStateId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="brandName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="brandNo" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="category" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="genericArticleId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="numberType" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="sortNo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "articleDirectSearchAllNumbersWithStateRecord", propOrder = {
    "articleId",
    "articleName",
    "articleNo",
    "articleSearchNo",
    "articleStateId",
    "brandName",
    "brandNo",
    "category",
    "genericArticleId",
    "numberType",
    "sortNo"
})
public class ArticleDirectSearchAllNumbersWithStateRecord
    extends ArticleDirectSearchAllNumbersWithStateRecordSrc
{

    protected Long articleId;
    protected String articleName;
    protected String articleNo;
    protected String articleSearchNo;
    protected Integer articleStateId;
    protected String brandName;
    protected Long brandNo;
    protected String category;
    protected Long genericArticleId;
    protected Integer numberType;
    protected Integer sortNo;

    /**
     * Gets the value of the articleId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getArticleId() {
        return articleId;
    }

    /**
     * Sets the value of the articleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setArticleId(Long value) {
        this.articleId = value;
    }

    /**
     * Gets the value of the articleName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArticleName() {
        return articleName;
    }

    /**
     * Sets the value of the articleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArticleName(String value) {
        this.articleName = value;
    }

    /**
     * Gets the value of the articleNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArticleNo() {
        return articleNo;
    }

    /**
     * Sets the value of the articleNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArticleNo(String value) {
        this.articleNo = value;
    }

    /**
     * Gets the value of the articleSearchNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArticleSearchNo() {
        return articleSearchNo;
    }

    /**
     * Sets the value of the articleSearchNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArticleSearchNo(String value) {
        this.articleSearchNo = value;
    }

    /**
     * Gets the value of the articleStateId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getArticleStateId() {
        return articleStateId;
    }

    /**
     * Sets the value of the articleStateId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setArticleStateId(Integer value) {
        this.articleStateId = value;
    }

    /**
     * Gets the value of the brandName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * Sets the value of the brandName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrandName(String value) {
        this.brandName = value;
    }

    /**
     * Gets the value of the brandNo property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBrandNo() {
        return brandNo;
    }

    /**
     * Sets the value of the brandNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBrandNo(Long value) {
        this.brandNo = value;
    }

    /**
     * Gets the value of the category property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the value of the category property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategory(String value) {
        this.category = value;
    }

    /**
     * Gets the value of the genericArticleId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getGenericArticleId() {
        return genericArticleId;
    }

    /**
     * Sets the value of the genericArticleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setGenericArticleId(Long value) {
        this.genericArticleId = value;
    }

    /**
     * Gets the value of the numberType property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumberType() {
        return numberType;
    }

    /**
     * Sets the value of the numberType property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumberType(Integer value) {
        this.numberType = value;
    }

    /**
     * Gets the value of the sortNo property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSortNo() {
        return sortNo;
    }

    /**
     * Sets the value of the sortNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSortNo(Integer value) {
        this.sortNo = value;
    }

}
