package com.github.arief.annuur.guyub.form.group

import com.github.arief.annuur.guyub.model.FormField
import com.github.arief.annuur.guyub.model.PasswordType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map

class SingleFormViewModel {
    var datas = MutableStateFlow(listOf<FormField>())
    var enableButton = MutableStateFlow(false)
    private var password = ""

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

    fun setPassword(pass: String, type: PasswordType): Boolean {
        return if (type == PasswordType.PASSWORD) {
            password = pass
            true
        } else {
            val isCorrect = pass == password
            updatePasswordComponent(isCorrect)
            isCorrect
        }
    }

    private fun updatePasswordComponent(correct: Boolean) {
        val data = datas.value
        data.forEach {
            if (it is FormField.Password) {
                it.isError = !correct
                it.message = "Please recheck your password"
            }
        }
        datas.value = data
    }

    fun getSubmittedValue(): Map<String, String> {
        return datas.value.associate {
            Pair(it.key, it.value)
        }
    }


}