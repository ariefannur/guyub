package com.github.arief.annuur.guyub.android

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.github.arief.annuur.guyub.android.theme.MyApplicationTheme
import com.github.arief.annuur.guyub.ui.UIAction
import com.github.arief.annuur.guyub.ui.group.GTabLayout
import com.github.arief.annuur.guyub.utils.FakeData
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scope = rememberCoroutineScope()
            val snackBarHostState = remember { SnackbarHostState() }

            MyApplicationTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    snackbarHost = {
                        SnackbarHost(hostState = snackBarHostState)
                    }
                ) {
                    Surface(modifier = Modifier.padding(it)) {
                        GTabLayout(data = FakeData.tabLayoutData) { action ->
                            when (action) {
                                is UIAction.ActionFeed -> {
                                    scope.launch {
                                        snackBarHostState.showSnackbar(
                                            "Click Feed from item ${action.item.title}"
                                        )
                                    }
                                }
                                is UIAction.ActionProfile -> {
                                    scope.launch {
                                            snackBarHostState.showSnackbar(
                                                "Click Profile from item ${action.item}"
                                            )
                                    }
                                    when(action.item) {
                                        "Login" , "Register"-> navigateToSingle(action.item)
                                        "Wizard" -> navigateToWizard()
                                        else -> Unit
                                    }
                                }
                                is UIAction.ActionBasic -> {
                                    scope.launch {
                                        snackBarHostState.showSnackbar(
                                            "Click Feed from item ${action.item.title}"
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    }
}

fun Activity.navigateToSingle(titlePage: String) {
    startActivity(Intent(this, SingleActivity::class.java).apply {
        putExtra("title", titlePage)
    })
}

fun Activity.navigateToWizard() {
    startActivity(Intent(this, WizardActivity::class.java))
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView("Hello, Android!")
    }
}
