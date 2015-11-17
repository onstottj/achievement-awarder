package com.reonsoftware.awarder.utilities

import com.reonsoftware.awarder.json.JsonUtils
import com.reonsoftware.awarder.models.{Activity, Metric}
import org.scalatest.FunSpec
import spray.json._
import DefaultJsonProtocol._
import com.reonsoftware.awarder.json.MyJsonProtocol.activityFormat

class JsonConversionTests extends FunSpec {

  describe("Activity objects") {

    it("should be able to be parsed from JSON in the sample file") {
      val sampleFileUrl = getClass.getClassLoader.getResource("sampleActivity.json")
      assert(sampleFileUrl != null)
      val activity = JsonUtils.readActivityFromFile(sampleFileUrl.toURI)
      println("Parsed an Activity from the sample JSON file: " + activity)
    }

    it("should survive a JSON serialization round trip") {
      val date = DateUtils.simpleDateFormat.parse("2015-08-24T20:00:08")
      val metric = Metric("metricType", List(2, 10, 15))
      val activity = Activity("myUserId", "myActivityType", date, metric)

      val serializedActivity = activity.toJson
      val deserializedActivity = serializedActivity.convertTo[Activity]
      // This also ensures that the Metric was serialized/deserialized correctly
      assert(deserializedActivity == activity)
    }

  }

}