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
 * <p>Java class for articlePartList3Record complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="articlePartList3Record"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}articlePartList3RecordSrc"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="partlistAttributs" type="{http://server.cat.tecdoc.net}articlePartListAttributsRecordSeq" minOccurs="0"/&gt;
 *         &lt;element name="partlistDetails" type="{http://server.cat.tecdoc.net}articlePartList2Record" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "articlePartList3Record", propOrder = {
    "partlistAttributs",
    "partlistDetails"
})
public class ArticlePartList3Record
    extends ArticlePartList3RecordSrc
{

    protected ArticlePartListAttributsRecordSeq partlistAttributs;
    protected ArticlePartList2Record partlistDetails;

    /**
     * Gets the value of the partlistAttributs property.
     * 
     * @return
     *     possible object is
     *     {@link ArticlePartListAttributsRecordSeq }
     *     
     */
    public ArticlePartListAttributsRecordSeq getPartlistAttributs() {
        return partlistAttributs;
    }

    /**
     * Sets the value of the partlistAttributs property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArticlePartListAttributsRecordSeq }
     *     
     */
    public void setPartlistAttributs(ArticlePartListAttributsRecordSeq value) {
        this.partlistAttributs = value;
    }

    /**
     * Gets the value of the partlistDetails property.
     * 
     * @return
     *     possible object is
     *     {@link ArticlePartList2Record }
     *     
     */
    public ArticlePartList2Record getPartlistDetails() {
        return partlistDetails;
    }

    /**
     * Sets the value of the partlistDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArticlePartList2Record }
     *     
     */
    public void setPartlistDetails(ArticlePartList2Record value) {
        this.partlistDetails = value;
    }

}
