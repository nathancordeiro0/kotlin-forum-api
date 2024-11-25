package br.com.kotlin.forum.mapper

interface Mapper<T, U> {

    fun map(t: T): U

}
