package com.github.arief.annuur.guyub.form.group

import com.github.arief.annuur.guyub.model.FormField
import kotlinx.coroutines.flow.MutableStateFlow

class SingleFormViewModel {
    var datas = MutableStateFlow(listOf<FormField>())
    var enableButton = MutableStateFlow(false)

    fun init(list: List<FormField>) {
        datas.value = list
    }
    fun checkButton(isError: Boolean, form: FormField) {
        val data = datas.value
        data.forEach {
            if (it.key == form.key)
                it.isError = isError
        }
        datas.value = data
        val errors = datas.value.map { it.isError }
        val result = errors.find { it }

        enableButton.value = result != true
    }


}