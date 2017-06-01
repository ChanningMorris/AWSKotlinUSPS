package view

import model.CityStateLookupResponse
import controller.callUSPS
import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.LambdaLogger

public class GetZipCodeInfo {
	public fun handler(zipcode: String, context: Context): CityStateLookupResponse{
		val lambdaLogger = context.getLogger()
		lambdaLogger.log("GetZipCodeInfo Request, zipcode: " + zipcode)
		return callUSPS(zipcode)
	}
}