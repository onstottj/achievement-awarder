package com.reonsoftware.awarder

import com.reonsoftware.awarder.achievements.Achievements
import com.reonsoftware.awarder.json.JsonUtils
import com.reonsoftware.awarder.utilities.FileUtils

/**
  * Achievement Awarder main class
  *
  * @author Jon Onstott
  * @since 11/15/2015
  */
object AchievementAwarder {

  def main(args: Array[String]) {
    println("Checking your data...\n\n")

    val filesToProcess = List("data1.json", "data2.json", "data3.json", "data4.json")

    val activities = filesToProcess
      .map(file => FileUtils.getResourceUri(file))
      .map(fileUri => JsonUtils.readActivityFromFile(fileUri))

    Achievements.awardAchievements(activities)

    println("Finished awarding achievement(s).")
  }

}
