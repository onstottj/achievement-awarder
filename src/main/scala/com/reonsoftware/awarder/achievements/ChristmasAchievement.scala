package com.reonsoftware.awarder.achievements

import java.util.{TimeZone, Calendar}

import com.reonsoftware.awarder.models.Activity

/**
  * The "CHRISTMAS" achievement. The requirements to earn this achievement are as follows:
  *
  * 1) The activity_type and metric type must be "fuel"
  * 2) The activity must be performed on December 25th
  * 3) The total fuel for the activity must be greater than 300
  *
  * @author Jon Onstott
  * @since 11/17/2015
  */
object ChristmasAchievement extends Achievement {

  private val requiredType = "fuel"
  val requiredTotal = 300

  override def doesActivityQualify(activity: Activity): Boolean = {
    doesActivityTypeQualify(activity) && doesDateQualify(activity) && doesTotalQualify(activity)
  }

  private def doesActivityTypeQualify(activity: Activity): Boolean = {
    activity.activityType == requiredType && activity.metric.metricType == requiredType
  }

  private def doesDateQualify(activity: Activity): Boolean = {
    val calendar = Calendar.getInstance(TimeZone.getDefault)
    calendar.setTime(activity.date)
    // Require Dec. 25th
    calendar.get(Calendar.MONTH) == 12 - 1 && calendar.get(Calendar.DAY_OF_MONTH) == 25
  }

  private def doesTotalQualify(activity: Activity): Boolean = activity.metric.data.sum > requiredTotal

  override def presentAward(activity: Activity): Unit = {
    ???
  }

}
