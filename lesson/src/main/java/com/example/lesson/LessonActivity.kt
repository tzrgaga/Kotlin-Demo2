package com.example.lesson

import android.os.Bundle
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.core.BaseView
import com.example.lesson.entity.Lesson

class LessonActivity : AppCompatActivity(), BaseView<LessonPresenter>, Toolbar.OnMenuItemClickListener {

//    private var lessonPresenter = LessonPresenter(this)

//    override fun getPresenter(): LessonPresenter {
//        return lessonPresenter
//    }

    //属性委托 有些常⻅的属性操作，我们可以通过委托的方式，让它只实现一次
    //lazy 延迟属性:值只在第一次访问的时候计算
    override val presenter: LessonPresenter by lazy {
        LessonPresenter(this)
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        presenter.showPlayback()
        return false
    }

    private var lessonAdapter = LessonAdapter()


    private lateinit var refreshLayout: SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson)

        findViewById<Toolbar>(R.id.toolbar).run {
            this.inflateMenu(R.menu.menu_lesson)
            this.setOnMenuItemClickListener(this@LessonActivity)
        }

        //kotlin标准函数
        //不需要返回自身 -> 从 run 和 let 中选择
        //作用域中使用 this 作为参数 ----> 选择 run
        findViewById<RecyclerView>(R.id.list).run {
            layoutManager = LinearLayoutManager(this@LessonActivity)
            adapter = lessonAdapter
            addItemDecoration(DividerItemDecoration(this@LessonActivity, LinearLayout.VERTICAL))
        }

        refreshLayout=findViewById(R.id.swipe_refresh_layout)

        refreshLayout.run {
            this.setOnRefreshListener { presenter.fetchData() }
            this.isRefreshing = true
        }

        presenter.fetchData()

    }

    fun  showResult( lessons:List<Lesson>) {
        lessonAdapter.updateAndNotify(lessons)
        refreshLayout.isRefreshing = false
    }


}