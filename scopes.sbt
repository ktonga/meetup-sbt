
lazy val scopedSetting = settingKey[String]("Value changes depending on the task")
lazy val firstTask = taskKey[Unit]("The first task")
lazy val secondTask = taskKey[Unit]("The second task")
lazy val otherTask = taskKey[Unit]("Other task")
def printScopedSetting(value: String) = { println("scopedSetting is: " + value) }

firstTask := printScopedSetting(scopedSetting.value)

secondTask := printScopedSetting(scopedSetting.value)

otherTask := printScopedSetting(scopedSetting.value)

scopedSetting := "Global"

scopedSetting in firstTask := "First"

scopedSetting in secondTask := "Second"
