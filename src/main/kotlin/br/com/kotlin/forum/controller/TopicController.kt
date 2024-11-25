package br.com.kotlin.forum.controller

import br.com.kotlin.forum.dto.NewTopicForm
import br.com.kotlin.forum.dto.TopicView
import br.com.kotlin.forum.dto.UpdateTopicForm
import br.com.kotlin.forum.services.TopicService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/topics")
class TopicController(private val service: TopicService) {

    @GetMapping
    fun list(): List<TopicView> {
        return service.list()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): TopicView {
        return service.findById(id)
    }

    @PostMapping
    fun register(@RequestBody @Valid form: NewTopicForm) {
        service.register(form)
    }

    @PutMapping
    fun update(@RequestBody @Valid form: UpdateTopicForm) {
        service.update(form)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        service.delete(id)
    }

}