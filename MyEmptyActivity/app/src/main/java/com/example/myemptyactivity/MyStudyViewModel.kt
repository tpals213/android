package com.example.myemptyactivity

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MyStudyViewModel : ViewModel()  {
    val text: MutableState<String> = mutableStateOf<String>("")
    val image: MutableState<Int> = mutableIntStateOf(R.drawable.dog)

    fun changeName(name:String){
        text.value = "이름은 ${name}"
        when(name){
            "1번 장세민" -> image.value = R.drawable.cat1
            "2번 가족원" -> image.value = R.drawable.cat2
            "3번 친구들" -> image.value = R.drawable.cat3
            "4번 친척들" -> image.value = R.drawable.cat4
            else -> image.value = R.drawable.dog
        }
    }
}