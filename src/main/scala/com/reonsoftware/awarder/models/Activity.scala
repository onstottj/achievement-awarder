package com.reonsoftware.awarder.models

import java.util.Date

/**
  * @param userId       Identifier for the user
  * @param activityType Identifier for the activity (e.g., Running, Swimming, Basketball, etc.)
  * @param date         The activity date
  * @param metric       Data for the activity, it includes a type (fuel, distance, etc.) as well as numerical values.
  *                     The numerical values represent the metric type over time (i.e. fuel earned for each minute).
  *
  * @author Jon Onstott
  * @since 11/15/2015
  */
case class Activity(userId: String,
                    activityType: String,
                    date: Date,
                    metric: Metric)