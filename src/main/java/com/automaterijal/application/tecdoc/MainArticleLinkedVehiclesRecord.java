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
 * <p>Java class for mainArticleLinkedVehiclesRecord complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="mainArticleLinkedVehiclesRecord"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}mainArticleLinkedVehiclesRecordSrc"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="articleLinkId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="linkingTargetId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="mainArticleId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mainArticleLinkedVehiclesRecord", propOrder = {
    "articleLinkId",
    "linkingTargetId",
    "mainArticleId"
})
public class MainArticleLinkedVehiclesRecord
    extends MainArticleLinkedVehiclesRecordSrc
{

    protected Long articleLinkId;
    protected Long linkingTargetId;
    protected Long mainArticleId;

    /**
     * Gets the value of the articleLinkId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getArticleLinkId() {
        return articleLinkId;
    }

    /**
     * Sets the value of the articleLinkId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setArticleLinkId(Long value) {
        this.articleLinkId = value;
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
     * Gets the value of the mainArticleId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMainArticleId() {
        return mainArticleId;
    }

    /**
     * Sets the value of the mainArticleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMainArticleId(Long value) {
        this.mainArticleId = value;
    }

}
