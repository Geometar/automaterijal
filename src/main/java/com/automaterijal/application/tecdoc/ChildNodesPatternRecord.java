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
 * <p>Java class for childNodesPatternRecord complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="childNodesPatternRecord"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}childNodesPatternRecordSrc"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="assemblyGroupName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="assemblyGroupNodeId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="parentNodeId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "childNodesPatternRecord", propOrder = {
    "assemblyGroupName",
    "assemblyGroupNodeId",
    "parentNodeId"
})
public class ChildNodesPatternRecord
    extends ChildNodesPatternRecordSrc
{

    protected String assemblyGroupName;
    protected Long assemblyGroupNodeId;
    protected Long parentNodeId;

    /**
     * Gets the value of the assemblyGroupName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAssemblyGroupName() {
        return assemblyGroupName;
    }

    /**
     * Sets the value of the assemblyGroupName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAssemblyGroupName(String value) {
        this.assemblyGroupName = value;
    }

    /**
     * Gets the value of the assemblyGroupNodeId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAssemblyGroupNodeId() {
        return assemblyGroupNodeId;
    }

    /**
     * Sets the value of the assemblyGroupNodeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAssemblyGroupNodeId(Long value) {
        this.assemblyGroupNodeId = value;
    }

    /**
     * Gets the value of the parentNodeId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentNodeId() {
        return parentNodeId;
    }

    /**
     * Sets the value of the parentNodeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentNodeId(Long value) {
        this.parentNodeId = value;
    }

}
