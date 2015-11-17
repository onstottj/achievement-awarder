package com.reonsoftware.awarder.achievements

import com.reonsoftware.awarder.models.{Activity, Metric}
import com.reonsoftware.awarder.utilities.DateUtils
import org.scalatest.FunSpec

/**
  * @author Jon Onstott
  * @since 11/17/2015
  */
class AchievementTests extends FunSpec {

  describe("The CHRISTMAS achievement") {

    val userId = "JohnDoe"

    val qualifyingDate = DateUtils.simpleDateFormat.parse("2015-12-25T20:00:08")
    val nonQualifyingDate = DateUtils.simpleDateFormat.parse("2001-01-01T20:00:08")

    val qualifyingMetric = Metric("fuel", List(200, 100, 150))

    it("should only be triggered if the date is correct") {
      // Non-qualifying date, should fail
      val activity = Activity(userId, "fuel", nonQualifyingDate, qualifyingMetric)
      assert(!ChristmasAchievement.doesActivityQualify(activity))

      // Qualifying date, should pass
      val activity2 = Activity(userId, "fuel", qualifyingDate, qualifyingMetric)
      assert(ChristmasAchievement.doesActivityQualify(activity2))
    }

    it("should only be triggered if the activity type is correct") {
      // Invalid activity type, should fail
      val activity = Activity(userId, "mileage", qualifyingDate, qualifyingMetric)
      assert(!ChristmasAchievement.doesActivityQualify(activity))

      // Invalid metric type, should fail
      val metricWithNonQualifyingType = Metric("mileage", List(200, 100, 150))
      val activity2 = Activity(userId, "fuel", qualifyingDate, metricWithNonQualifyingType)
      assert(!ChristmasAchievement.doesActivityQualify(activity2))

      // Correct types, should pass
      val activity3 = Activity(userId, "fuel", qualifyingDate, qualifyingMetric)
      assert(ChristmasAchievement.doesActivityQualify(activity3))
    }

    it("should only be triggered if the total fuel is greater than " + ChristmasAchievement.requiredTotal) {
      // Total fuel is 245, should fail
      val metricWithNonQualifyingTotal = Metric("fuel", List(70, 50, 125))
      val activity = Activity(userId, "mileage", qualifyingDate, metricWithNonQualifyingTotal)
      assert(!ChristmasAchievement.doesActivityQualify(activity))

      // Total fuel is 450, should pass
      val activity2 = Activity(userId, "fuel", qualifyingDate, qualifyingMetric)
      assert(ChristmasAchievement.doesActivityQualify(activity2))
    }

  }

}
