package ru.artkolest.spidertestproject.base

interface BaseContract {

    interface View

    interface Presenter{
        fun start()
        fun stop()
        fun dispose()
    }
}