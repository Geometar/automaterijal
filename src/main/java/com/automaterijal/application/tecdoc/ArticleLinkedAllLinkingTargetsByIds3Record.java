//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.06.25 at 12:34:57 AM CEST 
//


package com.automaterijal.application.tecdoc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for articleLinkedAllLinkingTargetsByIds3Record complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="articleLinkedAllLinkingTargetsByIds3Record"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}articleLinkedAllLinkingTargetsByIds3RecordSrc"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="articleLinkId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="linkedArticleImmediateAttributs" type="{http://server.cat.tecdoc.net}immediateAttributsLinkedElementsRecordSeq" minOccurs="0"/&gt;
 *         &lt;element name="linkedAxles" type="{http://server.cat.tecdoc.net}axleByIdRecordSeq" minOccurs="0"/&gt;
 *         &lt;element name="linkedMarks" type="{http://server.cat.tecdoc.net}markByIdRecordSeq" minOccurs="0"/&gt;
 *         &lt;element name="linkedMotors" type="{http://server.cat.tecdoc.net}articleLinkedMotorsByIdRecordSeq" minOccurs="0"/&gt;
 *         &lt;element name="linkedVehicles" type="{http://server.cat.tecdoc.net}articleLinkedVehiclesById2RecordSeq" minOccurs="0"/&gt;
 *         &lt;element name="linkingTargetId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="linkingTargetType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "articleLinkedAllLinkingTargetsByIds3Record", propOrder = {
    "articleLinkId",
    "linkedArticleImmediateAttributs",
    "linkedAxles",
    "linkedMarks",
    "linkedMotors",
    "linkedVehicles",
    "linkingTargetId",
    "linkingTargetType"
})
public class ArticleLinkedAllLinkingTargetsByIds3Record
    extends ArticleLinkedAllLinkingTargetsByIds3RecordSrc
{

    protected long articleLinkId;
    protected ImmediateAttributsLinkedElementsRecordSeq linkedArticleImmediateAttributs;
    protected AxleByIdRecordSeq linkedAxles;
    protected MarkByIdRecordSeq linkedMarks;
    protected ArticleLinkedMotorsByIdRecordSeq linkedMotors;
    protected ArticleLinkedVehiclesById2RecordSeq linkedVehicles;
    protected long linkingTargetId;
    protected String linkingTargetType;

    /**
     * Gets the value of the articleLinkId property.
     * 
     */
    public long getArticleLinkId() {
        return articleLinkId;
    }

    /**
     * Sets the value of the articleLinkId property.
     * 
     */
    public void setArticleLinkId(long value) {
        this.articleLinkId = value;
    }

    /**
     * Gets the value of the linkedArticleImmediateAttributs property.
     * 
     * @return
     *     possible object is
     *     {@link ImmediateAttributsLinkedElementsRecordSeq }
     *     
     */
    public ImmediateAttributsLinkedElementsRecordSeq getLinkedArticleImmediateAttributs() {
        return linkedArticleImmediateAttributs;
    }

    /**
     * Sets the value of the linkedArticleImmediateAttributs property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImmediateAttributsLinkedElementsRecordSeq }
     *     
     */
    public void setLinkedArticleImmediateAttributs(ImmediateAttributsLinkedElementsRecordSeq value) {
        this.linkedArticleImmediateAttributs = value;
    }

    /**
     * Gets the value of the linkedAxles property.
     * 
     * @return
     *     possible object is
     *     {@link AxleByIdRecordSeq }
     *     
     */
    public AxleByIdRecordSeq getLinkedAxles() {
        return linkedAxles;
    }

    /**
     * Sets the value of the linkedAxles property.
     * 
     * @param value
     *     allowed object is
     *     {@link AxleByIdRecordSeq }
     *     
     */
    public void setLinkedAxles(AxleByIdRecordSeq value) {
        this.linkedAxles = value;
    }

    /**
     * Gets the value of the linkedMarks property.
     * 
     * @return
     *     possible object is
     *     {@link MarkByIdRecordSeq }
     *     
     */
    public MarkByIdRecordSeq getLinkedMarks() {
        return linkedMarks;
    }

    /**
     * Sets the value of the linkedMarks property.
     * 
     * @param value
     *     allowed object is
     *     {@link MarkByIdRecordSeq }
     *     
     */
    public void setLinkedMarks(MarkByIdRecordSeq value) {
        this.linkedMarks = value;
    }

    /**
     * Gets the value of the linkedMotors property.
     * 
     * @return
     *     possible object is
     *     {@link ArticleLinkedMotorsByIdRecordSeq }
     *     
     */
    public ArticleLinkedMotorsByIdRecordSeq getLinkedMotors() {
        return linkedMotors;
    }

    /**
     * Sets the value of the linkedMotors property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArticleLinkedMotorsByIdRecordSeq }
     *     
     */
    public void setLinkedMotors(ArticleLinkedMotorsByIdRecordSeq value) {
        this.linkedMotors = value;
    }

    /**
     * Gets the value of the linkedVehicles property.
     * 
     * @return
     *     possible object is
     *     {@link ArticleLinkedVehiclesById2RecordSeq }
     *     
     */
    public ArticleLinkedVehiclesById2RecordSeq getLinkedVehicles() {
        return linkedVehicles;
    }

    /**
     * Sets the value of the linkedVehicles property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArticleLinkedVehiclesById2RecordSeq }
     *     
     */
    public void setLinkedVehicles(ArticleLinkedVehiclesById2RecordSeq value) {
        this.linkedVehicles = value;
    }

    /**
     * Gets the value of the linkingTargetId property.
     * 
     */
    public long getLinkingTargetId() {
        return linkingTargetId;
    }

    /**
     * Sets the value of the linkingTargetId property.
     * 
     */
    public void setLinkingTargetId(long value) {
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

}
