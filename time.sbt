import java.text.DateFormat
import java.util.Date

lazy val staticTime = settingKey[Date]("Build launch time")
lazy val formatStyle = settingKey[Int]("Style for formatting date and time")
lazy val formatter = settingKey[DateFormat]("Date Formatter")
lazy val dynamicTime = taskKey[Date]("Generates a Date for the current time")
lazy val formatTime = taskKey[String]("Formats the current time")
lazy val printTime = taskKey[Unit]("Prints the current time")

staticTime := new Date

dynamicTime := new Date

formatStyle := DateFormat.SHORT

formatter := {
  val style = formatStyle.value
  DateFormat.getDateTimeInstance(style, style)
}

formatTime := formatter.value.format(dynamicTime.value)

printTime := println("Time: " + formatTime.value)

