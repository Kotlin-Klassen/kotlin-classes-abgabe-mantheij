class Library {

    private val books = mutableListOf<Book>()

    // Nested Class for Library Address
    class LibraryAddress(
        private val street: String,
        private val city: String,
        private val zipCode: String
    ) {
        fun printAddress() {
            println("Library Address: $street, $city, $zipCode")
        }
    }

    // Inner Class for Library Member
    inner class LibraryMember(
        val name: String,
        val memberID: Int
    ) {
        fun checkoutBook(book: Book, dueDate: String) {
            if (book.status is BookStatus.Available) {
                book.status = BookStatus.CheckedOut(dueDate)
                println("$name checked out '${book.title}'")
            } else {
                println("Book '${book.title}' is not available for checkout.")
            }
        }

        fun reserveBook(book: Book) {
            if (book.status is BookStatus.Available) {
                book.status = BookStatus.Reserved(name)
                println("$name reserved '${book.title}'")
            } else {
                println("Book '${book.title}' cannot be reserved.")
            }
        }
    }

    // Library methods
    fun addBook(book: Book) {
        books.add(book)
        println("Added book: '${book.title}' by ${book.author}")
    }

    fun searchBook(query: String): List<Book> {
        return books.filter {
            it.title.contains(query, ignoreCase = true) || it.author.contains(query, ignoreCase = true)
        }
    }

    fun getAllBookStatuses() {
        books.forEach {
            println("Book: '${it.title}', Status: ${it.status.printStatus()}")
        }
    }
}