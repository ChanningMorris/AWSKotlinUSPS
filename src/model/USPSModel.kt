package model

import model.callUSPS
import java.net.URLEncoder
import java.io.ByteArrayInputStream
import java.io.InputStream
import javax.xml.bind.annotation.XmlRootElement
import javax.xml.bind.annotation.XmlAttribute
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.JAXBContext
import javax.xml.bind.JAXBException
import javax.xml.bind.Unmarshaller

fun getRequestUri(zipcode : String): String{
	var USPSUserKey: String? = System.getenv("USPSUserKey")
	if(USPSUserKey == null) throw IllegalArgumentException("User Key Not Found")
	var uri: String
	uri = "<CityStateLookupRequest USERID=\"" + USPSUserKey + "\"><ZipCode ID=\"0\">" + "<Zip5>" + zipcode + "</Zip5></ZipCode></CityStateLookupRequest>"
	return URLEncoder.encode(uri, "UTF-8")
}

@XmlRootElement(name="CityStateLookupResponse") class CityStateLookupResponse(){
	@XmlElement var ZipCode: ZipCode? = null
}

@XmlAccessorType(XmlAccessType.FIELD)
class ZipCode(){
	@XmlAttribute(name="ID")
	var ID: String? = null
	@XmlElement
	var Zip5: String? = null
	@XmlElement
	var City: String? = null
	@XmlElement
	var State: String? = null
}