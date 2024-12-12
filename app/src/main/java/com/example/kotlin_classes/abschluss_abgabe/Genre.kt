enum class Genre(val description: String) {
    FICTION("Fictional stories and novels"),
    NON_FICTION("Informative and factual works"),
    SCIENCE("Scientific literature and texts"),
    HISTORY("Historical accounts and studies"),
    CHILDREN("Books for children and young readers");

    fun printDescription() {
        println(description)
    }
}