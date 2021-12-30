//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.12.29 at 02:20:27 PM CET 
//


package com.automaterijal.application.tecdoc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for articleDirectSearchById4Record complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="articleDirectSearchById4Record"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}articleDirectSearchById4RecordSrc"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="articleAddName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="articleId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="articleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="articleNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="articleState" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="articleStateName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="brandName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="brandNo" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="flagAccessories" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="flagCertificationCompulsory" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="flagServiceExchangePart" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="flagSuitedforSelfService" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="genericArticleId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="hasAppendage" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="hasAxleLink" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="hasCsGraphics" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="hasDocuments" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="hasLessDiscount" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="hasMarkLink" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="hasMotorLink" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="hasOEN" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="hasPartList" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="hasPrices" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="hasSecurityInfo" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="hasUsage" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="hasVehicleLink" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="packingUnit" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
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
@XmlType(name = "articleDirectSearchById4Record", propOrder = {
    "articleAddName",
    "articleId",
    "articleName",
    "articleNo",
    "articleState",
    "articleStateName",
    "brandName",
    "brandNo",
    "flagAccessories",
    "flagCertificationCompulsory",
    "flagServiceExchangePart",
    "flagSuitedforSelfService",
    "genericArticleId",
    "hasAppendage",
    "hasAxleLink",
    "hasCsGraphics",
    "hasDocuments",
    "hasLessDiscount",
    "hasMarkLink",
    "hasMotorLink",
    "hasOEN",
    "hasPartList",
    "hasPrices",
    "hasSecurityInfo",
    "hasUsage",
    "hasVehicleLink",
    "packingUnit",
    "quantityPerPackingUnit"
})
public class ArticleDirectSearchById4Record
    extends ArticleDirectSearchById4RecordSrc
{

    protected String articleAddName;
    protected Long articleId;
    protected String articleName;
    protected String articleNo;
    protected Long articleState;
    protected String articleStateName;
    protected String brandName;
    protected Long brandNo;
    protected Boolean flagAccessories;
    protected Boolean flagCertificationCompulsory;
    protected Boolean flagServiceExchangePart;
    protected Boolean flagSuitedforSelfService;
    protected Long genericArticleId;
    protected Boolean hasAppendage;
    protected Boolean hasAxleLink;
    protected Boolean hasCsGraphics;
    protected Boolean hasDocuments;
    protected Boolean hasLessDiscount;
    protected Boolean hasMarkLink;
    protected Boolean hasMotorLink;
    protected Boolean hasOEN;
    protected Boolean hasPartList;
    protected Boolean hasPrices;
    protected Boolean hasSecurityInfo;
    protected Boolean hasUsage;
    protected Boolean hasVehicleLink;
    protected Integer packingUnit;
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
     * Gets the value of the flagAccessories property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFlagAccessories() {
        return flagAccessories;
    }

    /**
     * Sets the value of the flagAccessories property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFlagAccessories(Boolean value) {
        this.flagAccessories = value;
    }

    /**
     * Gets the value of the flagCertificationCompulsory property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFlagCertificationCompulsory() {
        return flagCertificationCompulsory;
    }

    /**
     * Sets the value of the flagCertificationCompulsory property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFlagCertificationCompulsory(Boolean value) {
        this.flagCertificationCompulsory = value;
    }

    /**
     * Gets the value of the flagServiceExchangePart property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFlagServiceExchangePart() {
        return flagServiceExchangePart;
    }

    /**
     * Sets the value of the flagServiceExchangePart property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFlagServiceExchangePart(Boolean value) {
        this.flagServiceExchangePart = value;
    }

    /**
     * Gets the value of the flagSuitedforSelfService property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFlagSuitedforSelfService() {
        return flagSuitedforSelfService;
    }

    /**
     * Sets the value of the flagSuitedforSelfService property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFlagSuitedforSelfService(Boolean value) {
        this.flagSuitedforSelfService = value;
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
     * Gets the value of the hasAppendage property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasAppendage() {
        return hasAppendage;
    }

    /**
     * Sets the value of the hasAppendage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasAppendage(Boolean value) {
        this.hasAppendage = value;
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
     * Gets the value of the hasCsGraphics property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasCsGraphics() {
        return hasCsGraphics;
    }

    /**
     * Sets the value of the hasCsGraphics property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasCsGraphics(Boolean value) {
        this.hasCsGraphics = value;
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
     * Gets the value of the hasLessDiscount property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasLessDiscount() {
        return hasLessDiscount;
    }

    /**
     * Sets the value of the hasLessDiscount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasLessDiscount(Boolean value) {
        this.hasLessDiscount = value;
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
     * Gets the value of the hasUsage property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasUsage() {
        return hasUsage;
    }

    /**
     * Sets the value of the hasUsage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasUsage(Boolean value) {
        this.hasUsage = value;
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
