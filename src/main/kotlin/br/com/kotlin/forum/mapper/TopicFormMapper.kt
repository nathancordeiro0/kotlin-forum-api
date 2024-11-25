package br.com.kotlin.forum.mapper

import br.com.kotlin.forum.dto.NewTopicForm
import br.com.kotlin.forum.model.Topic
import br.com.kotlin.forum.services.CourseService
import br.com.kotlin.forum.services.UserService
import org.springframework.stereotype.Component

@Component
class TopicFormMapper(
    private val courseService: CourseService,
    private val userService: UserService,
): Mapper<NewTopicForm, Topic> {

    override fun map(t: NewTopicForm): Topic {
        return Topic(
            title = t.title,
            message = t.message,
            course = courseService.findById(t.idCourse),
            author = userService.findById(t.idAuthor)
        )
    }

}
