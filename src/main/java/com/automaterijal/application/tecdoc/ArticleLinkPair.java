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
 * <p>Java class for articleLinkPair complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="articleLinkPair"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}articleLinkPairSrc"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="articleId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="articleLinkId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "articleLinkPair", propOrder = {
    "articleId",
    "articleLinkId"
})
public class ArticleLinkPair
    extends ArticleLinkPairSrc
{

    protected long articleId;
    protected long articleLinkId;

    /**
     * Gets the value of the articleId property.
     * 
     */
    public long getArticleId() {
        return articleId;
    }

    /**
     * Sets the value of the articleId property.
     * 
     */
    public void setArticleId(long value) {
        this.articleId = value;
    }

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

}
