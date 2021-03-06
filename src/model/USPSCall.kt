package model

import java.net.URLConnection
import java.net.URL
import model.CityStateLookupResponse
import model.getRequestUri
import controller.parseUSPSResponse

fun callUSPS(zipCode: String) : CityStateLookupResponse{
	var requestUri: String = getRequestUri(zipCode)
	var url: URL = URL("http://production.shippingapis.com/ShippingAPITest.dll?API=CityStateLookup&XML=" + requestUri)
	var connection: URLConnection = url.openConnection()
	
	return parseUSPSResponse(connection.getInputStream())
}