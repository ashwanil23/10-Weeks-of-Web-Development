package com.kingkong.a10weeksofwebdev

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kingkong.a10weeksofwebdev.model._10WeeksOfWebDev
import com.kingkong.a10weeksofwebdev.model.tipsRepository
import com.kingkong.a10weeksofwebdev.ui.theme._10WeeksOfWebDevTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _10WeeksOfWebDevTheme {
                Surface(modifier = Modifier
                    .fillMaxWidth()) {
                    _10WeeksOfWebDevAppPreview()
                }
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun _10WeeksOfWebDevTopAppBar(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(
        title = { 
            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.headlineLarge
            )
        }
    )
}
@Composable
fun _10WeeksOfWebDevApp(modifier: Modifier = Modifier){
    Scaffold(
        modifier = Modifier.padding(top=20.dp),
        topBar = {
            _10WeeksOfWebDevTopAppBar()
        }
    ) {
        val firstRes = tipsRepository.tips
        _10WeeksOfWebDevList(tipsList = firstRes, contentPadding = it)
    }
}


@Preview(showBackground = true)
@Composable
fun _10WeeksOfWebDevAppPreview() {
    _10WeeksOfWebDevTheme {
        _10WeeksOfWebDevApp()
    }
}