//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.2 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2021.05.26 à 02:47:36 PM CEST 
//


package com.formation.sboot.soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.formation.sboot.soap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetAllCountriesRequest_QNAME = new QName("http://www.formation.com/sboot/soap", "GetAllCountriesRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.formation.sboot.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CountryType }
     * 
     */
    public CountryType createCountryType() {
        return new CountryType();
    }

    /**
     * Create an instance of {@link GetAllCountriesResponse }
     * 
     */
    public GetAllCountriesResponse createGetAllCountriesResponse() {
        return new GetAllCountriesResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.formation.com/sboot/soap", name = "GetAllCountriesRequest")
    public JAXBElement<Object> createGetAllCountriesRequest(Object value) {
        return new JAXBElement<Object>(_GetAllCountriesRequest_QNAME, Object.class, null, value);
    }

}
