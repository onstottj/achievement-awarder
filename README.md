Achievement Awarder
===================

This is a sample Scala project that reads activity data JSON from files and awards achievements.

Libraries used:

 - Scala 2.11
 - Spray-json for JSON serialization/deserialization (https://github.com/spray/spray-json)
 - FunSpec for BDD (http://www.scalatest.org/getting_started_with_fun_spec)

Running the app
---------------

This sample is a command-line app with the main class `com.reonsoftware.awarder.AchievementAwarder`.
You can run this from your IDE.

The JSON files in src/main/resources are examined to see if there are any activities that qualify for awards.

Command-line output looks like:

    Checking your data...

      ,----..    ,---,                                    ___              ____
     /   /   \ ,--.' |               ,--,               ,--.'|_          ,'  , `.
    |   :     :|  |  :      __  ,-.,--.'|               |  | :,'      ,-+-,.' _ |
    .   |  ;. /:  :  :    ,' ,'/ /||  |,      .--.--.   :  : ' :   ,-+-. ;   , ||             .--.--.
    .   ; /--` :  |  |,--.'  | |' |`--'_     /  /    '.;__,'  /   ,--.'|'   |  || ,--.--.    /  /    '
    ;   | ;    |  :  '   ||  |   ,',' ,'|   |  :  /`./|  |   |   |   |  ,', |  |,/       \  |  :  /`./
    |   : |    |  |   /' :'  :  /  '  | |   |  :  ;_  :__,'| :   |   | /  | |--'.--.  .-. | |  :  ;_
    .   | '___ '  :  | | ||  | '   |  | :    \  \    `. '  : |__ |   : |  | ,    \__\/: . .  \  \    `.
    '   ; : .'||  |  ' | :;  : |   '  : |__   `----.   \|  | '.'||   : |  |/     ," .--.; |   `----.   \
    '   | '/  :|  :  :_:,'|  , ;   |  | '.'| /  /`--'  /;  :    ;|   | |`-'     /  /  ,.  |  /  /`--'  /
    |   :    / |  | ,'     ---'    ;  :    ;'--'.     / |  ,   / |   ;/        ;  :   .'   \'--'.     /
     \   \ .'  `--''               |  ,   /   `--'---'   ---`-'  '---'         |  ,     .-./  `--'---'
      `---`                         ---`-'                                      `--`---'

    Congratulations! You have earned the CHRISTMAS achievement for driving on 2015-12-25T08:00:08, using 431 units of fuel.

    Finished awarding achievement(s).

You can run `mvn test` to run the BDD-style unit tests.