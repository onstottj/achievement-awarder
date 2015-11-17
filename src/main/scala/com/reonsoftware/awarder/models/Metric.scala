package com.reonsoftware.awarder.models

/**
  * This class represents data for the activity; it includes a type (fuel, distance, etc.) as well as numerical
  * values.  The numerical values represent the metric type over time (i.e. fuel earned for each minute).
  *
  * @author Jon Onstott
  * @since 11/15/2015
  */
case class Metric(metricType: String,
                  data: List[Int])