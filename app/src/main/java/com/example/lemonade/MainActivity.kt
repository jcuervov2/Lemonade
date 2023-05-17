package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.data.States
import com.example.lemonade.data.statesLemonade

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                LemonadeApp()
            }
        }
    }
}

fun machineStateLemonade(stateApp: States): States{
    return  when (stateApp) {
        States.LEMON_TREE -> States.LEMON_SQUEEZE
        States.LEMON_SQUEEZE -> States.LEMON_DRINK
        States.LEMON_DRINK -> States.LEMON_RESTART
        States.LEMON_RESTART -> States.LEMON_TREE
        else -> States.LEMON_TREE
    }
}

@Composable
fun LemonadeWithButtonAndImage(modifier: Modifier = Modifier) {

    var stateApp by remember { mutableStateOf(States.LEMON_TREE) }
    var randomTaps by remember { mutableStateOf(0) }

    val lemonTreeState = statesLemonade.find { it.state == stateApp }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (lemonTreeState != null) {
            Button(onClick = {
                stateApp = machineStateLemonade (stateApp)

            }) {
                Image(
                    painter = painterResource(id = lemonTreeState.idDrawable),
                    contentDescription = stringResource(lemonTreeState.idContentDescription)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(id = lemonTreeState.idString),
                fontSize = 18.sp
            )
        }
    }
}


@Preview
@Composable
fun LemonadeApp() {
    LemonadeWithButtonAndImage(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}