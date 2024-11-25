package br.com.kotlin.forum.services

import br.com.kotlin.forum.dto.NewTopicForm
import br.com.kotlin.forum.dto.TopicView
import br.com.kotlin.forum.dto.UpdateTopicForm
import br.com.kotlin.forum.mapper.TopicFormMapper
import br.com.kotlin.forum.mapper.TopicViewMapper
import br.com.kotlin.forum.model.Topic
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody
import java.util.stream.Collectors

@Service
class TopicService(
    private var topics: List<Topic> = ArrayList(),
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper
    ) {

    fun list(): List<TopicView> {
        return topics.stream().map {
            t -> topicViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun findById(id: Long): TopicView {
        val topic = topics.stream().filter { t ->
            t.id == id
        }.findFirst().get()
        return topicViewMapper.map(topic)
    }

    fun register(@RequestBody form: NewTopicForm) {
        val topic = topicFormMapper.map(form)
        topic.id = topics.size.toLong() + 1
        topics = topics.plus(topic)
    }

    fun update(form: UpdateTopicForm) {
        val topic = topics.stream().filter { t ->
            t.id == form.id
        }.findFirst().get()
        topics = topics.minus(topic).plus(Topic(
            id = form.id,
            title = form.title,
            message = form.message,
            author = topic.author,
            course = topic.course,
            answers = topic.answers,
            status = topic.status,
            createdAt = topic.createdAt
        ))
    }

    fun delete(id: Long) {
        val topic = topics.stream().filter { t ->
            t.id == id
        }.findFirst().get()
        topics = topics.minus(topic)
    }
}
