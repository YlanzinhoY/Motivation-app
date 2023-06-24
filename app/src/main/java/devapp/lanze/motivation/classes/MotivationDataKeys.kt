package devapp.lanze.motivation.classes

class MotivationDataKeys private constructor() {
    companion object {
        const val USER_NAME = "USER_NAME"
    }

    object FILTER {
        const val ALL = 1
        const val SMILE = 2
        const val SUNNY = 3
    }
}