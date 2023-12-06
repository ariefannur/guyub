package com.github.arief.annuur.guyub.form.group

import com.github.arief.annuur.guyub.model.FormField
import com.github.arief.annuur.guyub.model.PasswordType
import kotlinx.coroutines.flow.MutableStateFlow

class SingleFormViewModel {
    var datas = MutableStateFlow(listOf<FormField>())
    private var mapData = mutableMapOf<String, FormField>()
    private var password = ""
    private var buttonField: FormField.Button? = null
    var enableButtonState = MutableStateFlow(false)

    fun init(list: List<FormField>) {
        datas.value = list
        list.find { it is FormField.Button } ?.let {
            buttonField = it as FormField.Button
        }
    }
    fun validationForm(isError: Boolean, form: FormField) {
        // convert to map
        mapData = datas.value.associateBy { it.key }.toMutableMap()
        val updateField = mapData[form.key]
        updateField?.let {
            it.isError = isError
            mapData[form.key] = it
        }

        val enableButton = if (isError) false
        else {
            for (i in 0.until(datas.value.size)) {
                if (datas.value[i].isError) false
                else continue
            }
            true
        }

        buttonField?.let {
//            update the button
            val updateButton = mapData[it.key] as FormField.Button
            buttonField = FormField.Button(updateButton.label, updateButton.key, updateButton.required, enableButton)
            mapData[it.key] = buttonField!!
        }

        enableButtonState.value = enableButton

//    update list based on map
        datas.value = mapData.values.toList()
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
        return datas.value.filter { it !is FormField.Button }.associate {
            Pair(it.key, it.value)
        }
    }


}