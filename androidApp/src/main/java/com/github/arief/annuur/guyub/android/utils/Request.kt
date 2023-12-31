package com.github.arief.annuur.guyub.android.utils

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.gson.gson
import java.lang.reflect.Type

object Request {
    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            gson()
        }
    }
    private val BASE_URL = "https://raw.githubusercontent.com/ariefannur/guyub/main/static/"
    suspend fun getLoginForm(): List<Map<String, Any>>{
        return getForm("${BASE_URL}form-login.json")
    }

    suspend fun getRegisterForm(): List<Map<String, Any>>{
        return getForm("${BASE_URL}form-register.json")
    }

    suspend fun getUI(): Map<String, Any> {
        return getUIResponse("${BASE_URL}ui-basic.json")
    }

    suspend fun getWizard(): List<List<Map<String, Any>>> {
        return getFormWizard("${BASE_URL}form-wizard.json")
    }

    private suspend fun getUIResponse(url: String): Map<String, Any> {
        val response: HttpResponse = client.get(url)
        return if (response.status == HttpStatusCode.OK) {
            val raw = response.bodyAsText()
            val empMapType = object : TypeToken<Map<String, Any>>() {}.type
            return Gson().fromJson(raw, empMapType)
        } else mapOf()
    }

    private suspend fun getForm(url: String): List<Map<String, Any>> {
        val response: HttpResponse = client.get(url)
        return if (response.status == HttpStatusCode.OK) {
            val raw = response.bodyAsText()
            val itemType = object : TypeToken<List<Map<String, Any>>>() {}.type
            Gson().fromJson(raw, itemType)
        } else listOf()
    }

    private suspend fun getFormWizard(url: String): List<List<Map<String, Any>>> {
        val response: HttpResponse = client.get(url)
        return if (response.status == HttpStatusCode.OK) {
            val raw = response.bodyAsText()
            val itemType = object : TypeToken<List<List<Map<String, Any>>>>() {}.type
            Gson().fromJson(raw, itemType)
        } else listOf()
    }
}