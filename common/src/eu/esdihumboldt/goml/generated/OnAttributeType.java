//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.11.10 at 10:39:16 AM MEZ 
//


package eu.esdihumboldt.goml.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for onAttributeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="onAttributeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element ref="{http://www.omwg.org/TR/d7/ontology/alignment}Property"/>
 *         &lt;element ref="{http://www.omwg.org/TR/d7/ontology/alignment}Relation"/>
 *       &lt;/choice>
 *       &lt;attribute ref="{http://www.w3.org/1999/02/22-rdf-syntax-ns#}about"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "onAttributeType", propOrder = {
    "property",
    "relation"
})
public class OnAttributeType {

    @XmlElement(name = "Property", namespace = "http://www.omwg.org/TR/d7/ontology/alignment")
    protected PropertyType property;
    @XmlElement(name = "Relation", namespace = "http://www.omwg.org/TR/d7/ontology/alignment")
    protected RelationType relation;
    @XmlAttribute(namespace = "http://www.w3.org/1999/02/22-rdf-syntax-ns#")
    protected String about;

    /**
     * Gets the value of the property property.
     * 
     * @return
     *     possible object is
     *     {@link PropertyType }
     *     
     */
    public PropertyType getProperty() {
        return property;
    }

    /**
     * Sets the value of the property property.
     * 
     * @param value
     *     allowed object is
     *     {@link PropertyType }
     *     
     */
    public void setProperty(PropertyType value) {
        this.property = value;
    }

    /**
     * Gets the value of the relation property.
     * 
     * @return
     *     possible object is
     *     {@link RelationType }
     *     
     */
    public RelationType getRelation() {
        return relation;
    }

    /**
     * Sets the value of the relation property.
     * 
     * @param value
     *     allowed object is
     *     {@link RelationType }
     *     
     */
    public void setRelation(RelationType value) {
        this.relation = value;
    }

    /**
     * Gets the value of the about property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAbout() {
        return about;
    }

    /**
     * Sets the value of the about property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAbout(String value) {
        this.about = value;
    }

}
