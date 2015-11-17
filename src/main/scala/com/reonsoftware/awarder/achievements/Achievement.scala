package com.reonsoftware.awarder.achievements

import com.reonsoftware.awarder.models.Activity

/**
  * @author Jon Onstott
  * @since 11/17/2015
  */
object Achievements {

  /**
    * A list of all possible achievements.  Add additional achievements here in the future.
    */
  private val allAchievements = List[Achievement](ChristmasAchievement)

  def awardAchievements(activities: List[Activity]) {
    for (achievement <- allAchievements;
         activity <- activities if achievement.doesActivityQualify(activity)) {
      achievement.presentAward(activity)
    }
  }

}

/**
  * All achievements extend this trait
  */
trait Achievement {

  def doesActivityQualify(activity: Activity): Boolean

  def presentAward(activity: Activity)

}
