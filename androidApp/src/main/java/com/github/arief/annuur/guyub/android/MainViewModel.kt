package com.github.arief.annuur.guyub.android

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.arief.annuur.guyub.android.utils.Request
import com.github.arief.annuur.guyub.mapper.toFormField
import com.github.arief.annuur.guyub.model.FormField
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    val formState = MutableStateFlow(listOf<FormField>())
    val listWizardForm = MutableStateFlow(listOf(listOf<FormField>()))
    fun getFormLogin() {
        viewModelScope.launch {
            val result = Request.getLoginForm().map {
                it.toFormField()
            }
            formState.value = result
        }
    }

    fun getFormRegister() {
        viewModelScope.launch {
            val result = Request.getRegisterForm().map {
                it.toFormField()
            }
            formState.value = result
        }
    }

    fun getWizardForm() {
        viewModelScope.launch {
            val result = Request.getWizard().map { listData ->
                listData.map { it.toFormField() }
            }

            listWizardForm.value = result
        }
    }
}