package br.com.kotlin.forum.mapper

import br.com.kotlin.forum.dto.TopicView
import br.com.kotlin.forum.model.Topic
import org.springframework.stereotype.Component

@Component
class TopicViewMapper: Mapper<Topic, TopicView> {

    override fun map(t: Topic): TopicView {
        return TopicView(
            id = t.id,
            title = t.title,
            message = t.message,
            status = t.status,
            createdAt = t.createdAt
        )
    }

}