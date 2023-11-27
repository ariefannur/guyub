package com.github.arief.annuur.guyub.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.github.arief.annuur.guyub.android.theme.MyApplicationTheme
import com.github.arief.annuur.guyub.form.group.GSingleForm
import com.github.arief.annuur.guyub.model.UIFieldType
import com.github.arief.annuur.guyub.ui.GBasicList
import com.github.arief.annuur.guyub.ui.GFeed
import com.github.arief.annuur.guyub.ui.GProfile
import com.github.arief.annuur.guyub.ui.group.GTabLayout
import com.github.arief.annuur.guyub.utils.FakeData
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            val scope = rememberCoroutineScope()
            val snackBarHostState = remember { SnackbarHostState() }
            val viewModel = MainViewModel()

            LaunchedEffect(viewModel) {
                viewModel.getFormLogin()
            }

            MyApplicationTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    snackbarHost = {
                        SnackbarHost(hostState = snackBarHostState)
                    }
                ) {
                    Surface(modifier = Modifier.padding(it)) {
//                        GSingleForm(listData = FakeData.singleFormData/*viewModel.listData.collectAsState().value*/) {
//                            scope.launch {
//                                snackBarHostState.showSnackbar(it.toString())
//                            }
//                        }
//                        GProfile(data = FakeData.sampleProfile)
//                    }
                        GTabLayout(data = FakeData.tabLayoutData)
                    }
                }
            }
        }

    }
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
