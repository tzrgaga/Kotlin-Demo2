package com.example.core.utils




import android.content.res.Resources
import android.util.TypedValue
import android.widget.Toast
import com.example.core.BaseApplication


private val displayMetrics = Resources.getSystem().displayMetrics

//    fun dp2px(dp: Float): Float {
//        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, displayMetrics)
//    }

//扩展函数
fun Float.dp2px() = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, displayMetrics)

object Utils {




//    fun toast(string: String) {
//        toast(string, Toast.LENGTH_SHORT)
//    }

    //通过函数参数默认值来代替 Java 的函数重载
    fun toast(string: String, duration: Int=Toast.LENGTH_SHORT) {
        Toast.makeText(BaseApplication.currentApplication, string, duration).show()
    }
}