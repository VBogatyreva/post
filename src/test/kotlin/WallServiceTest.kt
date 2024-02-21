import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun add() {

        val post1 = WallService.add(Post(1, "Скоро Весна", Likes(12), Comments(1), 20))
        val post2 = WallService.add(Post(2, "Скоро Лето", Likes(32), Comments(15), 20))

        assertNotEquals(post1.id, post2.id)
    }


    @Test
    fun updateExisting() {

        val service = WallService

        service.add(Post(1, "Скоро Весна", Likes(12), Comments(1), 20))
        service.add(Post(1, "Скоро Весна", Likes(32), Comments(1), 20))
        service.add(Post(1, "Скоро Весна", Likes(62), Comments(1), 20))

        val update = Post(1, "Скоро Весна", Likes(82), Comments(1), 20)

        val result = service.update(update)

        assertTrue(result)

    }

    @Test
    fun updateNotExisting() {

        val service = WallService

        service.add(Post(1, "Скоро Весна", Likes(12), Comments(1), 20))
        service.add(Post(2, "Скоро Лето", Likes(32), Comments(1), 23))
        service.add(Post(3, "Скоро Зима", Likes(2), Comments(1), 27))

        val update = Post(4, "Скоро ЧТО", Likes(0), Comments(0), 29)

        val result = service.update(update)

        assertFalse(result)

    }
}