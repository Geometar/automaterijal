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
 * <p>Java class for vehicleByIds3Record complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="vehicleByIds3Record"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}vehicleByIds3RecordSrc"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="axles" type="{http://server.cat.tecdoc.net}axleByCarIdRecordSeq" minOccurs="0"/&gt;
 *         &lt;element name="cabs" type="{http://server.cat.tecdoc.net}cabsByCarIdRecordSeq" minOccurs="0"/&gt;
 *         &lt;element name="carId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="kbaNumbers" type="{http://server.cat.tecdoc.net}kbaNumbersByVehicleIdRecordSeq" minOccurs="0"/&gt;
 *         &lt;element name="motorCodes" type="{http://server.cat.tecdoc.net}motorCodesByCarIdRecordSeq" minOccurs="0"/&gt;
 *         &lt;element name="protoTypes" type="{http://server.cat.tecdoc.net}vehiclePrototypeRecordSeq" minOccurs="0"/&gt;
 *         &lt;element name="secondaryTypes" type="{http://server.cat.tecdoc.net}secondaryTypesByCarIdRecordSeq" minOccurs="0"/&gt;
 *         &lt;element name="vehicleDetails" type="{http://server.cat.tecdoc.net}vehicleByIdRecord" minOccurs="0"/&gt;
 *         &lt;element name="vehicleRegistrationInfo" type="{http://server.cat.tecdoc.net}vehicleRegistrationInfoByIdRecord" minOccurs="0"/&gt;
 *         &lt;element name="wheelBases" type="{http://server.cat.tecdoc.net}wheelBasesByCarIdRecordSeq" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "vehicleByIds3Record", propOrder = {
    "axles",
    "cabs",
    "carId",
    "kbaNumbers",
    "motorCodes",
    "protoTypes",
    "secondaryTypes",
    "vehicleDetails",
    "vehicleRegistrationInfo",
    "wheelBases"
})
public class VehicleByIds3Record
    extends VehicleByIds3RecordSrc
{

    protected AxleByCarIdRecordSeq axles;
    protected CabsByCarIdRecordSeq cabs;
    protected long carId;
    protected KbaNumbersByVehicleIdRecordSeq kbaNumbers;
    protected MotorCodesByCarIdRecordSeq motorCodes;
    protected VehiclePrototypeRecordSeq protoTypes;
    protected SecondaryTypesByCarIdRecordSeq secondaryTypes;
    protected VehicleByIdRecord vehicleDetails;
    protected VehicleRegistrationInfoByIdRecord vehicleRegistrationInfo;
    protected WheelBasesByCarIdRecordSeq wheelBases;

    /**
     * Gets the value of the axles property.
     * 
     * @return
     *     possible object is
     *     {@link AxleByCarIdRecordSeq }
     *     
     */
    public AxleByCarIdRecordSeq getAxles() {
        return axles;
    }

    /**
     * Sets the value of the axles property.
     * 
     * @param value
     *     allowed object is
     *     {@link AxleByCarIdRecordSeq }
     *     
     */
    public void setAxles(AxleByCarIdRecordSeq value) {
        this.axles = value;
    }

    /**
     * Gets the value of the cabs property.
     * 
     * @return
     *     possible object is
     *     {@link CabsByCarIdRecordSeq }
     *     
     */
    public CabsByCarIdRecordSeq getCabs() {
        return cabs;
    }

    /**
     * Sets the value of the cabs property.
     * 
     * @param value
     *     allowed object is
     *     {@link CabsByCarIdRecordSeq }
     *     
     */
    public void setCabs(CabsByCarIdRecordSeq value) {
        this.cabs = value;
    }

    /**
     * Gets the value of the carId property.
     * 
     */
    public long getCarId() {
        return carId;
    }

    /**
     * Sets the value of the carId property.
     * 
     */
    public void setCarId(long value) {
        this.carId = value;
    }

    /**
     * Gets the value of the kbaNumbers property.
     * 
     * @return
     *     possible object is
     *     {@link KbaNumbersByVehicleIdRecordSeq }
     *     
     */
    public KbaNumbersByVehicleIdRecordSeq getKbaNumbers() {
        return kbaNumbers;
    }

    /**
     * Sets the value of the kbaNumbers property.
     * 
     * @param value
     *     allowed object is
     *     {@link KbaNumbersByVehicleIdRecordSeq }
     *     
     */
    public void setKbaNumbers(KbaNumbersByVehicleIdRecordSeq value) {
        this.kbaNumbers = value;
    }

    /**
     * Gets the value of the motorCodes property.
     * 
     * @return
     *     possible object is
     *     {@link MotorCodesByCarIdRecordSeq }
     *     
     */
    public MotorCodesByCarIdRecordSeq getMotorCodes() {
        return motorCodes;
    }

    /**
     * Sets the value of the motorCodes property.
     * 
     * @param value
     *     allowed object is
     *     {@link MotorCodesByCarIdRecordSeq }
     *     
     */
    public void setMotorCodes(MotorCodesByCarIdRecordSeq value) {
        this.motorCodes = value;
    }

    /**
     * Gets the value of the protoTypes property.
     * 
     * @return
     *     possible object is
     *     {@link VehiclePrototypeRecordSeq }
     *     
     */
    public VehiclePrototypeRecordSeq getProtoTypes() {
        return protoTypes;
    }

    /**
     * Sets the value of the protoTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehiclePrototypeRecordSeq }
     *     
     */
    public void setProtoTypes(VehiclePrototypeRecordSeq value) {
        this.protoTypes = value;
    }

    /**
     * Gets the value of the secondaryTypes property.
     * 
     * @return
     *     possible object is
     *     {@link SecondaryTypesByCarIdRecordSeq }
     *     
     */
    public SecondaryTypesByCarIdRecordSeq getSecondaryTypes() {
        return secondaryTypes;
    }

    /**
     * Sets the value of the secondaryTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link SecondaryTypesByCarIdRecordSeq }
     *     
     */
    public void setSecondaryTypes(SecondaryTypesByCarIdRecordSeq value) {
        this.secondaryTypes = value;
    }

    /**
     * Gets the value of the vehicleDetails property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleByIdRecord }
     *     
     */
    public VehicleByIdRecord getVehicleDetails() {
        return vehicleDetails;
    }

    /**
     * Sets the value of the vehicleDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleByIdRecord }
     *     
     */
    public void setVehicleDetails(VehicleByIdRecord value) {
        this.vehicleDetails = value;
    }

    /**
     * Gets the value of the vehicleRegistrationInfo property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleRegistrationInfoByIdRecord }
     *     
     */
    public VehicleRegistrationInfoByIdRecord getVehicleRegistrationInfo() {
        return vehicleRegistrationInfo;
    }

    /**
     * Sets the value of the vehicleRegistrationInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleRegistrationInfoByIdRecord }
     *     
     */
    public void setVehicleRegistrationInfo(VehicleRegistrationInfoByIdRecord value) {
        this.vehicleRegistrationInfo = value;
    }

    /**
     * Gets the value of the wheelBases property.
     * 
     * @return
     *     possible object is
     *     {@link WheelBasesByCarIdRecordSeq }
     *     
     */
    public WheelBasesByCarIdRecordSeq getWheelBases() {
        return wheelBases;
    }

    /**
     * Sets the value of the wheelBases property.
     * 
     * @param value
     *     allowed object is
     *     {@link WheelBasesByCarIdRecordSeq }
     *     
     */
    public void setWheelBases(WheelBasesByCarIdRecordSeq value) {
        this.wheelBases = value;
    }

}
