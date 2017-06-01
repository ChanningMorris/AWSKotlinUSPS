package controller

import java.io.InputStream
import javax.xml.bind.JAXBContext
import javax.xml.bind.JAXBException
import javax.xml.bind.Unmarshaller
import model.CityStateLookupResponse

fun parseUSPSResponse(response: InputStream) : CityStateLookupResponse{
	val jbContext: JAXBContext = JAXBContext.newInstance(CityStateLookupResponse::class.java)
	val unmarshaller: Unmarshaller = jbContext.createUnmarshaller()
	return unmarshaller.unmarshal(response) as CityStateLookupResponse
}