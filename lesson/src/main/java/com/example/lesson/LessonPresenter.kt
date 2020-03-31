package com.example.lesson

import com.example.core.http.EntityCallback
import com.example.core.http.HttpClient
import com.example.core.utils.Utils
import com.example.lesson.entity.Lesson
import com.google.gson.reflect.TypeToken
import java.util.ArrayList

class LessonPresenter constructor(var activity: LessonActivity) {

    companion object {
        const val LESSON_PATH = "lessons"
    }

//    private val activity: LessonActivity


    private var lessons: List<Lesson> = ArrayList()

    private val type = object : TypeToken<List<Lesson>>() {}.type

    fun fetchData() {
        HttpClient.get(LESSON_PATH, type, object : EntityCallback<List<Lesson>> {
            override fun onSuccess(entity: List<Lesson>) {
                this@LessonPresenter.lessons = entity
                activity.runOnUiThread(Runnable { activity.showResult(entity) })
            }

            override fun onFailure(message: String?) {
                activity.runOnUiThread(Runnable { Utils.toast(message!!) })
            }
        })
    }

    fun showPlayback() {
//        val playbackLessons = ArrayList<Lesson>()
//        for (lesson in lessons) {
//            if (lesson.state === Lesson.State.PLAYBACK) {
//                playbackLessons.add(lesson)
//            }
//        }

//        lessons.forEach() { lesson: Lesson ->
//            if(lesson.state === Lesson.State.PLAYBACK){
//                playbackLessons.add(lesson)
//            }
//        }

//        lessons.forEach { lesson: Lesson ->
//            if (lesson.state === Lesson.State.PLAYBACK) {
//                playbackLessons.add(lesson)
//            }
//        }
//

//        lessons.forEach { lesson ->
//            if (lesson.state === Lesson.State.PLAYBACK) {
//                playbackLessons.add(lesson)
//            }
//        }

//        lessons.forEach {
//            if (it.state === Lesson.State.PLAYBACK) {
//                playbackLessons.add(it)
//            }
//        }


//        var filterPlaybackLessons = lessons.filter {
//            it.state === Lesson.State.PLAYBACK
//        }

        activity.showResult(lessons.filter { it.state === Lesson.State.PLAYBACK })
    }

}

//fun main() {
//    val array = intArrayOf(2, 3, 4, 45, 6, 7, 8, 9, 68, 30)
//    for (i in array.indices) {
//        println(array[i])
//
//    }
//
//    for (i in 0 until array.size) {
//        println(array[i])
//
//    }
//
//}
