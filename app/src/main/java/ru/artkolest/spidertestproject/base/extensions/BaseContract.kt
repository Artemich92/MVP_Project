package ru.artkolest.spidertestproject.base.extensions

interface BaseContract {

    interface View

    interface Presenter{
        fun start()
        fun stop()
        fun dispose()
    }
}