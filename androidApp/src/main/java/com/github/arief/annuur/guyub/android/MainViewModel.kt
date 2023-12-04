package com.github.arief.annuur.guyub.android

import androidx.lifecycle.ViewModel
import com.github.arief.annuur.guyub.android.utils.Request
import com.github.arief.annuur.guyub.mapper.toFormField
import com.github.arief.annuur.guyub.mapper.toUIField
import com.github.arief.annuur.guyub.model.FormField
import com.github.arief.annuur.guyub.model.UIField
import kotlinx.coroutines.flow.MutableStateFlow

class MainViewModel: ViewModel() {

    val listData = MutableStateFlow(listOf<FormField>())
    suspend fun getFormLogin() {
        val result = Request.getUI().toUIField()
        val list = (result as UIField.Basic).data
        list.forEach {
            println("BASIC $it")
        }
//        listData.value = result.map { it.toFormField() }
    }
}