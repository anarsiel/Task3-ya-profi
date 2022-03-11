package data

data class Promotion(
    var id: Int?,
    var name: String?,
    var description: String?,
    var participants: ArrayList<Participant>?,
    var prizes: ArrayList<Prize>?,
)