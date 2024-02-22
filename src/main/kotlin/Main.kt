data class Post(
    val id: Int,
    val text: String = "",
    val likes: Likes = Likes(0),
    val comments: Comments = Comments(0),
    val date: Int,
    val canDeleted: Boolean = false,
    val canEdited: Boolean = true,
    val canPined: Boolean = true,
)
data class Likes(
    val countLikes: Int
)
data class Comments(
    val countComments: Int
)
object WallService {
    private var posts = arrayOf<Post>()
    private var lastId = 0
    fun add(post: Post): Post {
        val newPost = post.copy(id = ++lastId, likes = post.likes.copy(), comments = post.comments.copy())
        posts += newPost
        return newPost
    }

    fun update(newPost: Post): Boolean {
        for (index in posts.indices) {
            if (posts[index].id == newPost.id) {
                posts[index] = newPost.copy(likes = newPost.likes.copy(), comments = newPost.comments.copy())
                return true
            }
        }
        return false
    }

    fun clear() {
        posts = emptyArray()
        lastId = 0
    }

    fun print() {
        for (post in posts) {
            print(post)
            println()
        }
        println()
    }
}

fun main() {
    WallService.add(Post(1, "Скоро Весна", Likes(12), Comments(1), 20))
    WallService.print()

    WallService.add(Post(2, "Скоро Лето", Likes(25), Comments(4), 21))
    WallService.print()

    WallService.update(Post(2, "Скоро Лето", Likes(58), Comments(8), 22))
    WallService.print()

    WallService.update(Post(2, "Скоро Лето", Likes(72), Comments(15), 23))
    WallService.print()

    WallService.add(Post(3, "Скоро Зима", Likes(2), Comments(1), 25))
    WallService.print()
}

