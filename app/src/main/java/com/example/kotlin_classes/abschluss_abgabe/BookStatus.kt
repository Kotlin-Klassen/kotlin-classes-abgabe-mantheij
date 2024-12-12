sealed class BookStatus {
    object Available : BookStatus()
    data class CheckedOut(val dueDate: String) : BookStatus()
    data class Reserved(val reservedBy: String) : BookStatus()

    fun printStatus(): String {
        return when (this) {
            is Available -> "Available"
            is CheckedOut -> "Checked out, due date: $dueDate"
            is Reserved -> "Reserved by $reservedBy"
        }
    }
}