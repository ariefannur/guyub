package com.github.arief.annuur.guyub.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.github.arief.annuur.guyub.form.group.GWizardForm
import kotlinx.coroutines.launch

class WizardActivity: ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scope = rememberCoroutineScope()
            val snackBarHostState = remember { SnackbarHostState() }
            val viewModel = MainViewModel()

            viewModel.getWizardForm()
            setContent {
                Scaffold (
                    topBar = {
                        TopAppBar(
                            title = { Text(text = "Wizard Form") },
                            navigationIcon = { Icons.Default.ArrowBack },
                            actions = {
                               // finish()
                            }
                        )
                    }
                ){ padding ->
                    Surface (Modifier.padding(padding)){
                        val data = viewModel.listWizardForm.collectAsStateWithLifecycle()
                        GWizardForm(dataWizard = data.value) {
                            scope.launch {
                                snackBarHostState.showSnackbar("$it")
                            }
                        }
                    }
                }
            }
        }
    }
}