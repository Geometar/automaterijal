//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.04.05 at 10:10:27 PM CEST 
//


package com.automaterijal.application.tecdoc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for articlePartList2Record complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="articlePartList2Record"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}articlePartList2RecordSrc"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="articleAddName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="articleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="articleNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="articleState" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="articleStateName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="brandName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="brandNo" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="genericArticleId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="genericArticleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="hasAxleLink" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="hasDocuments" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="hasMarkLink" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="hasMotorLink" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="hasOEN" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="hasPartList" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="hasPrices" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="hasSecurityInfo" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="hasVehicleLink" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="packingUnit" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="partArticleId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="partId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="quantityPerPackingUnit" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "articlePartList2Record", propOrder = {
    "articleAddName",
    "articleName",
    "articleNo",
    "articleState",
    "articleStateName",
    "brandName",
    "brandNo",
    "genericArticleId",
    "genericArticleName",
    "hasAxleLink",
    "hasDocuments",
    "hasMarkLink",
    "hasMotorLink",
    "hasOEN",
    "hasPartList",
    "hasPrices",
    "hasSecurityInfo",
    "hasVehicleLink",
    "packingUnit",
    "partArticleId",
    "partId",
    "quantity",
    "quantityPerPackingUnit"
})
public class ArticlePartList2Record
    extends ArticlePartList2RecordSrc
{

    protected String articleAddName;
    protected String articleName;
    protected String articleNo;
    protected Long articleState;
    protected String articleStateName;
    protected String brandName;
    protected Long brandNo;
    protected Long genericArticleId;
    protected String genericArticleName;
    protected Boolean hasAxleLink;
    protected Boolean hasDocuments;
    protected Boolean hasMarkLink;
    protected Boolean hasMotorLink;
    protected Boolean hasOEN;
    protected Boolean hasPartList;
    protected Boolean hasPrices;
    protected Boolean hasSecurityInfo;
    protected Boolean hasVehicleLink;
    protected Integer packingUnit;
    protected Long partArticleId;
    protected Long partId;
    protected Integer quantity;
    protected Integer quantityPerPackingUnit;

    /**
     * Gets the value of the articleAddName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArticleAddName() {
        return articleAddName;
    }

    /**
     * Sets the value of the articleAddName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArticleAddName(String value) {
        this.articleAddName = value;
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
     * Gets the value of the articleState property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getArticleState() {
        return articleState;
    }

    /**
     * Sets the value of the articleState property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setArticleState(Long value) {
        this.articleState = value;
    }

    /**
     * Gets the value of the articleStateName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArticleStateName() {
        return articleStateName;
    }

    /**
     * Sets the value of the articleStateName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArticleStateName(String value) {
        this.articleStateName = value;
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
     * Gets the value of the genericArticleName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGenericArticleName() {
        return genericArticleName;
    }

    /**
     * Sets the value of the genericArticleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGenericArticleName(String value) {
        this.genericArticleName = value;
    }

    /**
     * Gets the value of the hasAxleLink property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasAxleLink() {
        return hasAxleLink;
    }

    /**
     * Sets the value of the hasAxleLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasAxleLink(Boolean value) {
        this.hasAxleLink = value;
    }

    /**
     * Gets the value of the hasDocuments property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasDocuments() {
        return hasDocuments;
    }

    /**
     * Sets the value of the hasDocuments property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasDocuments(Boolean value) {
        this.hasDocuments = value;
    }

    /**
     * Gets the value of the hasMarkLink property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasMarkLink() {
        return hasMarkLink;
    }

    /**
     * Sets the value of the hasMarkLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasMarkLink(Boolean value) {
        this.hasMarkLink = value;
    }

    /**
     * Gets the value of the hasMotorLink property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasMotorLink() {
        return hasMotorLink;
    }

    /**
     * Sets the value of the hasMotorLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasMotorLink(Boolean value) {
        this.hasMotorLink = value;
    }

    /**
     * Gets the value of the hasOEN property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasOEN() {
        return hasOEN;
    }

    /**
     * Sets the value of the hasOEN property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasOEN(Boolean value) {
        this.hasOEN = value;
    }

    /**
     * Gets the value of the hasPartList property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasPartList() {
        return hasPartList;
    }

    /**
     * Sets the value of the hasPartList property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasPartList(Boolean value) {
        this.hasPartList = value;
    }

    /**
     * Gets the value of the hasPrices property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasPrices() {
        return hasPrices;
    }

    /**
     * Sets the value of the hasPrices property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasPrices(Boolean value) {
        this.hasPrices = value;
    }

    /**
     * Gets the value of the hasSecurityInfo property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasSecurityInfo() {
        return hasSecurityInfo;
    }

    /**
     * Sets the value of the hasSecurityInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasSecurityInfo(Boolean value) {
        this.hasSecurityInfo = value;
    }

    /**
     * Gets the value of the hasVehicleLink property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasVehicleLink() {
        return hasVehicleLink;
    }

    /**
     * Sets the value of the hasVehicleLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasVehicleLink(Boolean value) {
        this.hasVehicleLink = value;
    }

    /**
     * Gets the value of the packingUnit property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPackingUnit() {
        return packingUnit;
    }

    /**
     * Sets the value of the packingUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPackingUnit(Integer value) {
        this.packingUnit = value;
    }

    /**
     * Gets the value of the partArticleId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPartArticleId() {
        return partArticleId;
    }

    /**
     * Sets the value of the partArticleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPartArticleId(Long value) {
        this.partArticleId = value;
    }

    /**
     * Gets the value of the partId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPartId() {
        return partId;
    }

    /**
     * Sets the value of the partId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPartId(Long value) {
        this.partId = value;
    }

    /**
     * Gets the value of the quantity property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setQuantity(Integer value) {
        this.quantity = value;
    }

    /**
     * Gets the value of the quantityPerPackingUnit property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getQuantityPerPackingUnit() {
        return quantityPerPackingUnit;
    }

    /**
     * Sets the value of the quantityPerPackingUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setQuantityPerPackingUnit(Integer value) {
        this.quantityPerPackingUnit = value;
    }

}