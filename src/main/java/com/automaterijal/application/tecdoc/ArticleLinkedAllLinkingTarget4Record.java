//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.12.31 at 11:12:31 AM CET 
//


package com.automaterijal.application.tecdoc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for articleLinkedAllLinkingTarget4Record complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="articleLinkedAllLinkingTarget4Record"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}articleLinkedAllLinkingTarget4RecordSrc"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="articleLinkages" type="{http://server.cat.tecdoc.net}articleLinkedAllLinkingTargetDetailsRecordSeq" minOccurs="0"/&gt;
 *         &lt;element name="mainArticleLinkages" type="{http://server.cat.tecdoc.net}mainArticleLinkedVehiclesRecordSeq" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "articleLinkedAllLinkingTarget4Record", propOrder = {
    "articleLinkages",
    "mainArticleLinkages"
})
public class ArticleLinkedAllLinkingTarget4Record
    extends ArticleLinkedAllLinkingTarget4RecordSrc
{

    protected ArticleLinkedAllLinkingTargetDetailsRecordSeq articleLinkages;
    protected MainArticleLinkedVehiclesRecordSeq mainArticleLinkages;

    /**
     * Gets the value of the articleLinkages property.
     * 
     * @return
     *     possible object is
     *     {@link ArticleLinkedAllLinkingTargetDetailsRecordSeq }
     *     
     */
    public ArticleLinkedAllLinkingTargetDetailsRecordSeq getArticleLinkages() {
        return articleLinkages;
    }

    /**
     * Sets the value of the articleLinkages property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArticleLinkedAllLinkingTargetDetailsRecordSeq }
     *     
     */
    public void setArticleLinkages(ArticleLinkedAllLinkingTargetDetailsRecordSeq value) {
        this.articleLinkages = value;
    }

    /**
     * Gets the value of the mainArticleLinkages property.
     * 
     * @return
     *     possible object is
     *     {@link MainArticleLinkedVehiclesRecordSeq }
     *     
     */
    public MainArticleLinkedVehiclesRecordSeq getMainArticleLinkages() {
        return mainArticleLinkages;
    }

    /**
     * Sets the value of the mainArticleLinkages property.
     * 
     * @param value
     *     allowed object is
     *     {@link MainArticleLinkedVehiclesRecordSeq }
     *     
     */
    public void setMainArticleLinkages(MainArticleLinkedVehiclesRecordSeq value) {
        this.mainArticleLinkages = value;
    }

}
