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
 * <p>Java class for articlePartListRecord complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="articlePartListRecord"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}articlePartListRecordSrc"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="csgDocumentData" type="{http://server.cat.tecdoc.net}csgDocumentDataByArticleId2RecordSeq" minOccurs="0"/&gt;
 *         &lt;element name="partlistInfo" type="{http://server.cat.tecdoc.net}articlePartList3RecordSeq" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "articlePartListRecord", propOrder = {
    "csgDocumentData",
    "partlistInfo"
})
public class ArticlePartListRecord
    extends ArticlePartListRecordSrc
{

    protected CsgDocumentDataByArticleId2RecordSeq csgDocumentData;
    protected ArticlePartList3RecordSeq partlistInfo;

    /**
     * Gets the value of the csgDocumentData property.
     * 
     * @return
     *     possible object is
     *     {@link CsgDocumentDataByArticleId2RecordSeq }
     *     
     */
    public CsgDocumentDataByArticleId2RecordSeq getCsgDocumentData() {
        return csgDocumentData;
    }

    /**
     * Sets the value of the csgDocumentData property.
     * 
     * @param value
     *     allowed object is
     *     {@link CsgDocumentDataByArticleId2RecordSeq }
     *     
     */
    public void setCsgDocumentData(CsgDocumentDataByArticleId2RecordSeq value) {
        this.csgDocumentData = value;
    }

    /**
     * Gets the value of the partlistInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ArticlePartList3RecordSeq }
     *     
     */
    public ArticlePartList3RecordSeq getPartlistInfo() {
        return partlistInfo;
    }

    /**
     * Sets the value of the partlistInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArticlePartList3RecordSeq }
     *     
     */
    public void setPartlistInfo(ArticlePartList3RecordSeq value) {
        this.partlistInfo = value;
    }

}
