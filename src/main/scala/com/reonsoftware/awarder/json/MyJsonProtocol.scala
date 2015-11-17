package com.reonsoftware.awarder.json

import java.util.Date
import com.reonsoftware.awarder.models.{Activity, Metric}
import com.reonsoftware.awarder.utilities.DateUtils
import spray.json.{DefaultJsonProtocol, _}

/**
  * The values defined here aid with doing JSON serialization/deserialization.  The spray-json library is being
  * used (see https://github.com/spray/spray-json).
  *
  * @author Jon Onstott
  * @since 11/17/2015
  */
object MyJsonProtocol extends DefaultJsonProtocol {

  implicit object DateFormat extends RootJsonFormat[Date] {
    override def read(dateJson: JsValue): Date = dateJson match {
      case jsString: JsString =>
        deserializeDate(jsString)

      case _ => deserializationError("Date could not be parsed: unexpected JSON type found")
    }

    override def write(date: Date): JsValue = JsString(DateUtils.simpleDateFormat.format(date))
  }

  implicit val metricFormat = jsonFormat(Metric, "type", "data")

  /**
    * JSON field names are customized per http://stackoverflow.com/a/33761490/132374, since they don't match the            l
    * field names of the Activity case class.
    */
  implicit val activityFormat = jsonFormat(Activity, "user_id", "activity_type", "date_time", "metric")

  private def deserializeDate(jsString: JsString) = {
    try {
      DateUtils.simpleDateFormat.parse(jsString.convertTo[String])
    } catch {
      case e: Exception => deserializationError("Date could not be parsed", e)
    }
  }

}
